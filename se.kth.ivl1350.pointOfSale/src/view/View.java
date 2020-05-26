package view;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import exceptions.*;
import controller.*;
import model.*;
import integration.*;
import datatypes.Barcode;
import datatypes.Amount;

/**
 *Represents the display that the cashier uses.
 */
public class View {
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
		controller.addSaleObserver(new TotalRevenueView());
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
			
			Amount barcodeErrorPrice = new Amount(43);
			Barcode barcodeErrorBarcode = new Barcode(100001);
			Item twoBarcodeError = new Item("if this shows up something is wrong", barcodeErrorPrice, 10f, barcodeErrorBarcode, 2);
			listOfCustomersItems.add(twoBarcodeError);
			
			Amount databaseErrorPrice = new Amount(43);
			Barcode databaseErrorBarcode = new Barcode(200002);
			Item oneDatabaseError = new Item("if this shows up something is wrong", databaseErrorPrice, 10f, databaseErrorBarcode, 1);
			listOfCustomersItems.add(oneDatabaseError);
			
			controller.addItemsToAvailableItemsList();
			controller.initializeSale();
			
			for(Item itemCurrentlyBeingScanned : listOfCustomersItems) {
				ItemDTO scannedItem = new ItemDTO();
				
				try {
					scannedItem = controller.enterItemIdentifier(itemCurrentlyBeingScanned.getIdentifier());
				}
				catch (InventorySystemException e) {
					System.out.println(e.getMessage());
					continue;
				}
				
				controller.addItemsToCurrentSale(itemCurrentlyBeingScanned);
				
				int numberOfCurrentItem = itemCurrentlyBeingScanned.getQuantity();
				while(numberOfCurrentItem != 0) {
					System.out.println(scannedItem.toString());
					
					Amount priceOfVAT = new Amount(controller.calculatePriceOfVAT(itemCurrentlyBeingScanned));
					Amount priceIncludingVAT = new Amount(controller.calculatePriceIncludingVAT(itemCurrentlyBeingScanned));
					
					controller.addToTotalPriceOfItems(itemCurrentlyBeingScanned.getPrice());
					controller.addToTotalPriceOfVAT(priceOfVAT);
					controller.addToTotalPriceOfItemsIncludingVAT(priceIncludingVAT);
					System.out.println("Running total: " + controller.getTotalPriceOfItemsIncludingVAT().getAmount() + "\n");
					numberOfCurrentItem--;
				}
			}
			
			System.out.println("\nTotal price: " + controller.endSale().getAmount() + "\n");
			
			Amount paidAmount1 = new Amount(1f);
			controller.enterPaidAmount(paidAmount1);

			Amount paidAmount2 = new Amount(10f);
			controller.enterPaidAmount(paidAmount2);
			
			Amount paidAmount3 = new Amount(149f);
			controller.enterPaidAmount(paidAmount3);
			
			controller.setChange();
			Amount change = controller.getChange();
			System.out.println("Money back: " + change.getAmount() + "\n");
			
			controller.printReceipt();
	}
}
