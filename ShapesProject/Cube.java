
public class Cube 
/**
 * This class works with Method_Main to calculate and return
 * A cube's side length, area, and states the shape
 */
{

	private double side;
	
	//This method labels the length of a side of the given cube
	public Cube(double s) 
	{
		side = s ;
	}
	//This method returns the value of a side length
	public double getSide() 
	{
		return side;
	}
	//This method gives the diamond a new side length
	public void setSide(double newSide)
	{
		side = newSide;
	}
	//This method calculates and returns the area of a diamond
	public double getArea()
	{
		return ((side * side) * 6);
	}

	//This method states the shape of the class, which is a diamond
	public static void stateCube()
	{
		System.out.println("This class generates Cube shapes.");
	}
}
