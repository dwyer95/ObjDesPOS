package controller;
import datatypes.Amount;
import exceptions.*;
import datatypes.Barcode;

import java.util.*;

import datatypes.Address;
import integration.*;
import model.*;

/**
 *Represents the controller class which communicates with the classes in the other
 *packages and view.
 */
public class Controller {
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
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
		sale.addSaleObservers(saleObservers);
	}
	
	/**
	 * Calls the corresponding method in <code>Sale</code>.
	 * @param observer The <code>saleObserver</code> to add.
	 */
	public void addSaleObserver(SaleObserver observer) {
		saleObservers.add(observer);
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
	 * @throws InventorySystemException If unable to retrieve item info from inventory system.
	 */
	public ItemDTO enterItemIdentifier(Barcode enteredItemID) throws InventorySystemException {
		try {
			ItemDTO item = inventory.retrieveInfo(enteredItemID);
			return item;
		}
		catch (InvalidBarcodeException e) {
			System.out.println("FOR DEVELOPERS: " + e + " " + e.getStackTrace());
			throw new InventorySystemException("The identifier you entered is invalid.", e);
		}
		catch (DatabaseNotRespondingException e) {
			System.out.println("FOR DEVELOPERS: " + e + " " + e.getStackTrace());
			throw new InventorySystemException("Could not connect to external inventory database. Please contact the database administrator.", e);
		}
		
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
	public void enterPaidAmount(Amount paidAmount) {
		sale.addAmountPaid(paidAmount);
	}
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance.
	 * @param item The <code>Item</code> to calculate the VAT of.
	 * @return The price of the VAT.
	 */
	public float calculatePriceOfVAT(Item item) {
		return sale.calculatePriceOfVAT(item);
	}
	
	/**
	 * Calls the corresponding method in a <code>Sale</code> instance. 
	 * @param item The <code>Item</code> to calculate the price, including VAT, of.
	 * @return The price, including VAT.
	 */
	public float calculatePriceIncludingVAT(Item item) {
		return sale.calculatePriceIncludingVAT(item);
	}
	
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
	
	public Amount getAmountPaid() {
		return sale.getAmountPaid();
	}
	
	public Amount getChange() {
		return sale.getChange();
	}
	
	public void setChange(float amountPaid) {
		sale.setChange(amountPaid);
	}

}
