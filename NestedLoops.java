/**
 * This class creates a multiplication table up to the given int.
 * This class uses a nested for loop to create the table.
 */

public class NestedLoops 
{
	/*
	 * The main method simply calls on the buildMultTable method to create a multiplication table
	 * with a given int.
	 */

	public static void main(String[] args) 
	{
		buildMultTable(10);
	}
	
	/*
	 * The buildMultTable method uses a nested for loop to generate a multiplication table
	 * up to the int num. The int variables of printNum and addNum and declared which contain
	 * the values that will be printed and added to the number. The first for loop will run until
	 * The loop passes the value of num. Inside, the loop adds 1 to the value of addNum and runs
	 * another for loop that also lasts until the variable j passes the value of num. While it is
	 * under the value of num, printNum's value changes by multiplying the value of j with the value of
	 * addNum and that value is then printed with a tab for the next number. After the nested for loop
	 * passes the value of num, then the code will move to the next line to run the for loop again. 
	 * This process continues until both loops pass the value of num.
	 */
	
	public static void buildMultTable(int num)
	{
		int printNum = 0;
		int addNum = 0;
		for (int i = 1; i <= num; i++)
		{
			addNum++;
			for (int j = 1; j <= num; j++)
			{
				printNum = j * addNum;
				System.out.print(printNum + "\t");
			}
			System.out.println("");
		}
	}

}
