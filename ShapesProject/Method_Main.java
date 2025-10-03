import java.awt.Font;

public class Method_Main 
/**
 * This class works with the Circle, Square, Triangle, Diamond, and Cube classes
 * To print out the areas of the shapes, as well as the circumference and radius of a circle,
 * The base and heights of the triangle and diamond, and the length of a side of the square and cube.
 * Alongside this, this class also tests the setters and getters, which includes setting a new value to
 * Bases, radius, heights, and side lengths to alter the circumference and areas of the shapes.
 * Lastly, this class also states what shape each group generates.
 */
{
	
	public static void main(String[] args) {
		Circle myCirc1 = new Circle (5.6);
		Circle myCirc2 = new Circle (6.7);
		Circle myCirc3 = new Circle (6.9);
		Square mySquare1 = new Square (3.3);
		Square mySquare2 = new Square (10.3);
		Square mySquare3 = new Square (8.0);
		Triangle myTriangle1 = new Triangle (3.7,8.0);
		Triangle myTriangle2 = new Triangle (4.0,7.0);
		Triangle myTriangle3 = new Triangle (9.7, 12.0);
		Diamond myDiamond1 = new Diamond (14.0, 7.8);
		Diamond myDiamond2 = new Diamond (10.3, 6.8);
		Diamond myDiamond3 = new Diamond (4.3, 2.7);
		Cube myCube1 = new Cube (16.0);
		Cube myCube2 = new Cube (12.3);
		Cube myCube3 = new Cube (4.7);
		
		System.out.println("[Circles]");
		System.out.println("Circle 1:");
		System.out.println("The Radius of Circle 1 is " + myCirc1.getRadius());
		System.out.println("The Circumference of Circle 1 is " + myCirc1.getCircumf());
		System.out.println("The Area of Circle 1 is " + myCirc1.getArea());
		System.out.println("A circle is " + Circle.getDegrees() + " degrees");
		System.out.println();
		System.out.println("Circle 2:");
		System.out.println("The Radius of Circle 2 is " + myCirc2.getRadius());
		System.out.println("The Circumference of Circle 2 is " + myCirc2.getCircumf());
		System.out.println("The Area of Circle 2 is " + myCirc2.getArea());
		System.out.println();
		System.out.println("Circle 3:");
		System.out.println("The Radius of Circle 3 is " + myCirc3.getRadius());
		System.out.println("The Circumference of Circle 3 is " + myCirc3.getCircumf());
		System.out.println("The Area of Circle 3 is " + myCirc3.getArea());
		System.out.println();
		System.out.println("What would happen if the Radius of Circle 3 was 2.7?");
		myCirc3.setRadius(2.7);
		System.out.println("Well, the new circumference of circle 3 would be " + myCirc3.getCircumf());
		System.out.println("Alongside the new circumference, the new area of circle 3 would be " + myCirc3.getArea());
		Circle.stateCircle();
		System.out.println();
		
		System.out.println("[Squares]");
		System.out.println("Square 1:");
		System.out.println("The length of a side of square 1 is " + mySquare1.getSide());
		System.out.println("The area of square 1 is " + mySquare1.getArea());
		System.out.println();
		System.out.println("Square 2:");
		System.out.println("The length of a side of square 2 is " + mySquare2.getSide());
		System.out.println("The area of square 2 is " + mySquare2.getArea());
		System.out.println();
		System.out.println("Square 3:");
		System.out.println("The length of a side of square 3 is " + mySquare3.getSide());
		System.out.println("The area of square 3 is " + mySquare3.getArea());
		System.out.println();
		System.out.println("What would happen if the length of a side of square 3 was 8.9?");
		mySquare3.setSide(8.9);
		System.out.println("Well, the new area of square 3 would be " + mySquare3.getArea());
		Square.stateSquare();
		System.out.println();
		
		System.out.println("[Triangles]");
		System.out.println("Triangle 1:");
		System.out.println("The base of triangle 1 is " + myTriangle1.getBase());
		System.out.println("The height of triangle 1 is " + myTriangle1.getHeight());
		System.out.println("The area of triangle 1 is " + myTriangle1.getArea());
		System.out.println();
		System.out.println("Triangle 2:");
		System.out.println("The base of triangle 2 is " + myTriangle2.getBase());
		System.out.println("The height of triangle 2 is " + myTriangle2.getHeight());
		System.out.println("The area of triangle 2 is " + myTriangle2.getArea());
		System.out.println();
		System.out.println("Triangle 3:");
		System.out.println("The base of triangle 3 is " + myTriangle3.getBase());
		System.out.println("The height of triangle 3 is " + myTriangle3.getHeight());
		System.out.println("The area of triangle 3 is " + myTriangle3.getArea());
		System.out.println();
		System.out.println("What would happen if the base of triangle 3 was 3.2 and the beight was 4.3?");
		myTriangle3.setBase(3.2);
		myTriangle3.setHeight(4.3);
		System.out.println("Well, the new area of triangle 3 would be " + myTriangle3.getArea());
		Triangle.stateTriangle();
		System.out.println();
		
		System.out.println("[Diamonds]");
		System.out.println("Diamond 1:");
		System.out.println("The base of diamond 1 is " + myDiamond1.getBase());
		System.out.println("The height of diamond 1 is " + myDiamond1.getHeight());
		System.out.println("The area of diamond 1 is " + myDiamond1.getArea());
		System.out.println();
		System.out.println("Diamond 2:");
		System.out.println("The base of diamond 2 is " + myDiamond2.getBase());
		System.out.println("The height of diamond 2 is " + myDiamond2.getHeight());
		System.out.println("The area of diamond 2 is " + myDiamond2.getArea());
		System.out.println();
		System.out.println("Diamond 3:");
		System.out.println("The base of diamond 3 is " + myDiamond3.getBase());
		System.out.println("The height of diamond 3 is " + myDiamond3.getHeight());
		System.out.println("The area of diamond 3 is " + myDiamond3.getArea());
		System.out.println();
		System.out.println("What would happen if the base of diamond 3 was 5.9 and the height was 6.4?");
		myDiamond3.setBase(5.9);
		myDiamond3.setHeight(6.4);
		System.out.println("Well, the new area of diamond 3 would be " + myDiamond3.getArea());
		Diamond.stateDiamond();
		System.out.println();
		
		System.out.println("[Cubes]");
		System.out.println("Cube 1:");
		System.out.println("A side length of cube 1 is " + myCube1.getSide());
		System.out.println("The area of cube 1 is " + myCube1.getArea());
		System.out.println();
		System.out.println("Cube 2:");
		System.out.println("A side length of cube 2 is " + myCube2.getSide());
		System.out.println("The area of cube 2 is " + myCube2.getArea());
		System.out.println();
		System.out.println("Cube 3:");
		System.out.println("A side length of cube 3 is " + myCube3.getSide());
		System.out.println("The area of cube 3 is " + myCube3.getArea());
		System.out.println();
		System.out.println("What would happen if the side length of cube 3 was 6.2?");
		myCube3.setSide(6.2);
		System.out.println("Well, the new area of cube 3 would be " + myCube3.getArea());
		Cube.stateCube();
	}
}
