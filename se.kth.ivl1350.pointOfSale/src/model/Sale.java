package model;
import integration.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import datatypes.*;

/**
 * Represents a single sale.
 */
public class Sale {
	private static final int VAT_DIVISOR = 100;
	
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
	 * Creates a new instance of the <code>Sale</code> class.
	 * @param address The location of the store.
	 */
	public Sale(Address address) {
		this.dateOfSale = java.time.LocalDateTime.now();
		this.timeOfSale = java.time.LocalDateTime.now();
		addressOfStore = address;
		soldItems = new ArrayList<Item>();
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
	 * Adds total prices of the scanned item to corresponding parameters in this object and
	 * returns a string showing info about scanned item as well as the running total.
	 * @param scannedItem The item which is being scanned
	 * @return A string showing info about the scanned item and the running total
	 */
	public String enterItemIdentifier(ItemDTO scannedItem) {
		totalPriceOfItems.add(scannedItem.getPrice());
		totalPriceOfVAT.add(calculatePriceOfVAT(scannedItem));
		totalPriceOfItemsIncludingVAT.add(calculatePriceIncludingVAT(scannedItem));
		return scannedItemToString(scannedItem);
	}
	
	private String scannedItemToString(ItemDTO scannedItem) {
		StringBuilder itemAndRunningTotal = new StringBuilder();
		itemAndRunningTotal.append(scannedItem.toString());
		itemAndRunningTotal.append("\nRunning total: " + totalPriceOfItemsIncludingVAT.getAmount() + "\n");
		return itemAndRunningTotal.toString();
	}
	
	/**
	 * Returns a list, in the form of a String, of sold items containing the name, quantity and price 
	 * of each <code>Item</code> in the <code>soldItems</code> list. If the quantity is not more than 1, 
	 * quantity is not listed.
	 * @return The String which makes up the list of items
	 */
	public String printListOfSoldItems() {
		StringBuilder soldItemsList = new StringBuilder();
		for(Item item : soldItems) {
			if(item.getQuantity() > 1)
				soldItemsList.append(item.getName() + " *" + item.getQuantity() + "\t" + item.getPrice().getAmount()
						+ "\n");
			else
				soldItemsList.append(item.getName() + "  \t" + item.getPrice().getAmount() + "\n");
		}
		return soldItemsList.toString();
	}
	
	/**
	 * Calculates the VAT of an <code>Item</code> and returns it as an Amount.
	 * @param item The <code>Item</code> whose VAT should be calculated. 
	 * @return The VAT of the <code>Item</code>, as an Amount.
	 */
	private Amount calculatePriceOfVAT(ItemDTO item) {
		return new Amount(item.getPrice().getAmount() * (item.getVATRate() / VAT_DIVISOR));
	}
	
	/**
	 * Calculates the total price, including VAT, of an <code>Item</code>.
	 * @param item The <code>Item</code> whose total price should be calculated.
	 * @return The total price, including VAT, of the <code>Item</code>.
	 */
	private Amount calculatePriceIncludingVAT(ItemDTO item) {
		return new Amount(item.getPrice().getAmount() + (item.getPrice().getAmount() * 
				 (item.getVATRate() / VAT_DIVISOR)));
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
	 * Sets the <code>Amount</code> that has been paid by the customer.
	 * @param amountReceived The <code>Amount</code> received from the customer.
	 */
	public float setAmountPaid(Amount amountReceived) {
		amountPaid = amountReceived;
		setChange();
		return change.getAmount();
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
	 */
	private void setChange() {
		change.setAmount((float)Math.floor(amountPaid.getAmount() - totalPriceOfItemsIncludingVAT.getAmount()));
	}
}
