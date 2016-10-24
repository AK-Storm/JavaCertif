package com.ariche.learning.nested;

/***
 * 		Static nested class:
 * 
 * 		1- only could access the class members (static members) of the outer class 
 * 		2- we can access to instance class of the outer class only with a reference 
 *      3- we don't need to create an instance of the outer class object to instantiate 
 *         the nested static class or to use a it's static method
 */

public class NestedClassExample{
	
	private static int x;
	private int y ;
	
	public NestedClassExample(int y){
		this.y = y;
	}
	
	public int getY() {
		return y;
	} 

	public static class StaticNestedClass {
		public StaticNestedClass(){
			x = 1;
			// we could not reference y  because it's not static 
		}
		
		
		public String toString(){
			return "StaticInnerClass [ "+x+" ] ";
		}
		
		public  int accessToY(NestedClassExample outer){
			return outer.getY();
		}
		public static void methodToCall(){
			System.out.println("This is a static method in a static nested class !");
		}
	} 
	
	public static void main(String... args) {
		
		// how to use a static nested class
		NestedClassExample.StaticNestedClass s = new NestedClassExample.StaticNestedClass(); 
		
		System.out.println(s);
		
		// how to use a static method in a static nested class 
		NestedClassExample.StaticNestedClass.methodToCall();
		
		// to access the non static member in the outer class
		// it's possible with a reference 
		NestedClassExample outer  = new NestedClassExample(12);
		System.out.println(s.accessToY(outer));
	}
}