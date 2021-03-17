package accounts;

public class Account {
	
	protected int value; //Protected needed to access this field in Checking & Saving Account
	
	public Account(int value) {
		this.value = value;
	}
	
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
	
	public void depositMoney(int depositMoney) {
		value += depositMoney;
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
