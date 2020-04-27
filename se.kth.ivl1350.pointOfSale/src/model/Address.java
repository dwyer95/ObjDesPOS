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
	 * 
	 * @param street The street in the city in which the store is located.
	 * @param zipCode The zipcode of the store's address.
	 * @param city The city in which the store is located.
	 * @return The created instance.
	 */
	public Address(String street, int zipCode, String city) {
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
}
