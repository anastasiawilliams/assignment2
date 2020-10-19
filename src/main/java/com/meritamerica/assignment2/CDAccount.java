package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount {
	private int term;
	private double balance;
	private Date startDate;

	private CDOffering offering;

	public CDAccount(CDOffering offering, double balance) {
		super(balance, offering.getInterestRate());
		this.balance = balance;
		this.offering = offering;

	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getTerm() {
		this.term = this.offering.getTerm();
		return this.term;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getStartDate() {
		return startDate;
	}

	public CDOffering getOffering() {
		return offering;
	}

	public void setOffering(CDOffering offering) {
		this.offering = offering;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
