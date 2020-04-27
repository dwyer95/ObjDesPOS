package view;
import controller.*;
import model.*;
import integration.*;

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
		controller.addItemsToAvailableItemsList();
		Sale sale = controller.initializeSale();
		
		int itemsLeftToScan = 5;
		while(itemsLeftToScan != 0) {
			//scan item
			Item scannedItem = new controller.enterItemIdentifier(enteredItemID);
			// add itemprice to cost
			itemsLeftToScan -= scannedItem.getQuantity();
		}
		
		//print our receipt
		System.out.println("######### BEGINNING OF RECEIPT #########");
		System.out.println("Date: " + sale.getDateOfSale());
		System.out.println("Time: " + sale.getTimeOfSale());
		System.out.println("Total cost: " + sale.getTotalPrice());
		System.out.println("############ END OF RECEIPT ############");
		controller.endSale(sale);
	}
}
