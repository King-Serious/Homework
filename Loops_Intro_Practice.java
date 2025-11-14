
/**
 * This class is able to identify how many times a certain letter shows up in a given word,
 * Return the factorial of a given int, and print true if a string has two of the same letter
 * next to each other and false if it does not.
 */

public class LoopsIntroPractice {

	//The main method runs the codes of countLetters, getFactorial, and getIfRepeats
	//And prints out the results that are returned.
	
	public static void main(String[] args) 
	{
		System.out.println(countLetters("Antidisestablishmentarianism" , 'e'));
		System.out.println(getFactorial(6));
		System.out.println(getIfRepeats("Dawg"));
	}
	
	// This method identifies how many times a certain letter is in a given word.
	// To do this, a variable that contains how many times the letter is mentioned is declared.
	// Then, a for loop runs that analyzes all the characters in the given string and compares it
	// To the letter. If the character in the string matches with the letter that's being searched for,
	// Then the variable value is increased by one. This continues until all characters all analyzed, which
	// is when the variable's value is returned to the main method.
	
	public static int countLetters (String word, char letter)
	{
		int hahathisisthelettercount = 0;
		for (int i = 1; i <= word.length() - 1; i++)
		{
			if (word.charAt(i) == letter)
			{
				hahathisisthelettercount ++;
			}
		}
		return hahathisisthelettercount;
	}
	
	// This method obtains the factorial of a given int.
	// To do this, a variable totalFactor is assigned to the value of numberToFactor, the given int.
	// Then, a for loop runs that multiplies the variable totalFactor by numberToFactor minus one,
	// Which is pretty much the original number times the following number. After the first loop,
	// The total of the previous two numbers multiplied is then multiplied by one less of the previous
	// numberToFactor and so forth until it reaches one, which is stopped since continuing on would
	// multiply the number by zero, which just results to zero no matter what.
	
	public static int getFactorial(int numberToFactor)
	{
		int totalFactor = numberToFactor;
		for (int i = numberToFactor -1; i > 1; i--)
		{
			totalFactor = totalFactor * (i);
		}
		return totalFactor;
	}
	
	// This method returns the value of true or false depending if the given String has two
	// of the same letter next to each other.
	// To do this a for loop runs that compares each letter of the string to its previous letter.
	// Then, if the letter is equivalent to the previous character, the method will return the value of true.
	// Otherwise, if none of the letters in the string don't match this condition, the method will just return false.
	
	public static boolean getIfRepeats(String str)
	{
		for (int i = 1; i <= str.length() - 1; i++)
		{
			if (str.charAt(i) == str.charAt(i -1))
			{
				return true;
			}
		}
		return false;
	}
	

}
