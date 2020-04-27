package model;
import integration.*;
import java.time.LocalDateTime;

import datatypes.Amount;

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
	
	public void updateTotalPrice(ItemDTO itemDTO) {
		
	}
	
	public Amount addItem(ItemDTO item, int quantity) {
		
	}
	
	public void setAddress() {
		addressOfStore = address;
	}
	
	/**
	 * 
	 * @return The date in which the sale took place.
	 */
	public java.time.LocalDateTime getDateOfSale(){
		return dateOfSale;
	}
	
	/**
	 * 
	 * @return The time in which the sale took place.
	 */
	public java.time.LocalDateTime getTimeOfSale(){
		return timeOfSale;
	}
	
	/**
	 * 
	 * @return The total price of the sale.
	 */
	public Amount getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getAmountPaid() {
		return
	}
}
