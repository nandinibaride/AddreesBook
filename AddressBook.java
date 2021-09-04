package addressbook.com;

import java.util.ArrayList;	
import java.util.Scanner;

public class AddressBook {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> personList = new ArrayList<Person>();
	
	/*
	 * @purpose:Add contact details and set this details
	 * @return: No return value 
	 */

	public void addContactDetails() {
		
		System.out.println("Enter the contact details:");
		System.out.println("Enter the first name:");
		String firstName = sc.next();
		System.out.println("Enter the last name:");
		String lastName = sc.next();
		System.out.println("Enter the address:");
		String address = sc.next();
		System.out.println("Enter the city:");
		String city = sc.next();
		System.out.println("Enter the state:");
		String state = sc.next();
		System.out.println("Enter the email:");
		String email = sc.next();
		System.out.println("Enter the phonenumber:");
		String phoneNumber = sc.next();
		System.out.println("Enter the zip:");
    	String zip =sc.next();
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setEmail(email);
		person.setPhonenumber(phoneNumber);
		person.setZip(zip);
		
		personList.add(person);
	}
	

	/*
	 * @purpose: Edit contact details using cases
	 * @return: No return value
	 */

	public void editContact(String fName) {
		
		for (Person person : personList) {

			if (person.getFirstName().equals(fName)) {

				System.out.println("Enter the detail which needs to be updated:");

				System.out.println("1 : First Name of the contact to be edited");
				System.out.println("2 : Last Name of the contact to be edited");
				System.out.println("3 : Address of the contact to be edited");
				System.out.println("4 : City of the contact to be edited");
				System.out.println("5 : State of the contact to be edited");
				System.out.println("6 : Zip of the contact to be edited");
				System.out.println("7 : Phone Number of the contact to be edited");
				System.out.println("8 : Email of the contact to be edited");

				System.out.println("Select the index for the contact detail ");

				int choice = sc.nextInt();
				switch (choice) {
				case 1: 
					System.out.println("Enter First Name: ");
					String firstName = sc.next();
					person.setFirstName(firstName);
                   break;			
	
				case 2: 
					System.out.println("Enter last name: ");
					String lastName = sc.next();
					person.setLastName(lastName);
					break;
				
				case 3: 
					System.out.println("Enter Address: ");
					String address = sc.next();
					person.setAddress(address);
					break;
				
				case 4: 
					System.out.println("Enter City: ");
					String city = sc.next();
					person.setCity(city);
					break;
				
				case 5: 
					System.out.println("Enter State: ");
					String state = sc.next();
					person.setState(state);
					break;
				
				case 6: 
					System.out.println("Enter Zip: ");
					String zip = sc.nextLine();
					person.setZip(zip);
					break;
				
				case 7: 
					System.out.println("Enter Phone Number:");
					String phoneNumber = sc.nextLine();
					person.setPhonenumber(phoneNumber);
					break;
				
				case 8: 
					System.out.println("Enter Email Code: ");
					String email = sc.next();
					person.setEmail(email);
					break;
					
				default:
						break;
				}
			}

		}
	}
	/*
	 * @purpose: Remove contact details in list
	 * @return: No return value
	 */
	
      public void removeContactDetails() {
		
		System.out.println("Enter the contact details:");
		System.out.println("Enter the first name:");
		String firstName = sc.next();
				
		for(Person person : personList) {
			if(person.getFirstName().equals(firstName)) {
				personList.remove(person);
			}
		}		
	}
   
     public static void main(String args[]) {
		
		AddressBook addressBook = new AddressBook();
		boolean flag = true;
		while(flag) {
		System.out.println("1.Add Contact" + "\n" + "2.Edit Contact" + "\n" + "3.Display AddressBook" + "\n" + "4.Delete Contact" + "\n" + "5.Exit");
		System.out.println("Enter Choice");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			addressBook.addContactDetails();
			break;
		
		case 2:
			System.out.println("Edit details");
			String firstName = sc.next();
			addressBook.editContact(firstName);
			break;
		
		case 3:
			System.out.println(personList);
			break;
			
		case 4:
			addressBook.removeContactDetails();        
			break;
		default:
			flag = false;
			break;
		}
     }
   }
}
