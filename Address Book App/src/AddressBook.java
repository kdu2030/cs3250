import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {
	private HashMap<String, Contact> contacts;

	
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
		else if(existingContact.getMailAddr().length() == 0 || contact.getMailAddr().length() == 0) {
			existingContact.setMailAddr(existingContact.getMailAddr() + contact.getMailAddr());
		}
		else if(existingContact.getEmail().length() == 0 || contact.getEmail().length() == 0) {
			existingContact.setEmail(existingContact.getEmail() + contact.getEmail());
		}
		else {
			contacts.put(contact.getName(), contact);
		}
	}



	public HashMap<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	

}
