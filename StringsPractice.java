import java.util.Scanner;

/**
 * This class is programmed to allow the user to enter any word and for the code to return that word plus a number.
 * That number adds up each time a new word is entered until the user types "stop". Once the user types "stop",
 * The code will then prompt the user to enter a double value to be the starting radius of a circle.
 * Afterwards, the code will prompt the user 5 times to enter a double value, which will be added to
 * the radius. After 5 numbers are added, the code prints out the original value and the final value
 * of the radius.
 */

public class StringsProject 
{

	static Scanner inputReader = new Scanner(System.in);

	// The main method accomplishes the first task of the assignment, which is to prompt the user
	// to input text into the console and then print out the input plus the number that the loop has ran.
	// To do this, I created two variables that contain the value of the user's input and how many times
	// the while loop has ran. The while loop activates as long as the user enters anything but "stop".
	// The loop will then print that input plus the amount of times the loop has ran and then add 1 to
	// the loop count and prompt the user to enter a new word, which will then be assigned to userInput.
	// After the user enters stop, the method getRadius runs. After that method is complete, the scanner
	// is then closed.
	
	public static void main(String[] args) 
	{
		String userInput = inputReader.nextLine();
		int numLoop = 0;
		while (! userInput.equals("stop"))
		{
			System.out.println(userInput + " " + numLoop);
			numLoop++;
			userInput = inputReader.nextLine();
		}
		getRadius();
		inputReader.close();
	}
	
	// The getRadius method completes the second task of the assignment and prompts
	// the user to enter a double value for a circle's radius. Then, the code
	// runs a for loop that has the user enter 5 double values that will be added
	// to the radius. After the loop runs 5 times, the code prints out the original value
	// of the radius and the new value that contains the sum of all the double values together.
	
	public static void getRadius()
	{
		System.out.println("Set the radius for your circle!");
		double originalCirc = inputReader.nextDouble();
		Circle radicalCirc = new Circle (originalCirc);
		double totalDoubleNics = radicalCirc.getRadius();
		for (int i = 0; i <5; i++)
		{
			System.out.println("Input a (double) Number");
			double doubleNics = inputReader.nextDouble();
			totalDoubleNics = totalDoubleNics + doubleNics;
		}
		System.out.println("Your circle originally had a radius of " + radicalCirc.getRadius() + " but now has a radius of " + totalDoubleNics + "!");
		
	}
	
	
}
