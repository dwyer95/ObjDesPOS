package controller;
import datatypes.*;
import integration.*;
import model.*;

/**
 *Represents the controller class which communicates with the classes in the other
 *packages and view.
 */
public class Controller {
	private AccountingSystem accounting;
	private InventorySystem inventory;
	private Printer printer;
	private Sale sale;
	private Receipt receipt;
	
	/**
	 * Creates an instance of the controller class.
	 * @param accounting The accounting system handler that the controller communicates with.
	 * @param inventory The inventory system handler that the controller communicates with.
	 * @param printer The printer handler that the controller communicates with.
	 */
	public Controller(AccountingSystem accounting, InventorySystem inventory, Printer printer) {
		this.accounting = accounting;
		this.inventory = inventory;
		this.printer = printer;
	}
	
	/**
	 * Marks the beginning of the sale.
	 */
	public void initializeSale() {
		sale = new Sale(accounting.retrieveAddress());
	}
	
	/**
	 * Calls the corresponding method in the inventory system handler.
	 */
	public void addItemsToAvailableItemsList() {
		inventory.addItemsToAvailableItemsList();
	}
	
	/**
	 * Calls the corresponding method in the inventory system handler.
	 * @param enteredItemID The barcode use to search the inventory system.
	 * @return The ItemDTO retrieved from the inventory system handler.
	 */
	public String enterItemIdentifier(Barcode enteredItemID) {
		return sale.enterItemIdentifier(inventory.retrieveInfo(enteredItemID));
		//return inventory.retrieveInfo(enteredItemID);
	}
	
	/**
	 * Calls the corresponding method in the inventory system handler.
	 * @param itemToAdd The item to add.
	 */
	public void addItemsToCurrentSale(Item itemToAdd) {
		sale.addItem(itemToAdd);
	}
	
	/**
	 * Used to signify that the <code>Sale</code> has ended.
	 * @return The total price, including VAT.
	 */
	public Amount endSale() {
		return sale.getTotalPriceOfItemsIncludingVAT();
	}
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance.
	 * @param paidAmount The amount paid by the customer.
	 */
	public float enterPaidAmount(Amount paidAmount) {
		return sale.setAmountPaid(paidAmount);
	}
	
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance.
	 * @param item The <code>Item</code> to calculate the VAT of.
	 * @return The price of the VAT.
	 */
	/*public void calculatePriceOfVAT(ItemDTO item) {
		sale.calculatePriceOfVAT(item);
	}*/
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance. 
	 * @param item The <code>Item</code> to calculate the price, including VAT, of.
	 * @return The price, including VAT.
	 */
	/*public void calculatePriceIncludingVAT(ItemDTO item) {
		sale.calculatePriceIncludingVAT(item);
	}*/
	
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance. 
	 * @param priceOfItem The price to be added.
	 */
	public void addToTotalPriceOfItems(Amount priceOfItem) {
		sale.addToTotalPriceOfItems(priceOfItem);
	}
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance. 
	 * @param priceOfVAT The price to be added.
	 */
	public void addToTotalPriceOfVAT(Amount priceOfVAT) {
		sale.addToTotalPriceOfVAT(priceOfVAT);
	}
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance. 
	 * @param itemPrice The price to be added.
	 */
	public void addToTotalPriceOfItemsIncludingVAT(Amount itemPrice) {
		sale.getTotalPriceOfItemsIncludingVAT().add(itemPrice);
	}
	
	/**
	 * Creates a <code>Receipt</code> locally and calls the corresponding method 
	 * in a <code>Printer</code> instance. 
	 */
	public void printReceipt() {
		receipt = sale.createReceipt();
		printer.printReceipt(receipt);
	}

	/**
	 * Calls the corresponding method in an <code>AccountingSystem</code> instance. 
	 */
	public void sendSaleInfo() {
		accounting.sendSaleInfo(sale);
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
	
	/*public void setChange() {
		sale.setChange();
	}*/

}
