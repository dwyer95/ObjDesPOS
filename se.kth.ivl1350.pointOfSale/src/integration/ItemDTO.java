package integration;
import datatypes.*;

/**
 * Represents a data transfer object (DTO) of the <code>Item</code> class.
 */
public final class ItemDTO {
	private final String name;
	private final Amount price;
	private final float VATRate;
	private final Barcode identifier;
	
	/**
	 * Creates a new instance of the ItemDTO class.
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
	 * Creates a new instance of the ItemDTO class without properties assigned by inputs.
	 */
	public ItemDTO() {
		this.name = "";
		this.price = new Amount(0f);
		this.VATRate = 12f;
		this.identifier = new Barcode(0);
	}
	
	@Override
	public String toString() {
		StringBuilder itemInfo = new StringBuilder();
		itemInfo.append("name: " + name + ", ");
		itemInfo.append("price: " + price.getAmount() + ", ");
		itemInfo.append("VAT rate: " + VATRate + "%, ");
		itemInfo.append("ID: " + identifier.getBarcode());
		return itemInfo.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public Amount getPrice() {
		return price;
	}
	
	public float getVATRate() {
		return VATRate;
	}
	
	public Barcode getIdentifier() {
		return identifier;
	}

}
