package startup;
import integration.*;
import controller.*;
import model.*;
import view.*;

/**
 * @author Jacob Dwyer
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountingSystem accounting = new AccountingSystem();
		InventorySystem inventory = new InventorySystem();
		Controller controller = new Controller(accounting, inventory);
		CashRegister cashRegister = new CashRegister();
		View view = new View(controller);
		
		view.hardCodedUseCase();
	}

}
