package model;

import datatypes.Amount;
import datatypes.Barcode;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Item {
	private String name;
	private Amount price;
	private Barcode identifier;
	private float VATRate;
	private int quantity;
	
	
	/**
	 * Creates an instance of the Item class.
	 * 
	 */
	public Item(String name, Amount price, float VATRate, Barcode identifier, int quantity) {
		this.name = name;
		this.price = price;
		this.VATRate = VATRate;
		this.identifier = identifier;
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
