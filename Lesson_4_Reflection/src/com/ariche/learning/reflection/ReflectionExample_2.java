package com.ariche.learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/***
 *        Reflection : using Class object methods.
 */
public class ReflectionExample_2 {

	public static void main(String[] args) throws Exception {

		System.out.println("using Class object methods");

		// a - getSuperClass() : getting super-classes
		String s = "test";
		Class cl = s.getClass();
		Class superClass = cl.getSuperclass();
		System.out.println(superClass.getName());

		// b - getModifiers : getting constants that refere to private
		// ,public,protected ...
		// we use it with the Modifier class that give lot of methods to test
		// these constants

		int modifier = cl.getModifiers();
		if (Modifier.isPublic(modifier)) {
			System.out.println("the class is public");
		}
		if (Modifier.isFinal(modifier)) {
			System.out.println("the class is final");
		}
		if (Modifier.isStatic(modifier)) {
			System.out.println("the class is static");
		}

		// ...
		// isAbstract,isInterface,isNative,isPrivate,isProtected,isPublic,isStatic,isSynchronized,isTransient,isVolatile

		// c - getInterfaces : getting all the interfaces that the class
		// implements
		Class[] interfaces = cl.getInterfaces();
		System.out.println("String implements : ");
		for (Class i : interfaces) {
			System.out.println(" -> " + i.getName());
		}

		// d -Field[] getFields() : get all the public attributs of a class
		// see also Class getDeclaringClass(),int getModifiers(),Object
		// get(Object),
		System.out.println("public string's attributes :");
		Field[] champs = cl.getFields();
		for (Field champ : champs) {
			System.out.println(
					"Name :" + champ.getName() + " Type : " + champ.getType().getName() + " Value " + champ.get(champ));
		}

		// e - Constructor[] getConstructors(): get constructors
		// Constructor methods : String getName(),Class[]
		// getExceptionTypes(),Class[] getParametersType(),int
		// getModifiers(),Object newInstance(Object[])
		System.out.println("String's constructors ");
		Constructor[] constructors = cl.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.getName() + rechercheParametres(constructor.getParameterTypes()));
		}

		// f - Method[] getMethods() : give us all public methods
		// Method methods : Class[] getParameterTypes,Class getReturnType,String
		// getName(),int getModifiers()
		// Class[] getExceptionTypes,Class getDeclaringClass[]
		// see also getDeclaredMethods : give all methods not only public
		System.out.println("String's public methods");
		Method[] methods = cl.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName() + rechercheParametres(method.getParameterTypes()));
		}

		// g- Getters\Setters

		System.out.println("getters \\setters : ");
		for (Method method : methods) {
			if (isGetter(method)) {
				System.out.println("  getter : " + method);
			}
			if (isSetter(method)) {
				System.out.println("  setter : " + method);
			}
		}

	}

	// utils
	private static String rechercheParametres(Class[] classes) {
		/***
		 * getName() returns some codes: primitives B -> byte C -> char D ->
		 * double F -> float I -> int J -> long S -> short Z -> boolean Objects
		 * : LclassName; tables : { [ }n type : n the number of [ is the
		 * dimension ex : float[12][5] -> [[float
		 */

		StringBuffer param = new StringBuffer("(");

		for (int i = 0; i < classes.length; i++) {
			param.append(formatParametre(classes[i].getName()));
			if (i < classes.length - 1)
				param.append(", ");
		}
		param.append(")");

		return param.toString();
	}

	private static String formatParametre(String s) {

		if (s.charAt(0) == '[') {

			StringBuffer param = new StringBuffer("");
			int dimension = 0;
			while (s.charAt(dimension) == '[')
				dimension++;

			switch (s.charAt(dimension)) {
			case 'B':
				param.append("byte");
				break;
			case 'C':
				param.append("char");
				break;
			case 'D':
				param.append("double");
				break;
			case 'F':
				param.append("float");
				break;
			case 'I':
				param.append("int");
				break;
			case 'J':
				param.append("long");
				break;
			case 'S':
				param.append("short");
				break;
			case 'Z':
				param.append("boolean");
				break;
			case 'L':
				param.append(s.substring(dimension + 1, s.indexOf(";")));
			}

			for (int i = 0; i < dimension; i++)
				param.append("[]");

			return param.toString();
		} else
			return s;

	}

	public static boolean isGetter(Method method) {
		boolean result = method.getName().startsWith("get") && (method.getParameterTypes().length == 0)
				&& (!Void.class.equals(method.getReturnType()));
		return result;
	}

	public static boolean isSetter(Method method) {
		boolean result = (method.getName().startsWith("set")) && (method.getParameterTypes().length == 1);
		return result;
	}
}
