package view;

import model.SaleObserver;
import java.util.*;
import datatypes.Amount;

/**
 * Represents an observer of the Sale class.
 */
public class TotalRevenueView implements SaleObserver {
	private Amount totalRevenue = new Amount();
	
	@Override
	public void newPayment(float paidAmount) {
		addNewPayment(paidAmount);
		printCurrentState();
	}
	
	private void addNewPayment(float paidAmount) {
		Amount paymentToAdd = new Amount(paidAmount);
		totalRevenue.add(paymentToAdd);
	}
	
	private void printCurrentState() {
		System.out.println("############ Total revenue ############");
		System.out.println(totalRevenue.getAmount());
		System.out.println("#######################################\n");
	}
}
