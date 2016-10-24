package com.ariche.learning.inheritance;

/**
 *  
 *    Inheritance 
 *    
 *    1- overriding : - we can override an inherited method, for that we have to define a same signiture method (params , name)
 *    				    the return type  should be compatible with the superclass's definition (covariant return type).
 *    
 *    				  - the override annotation ensure us that the method is really a new implementation of the superclass's method
 *    					if not we will have a compilation error.
 *	
 *	  2-when we redefine a static method we hide the superclass's implementation ,we don't say override(only for instance methods)
 *
 */
class AA {
	public void foo() {
		System.out.println("AA : foo"); 
	}
}

class BB extends AA{
	@Override
	public void foo() {
		System.out.println("BB: foo");
	}
}
public class InheritanceExample_2 {

	
	public static void main(String[] args) {
		BB b = new BB();
		b.foo();
	}
}
