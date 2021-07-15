from concurrent.futures.thread import ThreadPoolExecutor

import requests
from bs4 import BeautifulSoup
import pandas_read_xml as pdx
import pandas as pd

# baseUrl where all the sitemap urls are available
BASE_URL = 'https://www.cnbc.com/sitemapAll.xml'

def make_http_call_to_cnbc_for_data_to_analyze(url):
    page = requests.get(url)
    soup = BeautifulSoup(page.content, 'html.parser')
    print('content read: ', url)
    content1 = ''
    content2 = ''
    for title in soup.findAll('meta', attrs={'name': 'twitter:title'}):
        titleAttributes = title.attrs
        if titleAttributes is not None and 'content' in titleAttributes:
            content1 = titleAttributes['content']
            print('actual title content: ', content1)
    for description in soup.findAll('meta', attrs={'name': 'twitter:description'}):
        descriptionAttributes = description.attrs
        if descriptionAttributes is not None and 'content' in descriptionAttributes:
            content2 = descriptionAttributes['content']
            print('actual description content: ', content2)
    return content1, content2


def fetch_cnbc_urls():
    tesla_urls = []
    response = requests.get(BASE_URL)
    with open('cnbcBaseUrl.xml', 'wb') as f:
        f.write(response.content)
    df = pdx.read_xml("cnbcBaseUrl.xml", ['sitemapindex'])
    xml_url_list = [x['loc'] for x in df.sitemap]
    for url in xml_url_list:
        resp = requests.get(url)
        file_name = url.split('/')[3]
        with open(file_name, 'wb') as f:
            f.write(resp.content)
        df = pdx.read_xml(file_name, ['urlset'])
        page_url_list = [x['loc'] for x in df.url if str(x['loc']).find('tesla') != -1]
        tesla_urls.extend(page_url_list)

    tesla_urls_df = pd.DataFrame(columns=['tesla_url'], data=tesla_urls)
    tesla_urls_df.to_csv('tesla_urls.csv', index=False)


def fetch_and_save_tesla_content():
    tesla_content = []
    tesla_urls_df = pd.read_csv('tesla_urls.csv')
    future_list = []
    with ThreadPoolExecutor(max_workers=25) as executor:
        for i, url in enumerate(tesla_urls_df.tesla_url[:50]):
            future = executor.submit(make_http_call_to_cnbc_for_data_to_analyze, url)
            future_list.append(future)
            print(i, url)

    for data in future_list:
        tesla_content.extend(data.result())

    tesla_content_df = pd.DataFrame(columns=['tesla_content'], data=tesla_content)
    tesla_content_df.to_csv('tesla_content.csv', index=False)


if __name__ == '__main__':
    print('---Fetch And Save CNBC Tesla Data---')
    fetch_cnbc_urls()
    fetch_and_save_tesla_content()
    # clean_content_and_save_to_csv()
    # perform_sentimental_analysis()
