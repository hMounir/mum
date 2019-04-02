package library.business;

import java.io.Serializable;

public class Person implements Serializable{

    private String firstName;
    private String lastName;
    private String phone;
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, String phone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
    
    
}