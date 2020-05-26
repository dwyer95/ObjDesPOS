package exceptions;

import datatypes.Barcode;

/**
 * Thrown when an invalid <code>Barcode</code> is scanned.
 */
public class InvalidBarcodeException extends Exception {

	/**
	 * Creates an instance of the <code>InvalidBarcodeException</code>.
	 * @param barcode The scanned barcode.
	 */
	public InvalidBarcodeException(Barcode barcode) {
		super("Item with barcode "+ barcode.getBarcode() + " not found in inventory system.");
	}
}
