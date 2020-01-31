package model;

public class BankAccount {
	
	private static int count = 0;

	private final double DEFAULT_BALANCE = 0.00;

	private double balance;
	private String accountNumber;
	
	public BankAccount() {
		super();
		count++;
		this.balance = DEFAULT_BALANCE;		
		this.accountNumber = String.format("%06d", count);
	}
	
	public BankAccount(double balance) {
		super();
		count++;
		this.balance = balance;		
		this.accountNumber = String.format("%06d", count);
	}

	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}	
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}

}
