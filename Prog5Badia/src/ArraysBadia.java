//
//Alex Badia
//Prog 5
//Due Date and Time: 03/4/19 before 1:30 PM
//
//Purpose: use various types of arrays.
//
//Input: menu choice, list of pars, list of strokes, up to 20 integers in a list, up to 10 negative numbers in a list.
//
//Output: number of eagles, birdies, pars, bogeys, double bogeys, "others," entire list of positive numbers, entire list of negative numbers, entire list of both positive and negative numbers, max negative number value, number of times the max negative value appeared.
//
//Certification of Authenticity:
//   I certify that this lab is entirely my own work.

import java.util.*;
import java.text.*;

public class ArraysBadia {

	static Scanner input = new Scanner (System.in);
	
	public static void main (String []args) {
		//Declare variables
		int letterPresent = 0, numChoice = 0;
		char choice = '?';
		int size = 20, negSize = 10;
		int [] parList = new int [9];
		int [] strokeList = new int [9];
		int [] evenOrOddList = new int [20];
		int [] negList = new int [10];
		String results1 = "???", results2 = "???", results3 = "???", fakeChoice = "???";
		
		//Greet user and present user to prompt for input.
		System.out.println("Welcome to this program!");
		System.out.println("Menu:");
		System.out.println("1.) Let's Go Golfing!\n2.) More Positives or More Negatives?\n3.) How Many Maxes?\n0.) Quit.");
		System.out.print("Please choose a number from the menu: ");
		fakeChoice = input.next();
		
		for (int i = 0; i < fakeChoice.length(); i++) {
			choice = fakeChoice.charAt(i);
			if (Character.isLetter(choice)) {
				letterPresent++;
			}//if
		}//for
			if (letterPresent > 0)
				numChoice = -1;
			else numChoice = Integer.parseInt(fakeChoice);  //cast the string to an integer and set equal to numChoice
		
		while (numChoice != 0){
			
			switch (numChoice) {
			
				case 0:
					break;
					
				case 1:
					results1 = getStrokesAndPars(strokeList, parList);
					System.out.println(results1);
					numChoice = -1;
					break;
					
				case 2:
					results2 = getList(evenOrOddList, size);
					System.out.print(results2);
					numChoice = -1;
					break;
					
				case 3: 
					results3 = getNegativeList(negList, negSize);
					System.out.print(results3);
					numChoice = -1;
					break;
					
				default:
					System.out.println("\nMenu:");
					System.out.println("1.) Let's Go Golfing!\n2.) More Positives or More Negatives?\n3.) How Many Maxes?\n0.) Quit.");
					System.out.print("Please choose another number from the menu: ");
					fakeChoice = input.next();
					
					letterPresent = 0;
					
					for (int i = 0; i < fakeChoice.length(); i++) {
						choice = fakeChoice.charAt(i);
						if (Character.isLetter(choice)) {
							letterPresent++;
						}//if
					}//for
						if (letterPresent > 0)
							numChoice = -1;
						else numChoice = Integer.parseInt(fakeChoice);  //cast the string to an integer and set equal to numChoice
					
					break;
					
			}//switch
			
			
		}//while loops menu
		
		System.out.println("\nProgram terminated. Goodbye.");
		
	}//main
	
	//Name: getStrokesAndPars
	//Description: Prompts user to input the pars and strokes for each hole.
	//Parameters: strokes, holds value of strokeList from main.
	//          : pars, holds value of parList from main.
	//Returns: golfSummaryStats
	public static String getStrokesAndPars (int [] strokes, int [] pars) {
		String golfSummaryStats = "???";
		int parNum = 0;
		int numStroke = 0;
		
		//Just for formatting
		System.out.println();
		
		for (int i = 0; i < pars.length; i++) {
			System.out.print("Please enter the par value for hole (" + (i + 1) + "): ");
			parNum = input.nextInt();
			
			while (!(parNum > 0)) {
				System.out.print("INVALID PAR NUMBER!\nPlease enter another par value for hole (" + (i + 1) + "): ");
				parNum = input.nextInt();
				System.out.println();
			}//while, verifies the par number
			
			pars[i] = parNum;
			
		}//for, gets par values for each hole.
		
		//Just for formatting
		System.out.println();
		
		for (int i = 0; i < strokes.length; i++) {
			System.out.print("Please enter the number of strokes for hole (" + (i + 1) + "): ");
			numStroke = input.nextInt();
			
			while (!(numStroke > 0)) {
				System.out.println("INVALID STROKE NUMBER!\nPlease enter another number of strokes for hole (" + (i + 1) + "): ");
				numStroke = input.nextInt();
				System.out.println();
			}//while, verifies number of strokes
			
			strokes[i] = numStroke;
			
		}//for, gets users strokes for each hole.
		
		//Call helper method
		golfSummaryStats = calcStats(strokes, pars);
		
		return golfSummaryStats;
		
	}//getStrokesAndPars
	
	//Name: calcStats
	//Description: Calculates the number of eagles, birdies, pars, bogeys, double bogeys and others.
	//Parameters: listStrokes, holds value of strokes from getStrokesAndPars.
	//          : listPars, holds value of pars from getStrokesAndPars.
	//Returns: summary
	public static String calcStats (int [] listStrokes, int [] listPars) {
		int difference = 0, pars = 0, eagles = 0, birdies = 0, bogeys = 0, doubleBogeys = 0, other = 0;
		String summary = "???";
		
		for (int i = 0; i < 9; i++) {
			difference = listStrokes[i] - listPars[i];
			if (difference == -2)
				eagles++;
			else if (difference == -1)
				birdies++;
			else if (difference == 0)
				pars++;
			else if (difference == 1)
				bogeys++;
			else if (difference == 2)
				doubleBogeys++;
			else other++;
		}//for, loops through both lists of strokes and pars
		
		//Return string summary of variables and their values
		summary = "\nEagles: " + eagles;
		summary += "\nBirdies: " + birdies;
		summary += "\nPars: " + pars;
		summary += "\nBogeys: " + bogeys;
		summary += "\nDouble Bogeys: " + doubleBogeys;
		summary += "\nOther: " + other;
		
		return summary;
	}//calcStats

	//Name: getList
	//Description: prompts user to enter up to 20 integers into a list.
	//Parameters: list, holds value of evenOrOddList from main.
	//Returns: list
	public static String getList(int [] list, int index) {
		int roomLeft = 20, num = 0, size = 0;
		String answer = "???";
		
		System.out.println("\nYou can enter up to 20 integers into this list.");
		System.out.print("Please enter an integer number (0 to stop adding integer numbers): ");
		num = input.nextInt();
		System.out.println();
	
		while (num != 0 && size < index) {
			list[size] = num;
			size++;
			roomLeft--;
			//Just being a little more friendly to the user.
			if (roomLeft == 0)
				System.out.println("List Full!");
			else {
				System.out.println("You can still add up to " + (roomLeft) + " integer numbers to the list." );
				System.out.print("Please enter another integer number (0 to stop adding integer numbers): ");
				num = input.nextInt();
				System.out.println();
			}//else
		}//while, verifies input into list
		
		if (list[0]  == 0) {
			answer = "The list is empty!";
		} else answer = posOrNeg(list, size);
		
		return answer;
	}// getList	
	
	//Name: posOrNeg
	//Description: Prompts user to enter up to 20 numbers in a list.
	//Parameters: numList, holds value of list from getList.
	//          : limit, holds value of size from getList.
	//Returns: ans
	public static String posOrNeg(int [] numList, int limit) {
		String ans = "???";
		int numPos = 0;
		int numNeg = 0;
		
		for (int i = 0; i < limit; i++) {
			if (numList[i] > 0)
				numPos++;
			else numNeg++;
		}//for
		
		//Print list out
		if (numPos > numNeg) {
			ans = "The list of positive numbers are: ";
			for (int i = 0; i < limit; i++) {
				if (numList[i] > 0) {
					ans += numList[i] + " ";
				}//if
			}//for
		}//if
		else if (numNeg > numPos) {
			ans = "The list of negative numbers are: ";
			for (int i = 0; i < limit; i++) {
				if (numList[i] < 0) {
					ans += numList[i] + " ";
				}//if
			}//for
		}
		else {
			ans = "There are an equal number of positive and negative numbers: ";
			for (int i = 0; i < limit; i++)
					ans += numList[i] + " ";
		}//else
		
		return ans;
	}//posOrNeg
	
	//Name: getNegativeList
	//Description: prompts user to enter in 10 negative double numbers, positive to quit.
	//Parameters: list, holds place of negList in main.
	//          : size, holds place of negSize in main.
	//Returns: answer
	public static String getNegativeList(int [] list, int size) {
		String answer = "???";
		int roomLeft = 10, indexes = 0;
		int num = 0;
		
		System.out.println("\nYou can enter up to 10 negative numbers into this list.");
		System.out.print("Please enter a negative integer number (a positive number to stop adding numbers): ");
		num = input.nextInt();
		System.out.println();
	
		while ((num < 0) && (indexes < size)) {
			list[indexes] = num;
			indexes++;
			roomLeft--;
			
			//Just being a little more friendly to the user
			if (roomLeft == 0)
				System.out.println("List Full!");
			else {
				System.out.println("You can still add up to " + (roomLeft) + " negative numbers to the list." );
				System.out.print("Please enter another negative number (a positive number to stop adding numbers): ");
				num = input.nextInt();
				System.out.println();
			}//else
		}//while, verifies input into list
		
		answer = findMax(list, indexes);
		
		return answer;
	}//getNegativeList
	
	//Name: findMax
	//Description: finds the max value and the number of times it appears in the list.
	//Parameters: negativeNumbers, holds value of list from getNegativeList.
	//          : limit, holds value of indexes from getNegativeList.
	//Returns: solution
	public static String findMax(int [] negativeNumbers, int limit) {
		String solution = "???";
		int maxCount = 0;
		int maxVal = negativeNumbers[0];
		
		for (int i = 0; i < limit; i++) {
			if (maxVal < negativeNumbers[i]) {
				maxVal = negativeNumbers[i];
			}//if
		}//for
		
		for (int i = 0; i < limit; i++) {
			if (negativeNumbers[i] == maxVal) {
				maxCount++;
			}//if
		}//for
		
		solution = "Maximum Value: " + maxVal + "." + "\n";
		solution += "Number of occurences of the max value: " + maxCount + ".\n";
		
		return solution;
		
	}//findMax
	
}//class
