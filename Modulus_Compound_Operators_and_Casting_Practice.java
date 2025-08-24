//PART ONE: MODULUS
		//What would each of the following 1-6 lines including the modulo operator cause to be printed?
		     System.out.println(14 % 13);
		     //1
		     System.out.println(8 % 11);
		     //0
		     System.out.println(6 % 2);
		     //0
		     System.out.println(7 % 2);
		     //1
		     System.out.println(274 % 10);
		     //4
		     System.out.println(881 % 2);
		     //1

    //PART TWO: COMPOUND OPERATORS AND SHORTCUTS (credits to runestone.academy)

    int x = 0;
    int y = 1;
    int z = 2;
    x--; // x followed by the double minus sign
    y++;
    z+=y;
//After the above code runs, what are x, y, and z equal to?
     // x-- is 0 - 1 so x = -1
		 // y++ is 1 + 1 so y = 2
		 // z+=y is z = 2 + 2 so z = 4

    int a = 3;
    int b = 5;
    int c = 2;
    a = c * 2;
    b = b / 2;
    c++;
//After the above code runs, what are a, b, and c equal to?
		  // a = c * 2 is a = 2 * 2 so a = 4
		  // b = b / 2 is b = 5 / 2 but because it's int, b = 2
		  // c++ is c + 1 so c = 3

     //PART THREE: CASTING

     int total = 5 + 7 + 2;
     (double) (total / 3); //Option A
     total / 3; //Option B
     (double) total / 3; //Option C

//Which of the above options correctly computes the average of total? Why do the other options not work?
      // C correctly computes the average of total.
      // Option A doesn't work because total / 3 is in parenthesis, meaning that it will be computed in int format first before it's put into a double format
      // Option B doesn't work because without the double, the equation is still in int format, meaning the decimals are truncated
