package accounts;

public class CheckingAccount extends Account {
	
	/**
	 * @invar | creditLimit >= 0
	 */
	private int creditLimit;
	
	/**
	 * @pre | value >= 0
	 * @pre | creditLimit >= 0
	 * @post | requestMoney(0) == value
	 */
	public CheckingAccount(int value, int creditLimit) {
		super(value);
		this.creditLimit = creditLimit;
	}
	
	@Override
	/**
	 * @pre | requestedMoney >= 0
	 */
	public int requestMoney(int requestedMoney) {
		if (requestedMoney <= super.value + creditLimit) {
			value -= requestedMoney;
			return requestedMoney;
		} else {
			int valueToReturn = value + creditLimit;
			value = - creditLimit;
			return valueToReturn;
		}	
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other)
				&& ((CheckingAccount) other).creditLimit == this.creditLimit;
	}
	
	@Override
	public String toString() {
		return super.toString() + "credit limit = " + creditLimit;
	}
}
