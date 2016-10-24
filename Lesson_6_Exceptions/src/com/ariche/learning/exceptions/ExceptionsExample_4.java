package com.ariche.learning.exceptions;
/***
 * 
 *  Chaining Exceptions :
 *  	- Sometimes, when you catch an exception, you want to throw a new exception. 
 *  	However, you may want to convey the information in the original exception in the new exception.
 *      This can be done by chaining exceptions.
 *      
 *      - For that we have :
 *    		    Throwable getCause()
				Throwable initCause(Throwable)
				Throwable(String, Throwable)
				Throwable(Throwable)
 *
 */
public class ExceptionsExample_4 {

	public static void main(String[] args) {

		System.out.println("***no chaining example:");
		try {
			try {
				throw new Exception("One");
			} catch (Exception e) {
				throw new Exception("Two");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		System.out.println("\n***chaining example 1:");
		try {
			try {
				throw new Exception("Three");
			} catch (Exception e) {
				throw new Exception("Four", e);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("###what was the cause:");
			e.getCause().printStackTrace(System.out);
		}

		System.out.println("\n***chaining example 2:");
		try {
			try {
				throw new Exception("Five");
			} catch (Exception e) {
				throw new Exception(e);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}
}
