package accounts;

/**
 * @invar | 0 <= getAmount()
 */
public class SavingAccount extends Account {
	
	/**
	 * @post | getAmount() == 0
	 */
	public SavingAccount() {}
	
	@Override
	/**
	 * @mutates | this
	 * @pre | requestedMoney >= 0
	 * @post | getAmount() == old(getAmount())
	 * @post | result == 0
	 */
	public int requestMoney(int requestedMoney) {
		return 0;
	}
}
