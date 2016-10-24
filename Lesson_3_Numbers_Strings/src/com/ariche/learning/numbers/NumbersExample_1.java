package com.ariche.learning.numbers;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 
 * 		Number : 
 * 
 * 		1- it's an abstract class. 
 * 
 * 		2- Byte,Short,Integer,Long,Float,Double, BigDecimal,BigInteger,AtomicInteger,AtomicLong all of them extends Number.
 * 
 * 		3- Methods that all Number subclasses implements :	
 * 		   a - convert the Number object to a primitive type xxxValue(): byteValue,intValue,longValue,floatValue,doubleValue.
 * 		   b - compare the Number object to a primitive type int comapreTo(xxx e): comapreTo(int e),comapreTo(byte e),comapreTo(long e),comapreTo(float e),comapreTo(double e).
 * 		   c - equals.
 * 
 * 		4- each subclass of Number has thier specific methods for example Integer
 * 			  - static Integer decode(String s) : convert string  (hex,dec,octal) to Integer 
 * 			  - static int parseInt(String s) :  convert string (only decimal) to Integer
 * 			  - static int parseInt(String s, int radix) : convert string (on base radix) to Integer
 * 			  - String toString() : convert to string a Integer
 * 			  - static String toString(int i) :	convert a primitive int value to String
 * 			  - static Integer valueOf(int i) : convert a primitive int value to Integer
 * 			  - static Integer valueOf(String s) : convert a string (decimal) to Integer
 * 			  - static Integer valueOf(String s, int radix) : convert a string (base radix) to Integer
 * 
 * 		5- format ,printf methods (PrintStream class) allow us to format our out put ,DecimalFormat class too
 * 			http://docs.oracle.com/javase/tutorial/java/data/numberformat.html (for more details)
 *      
 *      6- Math class (java.lang) offers lot of useful methods,and constants.
 *      
 *  
 *
 */
public class NumbersExample_1 {

	public static void main(String[] args) {
		
		
		Integer a = 50 ; 
		System.out.println(a.floatValue());
		System.out.println(a.compareTo(4)); 
		System.out.println(Integer.decode("0x77"));
		System.out.println("0x77".toString());
		
		
		// format ,printf
		long n = 461012;
		System.out.format("%d%n", n); // --> "461012"
		System.out.format("%08d%n", n); // --> "00461012"
		System.out.format("%+8d%n", n); // --> " +461012"
		System.out.format("%,8d%n", n); // --> " 461,012"
		System.out.format("%+,8d%n%n", n); // --> "+461,012"

		double pi = Math.PI;

		System.out.format("%f%n", pi); // --> "3.141593"
		System.out.format("%.3f%n", pi); // --> "3.142"
		System.out.format("%10.3f%n", pi); // --> " 3.142"
		System.out.format("%-10.3f%n", pi); // --> "3.142"
		System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi); // --> "3,1416"

		Calendar c = Calendar.getInstance();
		System.out.format("%tB %te, %tY%n", c, c, c); // --> "May 29, 2006"

		System.out.format("%tl:%tM %tp%n", c, c, c); // --> "2:34 am"

		System.out.format("%tD%n", c); // --> "05/29/06"
		
		// DecimalFormat 
		customFormat("###,###.###", 123456.789);
		customFormat("###.##", 123456.789);
		customFormat("000000.000", 123.78);
		customFormat("$###,###.###", 12345.67);
		
		
		// Math class
		
		double e = -191.635;
		double b = 43.74;
		int l = 16, d = 45;

		System.out.printf("The absolute value " + "of %.3f is %.3f%n", e, Math.abs(e));

		System.out.printf("The ceiling of " + "%.2f is %.0f%n", b, Math.ceil(b));

		System.out.printf("The floor of " + "%.2f is %.0f%n", b, Math.floor(b));

		System.out.printf("The rint of %.2f " + "is %.0f%n", b, Math.rint(b));

		System.out.printf("The max of %d and " + "%d is %d%n", l, d, Math.max(l, d));

		System.out.printf("The min of of %d " + "and %d is %d%n", l, d, Math.min(l, d));
		
		
	}
	
	static public void customFormat(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		System.out.println(value + "  " + pattern + "  " + output);
	}
}
