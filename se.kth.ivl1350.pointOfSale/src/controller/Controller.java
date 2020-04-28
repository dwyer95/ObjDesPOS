package controller;
import datatypes.*;
import integration.*;
import model.*;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Controller {
	private AccountingSystem accounting;
	private InventorySystem inventory;
	private Sale sale;
	
	/**
	 * Creates an instance of the Controller class.
	 * 
	 * @param accounting
	 * @param inventory
	 */
	public Controller(AccountingSystem accounting, InventorySystem inventory) {
		this.accounting = accounting;
		this.inventory = inventory;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public void initializeSale() {
		sale = new Sale(accounting.retrieveAddress());
	}
	
	/**
	 * Bridge between View and InventorySystem.
	 */
	public void addItemsToAvailableItemsList() {
		inventory.addItemsToAvailableItemsList();
	}
	
	/**
	 * When the cashier scans an item
	 * 
	 * @param itemID
	 * @param quantity The quantity of an item. Default value is 1.
	 */
	public ItemDTO enterItemIdentifier(Barcode enteredItemID) {
		return inventory.retrieveInfo(enteredItemID);
	}
	
	public void addItemsToCurrentSale(Item itemToAdd) {
		sale.addItem(itemToAdd);
	}
	
	/**
	 * Used to signify that the sale has ended.
	 * @param sale
	 * @return
	 */
	public Amount endSale() {
		return sale.getTotalPrice();
	}
	
	/**
	 * 
	 * @param paidAmount
	 * @return
	 */
	public void enterPaidAmount(Amount paidAmount) {
		sale.setAmountPaid(paidAmount);
	}
	
	public float calculatePriceIncludingVAT(Item item) {
		return item.getPrice().getAmount() + (item.getPrice().getAmount() * (item.getVATRate() / 100));
	}
	
	public void addToTotalPrice(Amount itemPrice) {
		sale.getTotalPrice().add(itemPrice);
	}
	
	public java.time.LocalDate getDateOfSale(){
		return sale.getDateOfSale();
	}
	
	public java.time.LocalTime getTimeOfSale(){
		return sale.getTimeOfSale();
	}
	
	public Address getAddress() {
		return sale.getAddress();
	}
	
	public void loopThroughSoldItems() {
		sale.loopThroughSoldItems();
	}
	
	/**
	 * Sends information about the sale to the external accounting system.
	 */
	public void sendSaleInfo() {
		accounting.sendSaleInfo(sale);
	}
	
	public Amount getChange() {
		return sale.getChange();
	}
	
	public void setChange() {
		sale.setChange();
	}

}
