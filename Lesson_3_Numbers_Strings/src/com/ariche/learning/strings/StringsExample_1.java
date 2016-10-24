package com.ariche.learning.strings;

/***
 * 
 *  Strings :
 *  	1- formating 
 *  	2- comparing
 *		3- StringBuffer
 *		Note: There is also a StringBuffer class that is exactly the same as the StringBuilder class, 
 *			 except that it is thread-safe by virtue of having its methods synchronized.
 *		
 *		More details : http://docs.oracle.com/javase/tutorial/java/data/index.html 
 */

public class StringsExample_1 {

	public static void main(String[] args) {
		// 1 formating
		String fs;
		fs = String.format("The value of the float " +
		                   "variable is %f, while " +
		                   "the value of the " + 
		                   "integer variable is %d, " +
		                   " and the string is %s",
		                   5.66, 77, "home");
		System.out.println(fs);
		
		//2 comparing
		String searchMe = "Green Eggs and Ham";
		String findMe = "Eggs";
		int searchMeLength = searchMe.length();
		int findMeLength = findMe.length();
		boolean foundIt = false;
		for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
			if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
				foundIt = true;
				System.out.println(searchMe.substring(i, i + findMeLength));
				break;
			}
		}
		if (!foundIt)
			System.out.println("No match found.");
	    
		// 3 StringBuffer
		String palindrome = "Dot saw I was Tod";
        
        StringBuilder sb = new StringBuilder(palindrome);
        
        sb.reverse();  // reverse it
        
        System.out.println(sb);
	}
}
