
public class Square 
/**
 * This class works with Method_Main to calculate and return
 * A square's side length, area, and states the shape
 */
{

	private double side;
	
	//This method labels a side length of the given circle
	public Square(double s) 
	{
		side = s ;
	}
	//This method returns the value of a side of the square
	public double getSide() 
	{
		return side;
	}
	//This method gives the square a new side length
	public void setSide(double newSide)
	{
		side = newSide;
	}
	//This method calculates and returns the area of a square
	public double getArea()
	{
		return (side * side);
	}

	//This method states the shape of the class, which is a square
	public static void stateSquare()
	{
		System.out.println("This class generates Square shapes.");
	}
}
