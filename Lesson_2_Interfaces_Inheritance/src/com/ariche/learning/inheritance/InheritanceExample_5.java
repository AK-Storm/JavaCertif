package com.ariche.learning.inheritance;

/**
 *  	Final :
 *      1- a method could be final that means we could not override it in a subclass.
 *      2- even a class could be declared as final,so we could not extends it
 *      3- Methods called from constructors should generally be declared final. 
 *         If a constructor calls a non-final method, a subclass may redefine that method with surprising or undesirable results.


 *      
 *
 */
class Home{
	public final  void goHome(){
		System.out.println("a final method !!");
	}
}
class House extends Home {
// impossible to do that
//	@Override
//	public final void goHome(){
//		System.out.println();
//	}
}
public class InheritanceExample_5 {

	public static void main(String[] args) {
		House h = new House();
		h.goHome();
	}
}
