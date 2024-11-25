// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(plus(-2,3));   // 2 + 3
		System.out.println(plus(-5,-3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(minus(-2,7));  // 2 - 7
		System.out.println(minus(-2,-7));  // 2 - 7
 		System.out.println(times(4,4));  // 3 * 4
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
	int i = 0;
	if (x1 < 0 && x2 < 0) {
		while (i > x2) {
			x1--;
			i--;
		}
	}
	else {
		while (i < x2) {
			x1++;
			i++;
		}
	}
	return x1;
}
	public static int minus(int x1, int x2) { // Returns x1 - x2
		int i = x2;
		if (x2 < 0) {
			while (i < 0) {
				x1++;
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
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		int PositivNumber1 = x1;
		int PositivNumber2 = x2;
		if (x1 < 0) {
			PositivNumber1 = 0;
			for(int i=0; i>x1; i--){
				PositivNumber1++;
			}
		}
		if (x2 < 0) {
			PositivNumber2 = 0;
			for(int j=0; j>x2; j--){
				PositivNumber2++;
			}	
		}
		int i = 1, counter = PositivNumber1;
		while (i < PositivNumber2) {
			PositivNumber1 = plus(PositivNumber1, counter);
			i++;
		}
			if (x1 < 0 && x2 > 0 || x1 > 0 && x2 < 0) {
			int NegativeNumber = 0;
			for(int n=0; n < PositivNumber1; n++) {
				NegativeNumber--;
			}
			return NegativeNumber;
		}
	return PositivNumber1;
}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i=x;
		int counter=1;
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		while (counter < n) {
			x = times(x, i);
			counter++;
		}
		if (x < 0 )
		{
			counter = 0;
			while ( counter < n) {
				times(x, -1);
				counter++;
			}
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0 ) {
			return 0;
		}
		int PositivNumber1 = x1;
		int PositivNumber2 = x2;
		if (x1 < 0) {
			PositivNumber1 = 0;
			for(int i=0; i>x1; i--){
				PositivNumber1++;
			}
		}
		if (x2 < 0) {
			PositivNumber2 = 0;
			for(int j=0; j>x2; j--){
				PositivNumber2++;
			}	
		}
		if (x2 > x1) {
			return 0;
		}
		int counter = 1;
		while (x1 > x2) {
			x1=minus(x1, x2);
			if (x1 >= x2) {
				counter ++;
			}
		}
		if (x1 > 0 && x2 < 0 || x1 < 0 && x2 > 0) {
			int NegativeCounter = -1;
			for(int j=0; j<counter; j++){
				NegativeCounter--;
			}
			return NegativeCounter;
		}
		return counter;
	}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1 == 0) {
			return 0;
		}
		int div = div(x1, x2);
		div = times(div, x2);
		int result = x1 - div;
		if (result == x2) {
			return 0;
		}
		else
		return result;
	}
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 1) {
			return 1;
		}
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

