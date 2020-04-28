package model;
import java.time.LocalDateTime;

import datatypes.Address;

/**
 * @author Jacob Dwyer
 *
 */
public class Receipt {
	private java.time.LocalDate dateOfSale;
	private java.time.LocalTime timeOfSale;
	private Address addressOfStore;
	
	public Receipt(Sale sale) {
		this.dateOfSale = sale.getDateOfSale();
		this.timeOfSale = sale.getTimeOfSale(); 
	}
}
