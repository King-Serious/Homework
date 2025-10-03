
public class Circle 
/**
 * This class works with Method_Main to calculate and return
 * A circle's radius, circumference, area, degrees, and states the shape
 */
{
	private double radius;
	private final double pi = 3.14;
	
	//This method labels the radius of the given circle
	public Circle(double r) 
	{
		radius = r ;
	}
	//This method returns the value of the radius
	public double getRadius() 
	{
		return radius;
	}
	//This method gives the circle a new radius
	public void setRadius(double newRadius)
	{
		radius = newRadius;
	}
	//This method calculates and returns the circumference of a circle
	public double getCircumf()
	{
		return (2 * pi * radius);
	}
	//This method calculates and returns the area of a circle
	public double getArea()
	{
		return (pi * radius * radius);
	}
	//This method returns the amount of degrees of a circle
	public static int getDegrees()
	{
		return 360;
	}
	//This method states the shape of the class, which is circle
	public static void stateCircle()
	{
		System.out.println("This class generates Circle shapes.");
	}
}
