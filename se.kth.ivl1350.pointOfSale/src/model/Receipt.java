/**
 * 
 */
package model;

/**
 * @author Jacob Dwyer
 *
 */
public class Receipt {
	private Date dateOfSale;
	private Time timeOfSale;
	private Address addressOfStore;
	
	public Receipt Receipt() {
		Receipt receipt = new Receipt();
		return receipt;
	}
}
