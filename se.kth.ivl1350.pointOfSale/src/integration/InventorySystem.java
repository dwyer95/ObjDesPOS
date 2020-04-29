package integration;
import java.util.ArrayList;
import model.Item;
import datatypes.*;

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
	
	/**
	 * Creates an instance of the InventorySystem class.
	 */
	public InventorySystem() {
		
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
	 * Returns information about scanned item. 
	 * @return The information which is returned.
	 */
	public ItemDTO retrieveInfo(Barcode enteredItemID) {
		// loop through list of items
		for(ItemDTO item : availableItems)
			if(item.getIdentifier().getBarcode() == enteredItemID.getBarcode())
				return item;
		
		return null;
	}
}
