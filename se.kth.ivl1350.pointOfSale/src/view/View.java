package view;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.*;
import integration.*;
import datatypes.*;

/**
 *Represents the display that the cashier uses.
 */
public class View {
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 *  This method shows the flow of an arbitrary user case instead of
	 *  having a fully functional user interface. In this case, the customer
	 *  buys one banana and three packets of cheese.
	 */
	public void hardCodedUseCase() {
		ArrayList<Item> listOfCustomersItems = new ArrayList<Item>();
		
		Amount bananaPrice = new Amount(10f);
		Barcode bananaBarcode = new Barcode(945310);
		Item oneBanana = new Item("Banana", bananaPrice, 25f, bananaBarcode, 1);
		listOfCustomersItems.add(oneBanana);
		
		Amount cheesePrice = new Amount(43);
		Barcode cheeseBarcode = new Barcode(173031);
		Item threeCheese = new Item("Cheese", cheesePrice, 12f, cheeseBarcode, 3);
		listOfCustomersItems.add(threeCheese);
		
		Amount paidAmount;
		controller.addItemsToAvailableItemsList();
		// pre-sale initiation done
		
		// sale starts here
		controller.initializeSale();
		
		// put for-loop and calculations of vatprice, addToTotalPrice etc in enterItemId..() in Sale
		
		for(Item itemCurrentlyBeingScanned : listOfCustomersItems) {
			System.out.println(controller.enterItemIdentifier(itemCurrentlyBeingScanned.getIdentifier()));
			
		}
		
		System.out.println("\nTotal price: " + controller.endSale().getAmount());
		System.out.println("Money back: " + controller.enterPaidAmount(paidAmount = new Amount(160f)));
		controller.printReceipt();
	}
}
