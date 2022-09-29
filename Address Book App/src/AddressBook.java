import java.util.HashMap;

public class AddressBook {
	private HashMap<String, Contact> contacts;

	public static AddressBook combineTwo(AddressBook one, AddressBook two) {
		AddressBook combinedBook = new AddressBook();
		HashMap<String, Contact> combinedBookContacts = combinedBook.getContacts();
		combinedBookContacts.putAll(one.getContacts());
		for (String s:two.getContacts().keySet()) {
			Contact current = one.getContacts().get(s);
			Contact contact = two.getContacts().get(s);
			if(current == null) {
				combinedBookContacts.put(s, contact);
			}
			else {
				if(current.getPhoneNum().length() == 0 || contact.getPhoneNum().length() == 0) {
					current.setPhoneNum(current.getPhoneNum() + contact.getPhoneNum());
				}
				else {
					current.setPhoneNum(contact.getPhoneNum());
				}
				if(current.getMailAddr().length() == 0 || contact.getMailAddr().length() == 0) {
					current.setMailAddr(current.getMailAddr() + contact.getMailAddr());
				}
				else {
					current.setMailAddr(contact.getMailAddr());
				}
				if(current.getEmail().length() == 0 || contact.getEmail().length() == 0) {
					current.setEmail(current.getEmail() + contact.getEmail());
				}
				else {
					current.setEmail(contact.getEmail());
				}
			}
		}
			
		return combinedBook;
	}
	
	public AddressBook() {
		contacts = new HashMap<String, Contact>();
		
	}
	
	public void addContact(Contact contact) {
		Contact existingContact = contacts.get(contact.getName());
		if(existingContact == null) {
			contacts.put(contact.getName(), contact);
		}
		else {
			combineOrInsert(existingContact, contact);
		}
	}
	
	private void combineOrInsert(Contact existingContact, Contact contact) {
		if(existingContact.getPhoneNum().length() == 0 || contact.getPhoneNum().length() == 0) {
			existingContact.setPhoneNum(existingContact.getPhoneNum() + contact.getPhoneNum());
		}
		else {
			existingContact.setPhoneNum(contact.getPhoneNum());
		}
		if(existingContact.getMailAddr().length() == 0 || contact.getMailAddr().length() == 0) {
			existingContact.setMailAddr(existingContact.getMailAddr() + contact.getMailAddr());
		}
		else {
			existingContact.setMailAddr(contact.getMailAddr());
		}
		if(existingContact.getEmail().length() == 0 || contact.getEmail().length() == 0) {
			existingContact.setEmail(existingContact.getEmail() + contact.getEmail());
		}
		else {
			existingContact.setEmail(contact.getEmail());
		}
	}
	


	public HashMap<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		String output = "";
		for(String key: contacts.keySet()) {
			output += contacts.get(key).toString() + "\n";
		}
		return output;
	}
	
	
	

}
