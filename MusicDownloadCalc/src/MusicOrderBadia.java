//
//Alex Badia
//Prog 4
//Due Date and Time: 2/25/19 before 1:30 PM
//
//Purpose: to learn about methods and to continue to master conditional statements
//
//Input: Customer ID, customer name, number of songs ordered, song length, song genre, 
//
//Output: Customer name, customer ID, number of songs purchased, total cost of the songs, service charge, total amount due, number of customers, highest amount charged, customer with the highest amount charged, lowest amount charged, customer with the lowest amount charged, total amount of all music purchased, and the average of all purchase amounts.
//
//Certification of Authenticity:
//   I certify that this lab is entirely my own work.


import java.util.*;
import java.text.*;

public class MusicOrderBadia {
	
	static Scanner input = new Scanner (System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	
	public static void main (String[] args) {
		
		//Declare variables
		String customerName = "???";
		int numSongs = 0, customerID = -1, countCustomer = 0, highestID = Integer.MIN_VALUE, lowestID = Integer.MAX_VALUE, allSongs = 0;
		double totalCost = 0, serviceCharge = 0, amountDue = 0, highestAmount = Integer.MIN_VALUE, lowestAmount = Integer.MAX_VALUE, grandTotal = 0;
		
		System.out.print("Please enter your customer ID (1000 to 9999, inclusive, 0 to quit): ");
		customerID = input.nextInt();
		
		while (!(customerID <= 9999 && customerID >= 1000) && (customerID != 0)) {
			System.out.print("\nINVALID!\nPlease enter another customer ID (1000 to 9999, inclusive): ");
			customerID = input.nextInt();
		}//while customerID verification
		
		while (customerID != 0 ) {
			
			countCustomer += 1;
		
			System.out.print("\nPlease enter your name: ");
			customerName = input.next();
		
			System.out.print("\nPlease enter the number of songs you wanted to order: ");
			numSongs = input.nextInt();
		
			while (numSongs < 0) {
				System.out.print("\nINVALID\nPlease enter another number of songs you wanted to order: ");
				numSongs = input.nextInt();
			}//while verifies number of songs
		
			//Track grand total number of songs
			allSongs += numSongs;
						
			//Calculate the total cost of all songs
			totalCost = chooseSongs(numSongs);
		
			//Calculate the service charge
			serviceCharge = calcServiceCharge(totalCost, numSongs);
		
			//Calculate the total due
			amountDue = calcTotalDue(totalCost, serviceCharge);
		
			//Track highest amount
			if (highestAmount < amountDue) {
				highestAmount = amountDue;
				highestID = customerID;
			}//if
		
			//Track lowest amount
			if (countCustomer == 1) {
				lowestAmount = amountDue;
				lowestID = customerID;
			}//if
			if (lowestAmount > amountDue) {
				lowestAmount = amountDue;
				lowestID = customerID;
			}//if
		
			//Track total amount of all purchased music
			grandTotal += amountDue;
		
			//OutputResults
			outputResults(customerName, customerID, numSongs, totalCost, serviceCharge, amountDue);
		
			System.out.print("\nPlease enter another customer ID (1000 to 9999, inclusive, 0 to quit): ");
			customerID = input.nextInt();
		
			while (!(customerID <= 9999 && customerID >= 1000) && (customerID != 0)) {
				System.out.print("\nINVALID!\nPlease enter another customer ID (1000 to 9999, inclusive): ");
				customerID = input.nextInt();	
			}//while customerID verification
		
		}//while loop allows for multiple users
		
		//Output summary
		if (countCustomer == 0)
			System.out.print("\nNo customers detected.");
		else outputSummary (countCustomer, highestID, highestAmount, lowestID, lowestAmount, grandTotal, allSongs);
		
	}//main 
		
		//Name: chooseSongs.
		//Description: Let's user choose the number of songs they want to buy and the songs genres.
		//Parameters: songNum, holds value of numSongs from main.
		//Returns: sum divided by 100.
		public static double chooseSongs (int songNum){
			double seconds = 0;
			double sum = 0;
			char choice = '?';
			String genere = "???";
			double cost = 0;
			
			for (int i = 1; i <= songNum; i++) {
				System.out.print("\nWhat is the length of song number (" + i + ") in seconds (1 to 6000 inclusive)? ");
				seconds = input.nextDouble();
				
				while (!(seconds >= 1 && seconds <= 6000)) {
					System.out.print("\nINVALID SONG LENGTH\nPlease enter another length of song number (" + i + ") in seconds (1 to 6000 inclusive): ");
					seconds = input.nextDouble();
				}//while verifies song length
				
				System.out.print("\nWhat is the genere of this song, pop, rap, country, gospel or other? ");
				genere = input.next();
				choice = genere.charAt(0);
				choice = Character.toUpperCase(choice);
				
				while (choice != 'P' && choice != 'R' && choice != 'C' && choice != 'G' && choice != 'O') {
					System.out.print("\nINVALID GENRE\nEnter another genere of this song, pop, rap, country, gospel or other: ");
					genere = input.next();
					choice = genere.charAt(0);
					choice = Character.toUpperCase(choice);
				}//while verifies genre
				switch (choice) {
					case 'P':
						cost = seconds * 0.40;
						break;
					case 'R':
						cost = seconds * 0.54;
						break;
					case 'C':
						cost = seconds * .19;							
						break;
					case 'G':
						cost = seconds * .30;
						break;
					default:
						cost = seconds * .25;
						break;
					}//switch
				sum += cost;
			}//for
			return sum/100.0;		
		}//chooseSongs
		
		//Name: calcServiceCharge
		//Description: calculates the service charge.
		//Parameter: total, holds totalCost from main.
		//         : songs, holds numSongs from main.
		//Return: serviceFee
		public static double calcServiceCharge(double total, int songs) {
			double serviceFee = 0;
			if (songs > 15)
				serviceFee = total * .06;
			else if (songs >= 10)
				serviceFee = total * .10;
			else if (songs >= 5)
				serviceFee = total * .13;
			else if (songs >= 1)
				serviceFee = total * .16;
			return serviceFee;
		}//calcServicehCharge
		
		//Name: calcTotalDue
		//Description: calculates the total due for songs.
		//Parameters: total, holds serviceCharge from main.
		//          : serviceFee, holds totalCost from main.
		//Return: totaDue
		public static double calcTotalDue(double total, double serviceFee) {
			double totalDue = (total + serviceFee) * 1.07;
			return totalDue;
		}//calcTotalDue
		
		//Name: outputResults
		//Description: prints out the customer, customerID, number of songs ordered, price of all the songs, service charge, and the total amount due.
		//Return: void
		public static void outputResults(String name, int id, int numberOfSongs, double totalSongPrice, double serviceFee, double totalDue) {
			System.out.println("\nCustomer name: " + name + ".");
			System.out.println("Customer ID: " + id + ".");
			System.out.println("Number of songs: " + numberOfSongs + ".");
			System.out.println("Price of all songs: " + moneyStyle.format(totalSongPrice) + ".");
			System.out.println("Service charge:  " + moneyStyle.format(serviceFee) + ".");
			System.out.println("Total due: " + moneyStyle.format(totalDue) + ".");
		}//outputResults
	
		//Name: outputSummary
		//Description: prints out the customer, their ID, the customer who payed the max, the customer who payed the least, the average songs purchased and total purchase amount.
		//Return: void
		public static void outputSummary (int numCustomers, int maxID, double maxAmount, int minID, double minAmount, double summation, int grandNumberSongs) {
			System.out.println("\nNumber of customers processed: " + numCustomers + "." );
			System.out.println("Customer ID, " + maxID + ", payed the highest amount of " + moneyStyle.format(maxAmount) + ".");
			System.out.println("Customer ID, " + minID + ", payed the lowest amount of " + moneyStyle.format(minAmount) + ".");
			System.out.println("Total number of all songs purchased: " + grandNumberSongs + ".");
			System.out.println("Total amount of all music purchased: " + moneyStyle.format(summation) + ".");
			System.out.println("The average of all purchase amounts is: " + moneyStyle.format(summation/(double) numCustomers) + ".");
			System.out.println("Program terminated.");
		}//outputSummary 
}//class
		
		
		
		
		
