package com.ariche.learning.inheritance;
/**
 * 		Inheritance 
 * 
 * 		1- A class that is derived from another class is called a subclass (also a derived class, extended class, or child class). 
 * 		   The class from which the subclass is derived is called a superclass (also a base class or a parent class).
 * 
 *  	2- A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members,
 *  	   so they are not inherited by subclasses.
 *  	3- static methods are never inherited
 *  
 *      4- Casting : B is a subclass of A ,so B is A 
 *      			a- implicit casting : A a = new B(); (but we could not invoke B functions)
 *      			b- explicit casting : B b = (B) a ;
 * 
 *		5- instanceof operator can save you from a runtime error owing to an improper cast.
 *
 *		6- The access specifier for an overriding method can allow more, but not less, access than the overridden method. 
 *		   For example, a protected instance method in the superclass can be made public, but not private, in the subclass.
 *		
 *		7- You will get a compile-time error if you attempt to change an instance method in the superclass to a static method in the subclass,
 *		   and vice versa.
 */		

class A {
}

class B extends A {
	public void foo() {
		System.out.println("foo ");
	}
}
public class InheritanceExample_1 {
	
	public static void main(String[] args) {
		A a = new B();
		// we could not do a.foo(); because the compiler doesn't know b as a B class object we need to cast explicitly 
		B b = (B) a;
		b.foo();
		
		if(a instanceof B){
			System.out.println("yes a is a B instance");
		}
	}
}
