package com.ariche.learning.reflection;

/**
 * 			Reflection : getting Class object.
 */

public class ReflectionExample_1 {

	public static void main(String[] args) throws Exception {
		System.out.println("getting Class object");
		// a- using the getClass method inherited from Object class
		String s = "test";
		Class cl1 = s.getClass();
		System.out.println(cl1.getName());

		// b- using forName(String class name) the class name,exception
		// ClassNotFoundException is thrown if it does'nt exist
		Class cl2;
		try {
			cl2 = Class.forName("java.lang.String");
			System.out.println(cl2.getName());
		} catch (ClassNotFoundException e) {
			System.out.println("the class doesn't exist !!");
		}

		// c- using class
		Class cl3 = String.class;
		System.out.println(cl3.getName());
	}

}
