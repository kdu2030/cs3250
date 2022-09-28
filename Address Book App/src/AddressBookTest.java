import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class AddressBookTest {
	private Contact obiWan;
	private Contact yoda;
	private AddressBook book;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		book = new AddressBook();
		
		String obiName = "Obi Wan Kenobi";
		String obiPhoneNum = "(283) 834-2812";
		String obiMail = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String obiEmail = "okenobi@jedi.org";
		obiWan = new Contact(obiName, obiPhoneNum, obiMail, obiEmail);
		
		String yodaName = "Yoda";
		String yodaPhoneNum = "(828) 263-2912";
		String yodaMailAddr = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String yodaEmail = "yoda@jedi.org";
		yoda = new Contact(yodaName, yodaPhoneNum, yodaMailAddr, yodaEmail);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		// Necessary because we will modify obiWan and yoda in the test method
		obiWan = null;
		yoda = null;
		book.setContacts(new HashMap<String, Contact>());
	}

	/**
	 * TC-1 
	 * Input: 
	 * Name: Obi-Wan Kenobi Phone Number: (283) 834-2812 Mailing
	 * Address: 120 Lightsaber Drive, Jedi Temple, Coruscant Email Address:
	 * okenobi@jedi.org
	 * 
	 * Output: Contact object
	 * 
	 */
	@Test
	public void contactObjectCreateTest() {
		String expectedOutput = "Contact [name=Obi Wan Kenobi, phoneNum=(283) 834-2812, mailAddr=120 Lightsaber Drive, Jedi Temple, Coruscant, email=okenobi@jedi.org]";
		assertEquals(expectedOutput, obiWan.toString());
	}

	/**
	 * TC2: 
	 * Input:
	 * Name: Yoda Mailing Address: "           120 Lightsaber Drive, Jedi Temple, Coruscant             " Phone Number:" " Email Address:
	 * yoda@jedi.org
	 * 
	 * Output: Contact Object with Name: "Yoda" Mailing Address: "120 Lightsaber Drive, Jedi Temple, Coruscant Phone Number: ""
	 * Email Address: "yoda@jedi.org"
	 * 
	 */

	@Test
	public void contactObjectEmptyStringTest() {
		yoda.setPhoneNum("                ");
		yoda.setMailAddr("           120 Lightsaber Drive, Jedi Temple, Coruscant             ");
		String mailAddrRemoved = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String expectedOutput = String.format("Contact [name=Yoda, phoneNum=, mailAddr=%s, email=yoda@jedi.org]", mailAddrRemoved);
		assertEquals(expectedOutput, yoda.toString());
	}
	
	/**
	 * TC3:
	 * Input:
	 * Name: ""
	 * Phone Number: “(283) 834-2812”
	 * Mailing Address: “120 Lightsaber Drive, Jedi Temple, Coruscant”
	 * Email Address: “okenobi@jedi.org”
	 * Output:
	 * Runtime Error Exception
	 */
	@Test
	public void contactEmptyNameTest() {
		String name = "";
		String phoneNum = "(283) 834-2812";
		String mailAddr = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String email = "okenobi@jedi.org";
		assertThrows(RuntimeException.class, () -> new Contact(name, phoneNum, mailAddr, email));
	}
	
	//User Story 2 Start
	
	/**
	 * TC4
	 * Input:
	 * Name: Obi-Wan Kenobi 
	 * Phone Number: (283) 834-2812 
	 * Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant 
	 * Email Address: okenobi@jedi.org
	 * 
	 * Name: Yoda
	 * Phone Number: (828) 263-2912
	 * Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant 
	 * Email Address: yoda@jedi.org
	 * 
	 * Expected Output:
	 * book.getContacts().size == 2
	 */
	
	@Test
	public void multipleContactsTest() {
		book.addContact(obiWan);
		book.addContact(yoda);
		assertEquals(2, book.getContacts().size());
	}
	
	/**
	 * TC5:
	 * Contact object 1 with the following information stored in Address Book:
	 * Name: Obi-Wan Kenobi
	 * Phone Number: (283) 834-2812
	 * Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	 * Email Address: okenobi@jedi.org
	 * 
	 * Contact object 2:
	 * Name: Obi-Wan Kenobi
	 * Phone Number: (123) 456-7890
	 * Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	 * Email Address: okenobi@jedi.org
	 * 
	 * Expected Output:
	 * AddressBook.hash.get(“Obi-Wan Kenobi”).getPhoneNum() == "(123) 456-7890"
	 */
	@Test
	public void conflictingContactsTest() {
		book.addContact(obiWan);
		Contact obiWan2 = new Contact("Obi Wan Kenobi", "(123) 456-7890", "120 Lightsaber Drive, Jedi Temple, Coruscant", "okenobi@jedi.org");
		book.addContact(obiWan2);
		HashMap<String, Contact> contacts = book.getContacts();
		assertEquals("(123) 456-7890", contacts.get("Obi Wan Kenobi").getPhoneNum());
	}
	
	/**TC11
	*Input: Contact object 1 with the following information stored in Address Book 1:
	*Name: Obi-Wan Kenobi
	*Phone Number: (283) 834-2812
	*Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	*Email Address: okenobi@jedi.org

	*Contact object 2 with the following information stored in Address Book 2:
	*Name: Obi-Wan Kenobi
	*Phone Number: (283) 834-2812
	*Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	*Email Address: okenobi@jedi.org
	*
	*
	*Output: After merging Address Book and Address Book 2, printing the new Address Book’s HashMap’s size should yield a value of 1
	
	/**TC12
	*Input: Contact object 1 with the following information stored in Address Book 1:
	*Name: Obi-Wan Kenobi
	*Phone Number: “”
	*Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	*Email Address: okenobi@jedi.org

	*Contact object 2 with the following information stored in Address Book 2:
	*Name: Obi-Wan Kenobi
	*Phone Number: (283) 834-2812
	*Mailing Address: “”
	*Email Address: okenobi@jedi.org
	*
	*
	*Output: After merging Address Book and Address Book 2, printing the new Address Book’s HashMap’s size should yield a value of 1, and the Contact in the HashMap should have information equal to:
	*Name: Obi-Wan Kenobi
	*Phone Number: (283) 834-2812
	*Mailing Address: 120 Lightsaber Drive, Jedi Temple, Coruscant
	*Email Address: okenobi@jedi.org 
	*/
	@Test
	public void nonConflictingMergeTest() {
		obiWan.setPhoneNum("");
		Contact obiWan2 = new Contact("Obi Wan Kenobi", "(283) 834-2812", "", "okenobi@jedi.org");
		Contact expectedObiWan3 = new Contact("Obi Wan Kenobi", "(283) 834-2812", "120 Lightsaber Drive, Jedi Temple, Coruscant", "okenobi@jedi.org");
		book.addContact(obiWan);
		AddressBook book2 = new AddressBook();
		book2.addContact(obiWan2);
		AddressBook book3 = AddressBook.combine(book, book2);
		
		assertEquals(book3.getContacts().keySet().size(), 2);
		assertEquals(book3.getContacts().get("Obi Wan Kenobi"), expectedObiWan3);
	}

}
