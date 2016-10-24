package com.ariche.learning.inheritance;

/**
 *    	Hiding fields: 	  - if the subclass has a field with the same name as the superclass, even the type is not the same 
 *    				  		it will hide it, it's not recommended, because it makes the code more difficult to read.
 *    
 *    					- to access to these hidden fields,we use super.
 *     					- the same thing for accessing the superclass's constructor or overrided methods.
 *     					- we can refer to the suerclass's constructor using super(args list), it must be the first instruction called.
 *     
 */
class SuperClass{
	protected int a ; 
	protected int b ;
	protected int c ;
	public SuperClass(int b, int c) { 
		this.b = b;
		this.c = c;
		a = 10;
	}
	
	
}
class SubClass extends SuperClass {
	
	protected String a;
	
	public SubClass(int b, int c) {
		super(b, c); 
		a = "subclass";
	}
	
	public  void foo(){
		System.out.println(a);
	}
	public void fake(){
		System.out.println(super.a);
	}

	@Override
	public String toString() {
		return "SubClass [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	 
}
public class InheritanceExample_3 {

	public static void main(String[] args) {
		// case 1 : the a is hidden
		SubClass s = new SubClass(1,2);
		s.foo();
		
		// case 2 : access a superclass hidden field
		s.fake();
		
		// case 3 : super as constructor
		System.out.println(s);
	}
}
