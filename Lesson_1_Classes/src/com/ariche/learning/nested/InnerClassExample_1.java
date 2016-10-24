package com.ariche.learning.nested;


/***
 *   Inner-classes (non static nested classes)
 *   
 *   A- Member inner classes 
 *      
 *   	1- we can access to all the outer class member (static, final, private ...)
 *   
 *   	2- we could not declare static members in the member inner classes (methods or variables) because it's a non static block
 *     	   but they could access outer class static members 
 *      
 *   	3- to instantiate an object of the inner class we have to  instantiate first the outer class and follow the syntax :
 *   		OuterClass o = new OuterClass();
 *   		OuterClass.InnerClass i = o.new OuterClass.InnerClass();
 *
 */
public class InnerClassExample_1 { 
	
	private int x;
	private static final int  y = 2;
	
	public class InnerClass{
		
		// we could not declare the z (static member)
		// private static int z;
		//		public static void method(){
		//			
		//		}
		
		public InnerClass(){
			x = 1 ;
		}
		public void view(){
			System.out.println("we could access to all the outclass's members x : "+x+ " , y : "+y);
		}
	}
	
	
	public static void main(String[] args) {
		// how to instantiate a member class
		InnerClassExample_1 ie = new InnerClassExample_1();
		InnerClassExample_1.InnerClass inner = ie.new InnerClass();
		inner.view();
	}
	
}
