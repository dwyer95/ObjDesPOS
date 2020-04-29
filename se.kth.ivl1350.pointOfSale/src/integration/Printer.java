package integration;
import model.Receipt;

public class Printer {

	/**
	 * Constructs a new printer instance.
	 * @return returns the printer object.
	 */
	public Printer Printer() {
		Printer printer = new Printer();
		return printer;
	}
	
	public void printReceipt(Receipt receipt) {
		System.out.print(receipt.toString());
	}
}
