package integration;
import java.util.ArrayList;
import model.Item;
import datatypes.*;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class InventorySystem {
	private ArrayList<ItemDTO> availableItems = new ArrayList<ItemDTO>();
	
	private static final String BANANA_NAME = "Banana";
	private static final Amount BANANA_PRICE = new Amount(10f);
	private static final float BANANA_VAT = 25f;
	private static final Barcode BANANA_IDENTIFIER = new Barcode(945310);
	
	private static final String CHEESE_NAME = "Cheese";
	private static final Amount CHEESE_PRICE = new Amount(43f);
	private static final float CHEESE_VAT = 12f;
	private static final Barcode CHEESE_IDENTIFIER = new Barcode(173031);
	
	public InventorySystem InventorySystem() {
		InventorySystem inventory = new InventorySystem();
		return inventory;
	}
	
	/**
	 * Adds the items required for the hardcoded scenario to the
	 * list availableItems.
	 */
	public void addItemsToAvailableItemsList() {
		ItemDTO banana = new ItemDTO(BANANA_NAME, BANANA_PRICE, BANANA_VAT, BANANA_IDENTIFIER);
		ItemDTO cheese = new ItemDTO(CHEESE_NAME, CHEESE_PRICE, CHEESE_VAT, CHEESE_IDENTIFIER);
		availableItems.add(banana);
		availableItems.add(cheese);
	}
	
	/**
	 * Returns info about scanned item 
	 * 
	 * @return
	 */
	public ItemDTO retrieveInfo(Barcode enteredItemID) {
		// loop through list of items
		for(ItemDTO item : availableItems)
			if(item.getIdentifier().getBarcode() == enteredItemID.getBarcode())
				return item;
		
		return null;
	}
	
	
	// NOT USED! REMOVE!!
	public void updateInventory() {
		
	}
	
	public void printReceipt() {
		
	}
}
