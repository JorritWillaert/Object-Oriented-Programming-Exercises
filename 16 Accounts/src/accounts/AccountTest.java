package accounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void test() {
		CheckingAccount myCheckingAccount = new CheckingAccount(50);
		SavingAccount mySavingAccount = new SavingAccount();
		myCheckingAccount.depositMoney(20);
		mySavingAccount.depositMoney(100);
		
		assertEquals(20, myCheckingAccount.getAmount());
		assertEquals(100, mySavingAccount.getAmount());
		assertEquals(10, myCheckingAccount.requestMoney(10));
		assertEquals(0, mySavingAccount.requestMoney(10)); //Not allowed to request money from a savings account
		assertEquals(10, myCheckingAccount.getAmount());
		assertEquals(100, mySavingAccount.getAmount()); //Not allowed to request money from a savings account
		assertEquals(40, myCheckingAccount.requestMoney(40));
		assertEquals(-30, myCheckingAccount.getAmount());
		assertEquals(20, myCheckingAccount.requestMoney(40));
		assertEquals(-50, myCheckingAccount.getAmount());
		
		myCheckingAccount.depositMoney(60);
		mySavingAccount.depositMoney(40);
		assertEquals(10, myCheckingAccount.getAmount());
		assertEquals(140, mySavingAccount.getAmount());
		
		CheckingAccount mySecondCheckingAccount = new CheckingAccount(50);
		mySecondCheckingAccount.depositMoney(10);
		CheckingAccount myThirdCheckingAccount = new CheckingAccount(60);
		myThirdCheckingAccount.depositMoney(20);
		
		assertTrue(myCheckingAccount.equals(mySecondCheckingAccount));
		assertFalse(myCheckingAccount.equals(myThirdCheckingAccount));
	
		SavingAccount mySecondSavingAccount = new SavingAccount();
		mySecondSavingAccount.depositMoney(140);
		assertTrue(mySavingAccount.equals(mySecondSavingAccount));
		
		assertEquals("Amount of money on account = 10, credit limit = 50", myCheckingAccount.toString());
		assertEquals("Amount of money on account = 140", mySavingAccount.toString());
	}

}
