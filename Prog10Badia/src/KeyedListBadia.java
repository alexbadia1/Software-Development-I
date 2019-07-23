/**
 * 
 * @author Alex Badia <br>
 * 
 * This is a class definition for a keyed (linked) list of items that has keyed (linked) list and size. 
 * Methods include being able to find items, retrieve items, add items, delete items, track total total 
 * quantity, total price, if the list is full or empty, and print the entire list with item descriptions. <br>
 * 
 */
public class KeyedListBadia {
	/**
	 * Instance variable for shopping cart list
	 */
	private NodeBadia myHead;
	
	/**
	 * The null constructor for keyedListBadia
	 */
	public KeyedListBadia() {
		myHead = null;
	}//Null constructor
	
	/**
	 * This method clears the whole list
	 */
	public void clear () {
		myHead = null;
	}//clear
	
	/**
	 * This is a method that adds the item into the list
	 * @param product (incoming object "item")
	 * @return boolean success, whether the item was successfully added or not
	 */
	public boolean addItem(ItemBadia product) {
		boolean success = false, spotFound = false;
		NodeBadia previous= null, current = myHead;
		String itemName = "???";
		ItemBadia currentItem = null;
		if (retrieve(product.getName()) == null) {
			NodeBadia newItemNode = new NodeBadia();
			newItemNode.setData(product);
			while ( (current != null) && (spotFound != true) ) {
				currentItem = current.getData();
				itemName = currentItem.getName();
				if (itemName.compareToIgnoreCase(product.getName()) > 0) {
					spotFound = true;
				}//if
				else {
					previous = current;
					current = current.getNext();
				}//else
			}//while
			
			if (previous == null)	{
				newItemNode.setNext(current);
				myHead = newItemNode;
			} else {
				newItemNode.setNext(current);
				previous.setNext(newItemNode);
			}//if-else
			success = true;
		}//if
		return success;
	}//addItem
	
	/**
	 * This is a method that removes a specified item from the list
	 * @param keyValue (incoming name of object "item")
	 * @return boolean success, whether the item was successfully deleted or not
	 */
	public boolean remove (String keyValue) {
		boolean success = false, found = false;
		ItemBadia item = null;
		NodeBadia previous = null, current = myHead, following = null;
		String target = keyValue; //The method retrieve() has a parameter "keyValue" already.
		if(retrieve(target) != null) {
			while ( (current != null) && (found != true) ) {
				item = current.getData();
				if (target.equalsIgnoreCase(item.getName())) {
					found = true;
				} else {
					previous = current;
					current = current.getNext();
				}//if-else
			}//while
			following = current.getNext();
			if (previous == null) {
				myHead = following;
			} else previous.setNext(following);
			success = true;
		}//if
		return success;
	}//remove
	
	/**
	 * This is a method that returns the specified item from the list
	 * @param keyValue (incoming name of object "item")
	 * @return specified item if it is in the cart
	 */
	public ItemBadia retrieve (String keyValue) {
		NodeBadia current = myHead;
		boolean found = false;
		ItemBadia item = null, itemToRetrieve = null;
		while ((current != null) && (found != true)) {
			item = current.getData();
			if (keyValue.equalsIgnoreCase(item.getName())) {
				found = true;
				itemToRetrieve = item;
			} else current = current.getNext();
		}//while
		return itemToRetrieve;
	}//retrieve
	
	/**
	 * This is a method that tells if the list is empty or not empty
	 * @return boolean value, if the list is empty or not empty
	 */
	public boolean isEmpty()
	{ return (myHead == null);}
	
	/**
	 * This is a method that tells if the list is full or not full
	 * @return boolean value, if the list is full or not full
	 */
	public boolean isFull() {
		return false;
	}//isFull
	
	/**
	 * This is a method that prints details about all the objects in the list
	 */
	public void print() {
		NodeBadia current = myHead;
		ItemBadia item = null;
		System.out.println("\nHere is a summary of your entire shopping cart: \n");
		while (current != null) {
			item = current.getData();
			System.out.println(item.toString());
			current = current.getNext();
		}//while
	}//print
	
	/**
	 * This is a method that gets the total quantity of the items (not objects) in the cart
	 * @return total quantity of the items in the cart
	 */
	public int getCount() {
		int totalQuant = 0;
		NodeBadia current = myHead;
		ItemBadia item = null;
		while (current != null) {
			item = current.getData();
			totalQuant += item.getQuant();
			current = current.getNext();
		}//while
		return totalQuant;
	}//getCount
	
	/**
	 * The method finds the total price of all the items in the last
	 * @return the total price of all the items in the shopping cart
	 */
	public double calcTotalPrice() {
		double totalPrice = 0.0;
		NodeBadia current = myHead;
		ItemBadia item = null;
		while (current != null ) {
			item = current.getData();
			totalPrice += item.getPrice();
			current = current.getNext();
		}//while
		return totalPrice;
	}//calcTotal
	
	
}//class