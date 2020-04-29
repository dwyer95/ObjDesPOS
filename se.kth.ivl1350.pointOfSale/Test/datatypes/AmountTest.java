package datatypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountTest {
	private Amount firstAmount;
	private Amount secondAmount; 

	@BeforeEach
	void setUp() {
		firstAmount = new Amount();
		secondAmount = new Amount(4f);
	}

	@AfterEach
	void tearDown() {
		firstAmount = null;
		secondAmount = null;
	}

	@Test
	void testAddition() {
		firstAmount.setAmount(4f);
		firstAmount.add(secondAmount);
		assertEquals(8f, firstAmount.getAmount(), "Adding does not add amounts together");
	}
	
	@Test
	void testAddNull() {
		firstAmount = null;
		secondAmount.add(firstAmount);
		assertEquals(4f, secondAmount.getAmount(), "Adding null to amount produces another"
				+ " result than the unchanged amount.");
	}
	
	@Test
	void testSubtract() {
		firstAmount.setAmount(6f);
		firstAmount.subtract(secondAmount);
		assertEquals(2f, firstAmount.getAmount(), "Subtracting does not subtract an amount"
				+ " with another.");
	}
	
	@Test
	void testSubtractNull() {
		firstAmount = null;
		secondAmount.subtract(firstAmount);
		assertEquals(4f, secondAmount.getAmount(), "Subtracting amount with null produces another"
				+ " result than the unchanged amount.");
	}
	
	@Test
	void testMultiply() {
		firstAmount.setAmount(4f);
		firstAmount.multiply(secondAmount);
		assertEquals(16f, firstAmount.getAmount(), "Multiplying does not multiply an amount"
				+ " with another.");
	}
	
	@Test
	void testMultiplyNull() {
		firstAmount = null;
		secondAmount.multiply(firstAmount);
		assertEquals(4f, secondAmount.getAmount(), "Multiplying an amount with null produces another"
				+ " result than the unchanged amount.");
	}

}
