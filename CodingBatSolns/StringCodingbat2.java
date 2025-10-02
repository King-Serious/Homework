/**
*This class contains the solutions for makeOutWord, extraEnd, and withoutEnd
*from CodingBat, which ask to return words in the format of "<<word>>", 3 copies of the last two letters of
*a given word, and only the letters in between the first and last characters.
*/

//This method solves the problem of makeOutWord, which asks to return a word in the format
// of "<<word>>" with out equaling to "<<>>" or "[[]]" or any similar formats
//and word equaling to any given word.
// To do this, I first split the out word into two strings containing half of the given value of out
// Using this, I'd place it in the correct order with the word string to have the correct format.
public String makeOutWord(String out, String word) {
  String wawa = new String (out.substring(0,2));
  String awaw = new String (out.substring(2,4));
  String yesYes = wawa + word + awaw;
  return yesYes;
}

//This method solves the problem of extraEnd, which wants to return a value including 3 copies of the
// last two letters of a given word.
// To do this, I simply created a string that isolates the last two letters of the given word
// And created a code to repeat those letters three times
public String extraEnd(String str) {
  String woowoo = new String (str.substring(str.length()-2, str.length()));
  String oowoow = woowoo + woowoo + woowoo;
  return oowoow;
}

//This method solves the problem of withoutEnd, whose objective is to return a value that only includes
//The characters between the first and last character of a given string.
// To do this, I created a string that isolates the middle characters from the first and last character
// And returned that value.
public String withoutEnd(String str) {
  String baba = new String (str.substring(str.length()+1 - str.length(), str.length()-1));
  return baba;
}
