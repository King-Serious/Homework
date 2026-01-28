public boolean has23(int[] nums) 
{
  boolean present23 = false;
  for (int i = 0; i < nums.length; i ++)
  {
    if (nums[i] == 2 || nums[i] == 3)
    {
     present23 = true;
    }
  }
  return present23;
}

public boolean no23(int[] nums) 
{
  for (int i = 0; i < nums.length; i++)
  {
    if (nums[i] == 2 || nums[i] == 3)
    {
      return false;
    }
  }
  return true;
}

public int[] makeLast(int[] nums) 
{
  int[] doubleNums = new int[nums.length*2];
  doubleNums[doubleNums.length-1] = nums[nums.length-1];
  return doubleNums;
}

public boolean double23(int[] nums) 
{
  int track2 = 0;
  int track3 = 0;
  for (int i = 0; i < nums.length; i++)
  {
    if (nums[i] == 2)
    {
      track2++;
    }
    if (nums[i] == 3)
    {
      track3++;
    }
  }
  if (track2 == 2 || track3 == 2)
  {
    return true;
  }
  else return false;
}

public int[] fix23(int[] nums) 
{
  for (int i = 0; i < nums.length-1; i++)
  {
    int currentNum = nums[i];
    int nextNum = nums[i+1];
    if (currentNum == 2 && nextNum == 3)
    {
      nums[i+1] = 0;
    }
  }
  return nums;
}

public int start1(int[] a, int[] b) 
{
  int track1 = 0;
  if (a.length >= 1)
  {
    if (a[0] == 1)
    {
      track1++;
    }
  }
  if (b.length >= 1)
  {
   if (b[0] == 1)
    {
      track1++;
    }
  }
  return track1;
}

public int[] biggerTwo(int[] a, int[] b) 
{
  int aSum = a[0] + a[1];
  int bSum = b[0] + b[1];
  if (aSum >= bSum)
  {
    return a;
  }
  else return b;
}

public int[] makeMiddle(int[] nums) 
{
 int[] halfArray =  {nums[nums.length/2-1], nums[nums.length/2]};
 return halfArray;
}

public int[] plusTwo(int[] a, int[] b) 
{
  int[] combArray = new int[4];
  combArray[0] = a[0];
  combArray[1] = a[1];
  combArray[2] = b[0];
  combArray[3] = b[1];
  return combArray;
}

public int[] swapEnds(int[] nums) 
{
  int[] swapNums = new int[nums.length];
  swapNums[0] = nums[nums.length-1];
  for (int i = 1; i < nums.length-1; i++)
  {
    swapNums[i] = nums[i];
  }
  swapNums[nums.length-1] = nums[0];
  return swapNums;
}

public int[] midThree(int[] nums) 
{
  int midNums = nums.length/2+1;
  int[] midThree = {nums[midNums-2], nums[midNums-1], nums[midNums]};
  return midThree;
}

public int maxTriple(int[] nums) 
{
  int midNum = nums.length/2;
  if (nums[0] > nums[midNum])
  {
    if (nums[0] > nums[nums.length-1])
    return nums[0];
  }
  else if (nums[midNum] > nums[nums.length-1])
  {
    return nums[midNum];
  }
  return nums[nums.length-1];
}

public int[] frontPiece(int[] nums) 
{
  int[] first2 = new int[2];
  if (nums.length >= 2)
  {
    first2[0] = nums[0];
    first2[1] = nums[1];
    return first2;
  }
  return nums;
}

public boolean unlucky1(int[] nums) 
{
  if (nums.length <= 1)
  {
    return false;
  }
  if (nums[0] == 1 && nums[1] == 3 || nums[1] == 1 && nums[2] == 3 || nums[nums.length-2] == 1 && nums[nums.length-1] == 3)
  {
    return true;
  }
  return false;
}

public int[] make2(int[] a, int[] b) 
{
  int[] twoThings = new int[2];
  if (a.length < 1)
  {
    twoThings[0] = b[0];
    twoThings[1] = b[1];
  }
  if (a.length == 1)
  {
    twoThings[0] = a[0];
    twoThings[1] = b[0];
  }
  else if (a.length >= 2)
  {
    twoThings[0] = a[0];
    twoThings[1] = a[1];
  }
  return twoThings;
}

public int[] front11(int[] a, int[] b) 
{
  if (a.length == 0 && b.length == 0)
  {
    int[] none = {};
    return none;
  }
  else if (a.length == 0)
  {
    int[] someA = {b[0]};
    return someA;
  }
  else if (b.length == 0)
  {
    int[] someB = {a[0]};
    return someB;
  }
  int[] newFront = {a[0], b[0]};
  return newFront;
}
