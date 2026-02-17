
/**
 * This class is meant to complete 10 objectives: return the smallest number and index in an array,
 * the average of all numbers in an array, a boolean depending if all numbers in an array are even,
 * change the value of two consecutive 5s to 0s, a boolean if any number shows up three times in a row,
 * an int counting how many times a certain value shows up in an array, reverse the order of a given array,
 * shift the order of a given array to the right, and use selection sort to sort an array.
 */

public class AlgorithimsProject {

	/*
	 * The main method declares various arrays and runs them through the various methods to complete the mentioned objectives.
	 * The results of these methods are then printed out.
	 */
	
	public static void main(String[] args) 
	{
		int[] smallArray = {5, 3, 6, 2, 8};
		int[] medArray = {3, 10, 6, 8, 9, 7, 5, 5};
		int[] threeArray = {4, 6, 7, 8, 8, 8, 9, 10};
		int[] fiveArray = {2, 5, 8, 5, 3, 9, 8, 5, 5};
		int[] nicArray = {4, 5, 16, 36, 37, 67, 3498};
		int[] randArray = {56, 1000, 73, 69, 67, 83};
		int targetNum = 5;
		System.out.println("smallArray:");
		System.out.println("The smallest number in the array is " + smallestNum(smallArray));
		System.out.println("The index of the smallest number in the array is " + smallestIndex(smallArray));
		System.out.println("The mean of the array is " + arrayMean(smallArray));
		System.out.println("Result of checkEven: " + checkEven(smallArray));
		System.out.println("medArray:");
		System.out.print("Result of consFive: ");
		for (int i = 0; i < medArray.length; i++)
		{
			consFive(medArray);
			System.out.print(medArray[i] + ", ");
		}
		System.out.println("");
		System.out.println("threeArray: ");
		System.out.println("Result of threeFives: " + threeNums(threeArray));
		System.out.println("fiveArray: ");
		System.out.println("The number " + targetNum + " shows up " + howMany(fiveArray, targetNum) + " times");
		System.out.println("Result of reverseArray: ");
		for (int i = 0; i < fiveArray.length; i++)
		{
			int[] reversed = reverseArray(fiveArray);
			System.out.print(reversed[i] + ", ");
		}
		System.out.println("");
		System.out.println("nicArray:");
		System.out.println("Result of toTheRight: ");
		for (int i = 0; i < nicArray.length; i++)
		{
			int[] right = toTheRight(nicArray);
			System.out.print(right[i] + ", ");
		}
		System.out.println("");
		System.out.println("randArray:");
		select(randArray);
		for (int i = 0; i < randArray.length; i++)
		{
			System.out.print(randArray[i] + ", ");
		}
	}
	
	/*
	 * The smallestNum method locates and returns the smallest number in an array. To do this, an int variable
	 * lowestNum is created to track this number and changes every time a number in an array is detected
	 * to be smaller than the current value in lowestNum.
	 */
	
	public static int smallestNum(int[] tempNums)
	{
		int lowestNum = tempNums[0];
		for (int i = 1; i < tempNums.length; i++)
		{
			if (tempNums[i] < lowestNum)
			{
				lowestNum = tempNums[i];
			}
		}
		return lowestNum;
	}
	
	/*
	 * The smallestIndex method locates and returns the index of the smallest number in an array.
	 * This works similarly to the smallestNum method, but instead the int variable lowestNum contains
	 * the index where the smallest number is located and it changes to the index of wherever the smallest
	 * number is.
	 */
	
	public static int smallestIndex(int[] tempNums)
	{
		int lowestNum = tempNums[0];
		for (int i = 1; i < tempNums.length; i++)
		{
			if (tempNums[i] < lowestNum)
			{
				lowestNum = i;
			}
		}
		return lowestNum;
	}
	
	/*
	 * The arrayMean method calculates and returns the average of all values in an array.
	 * To do this, an int variable total is created and a for loop adds all values into the
	 * total variable. Afterwards, another int average is created that has the total divided by
	 * the amount of numbers in the array and returned after calculated.
	 */
	
	public static int arrayMean(int[] tempNums)
	{
		int total = 0;
		for (int i = 0; i < tempNums.length; i++)
		{
			total = total + tempNums[i];
		}
		int average = total / tempNums.length;
		return average;
	}
	
	/*
	 * The checkEven method checks if any value in an array is an odd number and returns false
	 * if detected and true if not. A for loop checks each value in the array and an if statement
	 * checks if that value moduled leaves one left, in which case returns false. Otherwise, if
	 * the if statement is ignored for the entire array, true is returned.
	 */
	
	public static boolean checkEven(int[] tempNums)
	{
		for (int i = 0; i < tempNums.length; i++)
		{
			if (tempNums[i] % 2 == 1)
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * The consFive method traverses an array and locates if there are two consecutive fives and changes their values
	 * to zero. The if statement checks when the value at the index and the next index are equal to five and changes
	 * their values to zero. Once the entire array is traversed, the array is returned.                                                                                                                                                                   cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
	 */
	
	public static int[] consFive(int[] tempNums)
	{
		for (int i = 0; i < tempNums.length - 1; i++)
		{
			if (tempNums[i] == 5 && tempNums[i+1] == 5)
			{
				tempNums[i] = 0;
				tempNums[i+1] = 0;
			}
		}
		return tempNums;
	}
	
	/*
	 * The threeNums method array traverses an array and checks if 3 consecutive values in the array
	 * are equivalent to each other and returns true when detected by the if statement and false
	 * if not.
	 */
	
	public static boolean threeNums(int[] tempNums)
	{
		for (int i = 0; i < tempNums.length - 2; i ++)
			if (tempNums[i+1] == tempNums[i] && tempNums[i+2] == tempNums[i])
			{
				return true;
			}
		return false;
	}
	
	/*
	 * The howMany method identifies how many times a certain number shows up in an array.
	 * To do this, an int tracker is declared that tracks how many times the number shows up in the array.
	 * A for loop then runs checking if the value at tempNums[i] is equal to the target number and adds
	 * 1 to the tracker every time it shows up. After the for loop checks each value, the final value of tracker
	 * is returned.
	 */
	
	public static int howMany(int[] tempNums, int target)
	{
		int tracker = 0;
		for (int i = 0; i < tempNums.length; i++)
		{
			if (tempNums[i] == target)
			{
				tracker++;
			}
		}
		return tracker;
	}
	
	/*
	 * The reverseArray method reverses the order of values in an array. To do this,
	 * a new array is created to store the reversed array and a for loop assigns the numbers
	 * of the original array to the new array in reverse by having the new array start from
	 * the left side and original array start from the right side. Once the values
	 * have been assigned, the new array is returned.
	 */
	
	public static int[] reverseArray(int[] tempNums)
	{
		int[] backArray = new int [tempNums.length];
		int j = 0;
		for (int i = tempNums.length-1; i >= 0; i--)
		{
			backArray[j] = tempNums[i];
			j++;
		}
		return backArray;
	}
	
	/*
	 * The toTheRight method moves each value one time to the right. To do this, a new int array finalArray
	 * is created that will store the final array that will be returned. Before the for loop runs, the first
	 * value in finalArray is already assigned to the final value of the original array. The for loop then stores
	 * each number from the original array into the new array but one index to the right. Then, the finalArray is returned.
	 */
	
	public static int[] toTheRight(int[] tempNums)
	{
		int[] finalArray = new int[tempNums.length];
		finalArray[0] = tempNums[tempNums.length-1];
		int j = 0;
		for (int i = 1; i < tempNums.length; i++)
		{
			finalArray[i] = tempNums[j];
			j++;
		}
		return finalArray;
	}
	
	/*
	 * The select method uses selection sort to organize an array and place it in numerical order.
	 * This method has a nested for loop that runs until it reaches the maximum length of the array.
	 * While this loop runs, the int variable minLoc is set to the value of i to identify the location of the
	 * minimum. If the value of the minimum is greater than the value at j, the variable minLoc is assigned to
	 * j, the location of the smaller number. Once the final minLoc is located, a temporary int variable stores
	 * the smallest found value and swaps the value at the location of the smallest number with the value at i.
	 * Once this is done, the array is returned.
	 */
	
	public static int[] select(int[] tempNums)
	{
		for (int i = 0; i < tempNums.length-1; i++)
		{
			int minLoc = i;
			for (int j = i + 1; j < tempNums.length; j++)
			{
				if (tempNums[minLoc] > tempNums[j])
				{
					minLoc = j;
				}
			}
			int temp = tempNums[minLoc];
			tempNums[minLoc] = tempNums[i];
			tempNums[i] = temp;
		}
		return tempNums;
	}

}
