package addressbook.com;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.*;

public class AddressBook
{
    static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> addressbookName = new ArrayList<Person>();
	static HashMap<String, ArrayList<Person>> addressbook = new HashMap<>();
	static String addressBookName;
	static String city;
	int countAddressBook = 0;

	public void addContactDetails()
	{
		if (countAddressBook == 0)
		{
			System.out.println("AddressBook is not present");
		}
		System.out.println("Add new AddressBook:");
		addressBookName = sc.next();
        System.out.println("Enter the contact details:");

		Person addContactDetails = new Person();
		System.out.println("Enter the first name:");
		String firstName = sc.next();

		if (countAddressBook > 0)
		{ 
			while (true)
			{
				if (checkDuplicateEntry(firstName))
				{
					System.out.println("Contact already exist..Please enter other name");
					System.out.println("Enter the first name:");
					firstName = sc.next();
					break;
				} 
				else 
				{
                   break;
				}

			}
		 }

		System.out.println("Enter the last name:");
		String lastName = sc.next();
		System.out.println("Enter the address:");
		String address = sc.next();
		System.out.println("Enter the city:");
		city = sc.next();
		System.out.println("Enter the state:");
		String state = sc.next();
		System.out.println("Enter the email:");
		String email = sc.next();
		System.out.println("Enter the phonenumber:");
		String phoneNumber = sc.next();
		System.out.println("Enter the zip:");
		String zip = sc.next();

		addContactDetails.setFirstName(firstName);
		addContactDetails.setLastName(lastName);
		addContactDetails.setAddress(address);
		addContactDetails.setCity(city);
		addContactDetails.setState(state);
		addContactDetails.setEmail(email);
		addContactDetails.setPhonenumber(phoneNumber);
		addContactDetails.setZip(zip);

		addressbookName.add(addContactDetails);
		addressbook.put(addressBookName, addressbookName);
		countAddressBook++;
    }
	
   /*
    * @purpose: Edit contact details 
    */
    public void editContact(String fName)
	{
		for (Person person : addressbookName)
		{
			if (person.getFirstName().equals(fName)) 
			{
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
	 * @purpose: Remove contact details using first name.
	 */
	public void removeContactDetails()
	{
		System.out.println("Enter the contact details:");
		System.out.println("Enter the first name:");
		String firstName = sc.next();

		for (Person person : addressbookName)
		{
			if (person.getFirstName().equals(firstName))
			{
				addressbookName.remove(person);
			}
		}
	 }

	/*
	 * @purpose: To check duplicate entry using first name
	 */

	public boolean checkDuplicateEntry(String fName)
	{
		ArrayList<Person> personlist = addressbook.get(addressBookName);
		return personlist.stream().anyMatch(person -> fName.equals(person.getFirstName()));
	}
	/*
	 * @purpose: Search person by city.
	 */
	public void searchandViewPersonByCity()
	{
        System.out.println("Enter the name of the City: ");
		String cityName = sc.next();
		System.out.println("Enter the name of the Person : ");
		String personName = sc.next();
	    ArrayList<Person> Personlist = addressbook.get(addressBookName);
			addressbookName.stream()
					.filter(person -> person.getFirstName().equals(personName) && person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person));
	}
	 /*
	  * @purpose:Count City in details	 
	  */
	public void countByCity()
	{
        System.out.println("Enter the name of the City:");
		String cityName = sc.next();
		ArrayList<Person> Personlist = addressbook.get(addressBookName);
		long count = addressbookName.stream().filter(person -> cityName.equals(person.getCity())).count();
		System.out.println(count);
	}
	
	/*
	 * @purpose:Sort the entries first name, city, state and zip in address book.
	 */
    public void sortEnteriesOfPerson()
	{ 
    	System.out.println("1 : Sort person by first name");
		System.out.println("2 : Sort person by city");
		System.out.println("3 : Sort person by State");
		System.out.println("4 : Sort person by zip");
		
        int choice = sc.nextInt();
    	switch (choice) {
    	case 1:
		ArrayList<Person> Personlist = addressbook.get(addressBookName);
		addressbookName.stream()
         .sorted((firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
		 .collect(Collectors.toList())
		  .forEach(person -> System.out.println(person));
		break;
		
    	case 2:
    		ArrayList<Person> Personlist1 = addressbook.get(addressBookName);
    		addressbookName.stream()
             .sorted((firstperson, secondperson) -> firstperson.getCity().compareTo(secondperson.getCity()))
    		 .collect(Collectors.toList())
    		  .forEach(person -> System.out.println(person));
    		break;
    		
    	case 3:
    		ArrayList<Person> Personlist2 = addressbook.get(addressBookName);
    		addressbookName.stream()
             .sorted((firstperson, secondperson) -> firstperson.getState().compareTo(secondperson.getState()))
    		 .collect(Collectors.toList())
    		  .forEach(person -> System.out.println(person));
    		break;
    		
    	case 4:
    		ArrayList<Person> Personlist3 = addressbook.get(addressBookName);
    		addressbookName.stream()
             .sorted((firstperson, secondperson) -> firstperson.getZip().compareTo(secondperson.getZip()))
    		 .collect(Collectors.toList())
    		  .forEach(person -> System.out.println(person));
    		break;
    	
    	default:
			break;
    	}
	}

	public static void main(String args[])
    {
		AddressBook addressBook = new AddressBook();

		boolean flag = true;
		while (flag) {
			System.out.println("1.Add Contact" + "\n" + "2.Edit Contact" + "\n" + "3.Display AddressBook" + "\n"
					+ "4.Delete Contact" + "\n" + "5.Search and view person by city" + "\n" + "6.Count by city" + "\n" + "7.Sort By FirstName" + "\n" + "8.Exit");
			System.out.println("Enter the Choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				addressBook.addContactDetails();
				addressBook.checkDuplicateEntry(addressBookName);
				break;

			case 2:
				System.out.println("Edit details");
				String firstName = sc.next();
				addressBook.editContact(firstName);
				break;

			case 3:
				System.out.println(addressbook);
				break;

			case 4:
				addressBook.removeContactDetails();
				break;

			case 5:
				addressBook.searchandViewPersonByCity();
				break;
				
			case 6:
				addressBook.countByCity();
				break;
				
			case 7:
				addressBook.sortEnteriesOfPerson();
				break;
				
			case 8:
			default:
				flag = false;
				break;
			}
		}
	}
}

