package integration;
import model.Receipt;

/**
 * Represents the handler that communicates with the external printer.
 */
public class Printer {

	/**
	 * Constructs a new <code>Printer</code> instance.
	 * @return returns the <code>Printer</code> object.
	 */
	public Printer Printer() {
		Printer printer = new Printer();
		return printer;
	}
	
	/**
	 * Calls on an external <code>Printer</code> to print a <code>Receipt</code>. 
	 * In the hardcoded user case it prints the receipt to screen instead.
	 * @param receipt The receipt to be printed.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.print(receipt.toString());
	}
}
