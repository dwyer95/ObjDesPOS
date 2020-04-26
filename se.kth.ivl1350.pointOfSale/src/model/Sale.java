package model;
import java.time.LocalDateTime;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Sale {
	private java.time.LocalDateTime dateOfSale;
	private java.time.LocalDateTime timeOfSale;
	private Address addressOfStore;
	private Amount totalPrice;
	private Amount amountPaid;
	private Item soldItem;
	private Amount change;
	
	public Sale Sale() {
		Sale sale = new Sale();
		this.dateOfSale = java.time.LocalDateTime.now();
		this.timeOfSale = java.time.LocalDateTime.now();
		return sale;
	}
	
	public void setAddress() {
		addressOfStore = address;
	}
	
	public java.time.LocalDateTime getDateOfSale(){
		return dateOfSale;
	}
	
	public java.time.LocalDateTime getTimeOfSale(){
		return timeOfSale;
	}
	
	public Amount getTotalPrice() {
		return totalPrice;
	}
}
