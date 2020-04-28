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
		//Item retrievedItem;
		
		return inventory.retrieveInfo(enteredItemID);
		
		//return retrievedItem;
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
	
	public void addToTotalPrice(Amount itemPrice) {
		this.sale.getTotalPrice().add(itemPrice);
	}
	
	public Amount getChange() {
		return sale.getChange();
	}
	
	public void setChange() {
		sale.setChange();
	}

}
