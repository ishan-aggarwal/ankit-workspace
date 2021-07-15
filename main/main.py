import uvicorn as uvicorn
from fastapi import FastAPI
from model import AddressBook

from query_dvcomm_db import QueryDVCOMM
dv_comm = QueryDVCOMM()

app = FastAPI()


@app.get("/")
async def root():
    return "Hi, try /query  or /insert"

@app.get("/query/{aid}")
async def endpoint3(aid):
    return dv_comm.query_addresse_by_id(aid)

@app.get("/query")
async def endpoint1():
    return dv_comm.query_addresses()


@app.post("/insert")
async def endpoint2(addr: AddressBook):
    return dv_comm.insert_addresses(addr.id, addr.firstname, addr.lastname, addr.email)
    # return (dv_comm.insert_addresses('PL36107', 'Ajay', 'Aoonuru', '["ajay.koonuru@pnc.com"]'),)

# @app.get("/ep1")
# async def endpoint1():
#     try:
#         dv_comm = QueryDVCOMM()
#         # print('=============== Query from Address Book ====================')
#         # dv_comm.query_addresses()
#         # print('=============== Insert Record into Address Book ====================')
#         # # values = [('PL36106', 'Ajay', 'Koonuru', '["ajay.koonuru@pnc.com"]')]
#         # # (dv_comm.generate_random_id(), 'Chandler', 'Long', '["Chandler.long@pnc.com"]')]
#         dv_comm.insert_addresses('PL36106', 'Ajay', 'Koonuru', '["ajay.koonuru@pnc.com"]')
#         # print('=============== Query from Address Book ====================')
#         # dv_comm.query_addresses()
#         # print('=============== Closing Connection ====================')
#     except:
#         return {"message": "Bye Worlds"}


if __name__ == "__main__":
    uvicorn.run(app, host="127.0.0.1", port=8001)