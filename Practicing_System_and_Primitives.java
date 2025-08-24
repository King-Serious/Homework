Task 1: Print out your name using the letter "O" in ASCII art.

    	System.out.println("  OOOOOOOO     OOOOOOOO      OOOOOOO       OOOOOOO     OOOOOOOO");
		System.out.println("      OO       OO            OOO           OOO         OO      ");
		System.out.println("      OO       OO             OOO           OOO        OO      ");
		System.out.println("      OO       OOOOOO          OOO           OOO       OOOOOO  ");
		System.out.println("     OO        OOOOOO           OOO           OOO      OOOOOO  ");
		System.out.println("OO   OO        OO                OOO           OOO     OO      ");
		System.out.println(" OO OO         OO                 OOO           OOO    OO      ");
		System.out.println("  OO           OOOOOOOO       OOOOOOO       OOOOOOO    OOOOOOOO");
// These groups of code will print out lines of Os that form my name, Jesse

Task 2: Write code to compute the following math problem:

6.0 x (3.5 - 1.5 x 5)
-------------------
    55.6 - 30.2

System.out.print((6.0 * (3.5 - 1.5 * 5)) / (55.6 - 30.2));
// This code should accurately compute the math problem by first completing the problems within the parenthesis, then doing the multiplication, and then the division

Task 3: Write adaptable code that will print out the circumference and area of a circle that has a radius of 4.0. (Hint: the value of pi is 3.14 and it never changes)
		    double  pi = 3.14; 
        double radius = 4.0;
        // These two codes above list the provided information (pi is 3.14 and radius is 4.0)
        double circumference = (2*pi*radius);
        double area = (pi*Math.pow(radius, 2));
        // These two codes above provide the formulas needed to find circumference (Multiplying 2 and pi and radius) and area (Multiply pi by radius squared
        System.out.println("The circumference of the circle is " + circumference);
        System.out.println("The area of the circle is " + area);
        // These two codes above print out the solutions in a format similar to the example output in the original task
