import java.text.DecimalFormat;
/**
 * 
 * @author Alex Badia <br>
 *
 *This is a class definition for an Item
 */
public class ItemBadia {
	private DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	/**
	 * Instance variable for the item's name
	 */
	private String myName;
	
	/**
	 * Instance variable for the item's quantity
	 */
	private int myQuant;
	
	/**
	 * Instance variable for the item's price
	 */
	private double myPrice;
	
	/**
	 * The empty constructor of the class
	 */
	public ItemBadia () {
		myName = "???";
		myQuant = 0;
		myPrice = 0.00;
	}//Empty Constructor
	
	/**
	 * The full constructor of the class
	 * @param newName (incoming item name)
	 * @param newQuant (incoming quantity of items)
	 * @param newPrice (incoming item price)
	 */
	public ItemBadia (String newName, int newQuant, double newPrice) {
		myName = newName;
		myQuant = newQuant;
		myPrice= newPrice;
	}//Full Constructor
	
	/**
	 * The setter for the item's name
	 * @param newName (incoming item name)
	 */
	public void setName (String newName) {
		myName = newName;
	}//setName
	
	/**
	 * The setter for the quantity of items
	 * @param newQuant (incoming quantity of items)
	 */
	public void setQuant (int newQuant) {
		myQuant = newQuant;
	}//setQuant
	
	/**
	 * The setter for the item price
	 * @param newPrice (incoming item price)
	 */
	
	public void setPrice (double newPrice) {
		myPrice = newPrice;
	}//setPrice
	
	/**
	 * The getter for the name of the item
	 * @return The item name
	 */
	public String getName () {
		return myName;
	}//getName
	
	/**
	 * The getter for the quantity of the item
	 * @return the quantity of the item
	 */
	public int getQuant () {
		return myQuant;
	}//getQuant
	
	/**
	 * The getter for the price of the item
	 * @return the item's price
	 */
	public double getPrice() {
		return myPrice;
	}//getPrice
	
	/**
	 * Returns details about the item as a string
	 */
	public String toString() {
		String summary = "???";
		summary = "Name: " + myName + "\n";
		summary += "Quantity: " + myQuant + "\n";
		if (myPrice == 0)
			summary += "Price: FREE \n";
		else summary += "Price: " + moneyStyle.format(myPrice) + "\n";
		return summary;
	}//toString
	
}//ItemBadia
