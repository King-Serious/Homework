import java.util.ArrayList;

/**
 * This class identifies the first time 4 appears in an integer array list, removes all fives in an integer array list,
 * and sorts an integer array list numerically using bubble sort.
 */

public class ListAlgs {
	
	/*
	 * This main method instantiates an integer array list and assigns it 5 random values between 1-9.
	 * Then, it prints out the list as it goes through the checkFor4, ridAllFives, and bubbleSort methods.
	 */

	public static void main(String[] args) 
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++)
		{
			int randNum = (int) (Math.random() * 10);
			nums.add(randNum);
		}
		
		System.out.println(nums);
		
		System.out.println(checkFor4(nums));
		
		System.out.println(ridAllFives(nums));
		
		System.out.println(bubbleSort(nums));
	}
	
	/*
	 * The checkFor4 method checks if a given integer array list contains a 4 and returns the index of where it is.
	 * To do this, an int variable index4 is declared that stores -1. A for loop traverses the array list until it either
	 * goes through each value in the array list or if a 4 is spotted as a value of the array list. When a 4 is spotted,
	 * the value of index4 is changed to the index of where the 4 is and the for loop stops so that index is returned.
	 * Otherwise, if the loop goes through the entire list without finding a 4, the method returns -1 to show that there
	 * was no 4 found in the method.
	 */
	
	public static int checkFor4(ArrayList<Integer> nums)
	{
		int index4 = -1;
		for (int i = 0; i < nums.size() - 1; i++)
		{
			if (nums.get(i) == 4)
			{
				index4 = i;
				i = nums.size() - 2;
			}
		}
		return index4;
	}
	
	/*
	 * The ridAllFives method removes all instances of a 5 being a value in an array list.
	 * To do this, a for loop traverses the entire array list and checks if a value in the list
	 * is equivalent to 5. When it is, that 5 in the list is removed. Once the list is traversed, the final
	 * array is returned.
	 */
	
	public static ArrayList<Integer> ridAllFives(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size() - 1; i++)
		{
			if (nums.get(i) == 5)
			{
				nums.remove(i);
				i--;
			}
		}
		return nums;
	}
	
	/*
	 * The bubbleSort method organizes a given array list numerically using bubble sort.
	 * To do this, a for loop creates an int variable temp that contains the biggest number (which initially starts as the first number
	 * of the array list) and the values at index i and index i+1 are compared. When the value at i is greater than the value at i+1,
	 * the value at i is set to the value at i+1 and the value at i+1 is set to i, which is contained in the temp variable declared previously
	 * in the method. Once the entire array list has been organized, it is returned.
	 */
	
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> nums)
	{
		for (int tempNums : nums)
		{
			for (int i = 0; i < nums.size() - 1; i++)
			{
				int temp = nums.get(i);
				if (nums.get(i+1) < nums.get(i))
				{
					nums.set(i, nums.get(i+1));
					nums.set(i+1, temp);
				}
			}
		}
		return nums;
	}

}
