import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressBookTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
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
		String name = "Obi Wan Kenobi";
		String phoneNum = "(283) 834-2812";
		String mailAddr = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String email = "okenobi@jedi.org";
		Contact obiWanKenobi = new Contact(name, phoneNum, mailAddr, email);
		String expectedOutput = "Contact [name=Obi Wan Kenobi, phoneNum=(283) 834-2812, mailAddr=120 Lightsaber Drive, Jedi Temple, Coruscant, email=okenobi@jedi.org]";
		assertEquals(expectedOutput, obiWanKenobi.toString());
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
		String name = "Yoda";
		String phoneNum = "                ";
		String mailAddr = "           120 Lightsaber Drive, Jedi Temple, Coruscant             ";
		String mailAddrRemoved = "120 Lightsaber Drive, Jedi Temple, Coruscant";
		String email = "yoda@jedi.org";
		Contact yoda = new Contact(name, phoneNum, mailAddr, email);
		String expectedOutput = String.format("Contact [name=%s, phoneNum=, mailAddr=%s, email=%s]", name, mailAddrRemoved, email);
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

}
