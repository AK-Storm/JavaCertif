package com.ariche.learning.polymorphism;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * 		Polymorphism : mean that the JVM will call the  appropriate method for the object that is referred to in each variable.
 * 		 			   This behavior is referred to as virtual method invocation  
 *
 */


class A {
	public void foo(){
		System.out.println(" A : foo");
	}
}
class B extends A{
	@Override
	public void foo(){
		System.out.println(" B : foo");
	}
}
class C extends A{
	@Override
	public void foo(){
		System.out.println(" C : foo");
	}
}
public class PolymorphExample {
	
	public static void main(String[] args) {
		A a,b,c;
		a = new A();
		b = new B();
		c = new C();
		List<A> l = new ArrayList<>();
		l.add(a);
		l.add(b);
		l.add(c);
		for (A elt : l) {
			elt.foo();
		}
	}

}
