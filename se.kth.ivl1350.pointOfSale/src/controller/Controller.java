package controller;
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
	
	public Sale initializeSale() {
		return sale = new Sale();
	}
	
	/**
	 * When the cashier scans an item
	 * 
	 * @param itemID
	 * @param quantity The quantity of an item. Default value is 1.
	 */
	public void enterItemIdentifier(Barcode itemID, int quantity) {
		
		if(itemIDExistsInDatabase) {
			
		}
	}
	
	public Amount endSale(Sale sale) {
		return sale.getTotalPrice();
	}
	
	public void signalDiscountRequest(CustomerID ID) {
		
	}
	
	public Amount enterPaidAmount(Amount paidAmount) {
		return paidAmount;
	}

}
