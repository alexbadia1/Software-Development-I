/**
 * 
 * @author Alex Badia
 * This is a class definition for a node that holds data about an object from the ItemBadia class and a reference to te next item in a linked list.
 *
 */

public class NodeBadia {
	/**
	 * Instance variable for the node's data
	 */
	private ItemBadia myData;
	
	/**
	 * Instance variable for the node's next reference
	 */
	private NodeBadia myNext;
	
	/**
	 * The null constructor of the node class
	 */
	public NodeBadia() {
		myData = null;
		myNext = null;
	}//null constructor
	
	/**
	 * This is the getter for the node's data
	 * @return myData
	 */
	public ItemBadia getData() 
	{ return myData; }//getData
	
	/**
	 * This is the setter for the node's data
	 * @param newData (incoming item)
	 */
	public void setData(ItemBadia newData)
	{ myData = newData; }//setData
	
	/**
	 * This is the getter for the next node the current nod references
	 * @return next node that is referenced by this current node
	 */
	public NodeBadia getNext() 
	{ return myNext; }//getNext
	
	/**
	 * This is the setter for the next node that this current node will reference
	 * @param newNext (incoming new reference)
	 */
	public void setNext(NodeBadia newNext) 
	{ myNext = newNext; }//setNext
	
}//node
