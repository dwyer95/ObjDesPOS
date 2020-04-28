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
	
	
	public void add(Amount termToAddWith) {
		amount += termToAddWith.getAmount();
	}
	
	public void subtract(Amount termToSubtractWith) {
		amount -= termToSubtractWith.getAmount();
	}
	
	public void multiply(Amount termToMultiplyWith) {
		amount *= termToMultiplyWith.getAmount();
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
