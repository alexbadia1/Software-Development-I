import java.util.*;
import java.text.*;
import java.io.*;

/**
*@author AlexBadia <br>
*Prog 7 <br>
*Due Date and Time: 04/01/19 before 1:30 PM <br>
*
*Purpose: to refine our knowledge about file input/ouput. <br>
*
*Input: file, menu choice, items into a cart. <br>
*
*Output: Most expensive item in cart, least expensive item in cart, total cost of all items in cart, and details about the items in cart including price and quantity. <br>
*
*Certification of Authenticity: <br>
*   I certify that this lab is entirely my own work. <br>
*/

public class ShoppingDemoBadia {
	
	static Scanner keyboard = new Scanner (System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	
	public static void main (String args[]) {
		//Declare variables
		ShoppingCartBadia shoppingCart = new ShoppingCartBadia();
		ItemBadia leastExpensive = null, mostExpensive = null;
		String input = "???", itemName = "???", fileName = "???";
		char choice = '?';
		int itemQuant = 0, numItems = 0, currentItem = 0;
		double itemPrice = 0.0;
		boolean invalid = false, retry = true;
		
		while(retry) {
		
			//Prompt user for name of file
			System.out.println("Please enter the name of the file: ");
			fileName = keyboard.next();
		
			//Create reference to file
			File myFile = new File(fileName);
			
			//Try to open and read the file, if possible
			try {
				Scanner fileInput = new Scanner(myFile);
				numItems = fileInput.nextInt();
		
				while (fileInput.hasNext() && currentItem < numItems) {
					boolean validItemQuant = true, validItemPrice = true;
					
					ItemBadia item = new ItemBadia ();
			
					//Read in the name of the item(s) from the file
					itemName = fileInput.next();
					item.setName(itemName);
			
					//Read in the quantity of item(s) from the file
					//System.out.print(fileInput.nextLine());
					itemQuant = fileInput.nextInt();
					
					if (itemQuant <= 0) {
						validItemQuant = false;
						System.out.println("The item, " + itemName + ", has an invalid quantity!");
					} else item.setQuant(itemQuant);
					
					//Read in the price of the item(s) from the file
					itemPrice = fileInput.nextDouble();
					
					if (itemPrice < 0) {
						validItemPrice = false;
						System.out.println("The item, " + itemName + ", has an invalid price!");
					} else item.setPrice(itemPrice);
					
					if(validItemQuant && validItemPrice) {
						shoppingCart.addToCart(item);
						currentItem++;
					} else {
						if (validItemQuant == false) {
							System.out.println("The item, " + itemName + ", could not be added to te cart since it has an invalid quantity: " + itemQuant + "!");
						}//if
						if (validItemPrice == false) {
							System.out.println("The item, " + itemName + ", could not be added to the cart since it has an invalid price: " + itemPrice + "!");
						}//if
					}//else
	
				}//while
				
				fileInput.close();
				System.out.println("\nDownloading...\n");
				System.out.println("File Download Complete!\n");
				System.out.println("Continuing to the menu...\n ");
				retry = false;
			}//try
		
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
				System.out.println("Failed to find file: " + myFile.getAbsolutePath() + ".");
				retry = tryAgain();
			}//catch
			
			catch (InputMismatchException ex) {
				ex.printStackTrace();
				System.out.println("Type mismatch for the number I just tried to read in from the file.");
				System.out.println(ex.getMessage());
				retry = tryAgain();
			}//catch
			
			catch (NumberFormatException ex) {
				ex.printStackTrace();
				System.out.println("Failed to convert text into an integer value.");
				System.out.println(ex.getMessage());
				retry = tryAgain();
			}//catch
			
			catch(NullPointerException ex) {
				System.out.println("Null pointer exception.");
				System.out.println(ex.getMessage());
				retry = tryAgain();
			}//catch
			
			catch (NoSuchElementException ex) {
				System.out.println("No such element exception: Oops looks like you entered an empty file! ");
				System.out.println(ex.getMessage());
				retry = tryAgain();
			}//catch
			
			catch(Exception ex) {
				System.out.println("Something went wrong!");
				ex.printStackTrace();
				retry = tryAgain();
			}//catch
			
		}//while
		
		while (choice != 'Q') {
			
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
					choice = '?';
					break;
						
				case 'L':
					leastExpensive = shoppingCart.findLeastExpensive();
					if (leastExpensive == null)
						System.out.println("There are no items in the cart to find the least expensive item.\n");
					else System.out.println(leastExpensive);
					choice = '?';
					break;
						
				case 'M':
					mostExpensive = shoppingCart.findMostExpensive();
					if (mostExpensive == null)
						System.out.println("There are no items in the cart to find the most expensive item.\n");
					else System.out.println(mostExpensive);
					choice = '?';
					break;
						
				case 'N':
					if (shoppingCart.getSize() > 0) 
						System.out.println("The total number of items in the cart is: " + shoppingCart.getSize() + "\n");
					else System.out.println("Your shopping cart is empty!\n");
					choice = '?';
					break;
						
				case 'T': 
					System.out.println("The total price of all items is: " + moneyStyle.format(shoppingCart.calcTotalPrice()) + ".\n");
					choice = '?';
					break;
						
				case 'P':
					shoppingCart.printList();
					choice = '?';
					break;
						
				case 'D':
					if (shoppingCart.deleteItem ())
						System.out.println("The most expensive item was succesfully removed from the shopping cart.\n");
					choice = '?';
					break;
						
				default:
					do {
						if(invalid) {
							System.out.println("Invalid input, please enter a menu character choice only!");
						}//if
						System.out.println("Menu: ");
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
						
						if ((choice != 'A') && (choice != 'L') && (choice != 'M') && (choice != 'T') && (choice != 'P') && (choice != 'D') && (choice != 'Q') && (choice != 'N'))
							invalid = true;
						else invalid = false;
					} while (invalid);//while
					break;
						
			}//switch
					
		}//while-loop, loops menu and validates single character input
	
	System.out.println("Program Terminated.");
	keyboard.close();
	}//main
	
	
	/**
	 * This is a method that prompts the user to input yes or no to indicate whether they want to try to re-enter in a file or not.
	 * @return boolean value indicating whether the user wants to enter another file name or continue to menu
	 */
	public static boolean tryAgain() {
		String answer = "???";
		boolean truth = false;
		
		System.out.println("Would you like to try entering in a different file again (Choose- Yes or No to continue to menu): ");
		answer = keyboard.next();
		
		while (!(answer.equalsIgnoreCase("Yes")) && !(answer.equalsIgnoreCase("No"))) {
			System.out.println("Invalid Input, Yes or No Only!");
			System.out.println("Would you like to try entering in a different file again (Choose- Yes or No to continue to menu): ");
			answer = keyboard.next();
		}//while
		if (answer.equalsIgnoreCase("Yes"))
			truth = true;
		
		return truth;
	}//tryAgain
	
}//ShoppingDemo
