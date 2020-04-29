package integration;
import java.util.ArrayList;
import model.Item;
import datatypes.*;

/**
 * Represents the handler that communicates with the external inventory system.
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
	 * @param enteredItemID The entered item's identifier.
	 * @return The information which is returned.
	 */
	public ItemDTO retrieveInfo(Barcode enteredItemID) {
		if(enteredItemID == null) {
			System.out.println("The input identifier is null.");
			return null;
		}
		
		for(ItemDTO item : availableItems)
			if(item.getIdentifier().getBarcode() == enteredItemID.getBarcode())
				return item;
		
		System.out.println("Entered identifier did not match any item in inventory.");
		return null;
	}
}
