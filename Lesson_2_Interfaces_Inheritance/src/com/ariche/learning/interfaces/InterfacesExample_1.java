package com.ariche.learning.interfaces;

/**
 * 		Interface = contract
 * 		
 *		1- An interface can contain : constants , abstract methods(general purpose), nested types ,default methods,static methods.
 *
 * 		2- Method bodies exist only for default methods and static methods.
 * 
 * 		3- An interface can extend one interface or lot of interfaces.
 * 
 * 		4- All interface's methods are implicitly public, we can omit the public modifier for members.
 * 
 *   	5- All constant values defined in an interface are implicitly public, static, and final. Once again, you can omit these modifiers.
 *   
 *   	6- When you define a new interface, you are defining a new reference data type. You can use interface names anywhere you can use any other data type name.
 *   	
 *   	7- To add a method in an interface, and avoid change the classes that implements this interface
 *   			a) create a new interface that extends the old one and add the new method in it 
 *   		    b) create a static method in the interface
 *   			c) create a default method in the interface
 *   
 * 		8- When you extend an interface that contains a default method, you can do the following:
 * 				a) Not mention the default method at all, which lets your extended interface inherit the default method.
 * 				b) Redeclare the default method, which makes it abstract.
 * 				c) Redefine the default method, which overrides it.
 * 		
 *
 */

interface DoIt{
	void doSomething();
	
	static void doItRight(){
		System.out.println("this is a static method ");
	}
	default void doNow(){
		System.out.println("this is a default method");
	}
}
public class InterfacesExample_1 implements DoIt {

	@Override
	public void doSomething() {
		System.out.println("overrided method");
	}

	public static void main(String[] args) {
		// to call a static method in interface we have to use the following syntax
		// Interface.StaticMethod
		// not InterfacesExample_1.StaticMethod
		DoIt.doItRight();
		InterfacesExample_1 m = new InterfacesExample_1();
		m.doNow();
		m.doSomething();
	}
}
