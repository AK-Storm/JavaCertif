package com.ariche.learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/***
 *		Reflection : dynamic objects using.  
 *
 */

class MyClass {
	
	public MyClass() {
		System.out.println("calling the no-args constructor ");
	}
	public MyClass(boolean a,String s){
		System.out.println("calling constructor with a :"+a+" , s :"+s);
	}
	public void foo(){
		System.out.println("foo method");
	}
	public int myMethod(){
		System.out.println("myMethod no args version");
		return 1;
	}
	public int myMethod(String a){
		System.out.println("myMethod  args version a "+a);
		return 2;
	}
	public int myMethod(String a,Integer i){
		System.out.println("myMethod  args version a "+a+" i "+i);
		return 3;
	}
	public static void myStaticMethod(){
		System.out.println("myStatic method"); 
	}
	private void myPrivateMethod(){
		System.out.println("myPrivateMethod ");
	}

	public void myMethoExeption(int param1) {
		System.out.println("myMethoExeption with int:" + param1);
		if (param1 == 10) {
			throw new IllegalStateException("the value 10 is not allowed here ");
		}
	}
}
public class ReflectionExample_3 {

	public static void main(String[] args) throws Exception{
		
		 // 1- creating objects dynamically 
		 // a - using newInstance() (Class one): only no-args constructor could be used.
		
		Class<MyClass> classe = (Class<MyClass>) Class.forName("com.ariche.learning.reflection.MyClass"); 
		MyClass instance1 = (MyClass) classe.newInstance(); 
		instance1.foo();
		
		 // b - using Constructor 
		 // we have to pass a table of classes that contains class of types to select the appropriate constructor
		 // when calling newInstance() (Constructor one) ; we have to pass a table of object (values)
		Constructor<MyClass> constructeur = classe.getConstructor(new Class[] {boolean.class, Class.forName("java.lang.String") });
		MyClass instance2 = (MyClass) constructeur.newInstance(new Object[] {Boolean.FALSE, "nom instance" });
		instance2.foo();
		
		// 2- invoking methods
		
		Object retour = executerMethode(instance2, "myMethod", null);
		System.out.println("return value  = " + retour);
		retour = executerMethode(instance2, "myMethod", new Object[] { "chaine1" });
		System.out.println("return value  = " + retour);
		retour = executerMethode(instance2, "myMethod", new Object[] { "chaine", 99 });
		System.out.println("return value  = " + retour);
		
		// static method
		Method staticMethod = classe.getDeclaredMethod("myStaticMethod", null); 
		staticMethod.invoke( new Object[0]);
		// private method 
		// by default we could not the access private methods IllegalAccessException is thrown
		// to avoid the access verification  we force the method.setAccessible(true);
		
		Method privateMethod = classe.getDeclaredMethod("myPrivateMethod", null); 
		privateMethod.setAccessible(true);
		privateMethod.invoke(instance2, new Object[0]);
		
		// Exception handlen with invoke 
		// the method throws an exception invoke will throw java.lang.reflect.InvocationTargetException.
		// to see the real Exception we have to use cause()
		try {
			Method m = classe.getMethod("myMethoExeption", Integer.TYPE);
			System.out.format("myMethoExeption : %s%n", m.toGenericString());
			m.invoke(instance2, Integer.valueOf(10));
		} catch (InvocationTargetException ex) { 
			Throwable cause = ex.getCause();
			System.out.println("Cause : " + cause.getMessage());
		}
		
		
	}

	public static Object executerMethode(Object objet, String nomMethode, Object[] parametres) throws Exception {
		Object retour;
		Class[] typeParametres = null;

		if (parametres != null) {
			typeParametres = new Class[parametres.length];
			for (int i = 0; i < parametres.length; ++i) {
				typeParametres[i] = parametres[i].getClass();
			}
		}
		else{
			
			// we have to send a empty table to invoke to avoid a warning from the compiler
			parametres = new Object[0];
		}

		Method m = objet.getClass().getMethod(nomMethode, typeParametres);
		if (Modifier.isStatic(m.getModifiers())) {
			retour = m.invoke(null, parametres);
		} else {
			retour = m.invoke(objet, parametres);
		}
		return retour;
	}
}
