from requests import get
import json
from bs4 import BeautifulSoup as Soup
from bs2json import bs2json

movie_name = "godfather"
url = get("https://www.rottentomatoes.com/search?search={0}".format(movie_name))
request = url.text

soup_data = Soup(request, 'html.parser')

converter = bs2json()
movies_json = soup_data.find('script', {'id':'movies-json'})
movies_all_strings = converter.convert(movies_json)
movies_all = movies_all_strings['script']['text']

movies_list = json.loads(movies_all) # dict of movies

list_of_movies = movies_list["items"] # list of movies

titles = []
def getMovieName(list_of_movies):
    for x in list_of_movies:
        for key, value in x.items():
            movie_name = x['name']
        titles.append(movie_name)
    print(titles)

# Convert list of dictionaries to Dictionary Value list 
# Using loop 
from collections import defaultdict

movies_dict = defaultdict(list) 
for sub in movies_list: 
    for key in sub: 
        movies_dict[key].append(sub[key]) 

movies_dict = str(dict(movies_dict))
      
# printing result  
print(movies_dict)