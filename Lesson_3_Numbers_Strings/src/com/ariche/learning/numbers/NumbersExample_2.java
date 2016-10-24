package com.ariche.learning.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  	Auto-boxing \ un-boxing
 *  	
 *  	Auto-boxing : convert automatically a primitive type to his wrapper in one of this situations :
 *  				   -1- Passed as a parameter to a method that expects an object of the corresponding wrapper class.
 *  				   -2- Assigned to a variable of the corresponding wrapper class.
 *  	unboxing :  convert automatically a wrapper type to primitive type in one of this situations :
 *  				   -1- Passed as a parameter to a method that expects a value of the corresponding primitive type.
 *  				   -2- Assigned to a variable of the corresponding primitive type.
 *
 */
public class NumbersExample_2 {

	public static void main(String[] args) {
		// Autoboxing 
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < 50; i++)
			li.add(i);
		System.out.println(sumEven(li));
		
		// unboxing

		Integer i = new Integer(-8);

		// 1. Unboxing through method invocation
		int absVal = absoluteValue(i);
		System.out.println("absolute value of " + i + " = " + absVal);

		List<Double> ld = new ArrayList<>();
		ld.add(3.1416); // pi is autoboxed through method invocation.

		// 2. Unboxing through assignment
		double pi = ld.get(0);
		System.out.println("pi = " + pi);
			
	}
	public static int sumEven(List<Integer> li) {
	    int sum = 0;
	    for (Integer i: li)
	        if (i % 2 == 0)
	            sum += i;
	        return sum;
	}
	public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}

