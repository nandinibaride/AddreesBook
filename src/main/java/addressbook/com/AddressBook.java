package addressbook.com;

public class AddressBook {
	
	public static void main(String args[]) {
		Person person = new Person();
		
		person.setFirstname("Nandini");
		person.setLastname("Baride");
		person.setCity("Latur");
		person.setEmail("nandu@gmail.com");
		person.setAddress("kolhe nagar Pune");
		person.setState("Maharashtra");
		person.setZip(987654);
		person.setPhonenumber(989878656); 
		
		System.out.println(person);
	 }
}

