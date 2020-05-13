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
	//private String noDB = "Could not establish connection to inventory system database.";
	
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

	/*@Test
	void testRetrieveInfoNullBarcode() {
		Barcode nullBar = null;
		ItemDTO itemDTO = inventory.retrieveInfo(nullBar);
		assertNull(itemDTO, "Using null as input parameter does not"
				+ " result in a null ItemDTO.");
	}
	
	@Test
	void testRetrieveInfoNoMatch() {
		Barcode wrongBar = new Barcode(1234);
		ItemDTO itemDTO = inventory.retrieveInfo(wrongBar);
		assertNull(itemDTO, "Using a barcode which does not exist in inventory"
				+ " system, as input parameter does not result in a null ItemDTO.");
	}*/
	
	@Test
	void testNoDatabaseConnection() {
		Barcode noDatabaseBar = new Barcode(200002);
		
		try {
			ItemDTO itemDTO = inventory.retrieveInfo(noDatabaseBar);
			
			fail("Could scan invalid item");
		}
		catch(DatabaseNotRespondingException e) {
			//assertTrue(e.getMessage().contains(noDB), "Wrong exception");
		}
		catch(InvalidBarcodeException e) {
			fail("Catched the wrong exception");
		}
	}

}
