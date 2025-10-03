
public class Triangle 
/**
 * This class works with Method_Main to calculate and return
 * A triangle's base, height, area, and states the shape
 */
{
	
	private double base;
	private double height;
	
	//This method labels the base and height of the given triangle
	public Triangle(double b, double h) 
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
	//This method gives the triangle a new base
	public void setBase(double newBase)
	{
		base = newBase;
	}
	//This method gives the triangle a new height
	public void setHeight(double newHeight)
	{
		height = newHeight;
	}
	//This method calculates and returns the area of a triangle
	public double getArea()
	{
		return (0.5 * base * height);
	}

	//This method states the shape of the class, which is a triangle
	public static void stateTriangle()
	{
		System.out.println("This class generates Triangle shapes.");
	}
}
