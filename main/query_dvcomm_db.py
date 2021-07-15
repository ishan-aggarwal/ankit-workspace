import mysql.connector
from mysql.connector import errorcode
from model import AddressBook
# from mysql.connector.cursor_cext import CMySQLCursor

from mysql_connection import DBConnection

config = {'host': '127.0.0.1',
          'user': 'root',
          'passwd': 'password',
          'database': 'test_schema'}


class QueryDVCOMM:
    """
    This class creates the connection and returns the connection object
    """

    @staticmethod
    def query_addresse_by_id(aid):
        address_list = []
        with DBConnection(config) as cursor:
            query = (f'SELECT id, firstname, lastname, email FROM address_book where id = "{aid}" ')
            cursor.execute(query)
            for (id, firstname, lastname, email) in cursor:
                address_list.append(AddressBook(id=id, firstname=firstname, lastname=lastname, email=email))
                # print('ID : {}, {}, {}, {}'.format(id, firstname, lastname, email))

            return address_list[0]

    @staticmethod
    def query_addresses():
        address_list = []
        with DBConnection(config) as cursor:
            query = ("SELECT id, firstname, lastname, email FROM address_book ")
            cursor.execute(query)
            for (id, firstname, lastname, email) in cursor:
                address_list.append(AddressBook(id=id, firstname = firstname, lastname =lastname, email =email))
                # print('ID : {}, {}, {}, {}'.format(id, firstname, lastname, email))

            return address_list

    @staticmethod
    def insert_addresses(id, first_name, last_name, email):
        try:
            with DBConnection(config) as cursor:
                statement = ("INSERT INTO address_book (id, firstname, lastname, email) VALUES (%s, %s, %s, %s) ")
                cursor.execute(statement, (id, first_name, last_name, email))
                # cursor.execute(statement, (values))
                # for (id_, firstname, lastname, email) in cursor:
                #     print('ID : {}, {}, {}, {}'.format(id_, firstname, lastname, email))
                return statement, (id, first_name, last_name, email)
        except Exception as e:
            return e


# def endpoint1():
#     try:
#         dv_comm = QueryDVCOMM()
#         print('=============== Query from Address Book ====================')
#         dv_comm.query_addresses()
#         print('=============== Insert Record into Address Book ====================')
#         # values = [('PL36106', 'Ajay', 'Koonuru', '["ajay.koonuru@pnc.com"]')]
#         # (dv_comm.generate_random_id(), 'Chandler', 'Long', '["Chandler.long@pnc.com"]')]
#         dv_comm.insert_addresses('PL36106', 'Ajay', 'Koonuru', '["ajay.koonuru@pnc.com"]')
#         print('=============== Query from Address Book ====================')
#         dv_comm.query_addresses()
#         print('=============== Closing Connection ====================')
#     except:
#         return {"message": "Bye Worlds"}
#
#
# endpoint1()
