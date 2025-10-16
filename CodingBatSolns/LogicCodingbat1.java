/**
* This class contains the solutions for cigarParty, dateFashion, squirrelPlay, caughtSpeeding, and sortaSum
* from CodingBat, which asks to use the if code to return a certain result when it meets certain requirements.
*/

//This method solves the problem of cigarParty, which asks to return true whenever the cigar int
// is below 60 and above 40 when it's not the weekend or when cigar amount is above 40 on the weekend.
// In any other case, the result would return false.
// To do this, I created two different if statements to differentiate the ranges of the weekends and
// Having one final if statement at the end to return false if either if statements don't work.
public boolean cigarParty(int cigars, boolean isWeekend) {
  if (cigars >= 40 && cigars <= 60 && isWeekend == false)
  {
    return true;
  }
  else if (cigars >= 40 && isWeekend == true )
  {
    return true;
  }
  return false;
}

//This method solves the problem of dateFashion, which asks to return 0, 1, or 2 depending on the fashion of you
// and date. If either person has a 2 or below, then 0 should be returned. If either person has an 8 or above and
// the other doesn't have a 2 or below, they return with a 2. Otherwise, they return with a 1.
// To do this, I created 2 different if statements to first identify if either person has a 2 or above and then identify if either person
// had an 8 or above. At the end, I added return 1 to create the alternative if either if statements don't fit.
public int dateFashion(int you, int date) {
  if (you <= 2 || date <= 2)
  {
    return 0;
  }
  else if (you >= 8 || date >= 8)
  {
    return 2;
  }
  return 1;
}

//This method solves the problem of squirrelPlay, which asks to return a true or false depending on the temperature and
// if it is Summer. If it's Summer, the range for true would be between 60 and 100 inclusive. If it's not Summer, the range
// would be between 60 and 90 inclusive. In any other scenario, the code would return false.
// To do this, I created two if statements to differentiate the ranges between isSummer being false nad isSummer being true.
// Lastly, I put return false at the end if either if statements don't match.
public boolean squirrelPlay(int temp, boolean isSummer) {
  if (temp >= 60 && temp <= 100 && isSummer == true)
  {
    return true;
  }
  else if (temp >= 60 && temp <= 90 && isSummer == false)
  {
    return true;
  }
  return false;
}

//This method solves the problem of caughtSpeeding, which asks to return a value of either 0, 1, or 2 depending
// on the speed and if isBirthday is true. Since there were many possibilities for speed and birthdays, I made
// 6 different if statements that would run with the given perimeters. If none of them would match,
// The code would return a value of 2.
public int caughtSpeeding(int speed, boolean isBirthday) {
  if (speed <= 65 && isBirthday == true)
  {
    return 0;
  }
  else if (speed <= 60 && isBirthday == false)
  {
    return 0;
  }
  else if (speed >= 61 && speed <= 80 && isBirthday == false)
  {
    return 1;
  }
  else if (speed >= 66 && speed <= 85 && isBirthday == true)
  {
    return 1;
  }
  else if (speed >= 81 && isBirthday == false)
  {
    return 2;
  }
  else if (speed >= 86 && isBirthday == true)
  {
    return 2;
  }
  return 2;
}

// This method solves the problem of sortaSum, which asks to return the sum of the two given numbers
// unless the sum is greater than or equal to 10 and less than or equal to 19.
// To do this, I created one if statements that adds the two values up first and puts that sum into the if statement
// To see if it fits. If it doesn't, then it'll return the sum instead of 20.
public int sortaSum(int a, int b) {
  if (a + b >= 10 && a + b <= 19)
  {
    return 20;
  }
return a + b;
}

