package com.ariche.learning.interfaces;
/***
 * 
 *  Interface : Functional Interfaces
 *  
 *  1- a functional interface is any interface that contains only one abstract method and it could contains any number of default methods
 *  or static methods.
 *  
 *  2- to tell the compiler to validate that the interface is functional we use @functional annotation.
 *  
 *  3- any interface could inherit our functional Interface but if the child interface add an abstract method it will be no longer 
 *     functional, and that of course doesn't influence our mother functional interface.
 *
 */
@FunctionalInterface
interface FunctionnalInterface{
	public void doSt();
	
	public static int fake(){
		return 0;
	}
	default void foo(){
		System.out.println("foo");
	}
}
public class InterfacesExample_3 {

	public static void main(String[] args) {
		callIt(new FunctionnalInterface() {
			
			@Override
			public void doSt() {
				System.out.println("this is a classic use of Functional interface (annonymous classes) !");
				
			}
		});
		callIt(()->{
			System.out.println("this is a more concise method to use FI (lambda expressions) !");
		});
		
	}
	public static void callIt(FunctionnalInterface f){
		f.doSt();
	}
}
