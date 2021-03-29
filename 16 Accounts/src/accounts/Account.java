package accounts;

public abstract class Account {
	
	private int value;
	
	/**
	 * @post | getAmount() == 0
	 */
	protected Account() {}
	
	/**
	 * @mutates | this
	 * @post | getAmount() == newValue
	 */
	protected void setValue(int newValue) {
		this.value = newValue;
	}
	
	/**
	 * @pre | 0 <= requestedMoney
	 * @mutates | this
	 * @post | 0 <= result
	 * @post | result <= requestedMoney
	 * @post | getAmount() == old(getAmount()) - result
	 */
	public abstract int requestMoney(int requestedMoney);
	
	/**
	 * @mutates | this
	 * @pre | depositMoney >= 0
	 * @post | getAmount() == old(getAmount()) + depositMoney
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
