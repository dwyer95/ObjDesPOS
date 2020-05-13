package integration;
import java.util.ArrayList;
import exceptions.*;
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
	
	private static final String DATABASEERROR_NAME = "if this shows up something is wrong";
	private static final Amount DATABASEERROR_PRICE = new Amount(43f);
	private static final float DATABASEERROR_VAT = 12f;
	private static final Barcode DATABASEERROR_IDENTIFIER = new Barcode(200002);
	
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
		ItemDTO databaseError = new ItemDTO(DATABASEERROR_NAME, DATABASEERROR_PRICE, DATABASEERROR_VAT, DATABASEERROR_IDENTIFIER);
		availableItems.add(banana);
		availableItems.add(cheese);
		availableItems.add(databaseError);
	}
	
	// throws checked exception
	/**
	 * Returns information about scanned item.
	 * @param enteredItemID The entered item's identifier.
	 * @return The information which is returned.
	 * @throws InvalidBarcodeException
	 * @throws DatabaseNotRespondingException
	 */
	public ItemDTO retrieveInfo(Barcode enteredItemID) throws InvalidBarcodeException, DatabaseNotRespondingException {
		if(enteredItemID.getBarcode() == 200002)
			throw new DatabaseNotRespondingException();
		
		for(ItemDTO item : availableItems) {
			if(item.getIdentifier().getBarcode() == enteredItemID.getBarcode())
				return item;
		}
		
		throw new InvalidBarcodeException(enteredItemID);
	}
}
