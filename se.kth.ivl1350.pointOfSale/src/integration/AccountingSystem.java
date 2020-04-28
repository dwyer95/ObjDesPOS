package integration;

import model.Sale;
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
	
	/**
	 * Sends information about the current sale to the external
	 * accounting system.
	 * 
	 * @param sale The current sale.
	 */
	public void sendSaleInfo(Sale sale) {
		
	}
	
	public Address retrieveAddress() {
		Address address = new Address("Avenue st. 7", 123456, "Cityville");
		return address;
	}
}
