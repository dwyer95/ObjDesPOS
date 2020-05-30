package model;
import datatypes.Amount;

/**
 * An observer interface for notifying objects about payments made.
 */
public interface SaleObserver {

	/**
	 * Adds a new entry to the <code>payments</code> list, then prints payments, in order,
	 * to the display.
	 * @param amountPaid The amount paid in current sale.
	 */
	void newPayment(float amountPaid);
}