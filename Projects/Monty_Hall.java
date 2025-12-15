import java.util.Scanner;

/**
 * This class demonstrates the Monty Hall Problem. Three doors are presented to the User and they
 * are then prompted to type a number correlating to the door of their choice. Once they make their
 * choice, one of the non-chosen doors will open to reveal absolutely nothing. The User is then offered
 * the option to switch their door with the other closed door in hopes to get the secret prize.
 * At the end, the door with the prize is revealed and the User will either be rewarded or shamed
 * depending on if they won or not.
 */

public class Monty_Hall 
{
	
static Scanner inputReader = new Scanner(System.in);

String playerDecides = inputReader.nextLine();	

	/**
	 * This main method simply starts the game and activates the gameStart method.
	 */

	public static void main(String[] ags) 
	{
	
	gameStart();
	
	}
	
	/**
	 * The gameStart method creates the opening prompt for the User and runs a Math.random()
	 * generator to identify the door that contains the winning prize. Afterwards, the code
	 * is run through the chooseDoor method.
	 */
	
	public static void gameStart()
	{
		System.out.println("You stand across 3 doors. One door has a secret prize behind it while the others are completely empty.");
		System.out.println("You will pick one of these doors. A door with nothing on it will be revealed.");
		System.out.println("You will then be prompted to either stick to your door or switch with the other remaining door.");
		System.out.println("After making your final decision, the doors will be opened to reveal what was inside of them.");
		System.out.println("You only get one shot at this, so don't mess up!");
		System.out.println("Pick a door!");
		System.out.println("Door 1 Door 2 Door 3");
		int winDoor = (int) (Math.random() * 3 + 1);
		chooseDoor(winDoor);
	}
	
	/**
	 * The chooseDoor method translates the User's input into one of the three doors.
	 * Using if statements and .equals, the code converts the User's String into an int.
	 * If the User enters something that isn't within the range, the User will be warned
	 * and prompted to enter a new value. Once a eligible number is picked, the
	 * switchDoor method will run with the values of the chosenDoorNum and victoryDoor
	 * going through.
	 */
	
	public static void chooseDoor(int victoryDoor)
	{
		
		String playerDecides = inputReader.nextLine();
		
		int chosenDoorNum = 0;
		
		if (playerDecides.equals("3") || playerDecides.equals("Three") || playerDecides.equals("three"))
		{
			chosenDoorNum = 3;
		}
		if (playerDecides.equals("2") || playerDecides.equals("Two") || playerDecides.equals("two"))
		{
			chosenDoorNum = 2;
		}
		if (playerDecides.equals("1") || playerDecides.equals("One") || playerDecides.equals("one"))
		{
			chosenDoorNum = 1;
		}
		
		if (chosenDoorNum <= 0 || chosenDoorNum >= 4)
		
		{
			System.out.println("Bad Boy! You need to pick a number between 1 and 3! Try again!");
			chooseDoor(victoryDoor);
		}
		
		switchDoor(chosenDoorNum, victoryDoor);
	}
	
	/**
	 * The switchDoor method informs the User of an empty door and gives them the opportunity
	 * to switch their door to the other closed door. To do this, two values that contain
	 * the door that will be opened and the door that will be offered to switch are determined
	 * and then the code prints out what empty door has been opened and allows the User to
	 * switch doors with the other closed one. If the User chooses to switch, chosenDoor
	 * is assigned the value of the offered door and then the revealDoor method is ran.
	 * Otherwise, the revealDoor method is ran with the original value of the User's chosen door.
	 */
	
	public static void switchDoor(int chosenDoor, int winDoor)
	{
		int offerDoor = chosenDoor;
		int revealDoor = winDoor;
		while (revealDoor == winDoor || revealDoor == chosenDoor)
		{
			revealDoor = (int) (Math.random() * 3 + 1);
		}
		while (offerDoor == chosenDoor || offerDoor == revealDoor)
		{
			offerDoor = (int) (Math.random() * 3 + 1);
		}
		System.out.println("Door " + revealDoor + " has shown to have nothing behind it.");
		System.out.println("You are then offered the ability to switch to the other closed door. Do you take it?");
		String playerDecides = inputReader.nextLine();
		if (playerDecides.equals("Yes") || playerDecides.equals("yes"))
		{
			chosenDoor = offerDoor;
			revealDoor(chosenDoor, winDoor);
		}
		else if (playerDecides.equals("No") || playerDecides.equals("no"))
		{
			revealDoor(chosenDoor, winDoor);
		}
	}
	
	/**
	 * The revealDoor method provides the final reveal on whether or not the User picked the right door.
	 * If the User chose the correct door, they will be praised for their good decision making skills.
	 * Otherwise, the User will be shamed if they picked the wrong door.
	 * After that, the Scanner closes and the code is complete.
	 */
	
	public static void revealDoor(int chosenDoor, int winDoor)
	{
		System.out.println("You chose Door " + chosenDoor + " and the door that contains the secret prize was...");
		inputReader.nextLine();
		System.out.println("Door " + winDoor + "!");
		if (chosenDoor == winDoor)
		{
			System.out.println("Good Boy! You solved the Monty Hall Problem!");
		}
		else if (chosenDoor != winDoor)
		{
			System.out.println("Bad Boy! You didn't solve the Monty Hall Problem!");
		}
		inputReader.close();
	}
}
