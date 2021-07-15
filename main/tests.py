import requests

def test_get_all_address_book_status_code_equals_200():
    response = requests.get("http://localhost:8001/query/")
    assert response.status_code == 200

def test_get_address_book_status_code_equals_200():
    response = requests.get("http://localhost:8001/query/1")
    assert response.status_code == 200

def test_post_address_book_status_code_equals_200():
    data = {
        "id":2,
        "firstname":"testname",
        "lastname":"testlastname",
        "email":"testemail"
    }
    response = requests.post("http://localhost:8001/insert",json=data)
    assert response.status_code == 200

test_get_all_address_book_status_code_equals_200()
test_get_address_book_status_code_equals_200()
test_post_address_book_status_code_equals_200()