package accounts;

public class SavingAccount extends Account {

	public SavingAccount(int value) {
		super(value);
	}
	
	@Override
	public int requestMoney(int requestedMoney) {
		return 0;
	}
}
