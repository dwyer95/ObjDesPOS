package model;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class Sale {
	private Date dateOfSale;
	private Time timeOfSale;
	private Address addressOfStore;
	private Amount totalPrice;
	private Amount amountPaid;
	private Item soldItem;
	private Amount change;
	
	public Sale Sale() {
		Sale sale = new Sale();
		return sale;
	}
}
