/**
 * 
 */
package model;
import java.time.LocalDateTime;

/**
 * @author Jacob Dwyer
 *
 */
public class Receipt {
	private java.time.LocalDateTime dateOfSale;
	private java.time.LocalDateTime timeOfSale;
	private Address addressOfStore;
	
	public Receipt Receipt(Sale sale) {
		Receipt receipt = new Receipt();
		this.dateOfSale = sale.getDateOfSale();
		this.timeOfSale = sale.getTimeOfSale(); 
		return receipt;
	}
}
