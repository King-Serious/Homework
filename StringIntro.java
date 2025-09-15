import java.util.Scanner;

/**
 * Using the methods introuced in the String Methods Tutorial, this class will
 * use a given string (which in this case is my name) and print the second and last characters of the string,
 * Locate the first e in the string, identify how many characters are in the string, and print the first and last three characters
 * in the string
 */
public class ScannerTutorial {

	/*
	 * This main method prints out the final results of the other methods and identifies the string that the other methods will reference,
	 * which is addressed as myName. The string is adaptable to work with any name
	 */
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		String myName = new String("JesseJusto");
		
		printSecondAndLastLetter(myName);
		
		System.out.println("The first e in " + myName + " is in character " + findTheE(myName));
		
		System.out.println(myName + " has " + getLength(myName) + " characters ");
		
		printFirstAndLastThree(myName);
		
		myScanner.close();
		
	}
	/*
	 * This method identifies and prints the second and last letter of myName
	 * To do this, the method first identifies the amount of characters in the myName string
	 * Then, the method idenfies the second character (which is at the second index)
	 * Afterwards, the method identifies the last letter by subtracting the amount of characters in the myName string by one
	 * and then printing the letter at that index
	 */
	public static void printSecondAndLastLetter(String str) {
		int lengthOfString = str.length();
		char firstLetter = str.charAt(1);
		char lastLetter = str.charAt(lengthOfString -1);
		System.out.println(firstLetter + " And " + lastLetter);
		
	}
	/*
	 * This method identifies the first index when e shows up in myName
	 */
	public static int findTheE(String str) {
		int eLocation = str.indexOf('e');
		return(eLocation);
	}
	/*
	 * This method identifies and returns the amount of characters in the myName string
	 */
	public static int getLength (String str) {
		
	int lengthOfString = str.length();
	return( lengthOfString );
	
	}
	/*
	 * This method will print the first character of myName as well as the last three characters
	 * To do this, the method identifies the first character (which would be at 0)
	 * The method then identifies the last three characters by first identifying how many characters myName has
	 * and then subtracting that amount by three and using the substring code to set it as the minimum range
	 * and setting the original length as the maximum range so it'll only print the characters within that range
	 */
	public static void printFirstAndLastThree(String str) {
		char myLetter = str.charAt(0);
		int lengthOfString = str.length();
		String lastThree = new String (str.substring (lengthOfString -3, lengthOfString));
		System.out.println("The first character in " + str + " is " + myLetter + " and the last three characters are " + lastThree);
		
		
	}
}
