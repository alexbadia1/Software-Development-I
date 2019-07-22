/**
*@author Alex Badia <br>
*Prog 6 RESUBMISSION<br>
*Due Date and Time: 05/0/19 before 1:30 PM <br>
*
*Changes/Fixes: drawSteps(), drawDoubleSteps(), and calcArea no longer take in <br>
*               parameters from main but call the instance variables directly from main. <br>
*			    Condensed the repetitive while-loops for the menu into a single do-while loop. <br>
*
*Purpose: to refine our knowledge about classes and methods. <br>
*
*Input: menu choice, width,number of steps, fill style. <br>
*
*Output: drawing of steps, drawing of steps doubled, text description of steps including width, area, fill style, and number of steps. <br>
*
*Certification of Authenticity: <br>
*   I certify that this lab is entirely my own work. <br>
*/

import java.util.*;

public class UpdatedStepsDemoBadia 
{
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main (String args []) 
	{
		//Declare variables
		String input = "???", fakeUserWidth = "???", fakeUserNumSteps = "???", fakeUserFillStyle = "???";
		boolean invalid = false;
		char choice = '?', userFillStyle = '*', temp = '?';
		int userWidth = 2, userStepNum = 5, stairArea = 0, letterPresent = 0;
		
		//Create an instance
		StepsBadia userStair = new StepsBadia(); 
		
		//Greet user and present user to prompt for input.
		System.out.println("Welcome to this program!");
		
		choice = input.charAt(0);
		choice = Character.toUpperCase(choice);
		
		while (choice != 'Q') 
		{
			
			switch (choice) 
			{
			
				case 'W':
					
					do 
					{
						System.out.println("Please enter the desired width: ");
						fakeUserWidth = keyboard.next();
					
						for (int i = 0; i < fakeUserWidth.length(); i++) {
							temp = fakeUserWidth.charAt(i);
							if (Character.isLetter(temp)) {
								letterPresent++;
							}//if
						}//for-loop validates for letter input
					
						if (letterPresent > 0)
							userWidth = -1; 
						else userWidth = Integer.parseInt(fakeUserWidth);  //cast the string to an integer
					
						letterPresent = 0;
					
					} while (userWidth <= 0); //validates numerical input	
					
					userStair.setStepWidth(userWidth);
					
					choice = '?';
					break;
					
				case 'N':
					
					do 
					{
						System.out.println("Please enter the desired number of steps: ");
						fakeUserNumSteps = keyboard.next();
						
						for (int i = 0; i < fakeUserNumSteps.length(); i++) {
							temp = fakeUserNumSteps.charAt(i);
							if (Character.isLetter(temp)) {
								letterPresent++;
							}//if
						}//for-loop validates for letter input
						
						if (letterPresent > 0)
							userStepNum = -1; 
						else userStepNum = Integer.parseInt(fakeUserNumSteps);  //cast the string to an integer
						
						letterPresent = 0;
						
					} while (userStepNum <= 0); //validates numerical input	
						
					userStair.setNumSteps(userStepNum);
					
					choice = '?';
					break;
					
				case 'F':
					
					System.out.println("Please enter the desired fill style: ");
					fakeUserFillStyle = keyboard.next();
		
					while (fakeUserFillStyle.length() > 1) 
					{
						System.out.println("Invalid Input, Please only enter in ONE character!");
						fakeUserFillStyle = keyboard.next();
					}//while-loop, validates for single character input
					
					userFillStyle = fakeUserFillStyle.charAt(0);
					userStair.setFillStyle(userFillStyle);
					
					choice = '?';
					break;
					
				case 'A':
					stairArea = userStair.calcArea();
					System.out.println("The area of the steps is: " + stairArea + ".\n");
					choice = '?';
					break;
					
				case 'T': 
					System.out.println(userStair);
					choice = '?';
					break;
					
				case 'D':
					userStair.drawSteps();
					choice = '?';
					break;
					
				case 'X':
					userStair.drawDoubleSteps();
					choice = '?';
					break;
					
				default:
					
					//FIX: CONDENSED REPEATED WHILE-LOOP CODE FOR MENU INTO ONE DO-WHILE LOOP
					
					do
					{
						if(invalid) 
						{
							System.out.println("Invalid input, please enter a menu character choice only!");
						}//if
						System.out.println("Menu:");
						System.out.println("W : Assign the Step Width");
						System.out.println("N : Assign the Number of Steps");
						System.out.println("F : Asign the Fill Style");
						System.out.println("A : Calculate the Area");
						System.out.println("T : Text Description of the Steps");
						System.out.println("D : Draw the Steps");
						System.out.println("X : Draw Thick Steps");
						System.out.println("Q : Quit");
						System.out.println("Please choose a choice: ");
						input = keyboard.next();
					
						choice = input.charAt(0);
						choice = Character.toUpperCase(choice);
						
						if ( ( (choice != 'W') && (choice != 'N') && (choice != 'F') && (choice != 'A') && (choice != 'T') && (choice != 'D') && (choice != 'D') && (choice != 'X') && (choice != 'Q') ) || (input.length() != 1) ) 
							invalid = true;
						else invalid = false;
					} while (invalid);//while
					break;
					
					
			}//switch
			
		}//while-loop, loops menu and validates single character input
		
		System.out.println("Program Terminated.");
		
	}//main
	
}//class
