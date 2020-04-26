package model;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Item {
	private String name;
	private Amount price;
	private int VATRate;
	private Barcode ID;
	
	/**
	 * Creates an instance of the Item class.
	 * 
	 * @return
	 */
	public Item Item() {
		Item item = new Item();
		return item;
	}

}
