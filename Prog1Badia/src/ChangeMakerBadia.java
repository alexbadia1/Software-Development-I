//
//Alex Badia
//Due Date and Time: 4 February 2019 before 1:30 PM
//
//Purpose: <to introduce me to the Java/Eclipse environment.
//
//Input: money amount
//
//Output: change in 20's, 10's, 5's, and 1 dollar bills, as well as quarters, nickels, dimes and pennies.
//
//Certification of Authenticity
//
//I certify that this lab is entirely my own work.

//Import statements
import java.util.*;

public class ChangeMakerBadia {
  public static void main (String[] args) {
      int amount, originalAmount, twenties, tens, fives, ones, quarters, dimes, nickels, pennies, bills, coins;
      
      //Get input
      System.out.println("Welcome to the change maker!");
      System.out.println("Enter a whole number amount ");
      System.out.println("I will output a combination of coins and bills ");
      System.out.println("that equals that amount of change:");
      
      Scanner keyboard = new Scanner(System.in);
      amount = keyboard.nextInt();
      
      //Calculation
      originalAmount = amount;
      twenties = amount / 2000;
      amount = amount % 2000;
      tens = amount / 1000;
      amount = amount % 1000;
      fives = amount / 500;
      amount = amount % 500;
      ones = amount / 100;
      amount = amount % 100;
      quarters = amount / 25;
      amount = amount % 25;
      dimes = amount / 10;
      amount = amount % 10;
      nickels = amount / 5;
      amount = amount % 5;
      pennies = amount;
      
      //Calculate total number of bills and coins
      bills = twenties + tens + fives + ones;
      coins = quarters + dimes + nickels + pennies;  
      
      System.out.println(originalAmount + " can be given as:");
      System.out.println(twenties + " twenty dollar bill(s).");
      System.out.println(tens + " ten dollar bills.");
      System.out.println(fives + " five dollar bill(s).");
      System.out.println(ones + " one dollar bill(s).");
      System.out.println(quarters + " quarter(s).");
      System.out.println(dimes + " dime(s).");
      System.out.println(nickels + " nickel(s).");
      System.out.println(pennies + " pennies.");
      System.out.println("Total number of bills: " + bills + ".");
      System.out.println("Total number of coins: " + coins + ".");
      keyboard.close();
  }//main
}//class ChangeMakerBadia
