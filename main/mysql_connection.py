import mysql.connector
from mysql.connector import errorcode


class DBConnection:
    """
    This class creates the connection and returns the connection object
    """

    def __init__(self, configuration):
        self.config = configuration

    def __enter__(self):
        try:
            # print(self.config)
            self.cnx = mysql.connector.connect(**self.config)
            self.cursor = self.cnx.cursor()
        except mysql.connector.Error as err:
            if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
                print("Something is wrong with your user name or password")
            elif err.errno == errorcode.ER_BAD_DB_ERROR:
                print("Database does not exist")
            else:
                print(err)
        # else:
            # print('Successfully created connection')
            # print('close connection')
            # raise Exception
            # self.cnx.close()

        return self.cursor

    def __exit__(self, exc_type, exc_value, exc_trace):
        print('closing connection :', str(exc_value), str(exc_trace), str(exc_type))
        self.cnx.commit()
        self.cursor.close()
        self.cnx.close()


