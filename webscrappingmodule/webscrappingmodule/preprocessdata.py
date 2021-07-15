import re
import pandas as pd


# cleaning of the tesla content
def clean_content_and_save_to_csv():
    clean_tesla_content = []
    tesla_content_df = pd.read_csv('tesla_content.csv')
    for content in tesla_content_df.tesla_content:
        content = re.sub(r'https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)',
                         '',
                         content, flags=re.MULTILINE)  # to remove links that start with HTTP/HTTPS in the content
        content = re.sub(r'[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)', '',
                         content, flags=re.MULTILINE)  # to remove other url links
        content = re.sub(r"#(\w+)", ' ', content, flags=re.MULTILINE)
        content = re.sub(r"@(\w+)", ' ', content, flags=re.MULTILINE)
        content = re.sub(' +', ' ', content, flags=re.MULTILINE)
        content = re.sub(r"\d", "", content)  # to remove the digits
        content = content.lower()  # to lower the contents
        clean_tesla_content.append(content)

        clean_tesla_content_df = pd.DataFrame(columns=['processed_content'], data=clean_tesla_content)
        clean_tesla_content_df.to_csv('tesla_processed_content.csv', index=False)
