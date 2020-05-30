package model;
import integration.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import datatypes.Address;
import datatypes.Amount;

/**
 * Represents a single sale.
 */
public class Sale {
	private static final int VAT_DIVISOR = 100;
	
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
	private java.time.LocalDateTime dateOfSale;
	private java.time.LocalDateTime timeOfSale;
	private Address addressOfStore;
	private ArrayList<Item> soldItems;
	private Amount totalPriceOfItems;
	private Amount totalPriceOfVAT;
	private Amount totalPriceOfItemsIncludingVAT;
	private Amount amountPaid;
	private Amount change;
	
	/**
	 * Adds a <code>saleObserver</code> to the list in saleObservers.
	 * @param observer The <code>saleObserver</code> to be added to the list.
	 */
	public void addSaleObserver(SaleObserver observer) {
		saleObservers.add(observer);
	}
	
	/**
	 * Adds each <code>saleObserver</code> in a list to the list saleObservers, in order.
	 * @param observers The list of <code>saleObservers</code>.
	 */
	public void addSaleObservers(List<SaleObserver> observers) {
		saleObservers.addAll(observers);
	}
	
	/**
	 * Notifies each observer object in the list <code>saleObservers</code>.
	 * @param paidAmount The amount paid by the customer.
	 */
	private void notifyObservers(float paidAmount) {
		for(SaleObserver observer : saleObservers) {
			observer.newPayment(paidAmount);
		}
	}
	
	/**
	 * Creates a new instance of the <code>Sale</code> class.
	 * @param address The location of the store.
	 */
	public Sale(Address address) {
		this.dateOfSale = java.time.LocalDateTime.now();
		this.timeOfSale = java.time.LocalDateTime.now();
		addressOfStore = address;
		soldItems = new ArrayList<>();
		totalPriceOfItems = new Amount(0f);
		totalPriceOfVAT = new Amount(0f);
		totalPriceOfItemsIncludingVAT = new Amount(0f);
		amountPaid = new Amount(0f);
		change = new Amount(0f);
	}
	
	/**
	 * Adds an <code>Item</code> to the <code>ArrayList</code> <code>soldItem</code> in this
	 * instance of <code>Sale</code>. If itemToAdd is null, do nothing.
	 * @param itemToAdd The <code>Item</code> to add to the list.
	 */
	public void addItem(Item itemToAdd) {
		if(itemToAdd == null)
			return;
		else
			soldItems.add(itemToAdd);
	}
	
	/**
	 * Prints the name, quantity and price of each <code>Item</code> in the <code>soldItems</code>
	 * list. If the quantity is not more than 1, quantity is not listed.
	 */
	public void printListOfSoldItems() {
		for(Item item : soldItems) {
			if(item.getQuantity() > 1)
				System.out.println(item.getName() + " *" + item.getQuantity() + "\t" + item.getPrice().getAmount());
			else
				System.out.println(item.getName() + "  \t" + item.getPrice().getAmount());
		}
	}
	
	/**
	 * Calculates the VAT of an <code>Item</code>.
	 * @param item The <code>Item</code> whose VAT should be calculated. 
	 * @return The VAT of the <code>Item</code>.
	 */
	public float calculatePriceOfVAT(Item item) {
		return item.getPrice().getAmount() * (item.getVATRate() / VAT_DIVISOR);
	}
	
	/**
	 * Calculates the total price, including VAT, of an <code>Item</code>.
	 * @param item The <code>Item</code> whose total price should be calculated.
	 * @return The total price, including VAT, of the <code>Item</code>.
	 */
	public float calculatePriceIncludingVAT(Item item) {
		return item.getPrice().getAmount() + (item.getPrice().getAmount() * 
				 (item.getVATRate() / VAT_DIVISOR));
	}
	
	/**
	 * Adds the total price, excluding VAT, of an <code>Item</code> to the total price of items.
	 * @param priceOfItem The price to be added.
	 */
	public void addToTotalPriceOfItems(Amount priceOfItem) {
		totalPriceOfItems.add(priceOfItem);
	}
	
	/**
	 * Adds the VAT price of an <code>Item</code> to the total price of VATs.
	 * @param priceOfVAT The price to be added.
	 */
	public void addToTotalPriceOfVAT(Amount priceOfVAT) {
		totalPriceOfVAT.add(priceOfVAT);
	}
	
	/**
	 * Creates an instance of the <code>Receipt</code> class.
	 * @return The created receipt.
	 */
	public Receipt createReceipt() {
		Receipt receipt = new Receipt(this);
		return receipt;
	}
	
	/**
	 * Gets the date in which the <code>Sale</code> took place.
	 * @return The date in which the <code>Sale</code> took place.
	 */
	public java.time.LocalDate getDateOfSale(){
		return dateOfSale.toLocalDate();
	}
	
	/**
	 * Gets the time of day in which the <code>Sale</code> took place.
	 * @return The time of day in which the <code>Sale</code> took place.
	 */
	public java.time.LocalTime getTimeOfSale(){
		return timeOfSale.toLocalTime();
	}
	
	/**
	 * Gets the <code>Address</code> of the store in which the <code>Sale</code> took place.
	 * @return The <code>Address</code> of the store in which the <code>Sale</code> took place.
	 */
	public Address getAddress() {
		return addressOfStore;
	}
	
	/**
	 * Gets the list of sold items.
	 * @return The list of sold items.
	 */
	public ArrayList<Item> getSoldItemList() {
		return soldItems;
	}
	
	/**
	 * Gets the total price of the <code>Items</code> in the <code>Sale</code>.
	 * @return The total price of the items in <code>Amount</code>.
	 */
	public Amount getTotalPriceOfItems() {
		return totalPriceOfItems;
	}
	
	/**
	 * Gets the total VAT of the entire <code>Sale</code>.
	 * @return The total VAT in <code>Amount</code> form.
	 */
	public Amount getTotalPriceOfVAT() {
		return totalPriceOfVAT;
	}
	
	/**
	 * Gets the total price of all the <code>Items</code>, including VAT.
	 * @return The price of all items, including VAT, in <code>Amount</code> form.
	 */
	public Amount getTotalPriceOfItemsIncludingVAT() {
		return totalPriceOfItemsIncludingVAT;
	}
	
	/**
	 * Gets the <code>Amount</code> paid by the customer.
	 * @return The <code>Amount</code> paid by the customer.
	 */
	public Amount getAmountPaid() {
		return amountPaid;
	}
	
	/**
	 * Adds the <code>Amount</code> received from the customer to the total amount 
	 * that has been payed.
	 * @param amountReceived The <code>Amount</code> received from the customer.
	 */
	public void addAmountPaid(Amount amountReceived) {
		amountPaid.add(amountReceived);
	}
	
	/**
	 * Gets the <code>change</code> stored in an instance of <code>Sale</code>.
	 * @return The stored <code>change</code>.
	 */
	public Amount getChange() {
		return change;
	}
	
	/**
	 * Calculates and sets the <code>change</code> that the customer should receive
	 * from the current <code>Sale</code>.
	 * @param paidAmount The amount that has been paid by the customer.
	 */
	public void setChange(float paidAmount) {
		change.setAmount((float)Math.floor(amountPaid.getAmount() - totalPriceOfItemsIncludingVAT.getAmount()));
		notifyObservers(paidAmount);
	}
}
