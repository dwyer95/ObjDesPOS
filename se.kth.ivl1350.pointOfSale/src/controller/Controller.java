package controller;
import datatypes.*;
import integration.*;
import model.*;

public class Controller {
	private AccountingSystem accounting;
	private InventorySystem inventory;
	private Printer printer;
	private Sale sale;
	private Receipt receipt;
	
	/**
	 * Creates an instance of the Controller class.
	 * 
	 * @param accounting
	 * @param inventory
	 */
	public Controller(AccountingSystem accounting, InventorySystem inventory, Printer printer) {
		this.accounting = accounting;
		this.inventory = inventory;
		this.printer = printer;
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
		return sale.getTotalPriceOfItemsIncludingVAT();
	}
	
	/**
	 * 
	 * @param paidAmount
	 * @return
	 */
	public void enterPaidAmount(Amount paidAmount) {
		sale.setAmountPaid(paidAmount);
	}
	
	public float calculatePriceOfVAT(Item item) {
		return sale.calculatePriceOfVAT(item);
	}
	
	public float calculatePriceIncludingVAT(Item item) {
		return sale.calculatePriceIncludingVAT(item);
	}
	
	public void addToTotalPriceOfItems(Amount priceOfItem) {
		sale.addToTotalPriceOfItems(priceOfItem);
	}
	
	public void addToTotalPriceOfVAT(Amount priceOfVAT) {
		sale.addToTotalPriceOfVAT(priceOfVAT);
	}
	
	public void addToTotalPriceOfItemsIncludingVAT(Amount itemPrice) {
		sale.getTotalPriceOfItemsIncludingVAT().add(itemPrice);
	}
	
	public void printReceipt() {
		receipt = sale.createReceipt();
		printer.printReceipt(receipt);
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
	
	public void printListOfSoldItems() {
		sale.printListOfSoldItems();
	}
	
	/**
	 * Sends information about the sale to the external accounting system.
	 */
	public void sendSaleInfo() {
		accounting.sendSaleInfo(sale);
	}
	
	public Amount getTotalPriceOfItems() {
		return sale.getTotalPriceOfItems();
	}
	
	public Amount getTotalPriceOfVAT() {
		return sale.getTotalPriceOfVAT();
	}
	
	public Amount getTotalPriceOfItemsIncludingVAT() {
		return sale.getTotalPriceOfItemsIncludingVAT();
	}
	
	public Amount getChange() {
		return sale.getChange();
	}
	
	public void setChange() {
		sale.setChange();
	}

}
