package model;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Address {
	private String street;
	private int zipCode;
	private String city;

	/**
	 * Creates an instance of the Address class.
	 * @return
	 */
	public Address Address(String street, int zipCode, String city) {
		Address address = new Address();
		return address;
	}
}
