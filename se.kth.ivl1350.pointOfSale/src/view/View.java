package view;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
			ItemDTO scannedItem = new ItemDTO("a", bananaPrice, 0f, bananaBarcode);
			
			scannedItem = controller.enterItemIdentifier(itemCurrentlyBeingScanned.getIdentifier());
			controller.addItemsToCurrentSale(itemCurrentlyBeingScanned);
			
			
			int numberOfCurrentItem = itemCurrentlyBeingScanned.getQuantity();
			while(numberOfCurrentItem != 0) {
				System.out.println(scannedItem.toString());
				Amount priceIncludingVAT = new Amount(controller.calculatePriceIncludingVAT(itemCurrentlyBeingScanned));
				controller.addToTotalPrice(priceIncludingVAT);
				numberOfCurrentItem--;
			}
			
		}
		System.out.println("\nTotal price: " + controller.endSale().getAmount());
		
		Amount paidAmount = new Amount(160f);
		controller.enterPaidAmount(paidAmount);

		System.out.println("\n######### BEGINNING OF RECEIPT #########");
		System.out.println("Date: " + controller.getDateOfSale());
		System.out.println("Time: " + controller.getTimeOfSale().truncatedTo(ChronoUnit.SECONDS));
		System.out.println(controller.getAddress());
		controller.loopThroughSoldItems();
		
		//System.out.println("Total cost: " + controller.getTotalPrice());
		System.out.println("############ END OF RECEIPT ############\n");
		
		controller.setChange();
		Amount change = controller.getChange();
		
		System.out.println("Money back: " + Math.floor(change.getAmount()));
	}
}
