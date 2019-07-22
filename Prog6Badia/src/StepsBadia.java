/**
 * 
 * @author Alex Badia <br>
 *
 *This is a class definition to draw steps. The getters and setters allow <br>
 *for the width, stair number, and fill style to be modified. The methods <br>
 *calculate the area, draws the steps, and draws "thick" steps. <br>
 *
 */
public class StepsBadia {
	/**
	 * Instance variable for the width of the Step.
	 */
	private int myStepWidth;
	
	/**
	 * Instance variable for the number of Steps.
	 */
	private int myNumSteps;
	
	/**
	 * Instance variable for the fill style of the steps
	 */
	private char myFillStyle;
	
	/**
	 * Null constructor creates an instance of the steps
	 */
	StepsBadia () 
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//emptyConstructor StepBadia
	
	/**
	 * Full constructor creates an instance of the steps
	 */
	StepsBadia (int newStepWidth, int newNumSteps, char newFillStyle) 
	{
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}//fullConstructor StepsBadia
	
	/**
	 * The getter for the step width.
	 * @return myStepWidth
	 */
	public int getStepWidth () 
	{
		return myStepWidth;
	}//getWidth
	
	/**
	 * The setter for the step width.
	 * @param newStepWidth (incoming step width)
	 */
	public void setStepWidth (int newStepWidth)
	{
		myStepWidth = newStepWidth;
	}//setSteptepWidth
	
	/**
	 * The getter for the number of steps.
	 * @return myNumSteps
	 */
	public int getNumSteps () 
	{
		return myNumSteps;
	}//getNumSteps
	
	/**
	 * The setter for the number of steps.
	 * @param newNumSteps (incoming number of steps)
	 */
	public void setNumSteps (int newNumSteps) 
	{
		myNumSteps = newNumSteps;
	}//setNumSteps
	
	/**
	 * The getter for the fill style of the steps.
	 * @return myFillStyle
	 */
	public char getFillStyle () 
	{
		return myFillStyle;
	}//getFillStyle
	
	/**
	 * The setter for the fill style of the steps.
	 * @param newFillStyle (incoming step fill style)
	 */
	public void setFillStyle (char newFillStyle)
	{
		myFillStyle = newFillStyle;
	}//setFillStyle
	
	/**
	 * This is a method that calculates the area of the steps.
	 * @return area
	 */
	public int calcArea ()  //FIX: METHOD NO LONGER TAKES PARAMTERS FROM MAIN, DIRECTLY ACCESSES IT'S OWN THE INSTANCE VARIABLES
	{
		int area = 0;
		int length = 0;
		
		for (int i = 0; i < myNumSteps; i++) {
			length = myStepWidth * (i) + myStepWidth;
			area += length;
		}//for-loop, calculates area
		
		return area;
		
	}//calcArea
	
	/**
	 * The method that draws the steps.
	 */
	public void drawSteps()  //FIX: METHOD NO LONGER TAKES PARAMTERS FROM MAIN, DIRECTLY ACCESSES IT'S OWN THE INSTANCE VARIABLES
	{
		int stepLength = 0;
		
		for (int currentStep = 0; currentStep < myNumSteps; currentStep++) {
			
			stepLength = myStepWidth * (currentStep) + myStepWidth;
			
			for (int currentStepLength = 0; currentStepLength < stepLength; currentStepLength++) {
				System.out.print(myFillStyle);
				
			}//for-loop, prints one line of a step
			
			System.out.println();
			
		}//for-loop, prints stairs
		
	}//drawSteps
	
	/**
	 * The method that draws "thick" steps.
	 */
	public void drawDoubleSteps () //FIX: METHOD NO LONGER TAKES PARAMTERS FROM MAIN, DIRECTLY ACCESSES IT'S OWN THE INSTANCE VARIABLES
	{
		int stepLength = 0;
		
		for (int currentStep = 0; currentStep < myNumSteps; currentStep++) {
			stepLength = myStepWidth * (currentStep) + myStepWidth;
			
			for (int repeatSameStep = 0; repeatSameStep < myStepWidth; repeatSameStep++) {
				
				for (int currentStepLength = 0; currentStepLength < stepLength; currentStepLength++) {
					System.out.print(myFillStyle);
					
				}//for-loop, prints one line of a step
				
				System.out.println();
				
			}//For-loop, creates thicker steps
			
		}//for-loop, prints stairs
		
	}//drawDoubleSteps
	
	/**
	 * The method that prints the width, number, fill style and area of the steps.
	 */
	public String toString() 
	{
		String ans = "???";
		
		ans = "Step width: " + myStepWidth + "\n";
		ans += "Number of steps: " + myNumSteps + "\n";
		ans += "Fill style: " + myFillStyle + "\n";
		ans += "Area: " + calcArea() + "\n";
		
		return ans;
		
	}//toString
	
}//StepsBadia
