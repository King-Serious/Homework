
public class TestExample {
/**
 * This class will test out the math class, using it
 * to find the absolute values, powers, and square roots of given numbers
 * Alongside that, this class will also print a randomly generated number between 11 and 20
 * @param args
 */
	public static void main(String[] args) {
	int posInt = 1 ;
	int negInt = -2 ;
	double posDouble = 1.0 ;
	double negDouble = -2.0; 
	
	//These following 4 codes calculate and return the absolute value of the integers.
	//The abs() code is overloaded because it calculates the absolute values of both integers and doubles
	System.out.println("The absolute value of " + ((int) (posInt)) + " is " + ((int) (Math.abs(posInt))));
	System.out.println("The absolute value of " + ((int) (negInt)) + " is " + ((int) (Math.abs(negInt))));
	System.out.println("The absolute value of " + ((double) (posDouble)) + " is " + ((double) (Math.abs(posDouble))));
	System.out.println("The absolute value of " + ((double) (negDouble)) + " is " + ((double) (Math.abs(negDouble))));
	
	//These following 2 codes calculate and return posInt to the power of negInt and negInt to the power of posInt.
	//The pow() code is not overloaded as the parameters are the same for both, which is integer.
	System.out.println("The result of " + ((int) (posInt)) + " to the power of " + ((int) (negInt)) + " is " + ((int) (Math.pow(posInt, negInt))));
	System.out.println("The result of " + ((int) (negInt)) + " to the power of " + ((int) (posInt)) + " is " + ((int) (Math.pow(negInt, posInt))));
	
	//These following 4 codes calculate and return the square root of the integers
	//3 out of 4 of these codes correctly calculate the square root of the integer.
	//However, the square root of (double) (negDouble) results in NaN because square rooting 2.0 results in an undefined
	// number, which is what NaN represents.
	System.out.println("The square root of " + ((int) (posInt)) + " is " + ((int) (Math.sqrt(posInt))));
	System.out.println("The square root of " + ((int) (negInt)) + " is " + ((int) (Math.sqrt(negInt))));
	System.out.println("The square root of " + ((double) (posDouble)) + " is " + ((double) (Math.sqrt(posDouble))));
	System.out.println("The square root of " + ((double) (negDouble)) + " is " + ((double) (Math.sqrt(negDouble))));
	
	//This code calculates and returns a randomly generated number between the range of 11 and 20.
	//The code first calculates a number between 0.0 inclusive and 1.0 exclusive.
	//Afterwards, that number is multiplied by 10, placed into INT format to truncate the decimal,
	// And then added with 11 to get the desired number.
	System.out.println("The random number generated is " + ((int) (Math.random() * 10) + 11));
		  
	}
}
