/**
 * 
 * @author Alex Badia
 * 
 * This is a class that creates a stack with an array where cards can be added (pushed) or removed (popped) from the stack.
 * Other methods include isEmpty and isFull which indicate if the stack is empty or not and full or not full, respectively.
 *
 */
public class StackBadia {
	/**
	 * Instance variable for the list of the stack class
	 */
	private CardBadia [] myList;
	private int mySize;
	private static final int MAX_SIZE = 52;
	
	/**
	 * The null constructor for the stack class
	 */
	public StackBadia() {
		mySize = 0;
		myList = new CardBadia [MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			myList[i] = null;
		}//for
	}//null constructor
	
	/**
	 * This is a method that tells whether the list is empty or not empty
	 * @return boolean value 
	 */
	public boolean isEmpty() {
		return (mySize == 0);
	}//isEmpty
	
	/**
	 * This is a method that tells whether the list is full or not full
	 * @return boolean value: false
	 */
	public boolean isFull() {
		return (mySize == MAX_SIZE);
	}//isFull
	
	/**
	 * This is a method that adds a card to the top of the stack
	 * @param newCard (incoming new card)
	 * @return boolean value depending if the card was successfully added or not
	 */
	public boolean push(CardBadia newCard) {
		boolean success = false;
		if( !isFull() ) {
			myList[mySize] = newCard;
			mySize++;
		}//if
		return success;
	}//push
	
	/**
	 * This is a method that removes a card from the top of the stack
	 * @return card removed from the stack, null if the stack is empty
	 */
	public CardBadia pop() {
		CardBadia poppedCard = null;
		if (!isEmpty() ) {
			mySize--;
			poppedCard = myList[mySize];
		}//if
		return poppedCard;
	}//pop
	
}//Stack
