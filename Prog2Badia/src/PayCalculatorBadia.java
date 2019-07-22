//
//Alex Badia
//Prog 2
//Due Date and Time: 1/11/19 before 1:30 PM
//
//Purpose: refine our knowledge about the proper use of control structures.
//
//Input: Last name, First name, hours worked, pay rate.
//
//Output: full name, hours worked, pay rate, gross wages, taxes owed, and net pay.
//
//Certification of Authenticity:
//   I certify that this lab is entirely my own work.
import java.util.*;
import java.text.*;

public class PayCalculatorBadia {
	public static void main(String[] args) {
		//Declare variables
		String lastName;
		String firstName;
		int hoursWorked;
		double payRate;
		double grossPay;
		double taxOwed;
		double netPay;
		
		//Prompt user for input
		Scanner input = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		System.out.print("Please enter you last name: ");
		lastName = input.next();
		
		System.out.print("Please enter your first name: ");
		firstName = input.next();
		
		System.out.print("Please enter the number of hours worked: ");
		hoursWorked = input.nextInt();
		
		System.out.print("Please your pay rate: ");
		payRate = input.nextDouble();
		
		//Calculate gross pay
		if (hoursWorked >= 50) {
			grossPay = (payRate * 40) + ((hoursWorked - 40) * payRate * 2.00);
		}//if
		else if (hoursWorked > 40) {
			grossPay = (payRate * 40) + ((hoursWorked - 40) * payRate * 1.50);
		}//if
		else grossPay = payRate * hoursWorked;
		
		//Calculate taxes owed
		if (grossPay > 2250.00) {
			taxOwed = .31 * grossPay;
		}//if
		else if (grossPay > 1000.00) {
			taxOwed = .22 * grossPay;
		}//if
		else if (grossPay > 200.00) {
			taxOwed = .10 * grossPay;
		}//if
		else taxOwed = 0.00;
		
		//Calculate net pay
		netPay = grossPay - taxOwed;
		
		//Output
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Hours worked: " + hoursWorked);
		System.out.println("Pay rate: " + moneyStyle.format(payRate));
		System.out.println("Gross wages: " + moneyStyle.format(grossPay));
		System.out.println("Taxes owed: " + moneyStyle.format(taxOwed));
		System.out.println("Net pay: " + moneyStyle.format(netPay));
		
		//close keyboard
		input.close();
		
	}//main
}//class
