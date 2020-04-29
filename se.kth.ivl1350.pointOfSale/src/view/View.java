package view;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.*;
import integration.*;
import datatypes.*;

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
		
		controller.addItemsToAvailableItemsList();
		controller.initializeSale();
		
		for(Item itemCurrentlyBeingScanned : listOfCustomersItems) {
			ItemDTO scannedItem = new ItemDTO();
			
			scannedItem = controller.enterItemIdentifier(itemCurrentlyBeingScanned.getIdentifier());
			controller.addItemsToCurrentSale(itemCurrentlyBeingScanned);
			
			
			int numberOfCurrentItem = itemCurrentlyBeingScanned.getQuantity();
			while(numberOfCurrentItem != 0) {
				System.out.println(scannedItem.toString());
				
				Amount priceOfVAT = new Amount(controller.calculatePriceOfVAT(itemCurrentlyBeingScanned));
				Amount priceIncludingVAT = new Amount(controller.calculatePriceIncludingVAT(itemCurrentlyBeingScanned));
				
				controller.addToTotalPriceOfItems(itemCurrentlyBeingScanned.getPrice());
				controller.addToTotalPriceOfVAT(priceOfVAT);
				controller.addToTotalPriceOfItemsIncludingVAT(priceIncludingVAT);
				numberOfCurrentItem--;
			}
			
		}
		System.out.println("\nTotal price: " + controller.endSale().getAmount());
		
		Amount paidAmount = new Amount(160f);
		controller.enterPaidAmount(paidAmount);

		controller.setChange();
		Amount change = controller.getChange();
		System.out.println("Money back: " + change.getAmount() + "\n");
		
		controller.printReceipt();
	}
}
