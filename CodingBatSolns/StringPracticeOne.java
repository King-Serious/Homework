/**
 * This class contains the solutions for helloName, makeAbba, makeTags, and firsthalf
 * from CodingBat, which ask to return a name, return a phrase in the form of abba, create HTML strings, and
 * Alongside that, this class will also print a randomly generated number between 11 and 20
 */

//This first method solves the problem for helloName, which requests to print out hellos to any given name
//This method returns the sentence "Hello (name)!" with the name being adaptable
public String helloName(String name) {
  return ("Hello " + name + "!");
}

// This next method solves the problem of returning two words in the form of abba
// By providing string a and b and putting it into abba form, this method completes the task and makes it adaptable

public String makeAbba(String a, String b) {
  return (a + b + b + a);
}

// This next method returns HTML strings like <i> Hello </i>
public String makeTags(String tag, String word) {
  return ("<" + tag + ">" + word + "</" + tag + ">");
}

//This last mathod prints half of a given string
//Using the information provided in the tutorial about StringMethods by first identifying the amount of characters
//In the given string using the .length method and then dividing that amount by two and using that number as the second integer
//for returning a part of the string
public String firstHalf(String str) {
  int lengthOfString = str.length();
  int halfLength = str.length() / 2;
  String Half = new String ( str.substring(0, halfLength) );
  return Half;
}
