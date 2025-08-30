/**
 *  This class will be able to calculate the area and volume of a cube
 *  by a given side length
 */
public class CubeCalculator {
		public static void main(String[] args) {
			// This code is where the side length will be inserted. The test value is 5 but can be changed
			// to any value and it'll still calculate correctly
			double side = 5.0;
			// This code will identify what the area of the cube is by inserting the side length into the formula
			double area = (6 * Math.pow(side, 2));
			// This code will identify what the volume of the cube is by inserting the side length into the formula
			double volume = Math.pow(side, 3);
		
		// This code will print out the side length as a whole number	
		System.out.println("The side length of the cube is " + ((int) (side)));
		// This code will print out the area of the cube as a whole number
		System.out.println("The area of the cube is " + ((int) (area)));
		// This code will print out the volume of the cube as a whole number
		System.out.println("The volume of the cube is " + ((int) (volume)));
		
		}
}
