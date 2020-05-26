package startup;
import integration.*;
import controller.*;
import model.*;
import view.*;

/**
 *Represents the startup of the system.
 */
public class Main {
	
	/**
	 * Starts the application.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountingSystem accounting = new AccountingSystem();
		InventorySystem inventory = new InventorySystem();
		Printer printer = new Printer();
		Controller controller = new Controller(accounting, inventory, printer);
		View view = new View(controller);
		
		int sales = 3;
		while(sales > 0) {
			view.hardCodedUseCase();
			sales--;
		}
		
	}

}
