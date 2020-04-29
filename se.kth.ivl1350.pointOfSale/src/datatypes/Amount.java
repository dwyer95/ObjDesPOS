package datatypes;

/**
 * Represents an amount of money.
 */
public class Amount {
	private float amount;
	
	/**
	 * Creates a new instance of the <code>Amount</code> class.
	 * @param amount The amount of cash that the instance represents.
	 */
	public Amount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * Creates a new instance of the <code>Amount</code> class with 0 as value.
	 */
	public Amount() {
		this.amount = 0;
	}
	
	/**
	 * Adds an <code>Amount</code> to the amount of current instance.
	 * @param termToAddWith The amount to be added.
	 */
	public void add(Amount termToAddWith) {
		if(termToAddWith == null) {
			System.out.println("Cannot add null");
			return;
		}
		amount += termToAddWith.getAmount();
	}
	
	/**
	 * Subtracts the amount of the current instance with another <code>Amount</code>.
	 * @param termToSubtractWith The amount to subtract with.
	 */
	public void subtract(Amount termToSubtractWith) {
		if(termToSubtractWith == null) {
			System.out.println("Cannot subtract with null");
			return;
		}
		amount -= termToSubtractWith.getAmount();
	}
	
	/**
	 * Multiply the amount of the current instance with another <code>Amount</code>.
	 * @param termToMultiplyWith The amount to multiply with.
	 */
	public void multiply(Amount termToMultiplyWith) {
		if(termToMultiplyWith == null) {
			System.out.println("Cannot multiply by null");
			return;
		}
		amount *= termToMultiplyWith.getAmount();
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
