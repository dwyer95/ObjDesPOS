package datatypes;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Address {
	private String name;
	private String street;
	private int zipCode;
	private String city;

	/**
	 * Creates a new instance of the <code>Address</code> class.
	 * 
	 * @param street Tells which street the store is on.
	 * @param zipCode Tells which zipcode the store uses. 
	 * @param city Tells what city the store is located in.
	 */
	public Address(String street, int zipCode, String city) {
		name = "Hello Goodbuy";
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuilder addressString = new StringBuilder();
		addressString.append("Hello Goodbuy ");
		addressString.append("on " + street + " ");
		addressString.append("in " + city + " ");
		addressString.append("(" + zipCode + ")");
		return addressString.toString();
	}
}
