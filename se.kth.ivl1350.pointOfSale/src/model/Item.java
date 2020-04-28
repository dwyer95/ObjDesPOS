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
	
	public int getQuantity() {
		return quantity;
	}
	
	public Barcode getIdentifier() {
		return identifier;
	}

}
