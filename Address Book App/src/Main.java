import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Address Book App");
		System.out.println("Enter contacts for Address Book 1, type # as the contact name when finished");
		System.out.println("Address Book 1:");
		String input = "";
		int contactNum = 1;
		AddressBook book1 = new AddressBook();
		while(!input.equals("#")) {
			System.out.printf("----Contact %d --- \n", contactNum);
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Phone Number: ");
			String phoneNum = scan.nextLine();
			System.out.print("Mailing Address: ");
			String mailAddr = scan.nextLine();
			System.out.print("Email Address: ");
			String emailAddr = scan.nextLine();
			contactNum++;
			input = emailAddr;
			book1.addContact(new Contact(name, phoneNum, mailAddr, emailAddr));
			
		}
		

	}

}
