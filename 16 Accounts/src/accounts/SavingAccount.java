package accounts;

public class SavingAccount extends Account {
	
	/**
	 * @pre | value >= 0
	 * @post | getAmount() == value
	 */
	public SavingAccount(int value) {
		super(value);
	}
	
	@Override
	/**
	 * @post | result == 0
	 */
	public int requestMoney(int requestedMoney) {
		return 0;
	}
}
