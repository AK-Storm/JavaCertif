package com.ariche.learning.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 			Exceptions : (see the image exceptions_tree)
 * 
 * 			1- There are three kinds of exceptions :	
 * 						- checked exceptions : These are exceptional conditions that a well-written application should anticipate and recover from. 
 * 						- unchecked exceptions :
 * 							- errors : These are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from.
 * 							- runtime exceptions  : These usually indicate programming bugs, such as logic errors or improper use of an API.
 *			All the exceptions are checked except Error,and RuntimeException and their subclasses.
 *
 *          2- All checked exceptions are subject of Catch or Specify Requirement in other words:	
 *          		    - Try-catch block to handle it.
 *          			- Specifying the Exceptions Thrown by a Method.
 *          
 *          3- Each try block support many catch blocks ,the first Exception could handle the problem will be used (inheritance)
 *          
 *          4- One catch block could support multiple Exceptions using | 
 *          		catch (IOException|SQLException ex)  the ex is final in this case so we could not change it.
 *          
 			5- The final block  is executed even if an unexpected exception occurs,generally it's used for clean up resources
 			   if the JVM exits while the try or catch code is being executed, then the finally block may not execute. 
 			   Likewise, if the thread executing the try or catch code is interrupted or killed, 
 			   the finally block may not execute even though the application as a whole continues.
 			   
 			
 *			  
 *
 */

 

public class ExceptionsExample_1 {

	public static void main(String[] args) throws Exception {
		PrintWriter out = null;
		List<Integer> list = new ArrayList<>();
		final int SIZE = 10;
		try {
			System.out.println("Entering" + " try statement");

			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < SIZE; i++) {
				out.println("Value at: " + i + " = " + list.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());

		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}

}
