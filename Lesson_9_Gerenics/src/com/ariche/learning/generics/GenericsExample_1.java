package com.ariche.learning.generics;

/**
 * 
 * 		Generic :
 *  
 * 		1- A generic type is declared by class name<T1, T2, ..., Tn> {  }, where the Ti are called type parameters
 * 		
 * 		2- A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.
 * 		
 * 		3- Type parameters naming conventions :	
 * 				he most commonly used type parameter names are:
 *				E - Element (used extensively by the Java Collections Framework)
 *				K - Key
 *				N - Number
 *				T - Type
 *				V - Value
 *				S,U,V etc. - 2nd, 3rd, 4th types.
 *					
 *		4- Terminology 
 *				- Generic type invocation: Box<Integer> e ,just declaration,also known as parameterized type
 *				- Type parameter (when declaring the generic type class)n is not type argument (when using it with a specific type)
 *				- Diamond : for jdk 7 and later we can omit the argument in the constructor and put an empty <> (diamond)
 *					ex : Box<Integer> e = new Box<Integer>(); equivalent to Box<Integer> e = new Box<>();
 *  	
 *  	5- Raw type : means using generic type without parameter ex : Box e = new Box();
 *  				 the compiler will display a warning each time we use them.
 *  
 *  	6- Generic methods: we can also declare generic methods, but we have to specify the type before the return type.
 *  
 */






class Box<T> { 
    private T t; 
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}



class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}

class Pair<K, V> {

	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
 
public class GenericsExample_1 {

	public static void main(String[] args) {
		// generic type
		Box<Integer> e = new Box<>(); 
		e.set(58);
		System.out.println(e.get());
		// generic method
		Pair<Integer, String> p1 = new Pair<>(1, "apple");
		Pair<Integer, String> p2 = new Pair<>(2, "pear");
		// when using we should indicate the types 
		boolean AreSame = Util.<Integer, String>compare(p1, p2);
		System.out.println(AreSame);
		// if we don't indicate them the compiler will  infer the type that is needed ==> inference
		boolean AreEq = Util.compare(p1, p2);
		System.out.println(AreEq);		
	}

}
