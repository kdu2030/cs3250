import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {
	private HashMap<String, Contact> contacts;

	
	public AddressBook() {
		contacts = new HashMap<String, Contact>();
		
	}
	
	public void addContact(Contact contact) {
		contacts.put(contact.getName(), contact);
		
	}

	public HashMap<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	

}
