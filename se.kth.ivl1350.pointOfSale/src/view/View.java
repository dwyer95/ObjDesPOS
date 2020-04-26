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
	
	// This method shows the flow of an arbitrary user case instead of
	// having a fully functional user interface
	public void hardCodedUseCase() {
		Sale sale = controller.initializeSale();
		
		int itemsLeftToScan = 5;
		while(itemsLeftToScan != 0) {
			//scan item
			itemsLeftToScan--;
		}
		
	}
}
