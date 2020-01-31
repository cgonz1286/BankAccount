package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		accounts.clear();
	}
	
	@Test
	public void initializeBankAccountTest() {
		accounts.add(new BankAccount());
		
		BankAccount account = accounts.get(0);
		
		assertNotNull(account);
	}
	
	@Test
	public void defaultBalanceTest() {
		accounts.add(new BankAccount());
		
		assertEquals(0.0, accounts.get(0).getBalance(), 0); 
	}
	
	@Test
	public void specifiedBalanceTest() {
		accounts.add(new BankAccount(750.00));
		
		assertEquals(750.0, accounts.get(0).getBalance(), 0); 
	}
	
	@Test
	public void depositTest() {
		accounts.add(new BankAccount(0.00));
		BankAccount account = accounts.get(0);
		
		account.deposit(500.00);
		
		assertEquals(500.0, account.getBalance(), 0); 
	}
	
	@Test
	public void withdrawTest() {
		accounts.add(new BankAccount(750.00));
		BankAccount account = accounts.get(0);
		
		account.withdraw(500);
		
		assertEquals(250.0, account.getBalance(), 0); 
	}

}
