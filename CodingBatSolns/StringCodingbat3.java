/**
* This class contains the solution for doubleChar()
* from CodingBat, which each ask to return double of each letter/character in a given string
*/


//This method provides the solution for doubleChar(). To do this, the code will first
// identify how many characters are in the given string and assign it to a variable.
// Then, two variables are declared, which will contain the number of the letter that will be returned twice
// and the string result that will be returned after the while code is complete.
// The while statement will go until there are no more letters to be printed from the given string.
// In this while statement, the letter/character that corresponds with the number will be assigned
// to a variable. Then, myLetter will be assigned whatever previous letters were assigned to it plus the singleLetter 
// doubled and printedLetter increases its value by one and the cycle continues until there are no more characters to double.
public String doubleChar(String str) {
  int lengthOfString = str.length();
  int printedLetter = 0;
  String myLetter = "";
  while (printedLetter < lengthOfString)
  {
    String singleLetter = String.valueOf(str.charAt(printedLetter));
    myLetter = myLetter + (singleLetter + singleLetter);
    printedLetter++ ;
  }
  return myLetter;
}
