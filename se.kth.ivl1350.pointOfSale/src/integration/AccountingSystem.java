package integration;

import model.Sale;
import datatypes.Address;

/**
 * The handler that communicates with the external accounting system.
 */
public class AccountingSystem {
	
	/**
	 * Creates an instance of the <code>AccountingSystem</code> class.
	 */
	public AccountingSystem() {
	}
	
	/**
	 * Sends information about the current sale to the external
	 * accounting system. Does nothing at the moment as the task
	 * did not involve external systems.
	 * @param sale The current <code>Sale</code>.
	 */
	public void sendSaleInfo(Sale sale) {
	}
	
	/**
	 * Retrieves the address of the store from the external accounting system.
	 * Since external systems are not used for this task, an <code>Address</code> is created
	 * locally instead.
	 * @return The address of the store.
	 */
	public Address retrieveAddress() {
		Address address = new Address("Avenue st. 7", 123456, "Cityville");
		return address;
	}
}
