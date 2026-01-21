public int[] rotateLeft3(int[] nums) 
{
  int firstNum = nums[0];
  int secondNum = nums[1];
  int thirdNum = nums[2];
  int[] finalNum = {secondNum, thirdNum, firstNum};
  return finalNum;
}

public int[] reverse3(int[] nums) 
{
  int firstNum = nums[0];
  int secondNum = nums[1];
  int thirdNum = nums[2];
  int[] finalNums = {thirdNum, secondNum, firstNum};
  return finalNums;
}

public int[] maxEnd3(int[] nums) 
{
  int largestNumber = nums[0];
  if (nums[2] > largestNumber)
  {
    largestNumber = nums[2];
  }
  for (int j = 0; j < nums.length; j++)
  {
    nums[j] = largestNumber;
  }
  return nums;
}

public int sum2(int[] nums) 
{
  int combinedNums = 0;
  if (nums.length == 0)
  {
    return combinedNums;
  }
  if (nums.length == 1)
  {
    combinedNums = nums[0];
    return combinedNums;
  }
  else combinedNums = nums[0] + nums[1];
  return combinedNums;
}

public int[] middleWay(int[] a, int[] b) 
{
  int firstMiddle = a[1];
  int secondMiddle = b[1];
  int[] comMiddle = {firstMiddle, secondMiddle};
  return comMiddle;
}

public int[] makeEnds(int[] nums) 
{
  int firstNums = nums[0];
  int lastNums = nums[nums.length-1];
  int[] firLasNums = {firstNums, lastNums};
  return firLasNums;
}
