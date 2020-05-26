package model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import datatypes.Address;
import datatypes.Amount;

/**
 * Represents the <code>Receipt</code> that the customer receives after a sale.
 */
public class Receipt {
	private java.time.LocalDate dateOfSale;
	private java.time.LocalTime timeOfSale;
	private Address addressOfStore;
	private ArrayList<Item> soldItems;
	private Amount totalPriceOfItems;
	private Amount totalPriceOfVAT;
	private Amount totalPriceOfItemsIncludingVAT;
	private Amount amountPaid;
	private Amount change;
	
	/**
	 * Creates a new instance of the <code>Receipt</code> class. Hard copies
	 * the values in the input parameter and sets as properties of this instance.
	 * @param sale The <code>Sale</code> instance which this instance gets its
	 * properties from.
	 */
	public Receipt(Sale sale) {
		dateOfSale = sale.getDateOfSale();
		timeOfSale = sale.getTimeOfSale();
		addressOfStore = sale.getAddress();
		soldItems = new ArrayList<Item>(sale.getSoldItemList());
		totalPriceOfItems = new Amount(sale.getTotalPriceOfItems().getAmount());
		totalPriceOfVAT = new Amount(sale.getTotalPriceOfVAT().getAmount());
		totalPriceOfItemsIncludingVAT = new Amount(sale.getTotalPriceOfItemsIncludingVAT().getAmount());
		amountPaid = new Amount(sale.getAmountPaid().getAmount());
		change = new Amount(sale.getChange().getAmount());
	}
	
	/**
	 * Prints the name, quantity and price of each item in the <code>soldItems</code> list.
	 * Used when printing text with a <code>StringBuilder</code> class.
	 * @param builder The StringBuilder to append to.
	 */
	private void printItemList(StringBuilder builder) {
		for(Item item : soldItems)
			builder.append("\n" + item.getName() + "\t*" + item.getQuantity() + "\t\t" + item.getPrice().getAmount());
	}
	
	@Override
	public String toString() {
		StringBuilder receiptInfo = new StringBuilder();
		receiptInfo.append("--------------START OF RECEIPT-----------------\n");
		receiptInfo.append("Date:\t" + dateOfSale + "\n");
		receiptInfo.append("Time:\t" + timeOfSale.truncatedTo(ChronoUnit.SECONDS) + "\n");
		receiptInfo.append(addressOfStore.toString());
		printItemList(receiptInfo);
		receiptInfo.append("\nPrice:\t\t" + totalPriceOfItems.getAmount() + "\n");
		receiptInfo.append("VAT:\t\t" + totalPriceOfVAT.getAmount() + "\n");
		receiptInfo.append("Amount paid:\t\t" + amountPaid.getAmount() + "\n");
		receiptInfo.append("Amount back:\t\t" + change.getAmount() + "\n");
		receiptInfo.append("---------------END OF RECEIPT-----------------\n");
		return receiptInfo.toString();
	}
}
