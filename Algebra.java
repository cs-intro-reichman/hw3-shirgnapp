// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));

	}

	public static int plus(int x1, int x2) {
	int i=0;
	while (i < x1) {
		x2++;
		i++;
	}
	return x2;
}
	
	public static int minus(int x1, int x2) { // Returns x1 - x2
		int i = x2;
		if (x2 < 0) {
			while (i < 0) {
				x1--;
				i++;
			}
			
		}
		else {
		while (i > 0) {
			x1--;
			i--;
		}
	}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = x1;
		int counter = 1;
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		if (x1 < 0 || x2 < 0) {
		while (counter > x2) {
			x1 = minus(x1, i);
			counter--;
		}
	}
	else {
		while (counter < x2) {
			x1 = plus(x1, i);
			counter++;
		}
	}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i=x;
		int counter=1;
		if (n == 0) {
			return 1;
		}
		if (x < 0) {
			if (n % 2 == 0) {
				while (counter < n) {
					x = times(x, i);
					counter++;
			}
		}
			else{
				while (counter < n) {
					x = times(x, i);
					counter++;
			}
			if (counter == n) {
				x = times(x, -1);
			}
		}
	}
		else {
			while (counter < n) {
				x = times(x, i);
				counter++;
		}
	}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i=x2;
		int counter=1;
		if (x1 == 0 || x2 > x1) {
			return 0;
		}
		else {
		while (x1>x2) {
			x1=minus(x1, i);
			if (x1 >= i) {
				counter++;
			}
			
		}
		if ((x2 < 0 && x1 > 0) || (x2 > 0  && x1 < 0)) {
			counter = times(counter, -1);
		}
		if (x1 == x2) {
			return counter;
		}
	}
	return counter;
	}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 > x1) {
			return (minus(x2, x1));
		}
		else
		{
			int div = div(x1, x2);
			int mod = times(x2, div); 
			mod = minus(x1, mod);
			return mod;
		}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for(int i=0; i<x; i++){
		if (times(i, i) == x) {
			return i;
		}
		if (times(i, i) > x) {
			i--;
			return (i);
		}
		}
		return 0;
			
	}	  	  
}

