package com.meritamerica.assignment2;

import java.util.ArrayList;

public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;

	private ArrayList<CheckingAccount> checkingAccounts;
	private ArrayList<SavingsAccount> savingsAccounts;
	private ArrayList<CDAccount> cdAccounts;

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;

		checkingAccounts = new ArrayList<CheckingAccount>();
		savingsAccounts = new ArrayList<SavingsAccount>();
		cdAccounts = new ArrayList<CDAccount>();
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return this.ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public String toString() {
		return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + " " + this.ssn;
	}

	// -------------- checking account ------------
	public CheckingAccount addCheckingAccount(double openingBalance) {

		double totalBalance = getCombinedBalance();

		if ((openingBalance + totalBalance) > MeritBank.accountLimit) {

			System.out.println(
					"!!! An account holder has combined balances exceeding $250,000, system could not create new account !!!");
			return null;
			
			
		}
		
		else {

		long newAccountNumber = MeritBank.getNextAccountNumber();

		double interest = 0.0001;

		CheckingAccount account = new CheckingAccount(newAccountNumber, openingBalance, interest);
		this.checkingAccounts.add(account);

		return account;
		
		}

	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		double totalBalance = getCombinedBalance();
		if ((checkingAccount.getBalance() + totalBalance) > MeritBank.accountLimit) {

			System.out.println(
					"!!! An account holder has combined balances exceeding $250,000, system could not create new account !!!");
			return null;
		}
		
		else {

		this.checkingAccounts.add(checkingAccount);
		return checkingAccount;
		}
		
	}

	// return list of all checking account of holder
	public CheckingAccount[] getCheckingAccounts() {
		CheckingAccount[] accounts = this.checkingAccounts.toArray(new CheckingAccount[checkingAccounts.size()]);
		return accounts;
	}

	// return number of all checking account of holder
	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.size();
	}

	// return total balance of all checking account
	public double getCheckingBalance() {
		double totalBalance = 0;
		if (this.checkingAccounts != null) {
			for (CheckingAccount account : this.checkingAccounts) {
				totalBalance += account.getBalance();
			}
		}
		return totalBalance;
	}

	// -------------- End of checking account ------------

	// -------------- savings account ------------
	public SavingsAccount addSavingsAccount(double openingBalance) {
		double totalBalance = getCombinedBalance();
		if ((openingBalance + totalBalance) > MeritBank.accountLimit) {

			System.out.println(
					"!!! An account holder has combined balances exceeding $250,000, system could not create new account !!!");
			return null;
		}
		
		else {

		long newAccountNumber = MeritBank.getNextAccountNumber();

		double interest = 0.01;

		SavingsAccount account = new SavingsAccount(newAccountNumber, openingBalance, interest);
		this.savingsAccounts.add(account);
		return account;
		}
	}
		

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		double totalBalance = getCombinedBalance();
		if ((savingsAccount.getBalance() + totalBalance) > MeritBank.accountLimit) {

			System.out.println(
					"!!! An account holder has combined balances exceeding $250,000, system could not create new account !!!");
			return null;
		}

		this.savingsAccounts.add(savingsAccount);
		return savingsAccount;
	}

	public SavingsAccount[] getSavingsAccounts() {
		SavingsAccount[] accounts = this.savingsAccounts.toArray(new SavingsAccount[savingsAccounts.size()]);
		return accounts;
	}

	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.size();
	}

	public double getSavingsBalance() {
		double totalBalance = 0;
		if (this.savingsAccounts != null) {
			for (SavingsAccount account : this.savingsAccounts) {
				totalBalance += account.getBalance();
			}
		}
		return totalBalance;
	}
	// -------------- End of savings account ------------

	// -------------- CD account ------------
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		CDAccount account = new CDAccount(offering, openingBalance);
		return account;
	}

	public CDAccount addCDAccount(CDAccount cdAccount) {

		this.cdAccounts.add(cdAccount);
		return cdAccount;
	}

	public CDAccount[] getCDAccounts() {
		CDAccount[] accounts = this.cdAccounts.toArray(new CDAccount[this.cdAccounts.size()]);
		return accounts;
	}

	public int getNumberOfCDAccounts() {
		return this.cdAccounts.size();
	}

	public double getCDBalance() {
		double totalBalance = 0;
		if (this.cdAccounts != null) {
			for (CDAccount account : this.cdAccounts) {
				totalBalance += account.getBalance();
			}
		}
		return totalBalance;
	}
	// -------------- End of CD account ------------

	public double getCombinedBalance() {
		double totalBalances = 0;

		totalBalances = getCheckingBalance() + getSavingsBalance();

		return totalBalances;

	}

}
