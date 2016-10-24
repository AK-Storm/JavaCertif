package com.ariche.learning.inheritance;
/***
 * 		Abstract classes :
 * 
 * 		1- it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.
 * 
 * 		2-  Methods in an interface (see the Interfaces section) that are not declared as default or static are implicitly abstract, 
 * 			so the abstract modifier is not used with interface methods.
 * 
 * 		3- Abstract vs Interface : 
 * 			-  With abstract classes, you can declare fields that are not static and final, and define public, protected, and private concrete methods.
 * 			   with interfaces, all fields are automatically public, static, and final, and all methods that you declare or define (as default methods) are public.
 * 			
 * 			-  we could only extends one abstract class but we could implemnts any number of interfaces, and this is powerful ;)
 * 				
 * 			- in general abstract classes are used to factorize the code.
 * 	 
 *
 */
// a very silly example :)
abstract class Foo{
	public abstract void bar();
}
public class InheritanceExample_6 extends Foo{

	@Override
	public void bar() {
		System.out.println("this is the implementation");
	}
	
	public static void main(String[] args) {
		Foo f = new InheritanceExample_6();
		f.bar();
	}

}
