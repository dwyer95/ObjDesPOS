package datatypes;

public class Barcode {
	private int barcode;
	
	/**
	 * Assigns a value to the barcode.
	 * @param barcode The value to assign.
	 */
	public Barcode(int barcode) {
		this.barcode = barcode;
	}
	
	/**
	 * Gets the barcode.
	 * @return The barcode to return.
	 */
	public int getBarcode() {
		return barcode;
	}
}
