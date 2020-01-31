package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		TransactionUtility transaction = new TransactionUtility();
		
		Scanner in = new Scanner(System.in);
		
		DecimalFormat d = new DecimalFormat("0.00");
		
		int option = 0;
		int accountNum = 0;
		int index = 0;
		String balance = "";
		double amount = 0;
		String amountStr = "";
		int fromAccountNum = 0;
		int toAccountNum = 0;
			
		System.out.println("Please select one of the following options:");
		System.out.println();
		System.out.print("Open new account (1), check balance (2), deposit (3), withdrawal (4), transfer funds (5), exit (999): ");
		option = in.nextInt();
		
	    while(option != 999){
	    		    	
	    	switch(option)
	    	{
	    		// Open new account
	    		case 1:
	    		   accounts.add(new BankAccount());
	    		   System.out.println("A new account was successfully created for you.");
	    		   index = accounts.size() - 1;
	    		   System.out.println("Your new account number is " + accounts.get(index).getAccountNumber() + ".");
	    		   System.out.println();
	    	       break;  
	    	   
	    	   // Check balance    
	    	   case 2:
	    	       System.out.print("Please enter your account number: ");
	    	       accountNum = in.nextInt();
	    	       System.out.println();
	    	       index = accountNum - 1; 
	    	       balance = d.format(accounts.get(index).getBalance());
	    	       System.out.println("Your current balance is $" + balance + ".");
	    	       System.out.println();
	    	       break; 
	    	       
	    	   // Deposit    
	    	   case 3:
	    		   System.out.print("Please enter your account number: ");
	    		   accountNum = in.nextInt();
	    	       index = accountNum - 1;     	
	    		   System.out.print("Please enter the amount you would like to deposit: ");
	    		   amount = in.nextDouble();
	    		   transaction.deposit(amount, accounts.get(index));
	    		   amountStr = d.format(amount);
	    		   System.out.println("Deposit of $" + amountStr + " was completed sucessfully.");	   
	    		   break;
	    		   
	    	   // Withdraw	   
	    	   case 4:
	    		   System.out.print("Please enter your account number: ");
	    		   accountNum = in.nextInt();
	    	       index = accountNum - 1;     	
	    		   System.out.print("Please enter the amount you would like to withdraw: ");
	    		   amount = in.nextDouble();
	    		   transaction.withdraw(amount, accounts.get(index));
	    		   amountStr = d.format(amount);
	    		   System.out.println("Withdrawal of $" + amountStr + " was completed sucessfully.");
		    	   break; 
		    	
		       // Transfer	   
		       case 5:
		    	   System.out.print("Please enter the 'from' account number: ");
	    		   fromAccountNum = in.nextInt();  	
	    		   System.out.print("Please enter the 'to' account number: ");
	    		   toAccountNum = in.nextInt();
	    		   System.out.print("Please enter the amount you would like to transfer: ");
	    		   amount = in.nextDouble();
	    		   transaction.transfer(amount, accounts.get(fromAccountNum - 1), accounts.get(toAccountNum -1));
	    		   amountStr = d.format(amount);
	    		   System.out.println("Transfer of $" + amountStr + " was completed sucessfully.");
		    	   break;
		    
		       // Exit	   
		       case 999:
		    	   // do nothing
		    	   
	    	   default: 
	    		   System.out.println("Invalid entry: Please enter options 1-5 or 999");
	    		   System.out.println();
	    	}
	    	
	    	System.out.println("Please select one of the following options:");
	    	System.out.println();
			System.out.print("Open new account (1), check balance (2), deposit (3), withdrawal (4), transfer funds (5), exit (999): ");
	    	option = in.nextInt();
	    }
	    
	    System.out.println();
	    System.out.println("Thank you for using the Bank Account simulation!");
		
	    in.close();

	}

}
