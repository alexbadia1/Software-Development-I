import java.io.*;
import java.util.*;
/**
*@author Alex Badia <br>
*Prog 11 <br>
*Due Date and Time: 05/06/19 before 1:30 PM <br>
*
*Purpose: to refine our knowledge about utilizing stacks with array and linked list implementation. <br>
*
*Input: file of cards. <br>
*
*Output: Total number of cards, total number of plays, a clear winner or not, player1 number of cards, player2 number of cards, who won. <br>
*
*Certification of Authenticity: <br>
*   I certify that this lab is entirely my own work. <br>
*/
public class BattleDemoBadia 
{
	static Scanner keyboard = new Scanner (System.in);
	
	public static void main (String args[]) 
	{
		System.out.println("Welcome To The Battle Demo Program!\n");
		
		//Create Stacks
		boolean gameOver = false, clearWinner = true;
		int playCount = 0, player1Total = 0, player2Total = 0, totalCards = 0;
		String whoWon = "no one";
		StackBadia player1Stack = new StackBadia ();
		StackBadia player2Stack = new StackBadia ();
		StackBadia player1DiscardStack = new StackBadia ();
		StackBadia player2DiscardStack = new StackBadia ();
		
		//deal cards
		totalCards = deal(player1Stack, player2Stack);
		
		if ( totalCards != 0 ) 
		{
			while (gameOver != true && playCount < 1000)  
			{
				if ( play(player1Stack, player2Stack, player1DiscardStack, player2DiscardStack) ) 
				{
					playCount++;
				} 
				else 
				{
					if ( player1Stack.isEmpty() ) {
						gameOver = true;
						whoWon = "player 2";
					} 
					else 
					{
						gameOver = true;
						whoWon = "player 1";
					}//nested if-else
					
				}//if-else
				
			}//while
			
			if (playCount == 1000) 
			{
				clearWinner = false;
			}//if
		}
		else 
		{
			System.out.println("There were no cards to be dealt!\n");
		}//if-else

		player1Total = countCard(player1Stack) + countCard(player1DiscardStack);
		player2Total = countCard(player2Stack) + countCard(player2DiscardStack);
		
		printResults(totalCards, playCount, clearWinner, player1Total, player2Total, whoWon);
		
	}//main
	
	/**
	 * This method deals the cards to each players stack
	 * @param stack1 (incoming player1 play stack)
	 * @param stack2 (incoming player2 play stack)
	 * @return number of cards dealt
	 */
	public static int deal (StackBadia stack1, StackBadia stack2) 
	{
		//Declare variables
		boolean retry = true;
		char cardSuit = '?';
		int cardValue = 0, cardCount = 0;
		String fileName = "???", fakeCardSuit = "???";
		
		while (retry)
		{
			//Prompt user for name of file
			System.out.println("Please enter the name of the file: ");
			fileName = keyboard.next();
			
			//Create reference to file
			File myFile = new File(fileName);
			
			//Try to open and read the file, if possible
			try 
			{
				Scanner fileInput = new Scanner(myFile);
				
				while (fileInput.hasNext()) 
				{
					//Create a card
					CardBadia card = new CardBadia ();
					cardCount++;
					
					//Read in the value of the card from the file
					cardValue = fileInput.nextInt();
					card.setValue(cardValue);
					
					//Read in the name of the item(s) from the file
					fakeCardSuit = fileInput.next();
					cardSuit = fakeCardSuit.charAt(0);
					cardSuit = Character.toUpperCase(cardSuit);
					card.setSuit(cardSuit);
					
					if (cardCount % 2 == 1) 
					{
						stack1.push(card); //Add one card to player1's stack
					} else stack2.push(card);//Add next card to player2's stack
					
				}//while
				
				fileInput.close();
				System.out.print("\nDownloading...\n");
				System.out.println("\nFile Download Complete!\n");
				System.out.println("Continuing to the menu...\n ");
				retry = false;
				
			}//try
			
			catch (FileNotFoundException ex) 
			{
				System.out.println("Failed to find file: " + myFile.getAbsolutePath() + ".");
				//ex.printStackTrace(); 
				retry = tryAgain();
				
			}//catch
			
			catch (InputMismatchException ex) 
			{
				System.out.println("Type mismatch for the number I just tried to read in from the file.");
				System.out.println(ex.getMessage());
				//ex.printStackTrace();
				retry = tryAgain();
				
			}//catch
			
			catch (NumberFormatException ex) 
			{
				System.out.println("Failed to convert text into an integer value.");
				System.out.println(ex.getMessage());
				//ex.printStackTrace();
				retry = tryAgain();
				
			}//catch
			catch(NullPointerException ex) 
			{
				System.out.println("Null pointer exception.");
				System.out.println(ex.getMessage());
				//ex.printStackTrace();
				retry = tryAgain();
				
			}//catch	
			catch (NoSuchElementException ex) 
			{
				System.out.println("No such element exception: Oops looks like you entered an empty file! ");
				System.out.println(ex.getMessage());
				//ex.printStackTrace();
				retry = tryAgain();
				
			}//catch
			catch(Exception ex) 
			{
				System.out.println("Something went wrong!");
				//ex.printStackTrace();
				retry = tryAgain();
				
			}//catch
			
		}//while
		
		return cardCount;
		
	}//deal
	
	/**
	 * This is a method that prompts the user to input yes or no to indicate whether they want to try to re-enter in a file or not.
	 * @return boolean value indicating whether the user wants to enter another file name or continue to menu.
	 */
	public static boolean tryAgain() 
	{
		String answer = "???";
		boolean truth = false;
		System.out.println("Would you like to try entering in a different file again (Type: Yes [to enter a file] or No [to continue]): ");
		answer = keyboard.next();
		
		while ( !(answer.equalsIgnoreCase("Yes")) && !(answer.equalsIgnoreCase("No")) ) 
		{
			System.out.println("Invalid Input, Yes or No Only!");
			System.out.println("Would you like to try entering in a different file again (Type: Yes [to enter a file] or No [to continue]): ");
			answer = keyboard.next();
		}//while
		
		if (answer.equalsIgnoreCase("Yes")) 
		{
			truth = true;
		}//if
		
		return truth;
		
	}//tryAgain
	
	/**
	 * This is a method that gets a card from each player.
	 * @param stack1 (incoming player1 play stack)
	 * @param stack2 (incoming player2 play stack)
	 * @param discardStack1 (incoming player1 discard stack)
	 * @param discardStack2 (incoming player2 discard stack)
	 * @return a boolean indicating the value if the play was successful.
	 */
	public static boolean play(StackBadia stack1, StackBadia stack2, StackBadia discardStack1, StackBadia discardStack2) 
	{
		boolean success = false;
		CardBadia cardInPlay1 = null, cardInPlay2 = null;
		
		if ( stack1.isEmpty() ) 
		{
			copy(stack1, discardStack1);
		}//if
		if ( stack2.isEmpty() ) 
		{
			copy(stack2, discardStack2);
		}//if 
		if ( !stack1.isEmpty() && !stack2.isEmpty() ) //check to see if either deck is still empty
		{
			//Draw a card from each deck
			cardInPlay1 = stack1.pop();
			cardInPlay2 = stack2.pop();
			
			//Compare Cards
			if ( compare(cardInPlay1, cardInPlay2) == 1)
			{
				winPlay(discardStack1, cardInPlay1, cardInPlay2); //move cards to player one's discard deck
			} 
			else if ( compare(cardInPlay1, cardInPlay2) == 2) 
			{
				winPlay(discardStack2, cardInPlay2, cardInPlay1); //move cards to player two's discard stack
			}//if
			else
			{
				winPlay(discardStack1, cardInPlay1);
				winPlay(discardStack2, cardInPlay2);
			}//else
			success = true;
			
		}//if
		
		return success;
		
	}//play
	
	/**
	 * This is a method that compares each players cards.
	 * @param card1 (incoming player1 card)
	 * @param card2 (incoming player2 card)
	 * @return returns an integer indicating which player won.
	 */
	public static int compare (CardBadia card1, CardBadia card2) 
	{
		int playerWhoWon = 0;
		if ( card1.getValue() > card2.getValue() ) 
		{
			playerWhoWon = 1;
		}//if
		else if ( card2.getValue() > card1.getValue() ) 
		{
			playerWhoWon = 2;
		}//if
		else 
		{
			if ( card1.getSuit() > card2.getSuit() ) 
			{
				playerWhoWon = 1;
			}//if
			else if (card2.getSuit() > card1.getSuit() ) 
			{
				playerWhoWon = 2;
			}//if
			
		}//else
		
		return playerWhoWon;
		
	}//compare
	
	/**
	 *This is a method puts the cards in to the winner's discard stack 
	 * @param discard (incoming discard stack)
	 * @param cardHigh (incoming greater value card)
	 * @param cardLow (incoming lower value card)
	 */
	public static void winPlay (StackBadia discard, CardBadia cardHigh, CardBadia cardLow) 
	{
		discard.push(cardHigh);
		discard.push(cardLow);
	}//winPlay
	
	/**
	 *This is a method that puts a card back in a player's own discard stack in case of a tie.
	 * @param discard (incoming discard stack)
	 * @param card (incoming greater value card)
	 */
	public static void winPlay (StackBadia discard, CardBadia card)
	{
		discard.push(card);
	}//winPlay
	
	/**
	 * This is a method that copies a player's discard stack into her play stack.
	 * @param playerStack (incoming player play stack)
	 * @param discardStack (incoming player discard stack)
	 */
	public static void copy(StackBadia playerStack, StackBadia discardStack) 
	{
		StackBadia tempStack = new StackBadia ();
		
		while ( !discardStack.isEmpty() || !tempStack.isEmpty() ) {
			tempStack.push( discardStack.pop() );
			playerStack.push( tempStack.pop() );
		}//while
		
	}//copy
	
	/**
	 * This is a method that counts the number of cards in a single stack
	 * @param stack (incoming play or discard stack)
	 * @return number of cards in the stack
	 */
	public static int countCard(StackBadia stack) {
		int total = 0;
		StackBadia temp = new StackBadia ();
		while ( !stack.isEmpty() ) //move cards to temporary stack
		{
			total++;
			temp.push(stack.pop());
		}//while
		
		while ( !temp.isEmpty() ) //move cards back to original stack
		{
			stack.push(temp.pop());
		}//while
		
		return total;
		
	}//countCard
	
	/**
	 * This is a method that prints the battle card game summary
	 * @param cardCount (incoming total number of cards)
	 * @param numPlays (incoming total number of turns)
	 * @param aWinner (incoming boolean indicating if there was a clear winner or not)
	 * @param player1Cards (total number of cards player1 has)
	 * @param player2Cards (total number of cards player2 has)
	 * @param finalResult (Battle Card Game Summary)
	 */
	public static void printResults (int cardCount, int numPlays, boolean aWinner, int player1Cards, int player2Cards, String finalResult) 
	{
		String ans = "Battle Card Game Summary\n";
		ans += "========================\n";
		ans += "The game started with " + cardCount + " card(s).\n"; 
		ans += "There were " + numPlays + " plays in the game.\n";
		if (cardCount != 0)
		{ 
			ans += (aWinner)? "The game ended with a clear winner.\n" : "The game took too long.\n";
		} else ans += "There were no cards to play the game.\n";
		ans += "Player 1 ended up with " + player1Cards + " card(s).\n";
		ans += "Player 2 ended up with " + player2Cards + " card(s).\n";
		ans += "The winner was " + finalResult + ".";
		System.out.println(ans);
	}//printResults
	
}//Battle Demo
