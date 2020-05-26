package exceptions;

import datatypes.*;

/**
 * 
 */
public class InventorySystemException extends Exception {
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public InventorySystemException(String message, Exception cause) {
		super(message, cause);
	}
}
