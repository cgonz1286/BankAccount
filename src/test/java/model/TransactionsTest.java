package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransactionsTest {
	
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	TransactionUtility transaction = new TransactionUtility();

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		accounts.clear();
	}

	@Test
	public void depositTest() {
		accounts.add(new BankAccount(500.00));
		BankAccount account = accounts.get(0);
		
		// Deposit 500.00
		transaction.deposit(500.00, account);
		
		// Assert new balance is 1000.00
		assertEquals(1000.0, account.getBalance(), 0);
	}
	
	@Test
	public void withdrawTest() {
		accounts.add(new BankAccount(1000.00));
		BankAccount account = accounts.get(0);
		
		// Withdraw 250.00
		transaction.withdraw(250.00, account);
		
		// Assert new balance is 750.00
		assertEquals(750.0, account.getBalance(), 0);
	}
	
	@Test
	public void transferTest() {
		// Start with 500.00 in account1 and 0.00 in account2
		accounts.add(new BankAccount(500.00));
		accounts.add(new BankAccount());
		BankAccount account1 = accounts.get(0);
		BankAccount account2 = accounts.get(1);
		
		// Transfer 300.00 from account1 to account2
		transaction.transfer(300.00, account1, account2);
		
		// Assert that account1 now has 200.00 and account2 now has 300.00
		assertTrue(account1.getBalance() == 200.0 && account2.getBalance() == 300.00);
	}

}
