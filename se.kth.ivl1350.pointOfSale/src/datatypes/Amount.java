package datatypes;

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
	 * Adds an <code>Amount</code> to the amount of current instance.
	 * @param termToAddWith The amount to be added.
	 */
	public void add(Amount termToAddWith) {
		amount += termToAddWith.getAmount();
	}
	
	/**
	 * Subtracts the amount of the current instance with another Amount.
	 * @param termToSubtractWith The amount to subtract with.
	 */
	public void subtract(Amount termToSubtractWith) {
		amount -= termToSubtractWith.getAmount();
	}
	
	/**
	 * Multiply the amount of the current instance with another Amount.
	 * @param termToMultiplyWith The amoun to multiply with.
	 */
	public void multiply(Amount termToMultiplyWith) {
		amount *= termToMultiplyWith.getAmount();
	}
	
	/**
	 * Returns the amount as a float.
	 * @return The amount that this instance represents.
	 */
	public float getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount of this instance to the float value of the parameter.
	 * @param amount The amount this instance should be set to.
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
