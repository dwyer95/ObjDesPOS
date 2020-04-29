package datatypes;

/**
 * Represents the <code>Barcode</code> on an <code>Item</code>.
 */
public class Barcode {
	private int barcode;
	
	/**
	 * Assigns a value to the barcode.
	 * @param barcode The value to assign.
	 */
	public Barcode(int barcode) {
		this.barcode = barcode;
	}
	
	public int getBarcode() {
		return barcode;
	}
}
