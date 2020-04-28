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
	
	public void loopThroughSoldItems() {
		for(Item item : soldItems) {
			if(item.getQuantity() > 1)
				System.out.println(item.getName() + " *" + item.getQuantity() + "\t" + item.getPrice().getAmount());
			else
				System.out.println(item.getName() + "  \t" + item.getPrice().getAmount());
		}
	}
	
	/**
	 * 
	 * @return The date in which the sale took place.
	 */
	public java.time.LocalDate getDateOfSale(){
		return dateOfSale.toLocalDate();
	}
	
	/**
	 * 
	 * @return The time in which the sale took place.
	 */
	public java.time.LocalTime getTimeOfSale(){
		return timeOfSale.toLocalTime();
	}
	
	public Address getAddress() {
		return addressOfStore;
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
		change.setAmount(amountPaid.getAmount() - totalPrice.getAmount());
	}
}
