//
//Alex Badia
//Prog 3
//Due Date and Time: 1/11/19 before 1:30 PM
//
//Purpose: to master conditional statements and loops.
//
//Input: Tax payer ID, Filing status, Gross income, number of exemptions.
//
//Output: taxes owed, taxpayer number, filing status, taxable income, tax rate,
//number of taxpayers, highest tax amount, taxpayerID of the highest tax amount,
//total amount of taxes paid, average amount.
//
//Certification of Authenticity:
//   I certify that this lab is entirely my own work.

import java.util.*;
import java.text.*;

public class TaxesBadia {
	public static void main(String [] args) {
		
		//Initialize variables
		final int STANDARD_DEDUCTION = 4_250;
		final int EXEMPTIONS_DEDUCTION= 1_600;
		int taxPayerID = 0;
		String fileStatus = "???";
		char status = '?';
		double grossIncome = 0;
		int exemptions = 0;
		double taxRate = 0;
		int deduction = 0;
		double taxesOwed = 0;
		String taxPercent = "???";
		int countTaxPayers = 0;
		double maxTaxAmount = 0;
		int maxID = 0;
		double taxTotal = 0;
		
		//Greet user
		System.out.println("Welcome to the tax program!");
		
		//Prompt user for input
		Scanner input = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		System.out.print("Please enter your taxpayer ID (0 to quit): ");
		taxPayerID = input.nextInt();
		
		//Big loop to allow for multiple users
		while (taxPayerID != 0) {
			countTaxPayers += 1;
			System.out.println("\nS for Single,\nM for Marries filing jointly,\nH for Head of househole,");
			System.out.print("Please enter your filing status: ");
			fileStatus = input.next();
			status = fileStatus.charAt(0);
			status = Character.toUpperCase(status);
			
			//Prompt user to enter filing status and validate
			while (status != 'S' && status !=  'M' && status != 'H') {
				System.out.println("OOPS, INVALID INPUT!");
				System.out.println("\nS for Single,\nM for Married filing jointly,\nH for Head of househole,");
				System.out.print("Please enter a valid filing status: ");
				fileStatus = input.next();
				status = fileStatus.charAt(0);
				status = Character.toUpperCase(status);
			}//while filingStatus
			
			//Get gross income from user
			System.out.println("\nGreat, now enter your gross income: ");
			grossIncome= input.nextDouble();
			
			//Get number of exemptions from user
			System.out.println("Thank you! Now please enter your number of exemptions: ");
			exemptions = input.nextInt();
			while (!(exemptions >= 0 && exemptions <= 10)) {
				System.out.println("OOPS, INVALID INPUT!\nOnly up to 10 exemptions are allowed.");
				System.out.println("Please enter another a valid number of tax exemptions: ");
				exemptions = input.nextInt();
			}//while exemptions
		
			//Calculate total taxable income
			deduction = exemptions * EXEMPTIONS_DEDUCTION + STANDARD_DEDUCTION;
			if (grossIncome <= 0);
			else grossIncome -= deduction;
		
			switch (status) {
				case 'S':
					if (grossIncome > 50_000) {
						taxRate = .31;
						taxPercent = "31%";
					}//if
					else if (grossIncome >= 15_000) {
						taxRate = .22;
						taxPercent = "22%";
					}//if
					else if (grossIncome > 0) {
						taxRate = .14;
						taxPercent = "14%";
					}//if
					else {
						taxRate = 0;
						taxPercent = "0%";
					}//if
					fileStatus = "Single";
					break;
				
				case 'M':
					if (grossIncome > 135_000) {
						taxRate = .29;
						taxPercent = "29%";
					}//if
					else if (grossIncome >= 25_000) {
						taxRate = .20;
						taxPercent = "20%";
					}//if
					else if (grossIncome > 0) {
						taxRate = .12;
						taxPercent = "12%";
					}//if
					else {
						taxRate = 0;
						taxPercent = "0%";
					}//if
					fileStatus = "Married Filing Jointly";
					break;
				
				case 'H':
					if (grossIncome > 70_000) {
						taxRate = .30;
						taxPercent = "30%";
					}//if
					else if (grossIncome >= 30_000) {
						taxRate = .21;
						taxPercent = "21%";
					}//if
					else if (grossIncome > 0) {
						taxRate = .13;
						taxPercent = "13%";
					}//if
					else {
						taxRate = 0;
						taxPercent = "0%";
					}//if
					fileStatus = "Head of household";
					break;
				
				default:
					break;
			}//switch
		
			//Calculate taxes owed
			if (grossIncome <=0)
			taxesOwed = (-1) * grossIncome * taxRate;
			else taxesOwed = grossIncome * taxRate;
			taxTotal += taxesOwed;
			if (maxTaxAmount <= taxesOwed) {
				maxTaxAmount = taxesOwed;
				maxID = taxPayerID;
			}//if
			
			//Output results
			System.out.println("Taxpayer ID: " + taxPayerID + ".");
			System.out.println("Filing Status: " + fileStatus + ".");
			System.out.println("Taxable Income: " + moneyStyle.format(grossIncome) + ".");
			System.out.println("Tax Rate: " + taxPercent + ".");
			System.out.println("Taxes Owed:" + moneyStyle.format(taxesOwed) + ".");
			System.out.println("Please enter your taxpayer ID (0 to quit): ");
			taxPayerID = input.nextInt();
		}//while multiple taxayers
		
		System.out.println("Number of taxpayers processed: " + countTaxPayers + ".");
		System.out.println("Taxpayer, " + maxID + ", payed the highest tax amount of " + moneyStyle.format(maxTaxAmount) + ".");
		System.out.println("Total amount of taxes paid: " + moneyStyle.format(taxTotal) + ".");
		if (taxTotal == 0 && countTaxPayers == 0)
			System.out.println("Average tax amount paid: $0.00.");
		else System.out.println("Average tax amount paid: " + moneyStyle.format(taxTotal/countTaxPayers) + ".");
		input.close();
	}//main
}//class TaxesBadia
