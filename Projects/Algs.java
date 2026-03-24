import java.util.ArrayList;

/**
 * This class returns the smallest number in an ArrayList, the index of the smallest numbers, the average/mean of all the numbers,
 * a boolean that determines if all numbers in the ArrayLst are even and returns false otherwise, an altered ArrayList that has any
 * consecutive 5s changed to 0, a boolean that retuns true if any number shows up three times in a row, a counter on how many times
 * a certain number shows up in the array, an altered ArrayList that is the reversed version of the passed array, an altered ArrayList
 * that shifts each value in the list to the right once, and an altered ArrayList's organized through selection sort.
 */


public class ListAlgsProject {
	
	/*
	 * The main method instantiates an array list that contains 6 randomized values. This array list is then ran through
	 * each and every method in this class and prints out the result after each method.
	 */

	public static void main(String[] args) 
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++)
		{
			int randNum = (int) (Math.random() * 10);
			nums.add(randNum);
		}
		int rand = (int) (Math.random() * 10);
		int targetNum = nums.get(rand);
		
		System.out.println("The smallest number in the array is " + smallestNum(nums));
		System.out.println("The index of the smallest number in the array is " + smallestIndex(nums));
		System.out.println("The mean of the array is " + arrayMean(nums));
		System.out.println("Result of checkEven: " + checkEven(nums));
		consFive(nums);
		System.out.println("Result of consFive: " + nums);
		System.out.println("threeArray: " + nums);
		System.out.println("Result of threeFives: " + threeNums(nums));
		System.out.println("fiveArray: " + nums);
		System.out.println("The number " + targetNum + " shows up " + howMany(nums, targetNum) + " times");
		reverseArray(nums);
		System.out.println("Result of reverseArray: " + nums);
		toTheRight(nums);
		System.out.println("Result of toTheRight: " + nums);
		select(nums);
		System.out.println("randArray: " + nums);
	}
	
	/*
	 * The smallestNum method locates and returns the smallest number in an array list. To do this, an int variable
	 * lowestNum is created to track this number and changes every time a number in an array list is detected
	 * to be smaller than the current value in lowestNum.
	 */
	
	public static int smallestNum(ArrayList<Integer> nums)
	{
		int lowestNum = nums.get(0);
		for (int i = 1; i < nums.size(); i++)
		{
			if (nums.get(i) < lowestNum)
			{
				lowestNum = nums.get(i);
			}
		}
		return lowestNum;
	}
	
	/*
	 * The smallestIndex method locates and returns the index of the smallest number in an array list.
	 * This works similarly to the smallestNum method, but instead the int variable lowestNum contains
	 * the index where the smallest number is located and it changes to the index of wherever the smallest
	 * number is.
	 */
	
	public static int smallestIndex(ArrayList<Integer> nums)
	{
		int lowestNum = nums.get(0);
		for (int i = 1; i < nums.size(); i++)
		{
			if (nums.get(i) < lowestNum)
			{
				lowestNum = i;
			}
		}
		return lowestNum;
	}
	
	/*
	 * The arrayMean method calculates and returns the average of all values in an array list.
	 * To do this, an int variable total is created and a for loop adds all values into the
	 * total variable. Afterwards, another int average is created that has the total divided by
	 * the amount of numbers in the array and returned after calculated.
	 */
	
	public static int arrayMean(ArrayList<Integer> nums)
	{
		int total = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			total = total + nums.get(i);
		}
		int average = total / nums.size();
		return average;
	}
	
	/*
	 * The checkEven method checks if any value in an array list is an odd number and returns false
	 * if detected and true if not. A for loop checks each value in the array list and an if statement
	 * checks if that value moduled leaves one left, in which case returns false. Otherwise, if
	 * the if statement is ignored for the entire array list, true is returned.
	 */
	
	public static boolean checkEven(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size(); i++)
		{
			if (nums.get(i) % 2 == 1)
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * The consFive method traverses an array list and locates if there are two consecutive fives and changes their values
	 * to zero. The if statement checks when the value at the index and the next index are equal to five and changes
	 * their values to zero. Once the entire array list is traversed, the array list is returned.                                                                                                                                                                   cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
	 */
	
	public static ArrayList<Integer> consFive(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size() - 1; i++)
		{
			if (nums.get(i) == 5 && nums.get(i+1) == 5)
			{
				nums.set(i, 0);
				nums.set(i+1, 0);
			}
		}
		return nums;
	}
	
	/*
	 * The threeNums method array list traverses an array and checks if 3 consecutive values in the array list
	 * are equivalent to each other and returns true when detected by the if statement and false
	 * if not.
	 */
	
	public static boolean threeNums(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size() - 2; i ++)
			if (nums.get(i+1) == nums.get(i) && nums.get(i+2) == nums.get(i))
			{
				return true;
			}
		return false;
	}
	
	/*
	 * The howMany method identifies how many times a certain number shows up in an array list.
	 * To do this, an int tracker is declared that tracks how many times the number shows up in the array list.
	 * A for loop then runs checking if the value at nums.get(i) is equal to the target number and adds
	 * 1 to the tracker every time it shows up. After the for loop checks each value, the final value of tracker
	 * is returned.
	 */
	
	public static int howMany(ArrayList<Integer> nums, int target)
	{
		int tracker = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			if (nums.get(i) == target)
			{
				tracker++;
			}
		}
		return tracker;
	}
	
	/*
	 * The reverseArray method reverses the order of values in an array. To do this,
	 * a for loop is created that runs until the the int value i is equal or greater than
	 * the amount of values in the nums. While this runs, the last value in the array list
	 * is added to the front of the array list and the last value in the array list is removed.
	 * This continues until the entire array is reversed, in which it is then returned.
	 */
	
	public static ArrayList<Integer> reverseArray(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size(); i++)
		{
			nums.add(i, nums.get(nums.size()-1));
			nums.remove(nums.size()-1);
		}
		return nums;
	}
	
	/*
	 * The toTheRight method moves each value one time to the right. To do this,
	 * the code simply adds the last number to the front and removes the last number in the array list.
	 * The array list is then returned.
	 */
	
	public static ArrayList<Integer> toTheRight(ArrayList<Integer> nums)
	{
		nums.add(0, nums.get(nums.size()-1));
		nums.remove(nums.size()-1);
		return nums;
	}
	
	/*
	 * The select method uses selection sort to organize an array list and place it in numerical order.
	 * This method has a nested for loop that runs until it reaches the maximum length of the array list.
	 * While this loop runs, the int variable minLoc is set to the value of i to identify the location of the
	 * minimum. If the value of the minimum is greater than the value at j, the variable minLoc is assigned to
	 * j, the location of the smaller number. Once the final minLoc is located, a temporary int variable stores
	 * the smallest found value and swaps the value at the location of the smallest number with the value at i.
	 * Once this is done, the array list is returned.
	 */
	
	public static ArrayList<Integer> select(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size()-1; i++)
		{
			int minLoc = i;
			for (int j = i + 1; j < nums.size(); j++)
			{
				if (nums.get(minLoc) > nums.get(j))
				{
					minLoc = j;
				}
			}
			int temp = nums.get(minLoc);
			nums.set(minLoc, nums.get(i));
			nums.set(i, temp);
		}
		return nums;
	}

}
