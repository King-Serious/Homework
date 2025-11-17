
import java.util.Scanner;

/**
 * This class mimics the simple functions of a WORDLE game. A random word from a given list will be selected for
 * the user to guess. The user will then have seven attempts to guess the correct word, with the code printing out either
 * the letter, an X, or a ? depending on the letter and position. The game will continue until the user either runs out
 * of attempts or the user guesses the word within the seven attempts. Afterwards, the user will be offered the opportunity
 * to play again, which restarts the game with a brand new word and seven new attempts.
 */

public class Wordle {
	
	static Scanner inputReader = new Scanner(System.in);

	// The main method declares variables that will be used in other methods.
	// This includes the option to play again, the word that the user entered,
	// the randomly selected word that the user needs to guess, the final result, and
	// the results of each attempt. This main method also enforces the rules of no double characters
	// and having the user type a five letter word, having a strike system that allows the user to make
	// two errors per attempt before automatically terminating the current run.
	// This method also contains the code for the game to inform the user of how many attempts they have left
	// as well as the prompts for whether they ran out of attempts or correctly guessed the word and
	// if the user wants to play again.
	
	public static void main(String[] args) 
	{
		boolean playAgain = true;
		boolean letsPlay = false;
		String playerDecides = "";
		String userWord = "";
		String correctWord = "";
		String lastResult = "";
		String result = "";
		while (playAgain)
		{
		startGame();
		correctWord = assignWord(correctWord);
		
		for (int attempt = 6; attempt >= 0; attempt--)
		{	
			for (int strike = 1; strike <= 3; strike++)
			{
				System.out.print("Please Enter your guess: ");
				playerDecides = inputReader.nextLine();
				letsPlay = checkWord(playerDecides);
				userWord = playerDecides;
				
				if (!letsPlay)
				{
					if (strike < 3)
					{
						System.out.println("Strike " + strike + "! Commit 3 strikes and you're out of this game.");
						System.out.println();
					}
					else if (strike == 3)
					{
						System.out.println("You strike out! You are not allowed to make attempt any further.");
						System.out.println();
						attempt = 0;
					}
				}
				else strike = 3;
			}
		
			if (letsPlay)
			{
				result = "";
				lastResult = playerWord(userWord, correctWord, result);
			}
			
			if (lastResult == "correct")
				{
				attempt = 0;
				}
			else {
				System.out.println("You have " + attempt + " attempts left!");
				System.out.println();
			}
		}
		
		if (lastResult == "correct")
		{
			System.out.println("Congratulations! You got the wordle! Good Boy!");
		}
		else System.out.println("You ran out of attempts! Nice try! The word was " + correctWord);
		
		playAgain = anotherWordle(playAgain);
				
		}
		inputReader.close();
	}
	
	// This method simply prints the introduction prompt when the game starts, informing the user
	// of the rules, conditions, and meanings behind certain characters returned.
	
	public static void startGame()
	{
		System.out.println("Welcome to WORDLE! Please enter a word that's 5 letters long!");
		System.out.println("No double letters allowed!");
		System.out.println("Any words that do not fit these two conditions above will receive a strike");
		System.out.println("You are allowed up to two stikes per attempt!");
		System.out.println("Once you get a third strike, the game ends!");
		System.out.println("You have seven attempts to guess the word!");
		System.out.println("Make sure the first letter of the word is uppercase and the rest is lowercase for each letter to count!");
		System.out.println("Key: ? = The letter is part of the correct word, but in the wrong position");
		System.out.println("Key: X = The letter is not part of the correct word");
		System.out.println();
	}
	
	// This method uses the math.random code to generate a number
	// that corresponds with a certain word and assign it to the variable randomWord. This word will become
	// the word that the user will have to guess in seven attempts.
	
	public static String assignWord(String randomWord)
	{
		int wordSelection = (int) (Math.random() * 10);
		randomWord = "Bonus";
		if (wordSelection == 1)
		{
			randomWord = "Chart";
		}
		else if (wordSelection == 2)
		{
			randomWord = "Those";
		}
		else if (wordSelection == 3)
		{
			randomWord = "Viola";
		}
		else if (wordSelection == 4)
		{
			randomWord = "House";
		}
		else if (wordSelection == 5)
		{
			randomWord = "Vowel";
		}
		else if (wordSelection == 6)
		{
			randomWord = "Sound";
		}
		else if (wordSelection == 7)
		{
			randomWord = "Jaunt";
		}
		else if (wordSelection == 8)
		{
			randomWord = "Folky";
		}
		else if (wordSelection == 9)
		{
			randomWord = "Cater";
		}
		return randomWord;
	}
	
	// This method checks the word that the user entered 
	// to ensure that it follows the guidelines of only being 5 letters long
	// and confirming that each letter is unique, meaning each letter is used once.
	// To do this, an if statement checks if the length of the word is 5 letters long
	// and then runs the word through a couple for statements and an if statement
	// which compares each letter to the other to confirm no letter was used more than once.
	// If the word follows the guidelines, the value for goodWord will be set true and the game
	// will analyze it as an appropriate guess. Otherwise, the game will inform the user
	// of their error and allow them to try again.
	
	public static boolean checkWord(String userWord)
	{
		boolean goodWord = false;
		int wordLength = userWord.length();
		
		if (wordLength == 5)
		{
			goodWord = true;
			for (int i = 0; i < wordLength-1; i++)
			{
				for (int j = 1+i; j < wordLength; j++)
				{
					if (userWord.charAt(i)==userWord.charAt(j))
					{
						goodWord = false;
						System.out.println("Bad Boy! Only 1 letter per word is allowed. Try again!");
						j = wordLength;
						i = wordLength-1;
					}
				}
			}
		}
		else System.out.println("Bad Boy! The word needs to be EXACTLY 5 letters long! Try again!");

		return goodWord;
	}

	// This method compares the userWord and correctWord and confirms if 
	// the user guessed the word correctly. To do this, a boolean variable is assigned
	// the value of false and an if statement checks if the words (that are exactly 5 letters long)
	// are exactly the same. If they are, the value of matchFound is changed to true and returned.
	// otherwise, matchFound will stay false and that value is returned.
	
	public static boolean matchWord(String word1, String word2)
	{
		boolean matchFound = false;
		if (word1.length() == 5 && word2.length() == 5)
		{
			if (word1.charAt(0) == word2.charAt(0) && word1.charAt(1) == word2.charAt(1) && word1.charAt(2) == word2.charAt(2) && word1.charAt(3) == word2.charAt(3) && word1.charAt(4) == word2.charAt(4))
			{
				matchFound = true;
			}
		}
		return matchFound;
	}
	
	// This method analyzes the 5 letter word that the user entered 
	// and compares each letter to each letter from the randomly assigned word.
	// The method first checks if both words are the exact same and returns a result value of correct to the main method.
	// Otherwise, the code continues and checks each letter to see if any words from userWord are present in correctWord.
	// When the code detects that the user's letter is in the exact spot of correctWord, the code prints out that letter.
	// If the code detects that the user's letter is present in correctWord but not in the same spot, the code prints out a ?
	// Otherwise, the code prints out an X.
	// This for statement continues until each letter is checked. Afterwards, the final combination is printed and returned to
	// the main method.
	
	public static String playerWord(String userWord, String correctWord, String result)
	{
		if (matchWord(userWord, correctWord))
		{
			result = "correct";
		}
		else
		{
			for (int i = 0; i < 5; i++)
			{
				if (userWord.charAt(i) == correctWord.charAt(i))
				{
					result = result + userWord.charAt(i);
				}
				else if (userWord.charAt(i) == correctWord.charAt(0) || userWord.charAt(i) == correctWord.charAt(1) || userWord.charAt(i) == correctWord.charAt(2) || userWord.charAt(i) == correctWord.charAt(3) || userWord.charAt(i) == correctWord.charAt(4))
				{
					result = result + "?";
				}
				else result = result + "X";
			}
			System.out.println(result);
		}
		return result;		
	}

	// Once the user either runs out of attempts or guesses the word, anotherWordle runs.
	// This method introduces the variables playerDecides, upperChar, and lowerChar.
	// playerDecides is the variable that contains what the user answers to the given prompt.
	// This prompt is printed and asks the user if they want to play again.
	// An if statement is ran to check if the user typed y or Y by
	// comparing it to the values of upperChar and lowerChar.
	// If what the user typed matches, restartGame's value is set to true and is returned to
	// the main method, restarting and opening a new game of WORDLE with a new word.
	// Otherwise, the method will return restartGame's value as false, therefore ending the game.
	
	public static boolean anotherWordle(boolean restartGame)
	{
		String playerDecides = "";
		String upperChar = "Y";
		String lowerChar = "y";
		restartGame = false;
		
		System.out.println();
		System.out.println();
		System.out.print("Do you want to play again? Enter 'Y' for Yes. Other response will exit the game: ");
		playerDecides = inputReader.nextLine();
		
		if (playerDecides.length() > 0)
		{			
			if (playerDecides.charAt(0) == upperChar.charAt(0) || playerDecides.charAt(0) == lowerChar.charAt(0))
			{
				restartGame = true;
			}
		}
		
		System.out.println();
		System.out.println();

		return restartGame;		
	}
}
