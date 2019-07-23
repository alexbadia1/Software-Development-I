/**
 * 
 * @author Alex Badia <br>
 * 
 * This is a class definition for a keyed list of items that has keyed list and size. 
 * Methods include being able to find items, retrieve items, add items, delete items, track total total 
 * quantity, total price, if the list is full or empty, and print the entire list with item descriptions. <br>
 * 
 */
public class KeyedListBadia {
	/**
	 * Instance variable for shopping cart list
	 */
	private ItemBadia [] myCart;
	
	/**
	 * Instance variable for the size of the cart
	 */
	private int mySize;
	
	/**
	 * The null constructor for the class
	 */
	public KeyedListBadia() {
		myCart = new ItemBadia [20];
		for (int i = 0; i < myCart.length; i++) {
			myCart[i] = null;
		}//for-loop, fills list of items with null
		mySize = 0;
	}//Null constructor
	
	/**
	 * This the getter for mySize
	 * @return the current size of the list
	 */
	public int getSize() {
		return mySize;
	}//getSIze
	
	/**
	 * This method clears the whole list
	 */
	public void clear () {
		mySize = 0;
	}//clear
	
	/**
	 * This is a method that finds the index of the specified item
	 * @param keyValue (incoming name of object "item")
	 * @return index location of the key value in cart 
	 */
	private int findIndex (String keyValue) {
		int location = 0;
		String name = "???";
		boolean found = false;
		
		if (mySize > 0) {
			while ( (location < mySize) && (found != true) ) {
				name = myCart[location].getName();
				if (name.equalsIgnoreCase(keyValue))
					found = true;
				else location++;
			}//while, finds index of keyValue
			if (found == false) {
				location = -1;
			}
		}//if		
				
		return location;			
	}//findIndex
	
	/**
	 * This is a method that adds the item into the list
	 * @param product (incoming object "item")
	 * @return boolean success, whether the item was successfully added or not
	 */
	public boolean addItem(ItemBadia product) {
		boolean success = false, spotFound = false;
		int whereToPut = 0;
		if (mySize < myCart.length) {
			if(retrieve(product.getName()) != null) {
				System.out.println(product.getName() + " is already in the cart!");
			}//if
			else  {
				while (whereToPut < mySize && spotFound != true) {
					if (myCart[whereToPut].getName().compareToIgnoreCase(product.getName()) > 0)
						spotFound = true;
					else whereToPut++;
				}//while
			
				for (int i = mySize - 1; i >= whereToPut ; i--) {
					myCart[i+1] = myCart[i];
				}//for
				myCart[whereToPut] = product;
				mySize++;
				success = true;
			}//else
		}//if
		return success;
	}//addItem
	
	/**
	 * This is a method that removes a specified item from the list
	 * @param keyValue (incoming name of object "item")
	 * @return boolean success, whether the item was successfully deleted or not
	 */
	public boolean remove (String keyValue) {
		boolean success = false;
		int indexToDelete = Integer.MIN_VALUE;
		if(mySize > 0) {
			indexToDelete = findIndex(keyValue);
			if (indexToDelete != -1) {
				System.out.println("\nDeleting the item: " + keyValue + "...");
				for (int i = indexToDelete; i < mySize - 1; i++) {
					myCart[i] = myCart[i + 1];
				}//for
				success = true;
				mySize--;
			}//if
		}//if
		return success;
	}//remove
	
	/**
	 * This is a method that returns the specified item from the list
	 * @param keyValue (incoming name of object "item")
	 * @return specified item if it is in the cart
	 */
	public ItemBadia retrieve (String keyValue) {
		int itemLocation = -1;
		ItemBadia item = null;
		if(mySize > 0) {
			itemLocation = findIndex(keyValue);
			if (itemLocation != -1) {
				item = myCart[itemLocation];
			}//if
		}//if
		return item;
	}//retrieve
	
	/**
	 * This is a method that tells if the list is empty or not empty
	 * @return boolean value, if the list is empty or not empty
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if (mySize == 0) {
			empty = true;
		}//if
		return empty;
	}//isEmpty
	
	/**
	 * This is a method that tells if the list is full or not full
	 * @return boolean value, if the list is full or not full
	 */
	public boolean isFull() {
		boolean full = false;
		if (mySize == myCart.length) {
				full = true;
			}//if
		return full;
	}//isFull
	
	/**
	 * This is a method that prints details about all the objects in the list
	 */
	public void print() {
			for (int i = 0; i < mySize; i++) {
				System.out.println(myCart[i].toString());
			}//for
	}//print
	
	/**
	 * This is a method that gets the total quantity of the items (not objects) in the cart
	 * @return total quantity of the items in the cart
	 */
	public int getCount() {
		int totalQuant = 0;
		if(mySize > 0) {
			for (int i = 0; i < mySize; i++) {
				totalQuant += myCart[i].getQuant();
			}//for
		}//if
		return totalQuant;
	}//getCount
	
	/**
	 * The method finds the total price of all the items in the last
	 * @return the total price of all the items in the shopping cart
	 */
	public double calcTotalPrice() {
		double totalPrice = 0.0;
		if (mySize > 0) {
			for (int i = 0; i < mySize; i++) {
				totalPrice += myCart[i].getPrice() * myCart[i].getQuant();
			}//for
		}//if
		return totalPrice;
	}//calcTotal
	
	
}//class