package integration;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class ItemDTO {
	private String name;
	private Amount price;
	private int VATRate;
	
	public String getName() {
		return name;
	}
	
	public Amount getPrice() {
		return price;
	}
	
	public VATRate getVATRate() {
		return VATRate;
	}

}
