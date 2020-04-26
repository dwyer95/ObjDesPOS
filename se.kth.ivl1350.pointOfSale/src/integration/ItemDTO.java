package integration;
import model.*; // otillåtet???

/**
 * 
 * @author Jacob Dwyer
 *
 */
public final class ItemDTO {
	private final String name;
	private final Amount price;
	private final int VATRate;
	private final Barcode ID;
	
	/**
	 * Creates a new instance representing an item.
	 * 
	 * @param name		The name of the item.
	 * @param price		The price which should appear on the receipt next to the item.
	 * @param VATRate	The tax rate of the item, which adds to its total price.
	 * @param ID		The item's unique identifier in the inventory database.
	 */
	public ItemDTO(String name, Amount price, int VATRate, Barcode ID) {
		this.name = name;
		this.price = price;
		this.VATRate = VATRate;
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	
	public Amount getPrice() {
		return price;
	}
	
	public int getVATRate() {
		return VATRate;
	}

}
