package com.ariche.learning.interfaces;

/**
 * 		Interface 
 * 	
 * 		- multi-inherited default methods, see the following example 
 * 
 * 		 Problem : the foo default method exist in both InterfaceA and InterfaceB ,if a class implements both of them we will get a compilation error
 *   	 Solution : override the  foo method in the our class.
 *       Remark : it we want to use the interface foo implementation  we have to InterfaceA.super.foo()
 *       
 *       Question : what about static methods ? 
 *       Response : we don't have this problem with static methods,'cuz to invoke it we specify the interface that we want 
 *       			not from the class. 
 *
 */
interface InterfaceA{
	default void foo(){
		System.out.println("A --- > foo");
	}
	public static void fake(){
		System.out.println("fake A");
	}
}
interface InterfaceB{
	default void foo(){
		System.out.println("B  --- > foo");
	}
	public static void fake(){
		System.out.println("fake B");
	}
}
public class InterfacesExample_2 implements InterfaceA,InterfaceB{

	@Override
	public void foo() { 
		// we can choose to use InterfaceA implementation
		//InterfaceA.super.foo();
		System.out.println("This is an overrided implementation !");
	}
	public static void main(String[] args) {
		
		InterfacesExample_2 e= new InterfacesExample_2();
		e.foo(); 
		
		InterfaceB.fake();
		
	}

}
