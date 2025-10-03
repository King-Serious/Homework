
public class Diamond 
/**
 * This class works with Method_Main to calculate and return
 * A diamond's base, height, area, and states the shape
 */
{

	private double base;
	private double height;
	
	//This method labels the base and height of the given diamond
	public Diamond(double b, double h) 
	{
		base = b ;
		height = h ;
	}
	//This method returns the value of the base
	public double getBase() 
	{
		return base;
	}
	// This method returns the value of the height
	public double getHeight()
	{
		return height;
	}
	//This method gives the circle a new base
	public void setBase(double newBase)
	{
		base = newBase;
	}
	//This method gives the triangle a new height
	public void setHeight(double newHeight)
	{
		height = newHeight;
	}
	//This method calculates and returns the area of a diamond
	public double getArea()
	{
		return (base * height);
	}

	//This method states the shape of the class, which is a diamond
	public static void stateDiamond()
	{
		System.out.println("This class generates Diamond shapes.");
	}
}
