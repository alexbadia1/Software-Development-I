/**
 * 
 * @author Alex Badia
 * 
 * This is a class for a card, that has a value and a suit. 
 *
 */
public class CardBadia {
	/**
	 *Instance variable for the value of the card
	 */
	private int myValue;
	
	/**
	 *Instance variable for the suit of the card
	 */
	private char mySuit;
	
	/**
	 *Null constructor for the card class 
	 */
	public CardBadia() {
		myValue = 0;
		mySuit = '?';
	}//full constructor
	
	/**
	 *The getter for the value of the card class
	 *@return myValue
	 */
	public int getValue() {
		return myValue;
	}//getValue
	
	/**
	 * The setter for the value of the card class
	 * @param newValue (incoming new value)
	 */
	public void setValue(int newValue) {
		myValue = newValue;
	}//setValue
	
	/**
	 * The getter for the suit of the card class
	 * @return mySuit
	 */
	public char getSuit() {
		return mySuit;
	}//getSuit

	/**
	 * The setter for the suit of the card class
	 * @param newSuit (incoming new suit)
	 */
	public void setSuit(char newSuit) {
		mySuit = newSuit;
	}//setSuit	
	
}//CardBadia
