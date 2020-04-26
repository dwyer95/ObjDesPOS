package integration;
import model.*;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class InventorySystem {

	public InventorySystem InventorySystem() {
		InventorySystem inventory = new InventorySystem();
		return inventory;
	}
	
	/**
	 * Returns info about scanned item 
	 * 
	 * @return
	 */
	public ItemDTO retrieveInfo() {
		ItemDTO ID = itemID;
		return ID;
	}
}
