package com.meritamerica.assignment2;

public class BankAccount {

	private long accountNumber;
	private double balance;
	private double interestRate;

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public BankAccount(double balance) {
		this.balance = balance;
		this.interestRate = 0;
	}

	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public boolean withdraw(double amount) {
		if (amount >= 0 && amount <= this.balance) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean deposit(double amount) {
		if (amount >= 0) {
			this.balance += amount;
			return true;
		} else {
			return false;
		}
	}

	public double futureValue(int years) {
		double futureBalanace = this.balance * Math.pow((1 + this.interestRate), years);
		return futureBalanace;
	}

}
