package accounts;

public class CheckingAccount extends Account {

	private int creditLimit;
	
	public CheckingAccount(int value, int creditLimit) {
		super(value);
		this.creditLimit = creditLimit;
	}
	
	@Override
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
