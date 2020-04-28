package model;
import integration.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import datatypes.Address;
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
	private ArrayList<Item> soldItems;
	private Amount totalPrice;
	private Amount amountPaid;
	private Amount change;
	
	public Sale(Address address) {
		this.dateOfSale = java.time.LocalDateTime.now();
		this.timeOfSale = java.time.LocalDateTime.now();
		addressOfStore = address;
		soldItems = new ArrayList<Item>();
		totalPrice = new Amount(0f);
		amountPaid = new Amount(0f);
		change = new Amount(0f);
	}
	
	public void addItem(Item itemToAdd) {
		soldItems.add(itemToAdd);
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
		return amountPaid;
	}
	
	/*public void updateTotalPrice(Amount priceOfCurrentItems) {
		float currentTotal = totalPrice.getAmount();
		currentTotal += priceOfCurrentItems.getAmount();
		totalPrice = currentTotal;
	}*/
	
	public void setTotalPrice(Amount newTotalPrice) {
		
	}
	
	public void setAmountPaid(Amount amountReceived) {
		amountPaid = amountReceived;
	}
	
	public Amount getChange() {
		return change;
	}
	
	public void setChange() {
		change.setAmount(totalPrice.getAmount() - amountPaid.getAmount());
	}
}
