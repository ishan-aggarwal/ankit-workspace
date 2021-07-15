from pydantic import BaseModel
from typing import Optional


class AddressBook(BaseModel):
    id: str
    firstname: Optional[str] = None
    lastname: Optional[str] = None
    email: Optional[str] = None
