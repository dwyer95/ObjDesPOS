package integration;
import datatypes.*;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public final class ItemDTO {
	private final String name;
	private final Amount price;
	private final float VATRate;
	private final Barcode identifier;
	
	/**
	 * Creates a new instance representing an item.
	 * 
	 * @param name		The name of the item.
	 * @param price		The price which should appear on the receipt next to the item.
	 * @param VATRate	The tax rate of the item, which adds to its total price.
	 * @param ID		The item's unique identifier in the inventory database.
	 */
	public ItemDTO(String name, Amount price, float VATRate, Barcode identifier) {
		this.name = name;
		this.price = price;
		this.VATRate = VATRate;
		this.identifier = identifier;
	}
	
	/**
	 * @return The name of the item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The price of the item.
	 */
	public Amount getPrice() {
		return price;
	}
	
	/**
	 * @return The item's VAT-rate. 
	 */
	public float getVATRate() {
		return VATRate;
	}
	
	public Barcode getIdentifier() {
		return identifier;
	}

}
