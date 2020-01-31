package model;

public class TransactionUtility {
	
	public TransactionUtility() {
		super();
	}

	public void deposit(double amount, BankAccount account) {
		account.deposit(amount);
	}
	
	public void withdraw(double amount, BankAccount account) {
		account.withdraw(amount);
	}
	
	public void transfer(double amount, BankAccount fromAccount, BankAccount toAccount) {
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
	}
	
}
