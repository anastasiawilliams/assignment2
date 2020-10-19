package com.meritamerica.assignment2;

public class MeritAmericaBankApp {

	public static void main(String[] args) {
		System.out.println("=== Welcome to Assignment II - Merit America Bank  ===");

		MeritBank meritBank = new MeritBank();

		// Add 5 CDOfferings to MeritBank
		// 1. 1 year term at 1.8%
		// 2. 2 year term at 1.9%
		// 3. 3 year term at 2.0%
		// 4. 5 year term at 2.5%
		// 5. 10 year term at 2.2%
		CDOffering[] CDofferings = new CDOffering[5];
		CDofferings[0] = new CDOffering(1,1.8/100);
		CDofferings[1] = new CDOffering(2,1.9/100);
		CDofferings[2] = new CDOffering(3,2.0/100);
		CDofferings[3] = new CDOffering(5,2.5/100);
		CDofferings[4] = new CDOffering(10,2.2/100);
		MeritBank.setCDOfferings(CDofferings);

		// Instantiate a new AccountHolder (ah1)
		AccountHolder ah1_holder = new AccountHolder("AHAONE", "SIMSONS", "", "123456789");

		System.out.println("ah1_holder=" + ah1_holder.getFirstName() + " " + ah1_holder.getLastName() + " ("
				+ ah1_holder.getSSN() + ")");
		System.out.println("=====================================================");
		// Add a checking account with an opening balance of $1,000 as well as
		// a savings account with an opening balance of $10,000 to ah1
		System.out.println("ah1_holder, opening balance of $1,000 and $10,000");
		CheckingAccount ah1_checking1 = ah1_holder.addCheckingAccount(1000);
		SavingsAccount ah1_saving1 = ah1_holder.addSavingsAccount(10000);
		if (ah1_checking1 != null && ah1_saving1 != null) {
			System.out.println(
					"ah1_holder, ah1_checking1=" + ah1_checking1.getAccountNumber() + " " + ah1_checking1.getBalance());
			System.out.println(
					"ah1_holder, ah1_saving1=" + ah1_saving1.getAccountNumber() + " " + ah1_saving1.getBalance());
		}
		System.out.println(
				ah1_holder.getFirstName() + " has a current combined balance=" + ah1_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add a checking account with an opening balance of $5,000 as well as a
		// savings account with an opening balance of $50,000 to ah1
		System.out.println("ah1_holder, opening balance of $5,000 and $50,000");
		CheckingAccount ah1_checking2 = ah1_holder.addCheckingAccount(5000);
		SavingsAccount ah1_saving2 = ah1_holder.addSavingsAccount(50000);
		if (ah1_checking2 != null && ah1_saving2 != null) {
			System.out.println(
					"ah1_holder, ah1_check2=" + ah1_checking2.getAccountNumber() + " " + ah1_checking2.getBalance());
			System.out.println(
					"ah1_holder, ah1_saving2=" + ah1_saving2.getAccountNumber() + " " + ah1_saving2.getBalance());
		}
		System.out.println(
				ah1_holder.getFirstName() + " has a current combined balance=" + ah1_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add a checking account with an opening balance of $50,000 as well as a
		// savings account with an opening balance of $500,000 to ah1
		System.out.println("ah1_holder, opening balance of $50,000 and $500,000");
		CheckingAccount ah1_checking3 = ah1_holder.addCheckingAccount(50000);
		SavingsAccount ah1_saving3 = ah1_holder.addSavingsAccount(500000);
		if (ah1_checking3 != null && ah1_saving3 != null) {
			System.out.println(
					"ah1_holder, ah1_check3=" + ah1_checking3.getAccountNumber() + " " + ah1_checking3.getBalance());
			System.out.println(
					"ah1_holder, ah1_saving3=" + ah1_saving3.getAccountNumber() + " " + ah1_saving3.getBalance());
		}
		System.out.println(
				ah1_holder.getFirstName() + " has a current combined balance=" + ah1_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add a checking account with an opening balance of $5,000 as well as a
		// savings account with an opening balance of $50,000 to ah1
		System.out.println("ah1_holder, opening balance of $5,000 and $50,000");
		CheckingAccount ah1_checking4 = ah1_holder.addCheckingAccount(5000);
		SavingsAccount ah1_saving4 = ah1_holder.addSavingsAccount(50000);
		if (ah1_checking4 != null && ah1_saving4 != null) {
			System.out.println(
					"ah1_holder, ah1_check4=" + ah1_checking4.getAccountNumber() + " " + ah1_checking4.getBalance());
			System.out.println(
					"ah1_holder, ah1_saving4=" + ah1_saving4.getAccountNumber() + " " + ah1_saving4.getBalance());
		}
		System.out.println(
				ah1_holder.getFirstName() + " has a current combined balance=" + ah1_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add the best CD offering as a CD account on ah1
		CDOffering bestOffer = MeritBank.getBestCDOffering(ah1_holder.getCombinedBalance());
		System.out.println("ah1_holder, has best term?=" + (bestOffer != null));
		if (bestOffer != null) {
			CDAccount ah1_cdacct = new CDAccount(bestOffer, ah1_holder.getCombinedBalance());
			ah1_holder.addCDAccount(ah1_cdacct);
			System.out.println("ah1_holder, best term=" + ah1_cdacct.getTerm());
		}
		System.out.println("=====================================================");

		// Add ah1 to Merit Bank's list of account holders
		MeritBank.addAccountHolder(ah1_holder);

		// Instantiate a new AccountHolder (ah2)
		AccountHolder ah2_holder = new AccountHolder("ah2", "assignment2", "", "Y123456789");
		System.out.println("ah2_holder=" + ah2_holder.getFirstName() + " " + ah2_holder.getLastName() + " ("
				+ ah2_holder.getSSN() + ")");
		System.out.println("=====================================================");

		// Add a checking account with an opening balance of $1,000 as well as a
		// savings account with an opening balance of $10,000 to ah2
		System.out.println("ah2_holder, opening balance of $1,000 and $10,000");
		CheckingAccount ah2_check1 = ah2_holder.addCheckingAccount(1000);
		SavingsAccount ah2_saving1 = ah2_holder.addSavingsAccount(10000);
		if (ah2_check1 != null && ah2_saving1 != null) {
			System.out
					.println("ah2_holder, ah2_check1=" + ah2_check1.getAccountNumber() + " " + ah2_check1.getBalance());
			System.out.println(
					"ah2_holder, ah2_saving1=" + ah2_saving1.getAccountNumber() + " " + ah2_saving1.getBalance());
		}
		System.out.println("ah2_holder, current combine balance=" + ah2_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add the second best CD offering as a CD account on ah2
		CDOffering secondBestOffer = MeritBank.getSecondBestCDOffering(ah2_holder.getCombinedBalance());
		System.out.println("ah2_holder, has 2nd best term?=" + (secondBestOffer != null));
		if (secondBestOffer != null) {
			CDAccount ah2_cdacct = new CDAccount(secondBestOffer, ah2_holder.getCombinedBalance());
			ah2_holder.addCDAccount(ah2_cdacct);
			System.out.println("ah2_holder, 2nd best term=" + ah2_cdacct.getTerm());
		}
		System.out.println("=====================================================");

		// Add ah1 to Merit Bank list of account holders
		MeritBank.addAccountHolder(ah2_holder);

		// Clear the CDs being offered by MeritBank
		MeritBank.clearCDOfferings();

		// Instantiate a new AccountHolder (ah3)
		AccountHolder ah3_holder = new AccountHolder("ah3", "assignment2", "", "Z123456789");
		System.out.println("ah3_holder=" + ah3_holder.getFirstName() + " " + ah3_holder.getLastName() + " ("
				+ ah3_holder.getSSN() + ")");
		System.out.println("=====================================================");

		// Add the second best CD offering as a CD account on ah3
		CDOffering secondBestOffer2 = MeritBank.getSecondBestCDOffering(ah3_holder.getCombinedBalance());
		System.out.println("ah2_holder, has 2nd best term?=" + (secondBestOffer2 != null));
		if (secondBestOffer2 != null) {
			CDAccount ah3_cdacct = new CDAccount(secondBestOffer2, ah3_holder.getCombinedBalance());
			ah2_holder.addCDAccount(ah3_cdacct);
			System.out.println("ah2_holder, 2nd best term=" + secondBestOffer2.getTerm());
		}
		;

		System.out.println("=====================================================");

		// Add a checking account with an opening balance of $1,000 as well as a
		// savings account with an opening balance of $10,000 to ah3
		System.out.println("ah3_holder, opening balance of $1,000 and $10,000");
		CheckingAccount ah3_check1 = ah3_holder.addCheckingAccount(1000);
		SavingsAccount ah3_saving1 = ah3_holder.addSavingsAccount(10000);
		if (ah3_check1 != null && ah3_saving1 != null) {
			System.out
					.println("ah3_holder, ah3_check1=" + ah3_check1.getAccountNumber() + " " + ah3_check1.getBalance());
			System.out.println(
					"ah3_holder, ah3_saving1=" + ah3_saving1.getAccountNumber() + " " + ah3_saving1.getBalance());
		}
		System.out.println("ah3_holder, current combine balance=" + ah3_holder.getCombinedBalance());
		System.out.println("=====================================================");

		// Add ah3 to Merit Bank's list of account holders
		MeritBank.addAccountHolder(ah3_holder);

		// Get the total balance of all accounts held by Merit Bank's account holders
		double bankTotalBalance = MeritBank.totalBalances();
		System.out
				.println("The total balance of all accounts held by Merit Bank's account holders= " + bankTotalBalance);
		System.out.println("=====================================================");

	}

}
