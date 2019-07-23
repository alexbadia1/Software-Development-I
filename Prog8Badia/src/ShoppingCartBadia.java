/**
 * 
 * @author Alex Badia <br>
 *
 *This is a class definition for the shopping cart that has a list of items and size. Methods include finding the most or least expensive item, calculating the most or least expensive item and adding or removing items from the cart.
 *
 */
public class ShoppingCartBadia {
	/**
	 * Instance variable for the shopping cart size
	 */
	private ItemBadia [] myItems;
	
	/**
	 * Instance variable for the current size of the shopping cart
	 */
	private int mySize;
	
	/**
	 * The empty constructor for the class
	 */
	public ShoppingCartBadia () {
		myItems = new ItemBadia [10];
		
		for(int i = 0; i < myItems.length; i++) {
			myItems[i] = null;
		}//for-loop
		
		mySize = 0;
	}//Empty Constructor
	
	/**
	 * The getter for the size of the cart
	 * @return the size of the cart
	 */
	public int getSize() {
		return mySize;
	}//getSize
	
	/**
	 * The method adds an item to the cart
	 * @param shoppingItem (incoming object "Item")
	 * @return a boolean value indicating if the item was successfully added
	 */
	public boolean addToCart (ItemBadia shoppingItem) {
		boolean success = false;
		if (mySize < myItems.length) {
			myItems[mySize] = shoppingItem;
			success = true;
			mySize++;
		}//if
		return success;
	}//addToCart
	
	/**
	 * The method finds the most expensive item in the cart
	 * @return the most expensive item in the shopping cart
	 */
	public ItemBadia findMostExpensive () {
		double maxPrice = Integer.MIN_VALUE;
		ItemBadia maxPricedItem = null;
		if (mySize > 0) {
			for (int i = 0; i < mySize; i++) {
				if (myItems[i].getPrice() > maxPrice) {
					maxPrice = myItems[i].getPrice();
					maxPricedItem = myItems[i];
				}//if
			}//findMostExpensive
		}//if
		return maxPricedItem;
	}//findMostExpensive
	
	/**
	 * The method finds the least expensive item in the cart
	 * @return the least expensive item in the shopping cart
	 */
	public ItemBadia findLeastExpensive () {
		double minPrice = Integer.MAX_VALUE;
		ItemBadia minPricedItem = null;
		if (mySize > 0) {
			for (int i = 0; i < mySize; i++) {
				if (myItems[i].getPrice() < minPrice) {
					minPrice = myItems[i].getPrice();
					minPricedItem = myItems[i];
				}//if
			}//findMostExpensive
		}//if
		return minPricedItem;
	}//findMostExpensive
	
	/**
	 * The method finds the total price of all the items in the last
	 * @return the total price of all the items in the shopping cart
	 */
	public double calcTotalPrice() {
		double grandTotal = 0.0;
		for (int i = 0; i < mySize; i++) {
			grandTotal += myItems[i].getPrice() * myItems[i].getQuant();
		}//for
		return grandTotal;
	}//calcTotal
	
	/**
	 * The method prints out all the items in the shopping cart
	 */
	public void printList () {
		System.out.println("Here is a summary of your entire shopping cart: \n");
		if (mySize == 0) {
			System.out.println("Your shopping cart is empty.\n");	
		}
		else {
			for (int i = 0; i < mySize; i++) {
			System.out.println(myItems[i].toString());
			}//for
		}//else
	}//printList
	
	/**
	 * The method deletes items from the list
	 * @return boolean value indicating if the item was removed from the list
	 */
	public boolean deleteItem () {
		boolean success = false;
		ItemBadia maxItem = findMostExpensive();
		if (maxItem == null) {
			System.out.println("The item does not exist in the cart to delete.\n");
		} 
		else {
			String itemToDelete = maxItem.getName();
			for (int i = 0; i < mySize; i++) {
				if (myItems[i].getName().equals(itemToDelete)) {
					//kind of like swapping the places of the last value of the list with the highest value in the list
					myItems[i] = myItems[mySize - 1];
					myItems[mySize - 1] = null;
					mySize--;
					success = true;
				}//if
			}//for
		}//else
		return success;
	}//deleteItem
	
}//ShoppingCartBadia
