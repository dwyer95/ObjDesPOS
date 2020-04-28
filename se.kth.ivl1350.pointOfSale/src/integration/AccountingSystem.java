package integration;

import datatypes.Address;

/**
 * 
 * The handler that communicates with the external accounting system.
 * 
 * @author Jacob Dwyer
 *
 */
public class AccountingSystem {
	
	/**
	 * Creates an instance of the AccountingSystem class.
	 * 
	 * @author Jacob Dwyer
	 * 
	 */
	public AccountingSystem() {
		
	}
	
	public void sendSaleInfo() {
		
	}
	
	public Address retrieveAddress() {
		Address address = new Address("Cityville", 123456, "Avenue st. 7");
		return address;
	}
}
