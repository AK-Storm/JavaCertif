package com.ariche.learning.nested;

/***
 * Nested interfeces : are interfaces declared inside a class or another interface
 * 	- 1 - Nested interface must be public if it is declared inside the interface but 
 *  	  it can have any access modifier if declared within the class.
 * 
 *  - 2 - Nested interfaces are declared static implicitly.
 *  - 3 - to use it see below
 */
interface Interface_Outer{
	public interface Interface_Inner {
		public void methodToUse();
	}
}
public class NestedInterfaces implements Interface_Outer.Interface_Inner {

	private interface Interface_a{
		public void method_a();
	}
	
	public static void main(String[] args) {
		Interface_a a = new Interface_a(){

			@Override
			public void method_a() {
				System.out.println("This is a nested interface");
				
			}
			
		};
		a.method_a();
		NestedInterfaces nf = new NestedInterfaces();
		nf.methodToUse();
	}

	@Override
	public void methodToUse() { 
		System.out.println("This is implementation of an nested interface");
	}
}
