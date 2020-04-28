package view;
import java.util.List;

import controller.*;
import model.*;
import integration.*;
import datatypes.*;

/**
 * 
 * @author Jacob Dwyer
 *
 */
public class View {
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 *  This method shows the flow of an arbitrary user case instead of
	 *  having a fully functional user interface
	 */
	public void hardCodedUseCase() {
		List<Item> listOfCustomersItems;
		
		Amount bananaPrice = new Amount(10f);
		Barcode bananaBarcode = new Barcode(094531f);
		Item oneBanana = new Item("Banana", bananaPrice, 25f, bananaBarcode, 1);
		listOfCustomersItems.add(oneBanana);
		
		Amount cheesePrice = new Amount(43);
		Barcode cheeseBarcode = new Barcode(173031f);
		Item threeCheese = new Item("Cheese", cheesePrice, 12f, cheeseBarcode, 3);
		listOfCustomersItems.add(threeCheese);
		
		controller.addItemsToAvailableItemsList();
		Sale sale = controller.initializeSale();
		
		//int itemsLeftToScan = 0;
		
		for(Item item : listOfCustomersItems) {
			//scan item
			ItemDTO scannedItem = controller.enterItemIdentifier(item.getIdentifier());
			// add itemprice to cost
			sale.getTotalPrice().add(scannedItem.getPrice().getAmount() * item.getQuantity());
		}
		
		
		// receive money from customer
		// calculate difference
		// give back change
		
		//print our receipt
		System.out.println("######### BEGINNING OF RECEIPT #########");
		System.out.println("Date: " + sale.getDateOfSale());
		System.out.println("Time: " + sale.getTimeOfSale());
		System.out.println("Total cost: " + sale.getTotalPrice());
		System.out.println("############ END OF RECEIPT ############");
		controller.endSale(sale);
	}
}
