package com.meritamerica.assignment2;

import java.util.ArrayList;

public class MeritBank {
	private static long seedAccountNumber = 1000001;
	private static ArrayList<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	private static ArrayList<CDOffering> cdOfferings = new ArrayList<CDOffering>();

	public static double accountLimit = 250000.0;

	public static void addAccountHolder(AccountHolder accountHolder) {
		accountHolders.add(accountHolder);
	}

	public static AccountHolder[] getAccountHolders() {
		AccountHolder[] accounts = accountHolders.toArray(new AccountHolder[accountHolders.size()]);
		return accounts;
	}

	public static CDOffering[] getCDOfferings() {
		CDOffering[] accounts = cdOfferings.toArray(new CDOffering[cdOfferings.size()]);
		return accounts;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		System.out.println("cdOfferings.size()=" + cdOfferings.size());
		if (cdOfferings.size() <= 0) {
			return null;
		}
		ArrayList<Double> offerAmounts = new ArrayList<Double>();
		for (int i = 0; i < cdOfferings.size(); i++) {
			offerAmounts.add(depositAmount * cdOfferings.get(i).getInterestRate());
		}
		int bestIndex = getMax(offerAmounts, -1);
		return cdOfferings.get(bestIndex);

	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		System.out.println("cdOfferings.size()=" + cdOfferings.size());

		if (cdOfferings.size() <= 0) {
			return null;
		}
		ArrayList<Double> offerAmounts = new ArrayList<Double>();
		for (int i = 0; i < cdOfferings.size(); i++) {
			offerAmounts.add(depositAmount * cdOfferings.get(i).getInterestRate());
		}
		int bestIndex = getMax(offerAmounts, -1);
		double bestOffer = (double) offerAmounts.get(bestIndex);
		int secondIndex = getMax(offerAmounts, bestOffer);

		return cdOfferings.get(secondIndex);
	}

	// Method for getting the max value and place of value
	public static int getMax(ArrayList<Double> valueList, double valueCompare) {
		double maxValue = valueList.get(0);
		int maxIndex = 0;
		for (int i = 1; i < valueList.size(); i++) {
			boolean isMax = false;
			double value = valueList.get(i);
			if (valueCompare < 0) {
				isMax = value > maxValue;
			} else {
				isMax = (value > maxValue) && (value < valueCompare);
			}

			if (isMax) {
				maxValue = value;
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	public static void clearCDOfferings() {
		cdOfferings.clear();

	
		

	}

	public static void setCDOfferings(CDOffering[] offerings) {
		
		for (CDOffering offering : offerings)
			cdOfferings.add(offering);
	}

	public static long getNextAccountNumber() {
		seedAccountNumber += 1;
		return seedAccountNumber;
	}

	// get a total balance from a whole bank
	public static double totalBalances() {
		double totalBalances = 0;
		for (AccountHolder accountHolder : accountHolders) {
			totalBalances += accountHolder.getCombinedBalance();
		}
		return totalBalances;
	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureBalanace = 0;
		futureBalanace = presentValue * Math.pow(1 + interestRate, term);
		return futureBalanace;
	}
}
