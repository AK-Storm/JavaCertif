package com.ariche.learning.inheritance;

/**
 *  	The object superclass's methods : 
 *  
 * 		1- clone : - The clone method test if the class is implementing Cloneable interface if it doesn't an CloneNotSupportedException 
 * 				   is thrown.
 * 		
 * 				   - The default behavior is to clone the values of primitives and references of objects (it's not good).
 * 
 * 	   	2- hashCode,equals : the hashCode's default behavior is to return object's address,so when we compare two objects with equals
 * 							(default behavior) will compare thier hashcode, so to override(of equals) this behavior we need to override 
 * 							the hashCode method too.
 * 
 * 		3- finalize : this method is called generally when the garbage collector need to free the memory of this object, but when it is called, or even if it is called, is uncertain. 
 * 		
 * 		4- getClass : return Class class that contain lot of methods that provide information about the class  
 * 		   
 * 	
 *
 */

class Fake implements Cloneable{
	
	private String foo ;
	
	public Fake(String foo) { 
		this.foo = foo;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException { 
		return new Fake(foo);
	}
		
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize is called !!");
	}
}

public class InheritanceExample_4 {
	
		public static void main(String[] args) throws CloneNotSupportedException {
			Fake f = new Fake("fake");
			Fake clone = (Fake) f.clone();
			
			// we see that we have two different references 
			System.out.println(f);
		    System.out.println(clone); 
		    
		    // getClass method
		    Class info = f.getClass();
		    System.out.println(info.getSimpleName());
		    System.out.println(info.isAnnotation());
		    System.out.println(info.isInterface());
		    //...
		}
}
