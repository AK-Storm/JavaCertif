package com.ariche.learning.chars;

/***
 * 
 * 		Character :
 * 		1- java.lang.Character provide a wrapper to char primitive type 
 * 		2- it has the option of auto-boxing\ unboxing
 *		3- see below the methods 
 */
public class Characters_Example {
	
	public static void main(String[] args) {
		
		Character a = 'a';
		System.out.println(Character.isLetter(a));
		System.out.println(Character.isDigit(a));
		System.out.println(Character.isWhitespace(a));
		System.out.println(Character.isUpperCase(a));
		System.out.println(Character.isLowerCase(a));
		System.out.println(Character.toUpperCase(a));
		System.out.println(Character.toLowerCase(a));
		System.out.println(Character.toString(a));
	} 
}
