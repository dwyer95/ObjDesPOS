package view;
import model.*;

import java.util.*;
import datatypes.Amount;

/**
 * Represents an observer of the Sale class.
 */
public class TotalRevenueView implements SaleObserver {
	private Amount totalRevenue = new Amount();
	
	@Override
	public void newPayment(Sale currentSale) {
		addNewPayment(currentSale);
		printCurrentState();
	}
	
	/**
	 * Adds a new entry to the <code>payments</code> list.
	 * @param currentSale The current sale.
	 */
	private void addNewPayment(Sale currentSale) {
		Amount paymentToAdd = new Amount(currentSale.getAmountPaid().getAmount());
		totalRevenue.add(paymentToAdd);
	}
	
	/**
	 * Prints made payments to the display.
	 */
	private void printCurrentState() {
		System.out.println("############ Total revenue ############");
		System.out.println(totalRevenue.getAmount());
		System.out.println("#######################################\n");
	}
}
