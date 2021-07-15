import unittest

from query_dvcomm_db import QueryDVCOMM
dv_comm = QueryDVCOMM()

class TestAddressBookMethods(unittest.TestCase):

    def test_query_addresses(self):
        list = dv_comm.query_addresses()
        self.assertIsNotNone(list)

    def test_query_addresses_byid(self):
        list = dv_comm.query_addresse_by_id(1)
        self.assertIsNotNone(list)

    def test_insert_address(self):
        list = dv_comm.insert_addresses(1,"testing_first_name","last_name","testing@gmail.com")
        self.assertIsNotNone(list)

if __name__ == '__main__':
    unittest.main()