package com.ariche.learning.nested;

/***
 * 
 * 	Inner-classes (non static nested classes)
 * 
 * 	B Local classes : a class declared inside a block (typically a method)
 *  
 * 		 1- if the method where class is declared is static we could reference only static members in the outer class
 *       
 *       2- if the method is not static we could reference all members in the outer class (final or not, static or not)
 *       
 * 		 3- we can not only access final or effectively final members (jdk8) in the enclosing  scope (method)
 *       
 *       4- effectively final member are the member never modified after init
 *       
 *       5- local classes are only used inside the methods where they are declared
 *    
 *       6- You cannot declare an interface inside a block; interfaces are inherently static
 */
public class InnerClassExample_2 {

	private static final int x = 11;
	private final int y = 33;
	private int z;
    
    InnerClassExample_2(){
    	this.z = 10;
    }
	public static void methodA(int a, int b) {

		class LocalClass_1 { 
			public void localMethod_1(){
				// here we could only access to static members because the outer method is static
				System.out.println("x : "+x);
				System.out.println("a : "+a); 
				System.out.println("b : "+b);
				 
				
			}
			
		}
		LocalClass_1 l = new LocalClass_1();
		l.localMethod_1();
		
	}
	
	public void methodB(int a,int b ){
		a = 5;
		 
		class LocalClass_2{
			
			public void localMethod_2(){
                 // we could not access to the a because it's not final or effectively final
				//System.out.println("a "+a);
				// we could access to b even it's not final but it's effectively final
				System.out.println("b : "+b);
				// the y member is final so we could access to it 
				System.out.println("y : "+y);
				// we could  access to x even it's a static member
				System.out.println("x  :"+x);
				// we have access to z even if it's not final and not effectively final because it's a member of the class 
				// not the enclosing  scope
				z = 55;
				System.out.println("z : "+z);
			}
		}
		
		LocalClass_2 l = new LocalClass_2();
		l.localMethod_2();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Calling the method A");
		InnerClassExample_2.methodA(1, 2);
		
		InnerClassExample_2 i = new InnerClassExample_2(); 
		System.out.println("Calling the method B");
		i.methodB(1, 2);
	}
}
