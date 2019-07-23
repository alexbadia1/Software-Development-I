import java.util.*;
import java.text.*;
import java.io.*;
/**
*@author AlexBadia <br>
*Prog 10 <br>
*Due Date and Time: 04/18/19 before 1:30 PM <br>
*
*Purpose: to refine our knowledge about utilizing linked lists for an ordered "array" implementation. <br>
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
		KeyedListBadia shoppingCart = new KeyedListBadia();
		//ItemBadia
		String answer = "???", input = "???", itemName = "???", fileName = "???", target = "???";
		char choice = '?';
		int itemQuant = 0, numItems = 0, currentItem = 0;
		double itemPrice = 0.0;
		boolean invalid = false, retry = true, notGoodAnswer = false;
		
		do {
			if (notGoodAnswer) {
				System.out.println("INVALID INPUT, would you like to enter a file (Type: Yes [to enter a file] or No [to continue to the menu]): ");
			} else System.out.println("Welcome to the shopping program, would you like to enter a file (Type: Yes [to enter a file] or No [to continue to the menu]): ");
			answer = keyboard.next();
			if ( !( answer.equalsIgnoreCase("Yes") ) && !( answer.equalsIgnoreCase("No") ) ) {
				notGoodAnswer = true;
			} else notGoodAnswer = false;
			
		} while (notGoodAnswer);
		
		
		if ( answer.equalsIgnoreCase("Yes") ) {
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
							shoppingCart.addItem(item);
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
					System.out.println("Failed to find file: " + myFile.getAbsolutePath() + ".");
					//ex.printStackTrace(); 
					retry = tryAgain();
				}//catch
			
				catch (InputMismatchException ex) {
					System.out.println("Type mismatch for the number I just tried to read in from the file.");
					System.out.println(ex.getMessage());
					//ex.printStackTrace();
					retry = tryAgain();
				}//catch
			
				catch (NumberFormatException ex) {
					System.out.println("Failed to convert text into an integer value.");
					System.out.println(ex.getMessage());
					//ex.printStackTrace();
					retry = tryAgain();
				}//catch
			
				catch(NullPointerException ex) {
					System.out.println("Null pointer exception.");
					System.out.println(ex.getMessage());
					//ex.printStackTrace();
					retry = tryAgain();
				}//catch
			
				catch (NoSuchElementException ex) {
					System.out.println("No such element exception: Oops looks like you entered an empty file! ");
					System.out.println(ex.getMessage());
					//ex.printStackTrace();
					retry = tryAgain();
				}//catch
			
				catch(Exception ex) {
					System.out.println("Something went wrong!");
					//ex.printStackTrace();
					retry = tryAgain();
				}//catch
			
			}//while
		}//if
		
		while (choice != '0') {
			
			switch (choice) {				
				case '1':
					
					ItemBadia item = new ItemBadia ();
					
					//get item name
					System.out.println("Please enter the name of the item you want to add to the shopping cart: ");
					itemName = keyboard.next();
					item.setName(itemName);
					
					//get item quantity
					System.out.println("Please enter the quantity of the item, " + itemName + ", you want: ");
					itemQuant = keyboard.nextInt();
					while (itemQuant <= 0) {
						System.out.println("Invalid item quantity! Please try entering a different quantity of " + itemName + ": ");
						itemQuant = keyboard.nextInt();
					}//while
					item.setQuant(itemQuant);
					
					//get the item price
					System.out.println("Please enter the price of the item, " + itemName + ": ");
					itemPrice = keyboard.nextDouble();
					while (itemPrice < 0) {
						System.out.println("Invalid item price! Please try entering a different price for " + itemName + ": ");
						itemPrice = keyboard.nextInt();
					}//while
					item.setPrice(itemPrice);
					
					//add to cart
					if (shoppingCart.addItem(item))
						System.out.println("\nItem was successfully added to the cart!\n");
					else System.out.println("\nItem could not be added to the cart!\n");
					choice = '?';
					break;
						
				case '2':
					System.out.println("Type in the name of the item you want to delete: ");
					String itemToDelete = keyboard.next();
					if (shoppingCart.remove (itemToDelete))
						System.out.println("\nThe item, " + itemToDelete + ", was succesfully removed from the shopping cart.\n");
					else System.out.println("\nThe item, " + itemToDelete + ", you want to remove from the cart does not exist in the cart.\n");
					choice = '?';
					break;
					
				case '3':
					if (shoppingCart.isEmpty()) {
						System.out.println("\nYour cart is empty!\n");
					} else shoppingCart.print();
					choice = '?';
					break;
						
				case '4':
					System.out.println("Please enter name of the item you want to retrieve: ");
					target = keyboard.next();
					if (shoppingCart.retrieve(target) == null) {
						System.out.println("\nThe item, " + target + ", you're looking for isn't in your cart!\n");
					} else { 
						System.out.println("");
						System.out.println(shoppingCart.retrieve(target).toString());
					}//if-else
					choice = '?';
					break;
						
				case '5': 
					System.out.println("The total number of item(s) in your cart is: " + shoppingCart.getCount() + ".\n");
					choice = '?';
					break;
						
				case '6':
					System.out.println("The total price is: " +  moneyStyle.format(shoppingCart.calcTotalPrice()) + ".\n");
					choice = '?';
					break;
						
				case '7':
					if(shoppingCart.isEmpty()) {
						System.out.println("Your cart is empty.\n");
					} else System.out.println("Your cart is not empty yet!.\n");
					choice = '?';
					break;
					
				case '8':
					if(shoppingCart.isFull()) {
						System.out.println("Your cart is full.\n");
					} else System.out.println("Your cart is not full yet.\n");
					choice = '?';
					break;
				
				case '9':
					shoppingCart.clear();
					System.out.println("Your cart has been emptied.\n");
					choice = '?';
					break;
						
				default:
					do {
						if(invalid) {
							System.out.println("Invalid input, please enter a menu character choice only!");
						}//if
						System.out.println("Menu: ");
						System.out.println("1. Add an item to the list");
						System.out.println("2. Delete an item from the list");
						System.out.println("3. Print each item in the list");
						System.out.println("4. Search for a user-specified item in the list");
						System.out.println("5. Count the total number of items in the list");
						System.out.println("6. Total the cost of the items in the list");
						System.out.println("7. Determine whether the list is empty");
						System.out.println("8. Determine whether the list is full");
						System.out.println("9. Clear the list");
						System.out.println("0. Quit");
						System.out.println("Please choose a choice: ");
						input = keyboard.next();
						
						if (input.length() == 1) {
							choice = input.charAt(0);
							if ((choice != '1') && (choice != '2') && (choice != '3') && (choice != '4') && (choice != '5') && (choice != '6') && (choice != '7') && (choice != '8') && (choice != '9') && (choice != '0')) {
								invalid = true;
							} else invalid = false;
						} else invalid = true;
						
					} while (invalid);//while
					break;
						
			}//switch
					
		}//while-loop, loops menu and validates single character input
	
	System.out.println("Goodbye...");
	keyboard.close();
	}//main
	
	
	/**
	 * This is a method that prompts the user to input yes or no to indicate whether they want to try to re-enter in a file or not.
	 * @return boolean value indicating whether the user wants to enter another file name or continue to menu
	 */
	public static boolean tryAgain() {
		String answer = "???";
		boolean truth = false;
		
		System.out.println("Would you like to try entering in a different file again (Type: Yes [to enter a file] or No [to continue to the menu]): ");
		answer = keyboard.next();
		
		while (!(answer.equalsIgnoreCase("Yes")) && !(answer.equalsIgnoreCase("No"))) {
			System.out.println("Invalid Input, Yes or No Only!");
			System.out.println("Would you like to try entering in a different file again (Type: Yes [to enter a file] or No [to continue to the menu]): ");
			answer = keyboard.next();
		}//while
		if (answer.equalsIgnoreCase("Yes"))
			truth = true;
		
		return truth;
	}//tryAgain
	
}//ShoppingDemo
