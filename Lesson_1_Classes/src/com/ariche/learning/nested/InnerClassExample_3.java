package com.ariche.learning.nested;

/***
 * 
 *  Inner-classes (non static nested classes)
 *  
 *  C - Anonymous Classes
 *  
 *  	1 - Anonymous Classes they have the same access to local variables of the enclosing scope:
 *			An anonymous class has access to the members of its enclosing class.
 *	 	    An anonymous class cannot access local variables in its enclosing scope that are not declared as final or effectively final.
 *
 *
 *		2- Anonymous classes also have the same restrictions as local classes with respect to their members:
 *		   You cannot declare static initializers or member interfaces in an anonymous class.
 *		   An anonymous class can have static members provided that they are constant variables.
 *
 *
 *		3- you cannot declare constructors in an anonymous class.
 *
 */
public class InnerClassExample_3 {

	public interface Gretting{
		public void greeting();
	}
	
	public static void main(String[] args) {
		Gretting englishGreeting = new Gretting(){

			@Override
			public void greeting() {
				System.out.println("Hello anonymous  !!!");
				
			} 
		};
		englishGreeting.greeting();
	}
}
