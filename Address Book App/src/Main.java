import java.util.Scanner;

public class Main {
	
	public static void addContactsToAddressBook(AddressBook book, Scanner scan) {
		String input = "";
		int contactNum = 1;
		while(true) {
			System.out.printf("----Contact %d --- \n", contactNum);
			System.out.print("Name: ");
			String name = scan.nextLine();
			if(name.equals("#")) {
				break;
			}
			System.out.print("Phone Number: ");
			String phoneNum = scan.nextLine();
			System.out.print("Mailing Address: ");
			String mailAddr = scan.nextLine();
			System.out.print("Email Address: ");
			String emailAddr = scan.nextLine();
			contactNum++;
			book.addContact(new Contact(name, phoneNum, mailAddr, emailAddr));
			
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Address Book App");
		System.out.println("Enter contacts for Address Book 1, type # for the name when finished");
		System.out.println("Address Book 1:");
		AddressBook book1 = new AddressBook();
		AddressBook book2 = new AddressBook();
		addContactsToAddressBook(book1, scan);
		System.out.println("Address Book 2:");
		addContactsToAddressBook(book1, scan);
		AddressBook book3 = AddressBook.combineTwo(book1, book2);
		System.out.println(book3);
		
		

	}

}
