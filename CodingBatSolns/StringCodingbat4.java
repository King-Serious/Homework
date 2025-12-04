/**
* This class contains the solution for countHi(), catDog(), countCode(), and repeatEnd()
* from CodingBat, which each ask to return double of each letter/character in a given string
*/

//This method provides the solution for countHi(), which asks to return the amount of times
//the string "hi" shows up in a given string. To do this, I created a for loop that runs until
// the value of i is less than the length of the string minus one. In this loop, I created an if
// statement that checks if two characters are equivalent to the string "hi". When this is true,
// the value of count increases by one. This continues until there are no more characters to be counted.
// Afterwards, the final value of count is returned.
public int countHi(String str) 
{
  int count = 0;
  for (int i = 0; i < str.length() -1; i++)
  {
    if (str.substring(i,i+2).equals("hi"))
    {
      count++;
    }
  }
  return count;
}

//This method provides the solution for catDog(), which asks to return a boolean of true
//if the strings "cat" and "dog" show up the same amount of times in a given string.
//To do this, a for loop is created that uses if statements to count how many times the Strings
// "cat" and "dog" show up in the given string. After the for loop is done, an if statement checks if
// the amount of times "cat" and "dog" show up in the given string are equivalent to each other.
// When it does, the value of true is returned and the value of false is returned otherwise.

public boolean catDog(String str) 
{
    int catCount = 0;
    int dogCount = 0;
  for (int i = 0; i < str.length() -2; i++)
  {
    if (str.substring(i,i+3).equals("cat"))
    {
      catCount++;
    }
    if (str.substring(i,i+3).equals("dog"))
    {
      dogCount++;
    }
  }
  if (catCount == dogCount)
  {
    return true;
  }
  else return false;
}

// This method provides the solution for countCode(), which asks to
// return how many times the Strings "co" and "e" show up. To do this,
// a for loop is created that checks two letters of a given String are "co" and then checks
// the second letter after the last two checked letters to see if it's "e".
// If this is true, then the value of count is increased by one.

public int countCode(String str) 
{
    int count = 0;
  for (int i = 0; i < str.length() -3; i++)
  {
    if (str.substring(i,i+2).equals("co") && str.substring(i+3,i+4).equals("e"))
    {
      count++;
    }
  }
  return count;
}

// This method provides the solution for repeatEnd(), which asks to
// repeat the last n amount of chars of the given string n times.
// To do this the variable of repChar is first declared
// to identify the characters that need to be repeated.
// Then, the variable of finalForm is declared, which will
// store the final String that will be returned.
// A for loop repeatedly enters the characters into the finalForm
// variable until the for loop runs n times. At the end, the value of
// finalForm will be returned, which contains the final String
// of repeated characters.

public String repeatEnd(String str, int n) 
{
  String repChar = str.substring(str.length()-n);
  String finalForm = "";
  for (int i = n; i > 0; i--)
  {
    finalForm = finalForm + repChar;
  }
  return finalForm;
}
