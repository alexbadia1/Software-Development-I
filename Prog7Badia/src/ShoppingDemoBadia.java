/**
*@ author Alex Badia <br>
*Prog 7 <br>
*Due Date and Time: 04/01/19 before 1:30 PM <br>
*
*Purpose: to refine our knowledge about classes and methods and lists. <br>
*
*Input: menu choice, items into a cart. <br>
*
*Output: Most expensive item in cart, least expensive item in cart, total cost of all items in cart, and details about the items in cart including price and quantity. <br>
*
*Certification of Authenticity: <br>
*   I certify that this lab is entirely my own work. <br>
*/

import java.util.*;
import java.text.*;

public class ShoppingDemoBadia {
	
	static Scanner keyboard = new Scanner (System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	public static void main (String args[]) {
		//Declare variables
		ShoppingCartBadia shoppingCart = new ShoppingCartBadia();
		ItemBadia leastExpensive = null, mostExpensive = null;
		String input = "???", itemName = "???";
		char choice = '?';
		int itemQuant = 0, num = 0;
		double itemPrice = 0.0;
				
		//Greet user and present user to prompt for input.
		System.out.println("Welcome to this program!");
		System.out.println("Menu:");
		System.out.println("A - Add an Item to the Cart");
		System.out.println("L - Find the Least Expensive Item in the Cart");
		System.out.println("M - Find the Most Expensive Item in the Cart");
		System.out.println("N - Find the Number of Items in the cart");
		System.out.println("T - Find the total cost of all Items in the Cart");
		System.out.println("P - Print out the details about all items in the Cart");
		System.out.println("D - Delete the Most Expensive Item from the Cart");
		System.out.println("Q : Quit");
		System.out.println("Please choose a choice: ");
		input = keyboard.next();
		
		choice = input.charAt(0);
		choice = Character.toUpperCase(choice);
		
		while ((choice != 'A') && (choice != 'L') && (choice != 'M') && (choice != 'T') && (choice != 'P') && (choice != 'D') && (choice != 'Q') && (choice != 'N')) {
			
			//Greet user and present user to prompt for input.
			System.out.println("Invalid input, please enter a menu character choice only!");
			System.out.println("Menu:");
			System.out.println("A - Add an Item to the Cart");
			System.out.println("L - Find the Least Expensive Item in the Cart");
			System.out.println("M - Find the Most Expensive Item in the Cart");
			System.out.println("N - Find the Number of Items in the cart");
			System.out.println("T - Find the total cost of all Items in the Cart");
			System.out.println("P - Print out the details about all items in the Cart");
			System.out.println("D - Delete the Most Expensive Item from the Cart");
			System.out.println("Q : Quit");
			System.out.println("Please choose a choice: ");
			input = keyboard.next();
			
			choice = input.charAt(0);
			choice = Character.toUpperCase(choice);
		}//While-loop to validate single letter input
			
		while (choice != 'Q') {	
			
			if (num > 0) {
			System.out.println("Menu:");
			System.out.println("A - Add an Item to the Cart");
			System.out.println("L - Find the Least Expensive Item in the Cart");
			System.out.println("M - Find the Most Expensive Item in the Cart");
			System.out.println("N - Find the Number of Items in the cart");
			System.out.println("T - Find the total cost of all Items in the Cart");
			System.out.println("P - Print out the details about all items in the Cart");
			System.out.println("D - Delete the Most Expensive Item from the Cart");
			System.out.println("Q : Quit");
			System.out.println("Please choose a choice: ");
			input = keyboard.next();
			
			choice = input.charAt(0);
			choice = Character.toUpperCase(choice);
			}//if
			
			num++;
			
			switch (choice) {				
				case 'A':
					
					ItemBadia item = new ItemBadia ();
					
					System.out.println("Please enter the name of the item you want to add to the shopping cart: ");
					itemName = keyboard.next();
					
					item.setName(itemName);
					
					System.out.println("Please enter the quantity of the item, " + itemName + ", you want: ");
					itemQuant = keyboard.nextInt();
					
					while (itemQuant <= 0) {
						System.out.println("Invalid item quantity! Please try entering a different quantity of " + itemName + ": ");
						itemQuant = keyboard.nextInt();
					}//while
					
					item.setQuant(itemQuant);
					
					System.out.println("Please enter the price of the item, " + itemName + ": ");
					itemPrice = keyboard.nextDouble();
					
					while (itemPrice < 0) {
						System.out.println("Invalid item price! Please try entering a different price for " + itemName + ": ");
						itemPrice = keyboard.nextInt();
					}//while
					
					item.setPrice(itemPrice);
					
					if (shoppingCart.addToCart(item))
						System.out.println("Item was successfully added to the cart!\n");
					else System.out.println("Item could not be added cause the cart is full!\n");
					break;
						
				case 'L':
					leastExpensive = shoppingCart.findLeastExpensive();
					if (leastExpensive == null)
						System.out.println("There are no items in the cart to find the least expensive item.\n");
					else System.out.println(leastExpensive);
					break;
						
				case 'M':
					mostExpensive = shoppingCart.findMostExpensive();
					if (mostExpensive == null)
						System.out.println("There are no items in the cart to find the most expensive item.\n");
					else System.out.println(mostExpensive);
					break;
						
				case 'N':
					if (shoppingCart.getSize() > 0) 
						System.out.println("The total number of items in the cart is: " + shoppingCart.getSize() + "\n");
					else System.out.println("Your shopping cart is empty!\n");
					break;
						
				case 'T': 
					System.out.println("The total price of all items is: " + moneyStyle.format(shoppingCart.calcTotalPrice()) + ".\n");
					break;
						
				case 'P':
					shoppingCart.printList();
					break;
						
				case 'D':
					if (shoppingCart.deleteItem ())
						System.out.println("The most expensive item was succesfully removed from the shopping cart.\n");
					break;
						
				default:
					
					while ((choice != 'A') && (choice != 'L') && (choice != 'M') && (choice != 'T') && (choice != 'P') && (choice != 'D') && (choice != 'Q') && (choice !='N')) {
						//Greet user and present user to prompt for input.
						System.out.println("Invalid choice, please enter a menu character choice only!");
						System.out.println("Menu:");
						System.out.println("A - Add an Item to the Cart");
						System.out.println("L - Find the Least Expensive Item in the Cart");
						System.out.println("M - Find the Most Expensive Item in the Cart");
						System.out.println("N - Find the Number of Items in the cart");
						System.out.println("T - Find the total cost of all Items in the Cart");
						System.out.println("P - Print out the details about all items in the Cart");
						System.out.println("D - Delete the Most Expensive Item from the Cart");
						System.out.println("Q : Quit");
						System.out.println("Please choose a choice: ");
						input = keyboard.next();
						
						choice = input.charAt(0);
						choice = Character.toUpperCase(choice);
					}//While-loop to validate single letter input
					num = 0;
					break;
						
			}//switch
					
		}//while-loop, loops menu and validates single character input
				
		System.out.println("Program Terminated.");
		
	}//main
	
}//ShoppingDemo
