package accounts;

public class Account {
	
	/**
	 * @invar | value >= 0
	 */
	protected int value; //Protected needed to access this field in Checking & Saving Account
	
	/**
	 * @post | getAmount() == value
	 */
	public Account(int value) {
		this.value = value;
	}
	
	/**
	 * @pre | requestedMoney >= 0
	 * @post | result >= 0
	 */
	public int requestMoney(int requestedMoney) {
		if (requestedMoney <= value) {
			value -= requestedMoney;
			return requestedMoney;
		} else {
			int valueToReturn = value;
			value = 0;
			return valueToReturn;
		}	
	}
	
	/**
	 * @pre | depositMoney >= 0
	 */
	public void depositMoney(int depositMoney) {
		value += depositMoney;
	}
	
	/**
	 * @basic
	 */
	public int getAmount() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other.getClass() == this.getClass() 
				&& ((Account) other).value == this.value;
	}
	
	@Override
	public String toString() {
		return "Amount of money on account = " + value;
	}
}
