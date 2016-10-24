package com.ariche.learning.generics;

/**
 * 		Generic:
 * 		
 * 		1- Bounded Type Parameters : if we want  to restrict the types that can be used as type arguments in a parameterized type.
 *         we used extends to specify that only the class and his subclasses are possible to be used.
 *         <T extends A> : T must be A subclass or A (A could be a class or an interface)
 *      2- Multiple Bounds: we can specify that the class could be a subclass of many other , we have to put the class first,to avoid a compilation error
 *      		Class A {   }
				interface B {  }
				interface C {   }

				class D <T extends A & B & C> {  }
		3- Generic Methods and Bounded Type Parameters,also methods could use bounds 		
 * 		    
 * 
 *   
 * 
 *
 */
class Boxy<T> {

    private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)  // we could not make e > elem because > is only available for primitives 
            							// so we have ensure that T implements comparable 
                ++count;
        return count;
    }
}

public class GenericsExample_2 {

	public static void main(String[] args) {
		
		Boxy<Integer> integerBox = new Boxy<Integer>();
        integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!
        integerBox.inspect(57); 
        // methods bounds
        Integer[] array = {1,2,3,4,5};
        int c = Boxy.countGreaterThan(array, 2);
        System.out.println(c);
        
        
	}
}
