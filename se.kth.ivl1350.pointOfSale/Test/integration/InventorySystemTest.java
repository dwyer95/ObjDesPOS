package integration;

import exceptions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datatypes.Amount;
import datatypes.Barcode;

class InventorySystemTest {
	private InventorySystem inventory;
	private ArrayList<ItemDTO> availableItems;
	private Barcode barcode;
	private static final String BANANA_NAME = "Banana";
	private static final Amount BANANA_PRICE = new Amount(10f);
	private static final float BANANA_VAT = 25f;
	private static final Barcode BANANA_IDENTIFIER = new Barcode(945310);
	
	private static final String CHEESE_NAME = "Cheese";
	private static final Amount CHEESE_PRICE = new Amount(43f);
	private static final float CHEESE_VAT = 12f;
	private static final Barcode CHEESE_IDENTIFIER = new Barcode(173031);
	
	private ItemDTO banana;
	private ItemDTO cheese;
	private ItemDTO itemDTO;
	
	@BeforeEach
	void setUp() {
		availableItems = new ArrayList<ItemDTO>();
		ItemDTO banana = new ItemDTO(BANANA_NAME, BANANA_PRICE, BANANA_VAT, BANANA_IDENTIFIER);
		ItemDTO cheese = new ItemDTO(CHEESE_NAME, CHEESE_PRICE, CHEESE_VAT, CHEESE_IDENTIFIER);
		availableItems.add(banana);
		availableItems.add(cheese);
		inventory = new InventorySystem();
		
		
	}

	@AfterEach
	void tearDown() {
		availableItems = null;
		banana = null;
		cheese = null;
		itemDTO = null;
		inventory = null;
		barcode = null;
	}
	
	/**
	 * Tests the method <code>retrieveInfo</code> to see if it catches
	 * <code>InvalidBarcodeException</code>. Fails if the method successfully
	 * retrieves item info, if the method catches the wrong <code>Exception</code>,
	 * or if the error message in the correct exception does not contain the 
	 * invalid <code>Barcode</code>.
	 */
	@Test
	void testInvalidBarcode() {
		Barcode invalidBar = new Barcode(100001);
		
		try {
			ItemDTO itemDTO = inventory.retrieveInfo(invalidBar);
			fail("Could scan invalid item");
		}
		catch(DatabaseNotRespondingException e) {
			fail("Catched the wrong exception");
		}
		catch(InvalidBarcodeException e) {
			assertTrue(e.getMessage().contains("" + invalidBar.getBarcode()), "Wrong error message, "
					+ "does not contain the invalid barcode: " + invalidBar.getBarcode());
		}
	}
	
	/**
	 * Tests the method <code>retrieveInfo</code> to see that it catches
	 * <code>DatabaseNotRespondingException</code>. Fails if it successfully 
	 * retrieves item info or if it catches the wrong <code>Exception</code>. 
	 */
	@Test
	void testNoDatabaseConnection() throws InventorySystemException {
		Barcode noDatabaseBar = new Barcode(200002);
		
		try {
			ItemDTO itemDTO = inventory.retrieveInfo(noDatabaseBar);
			fail("Could scan invalid item");
		}
		catch(DatabaseNotRespondingException e) {
			
		}
		catch(InvalidBarcodeException e) {
			fail("Catched the wrong exception");
		}
	}

}
