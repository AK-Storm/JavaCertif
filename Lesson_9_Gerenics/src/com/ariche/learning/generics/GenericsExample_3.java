package com.ariche.learning.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 *  		Type inference: ability to look at each method invocation and corresponding declaration to determine the type argument.
 *  		1- Type Inference and Generic Methods (see the GenericsExample_1)
 *  		2- Type Inference and Instantiation of Generic Classes (diamond )
 *  		3- Type Inference and Generic Constructors of Generic and Non-Generic Classes 
 *  		4- Target Types inference
 *
 */
class MyClass<X> {
	<T> MyClass(T t) {
		System.out.println("T : "+t.getClass().getName());
	}
}
class Utils{
	public static <T> List<T> emptyList(){
		return new ArrayList<>(); 
	}
	public static void processStringList(List<String> stringList) {
	    // process stringList
	}
}
public class GenericsExample_3 {
	
	public static void main(String[] args) {
		
		// 2- Type Inference and Instantiation of Generic Classes
		Map<String, List<String>> myMap_1 = new HashMap<String, List<String>>();
		// is equivalent to diamond supported for jdk7 and later 
		Map<String, List<String>> myMap_2 = new HashMap<>();
		
		// 3-  Type Inference and Generic Constructors of Generic and Non-Generic Classes 
		// in the following example the compiler detected that X is Integer  (motioned )
		// and the from the constructor's argument "" T : String
		MyClass<Integer> myclass = new MyClass("");
		// equivalent to
		MyClass<Integer> myclass2 = new<String> MyClass<Integer>("");
		
		//4- Target Types inference 
		
		// 4-a  assignment statement
		List<String> listOne = Utils.emptyList(); 
		// is equivalent to (because the compiler know that we have a List<String> in assignment)
		List<String> listTwo = Utils.<String>emptyList();
		
		// 4-b as argument to a method
		// the compiler know that the method processStringList has List<String> as argument 
		Utils.processStringList(Utils.emptyList());
		// equivalent to
		Utils.processStringList(Utils.<String>emptyList());
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		printList(l);
	}

	public static <T>void printList(List<T> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}
	
}

