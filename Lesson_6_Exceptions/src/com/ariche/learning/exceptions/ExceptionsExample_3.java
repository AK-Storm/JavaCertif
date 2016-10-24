package com.ariche.learning.exceptions;
/***
 * 

		Suppressed Exceptions : (jdk 7 and later)
		- When we try an exception, and we code in finally block if in this block we have an exception,it's going to be omitted or suppressed 
		,the best example is when we try to close a resource in a finally block and we had an exception.
		
		- The jdk 7 add two methods in Throwable class 
					Throwable.getSupressed(); // Returns Throwable[]
					Throwable.addSupressed(aThrowable);
		- When we use the classic try catch block we have to handle suppression exception ourselves, by using above methods. if we have .
		- the try-with-resources Statement support the suppression exception itself.
 * 
 */
class Resource implements AutoCloseable {
	
	/***
	 * 		Resource is a class that implements AutoCloseable and in his close method 
	 * 		throws an exception , so when we will try to use() it we will get a runtimeException
	 *      and in when trying to close it also we will get an exception.
	 * 	
	 */
	public void use() {
		throw new RuntimeException("This exception in the use method");
	}

	@Override
	public void close() throws Exception {
		throw new NullPointerException("This exception in the close method");
	}
}
public class ExceptionsExample_3 {
	// in this method doesn't handle the exception throws when trying to close 
	// because it's suppressed 
	public static void testWithoutSuppressionSupport() throws Exception {
		Resource resource = new Resource();
		try {
			resource.use();
		} finally {
			resource.close();
		}
	}
    
	// to solve the suppression support problem in close method we will use addSupressed in finally's try catch block
	public static void testWithSuppressionSupport() throws Exception{
		Resource resource = new Resource();
		Throwable throwable = null;
		try {
			resource.use();
		} catch (Exception e) {
			throwable = e;
		} finally {
			try {
				resource.close();
			} catch (Exception e) {
				if (throwable != null) {
					e.addSuppressed(throwable);
					throw e;
				}
			}
		}
	}

	public static void testWithTryCatchResource() throws Exception {
		try (Resource resource = new Resource()) {
			resource.use();
		}
	}
	public static void main(String args[]) {
		try {
			//testWithoutSuppressionSupport();
			//testWithSuppressionSupport();
			testWithTryCatchResource();
		} catch (Exception ex) {
			System.err.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.err.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.err.println("tt" + exception.toString());
				}
			}
		}
	}
}
