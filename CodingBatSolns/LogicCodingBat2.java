/**
* This class contains the solutions for alarmClock, in1To10, and old35
* from CodingBat, which each ask to return a result if the input meets certain requirements
*/

// This method solves the problem of alarmClock, which is supposed to return 7:00 or 10:00
// Depending on if it a weekend or weekday and if it's a vacation. To do this, I created
// Multiple if statements so the correct time will be returned with the given day and boolean.
public String alarmClock(int day, boolean vacation) 
{
  if (day >= 1 && day <= 5)
  {
    if (vacation == true)
    {
      return "10:00";
    }
    else if (vacation == false)
    {
      return "7:00";
    }
  }
  if (day <= 0 || day >= 6)
  {
    if (vacation == true)
    {
     return "off";
    }
    else if (vacation == false)
    {
      return "10:00";
    }
  }
  return "7:00";
}

// This method solves the problem of in1To10, which asks to return a true value
// either if outsideMode is true and the number is less than or equal to 1 or
// greater than or equal to 10 or if outsideMode is false and the number is between the
// values of 1 and 10 inclusive. To do this, I created if statements that check for outsideMode
// first and then checked the int to see if it fits the following if statement to return true.
// Otherwise, the code returns false.
public boolean in1To10(int n, boolean outsideMode) {
  if (outsideMode == true)
  {
    if (n <= 1 || n >= 10)
    {
      return true;
    }
  }
  if (outsideMode == false)
  {
    if (n >= 1 && n <= 10)
    {
      return true;
    }
  }
  return false;
}

// This method solves the problem of old35, which asks to return true if the given number
// is a multiple of 3 or 5, but not a multiple of both. To do this, I incorporated module into
// my if statements to identify if the given ints are multiples or 3 and/or 5. If they were multiples
// of both, the code would return false. If it's only a multiple of one, the code would return true.
// Otherwise, the code returns false.
public boolean old35(int n) {
  if (n % 5 == 0 && n % 3 == 0)
  {
    return false;
  }
  else if (n % 5 == 0 || n % 3 == 0)
  {
    return true;
  }
  return false;
}
