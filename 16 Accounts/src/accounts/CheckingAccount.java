package accounts;

/**
 * @invar | 0 <= getCreditLimit()
 * @invar | - getCreditLimit() <= getAmount()
 */
public class CheckingAccount extends Account {
	
	/**
	 * @invar | creditLimit >= 0
	 * @invar | -creditLimit <= getAmount()
	 */
	private int creditLimit;
	
	/**
	 * @pre | creditLimit >= 0
	 * @post | getAmount() == 0
	 * @post | getCreditLimit() == creditLimit
	 */
	public CheckingAccount(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	/**
	 * @basic
	 */
	public int getCreditLimit() {
		return creditLimit;
	}
	
	@Override
	/**
	 * @mutates | this
	 * @pre | requestedMoney >= 0
	 * @post | getAmount() == old(getAmount()) - result
	 * @post | requestedMoney <= old(getAmount()) + getCreditLimit() ?
	 * 		 |		 result == requestedMoney
	 * 		 | : 	 result == old(getAmount()) + getCreditLimit()
	 */
	public int requestMoney(int requestedMoney) {
		int oldValue = getAmount();
		if (requestedMoney > getAmount() + creditLimit)
			setValue(-creditLimit);
		else
			setValue(getAmount() - requestedMoney);;
		return oldValue - getAmount();	
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other)
				&& ((CheckingAccount) other).creditLimit == this.creditLimit;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", credit limit = " + creditLimit;
	}
}
