package model;
import datatypes.Amount;
import datatypes.Barcode;
import integration.ItemDTO;

/**
 * Represents an <code>Item</code> that a customer brings to the
 * point-of-sale.
 */
public class Item {
	private String name;
	private Amount price;
	private float VATRate;
	private Barcode identifier;
	private int quantity;
	
	/**
	 * Creates an instance of the <code>Item</code> class with parameters.
	 * @param name The name of the item.
	 * @param price The price of the item.
	 * @param VATRate The VAT-rate of the item.
	 * @param identifier The item's identifier.
	 * @param quantity The quantity of the item.
	 */
	public Item(String name, Amount price, float VATRate, Barcode identifier, int quantity) {
		this.name = name;
		this.price = price;
		this.VATRate = VATRate;
		this.identifier = identifier;
		this.quantity = quantity;
	}
	
	/**
	 * Creates an instance of the <code>Item</code> class with short parameter list.
	 * @param itemDTO The DTO which the item gets the rest of its properties from.
	 * @param quantity The quantity of the item.
	 */
	public Item(ItemDTO itemDTO, int quantity) {
		name = itemDTO.getName();
		price = itemDTO.getPrice();
		VATRate = itemDTO.getVATRate();
		identifier = itemDTO.getIdentifier();
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		StringBuilder itemInfo = new StringBuilder();
		itemInfo.append("name: " + name + ", ");
		itemInfo.append("price: " + price.getAmount() + ", ");
		itemInfo.append("VAT rate: " + VATRate + ", ");
		itemInfo.append("ID: " + identifier.getBarcode() + ", ");
		itemInfo.append("quantity: " + quantity);
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
	
	public int getQuantity() {
		return quantity;
	}
	
}
