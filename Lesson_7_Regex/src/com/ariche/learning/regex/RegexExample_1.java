package com.ariche.learning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/***
 * 		Regular expressions 
 * 
 * 		1- Character classes : 
 * 				a - Simple classes : [abc] means a or b or c 
 * 				b - Negation : [^abc] means not a , b ,c
 * 				c - Ranges : [a-z],[a-zA-Z]
 * 				d - Union :  [a-c[u-z]]
 * 				e - Intersection : [a-c && [u-z]]
 * 				g - Subtraction : [a-c && [^u-z]]
 * 
 * 		2- Predefined Character Classes :
 * 				a - . any character 
 * 				b - \d any number ,\D is [^\d]
 * 				c - \s any space character ,\S is [^\s]
 *				d - \w equivalent to [a-zA-Z_0-9]  ,\W is [^\w]
 *          Note : to get the code compiled we have to escape the \ because only Invalid escape sequence are (  \b  \t  \n  \f  \r  \"  \'  \\ )
 *                  so when we write \d it's not going to be compiled,we have to write \\d.
 *                  
 *      3- Qualifiers: allow you to specify the number of occurrences to match against there are three types of qualifiers :
 *      
 *      		a - greedy : read the entire word and compare it with the regex,if not matched back off one char and try again,repeat until the word is done.
 *      		b - reluctant : start at the beginning of the input string, then reluctantly eat one character at a time looking for a match. The last thing they try is the entire input string.
 *      		c - possessive :  read the entire input string, trying once (and only once) for a match.
 *          			
 *          <table>
			<tr><td>Greedy</td>	<td>Reluctant</td>	<td>Possessive</td>	<td>Meaning</td></tr>
			<tr><td>X?</td><td>	X??	</td><td>X?+	</td><td>X once or not at all</td></tr>
			<tr><td>X*</td><td>	X*?	</td><td>X*+	</td><td>X, zero or more times</td></tr>
			<tr><td>X+</td><td>	X+?	</td><td>X++	</td><td>X, one or more times</td></tr>
			<tr><td>X{n}</td><td>	X{n}?</td><td>	X{n}+	</td><td>X, exactly n times</td></tr>
			<tr><td>X{n,}</td><td>	X{n,}?</td><td>	X{n,}+	</td><td>X, at least n times</td></tr>
			<tr><td>X{n,m}</td><td>	X{n,m}?</td><td>	X{n,m}+	</td><td>X, at least n but not more than m times</td></tr>
			</table>
			
 *      4- Capturing Groups & Backreferences : 
 *      		a- capturing is making groups with parenthesis ex :((A)(B(C)) gives four groups
 *      			((A)(B(C)) ,A , (B(C),(C)
 *              b- backreference : means who many a captured group is gonning to be repeated (it's indicated by \n)
 *              	ex : (\d\d)\1 means two degits and the same group is repeated 1 time : 1212 ok ,1234 ko
 *      			
 *      
 *      5- Boundary Matchers : are used to specify the positions 
 *      	 ^	: The beginning of a line
			 $	: The end of a line
			\b	: A word boundary
			\B	: A non-word boundary
			\A	: The beginning of the input
			\G	: The end of the previous match
			\Z	: The end of the input but for the final terminator, if any
			\z	: The end of the input
			
			
	  	6- Pattern Class : 
	  		a- compile :static method that has two versions , compile(String pattern) and compile(String pattern,flag)
	  		   flags are some options that we specify before compiling (Pattern.CASE_INSENSITIVE,Pattern.COMMENTS ...)
	  		   we can combine as many as we want ,with |
	  		    pattern = Pattern.compile("[az]$", Pattern.MULTILINE | Pattern.UNIX_LINES)
	  		    or we could specify them in the pattern :
	  		   	pattern =  Pattern.compile("(?i)foo")
	  		    for more information https://docs.oracle.com/javase/tutorial/essential/regex/pattern.html
	  		    
	  		 b-  matches(String,CharSequence) ,test a match Pattern.matches("\\d","1")
	  		 c- split(String): split with a regex
	  		 d- public static String quote(String s) : take a string and propose a pattern to it
	  		 e- public String toString() : get the pattern's string
	  	  	 
	  7- Matcher class : 
	  		a- start / end return the place where the pattern start and end in the string 
	  		b- public boolean find(): Attempts to find the next subsequence of the input sequence that matches the pattern.
	  		c- lookingAt ,matches : try to match the pattern with the string ,matches compare the whole word,lookingAt does not
	  		d- replaceFirst(String) and replaceAll(String)
	  		
	   Note : there are some methods equivalent to those in java.lang.String matches,split ,replace ...
	   
	  8- PatternSyntaxException  Exception
	  		a- public String getDescription(): Retrieves the description of the error.
			b- public int getIndex(): Retrieves the error index.
			c- public String getPattern(): Retrieves the erroneous regular expression pattern.
			d- public String getMessage(): Returns a multi-line string containing the description of the syntax error and its index, the erroneous regular-expression pattern, and a visual indication of the error index within the pattern. 
 */


 
public class RegexExample_1 {

	public static void main(String[] args) {
		
		System.out.println("Pattern Class demo");
		patternDemo();
		System.out.println("*****************************************************************************************");
		System.out.println("Matcher Class demo");
		matcherDemo();
		System.out.println("*****************************************************************************************");
		System.out.println("PatternSyntaxException demo");
		patternSyntaxExceptionDemo();
	}
	
	public static void patternDemo(){
		// compile static method and pattern flags
		Pattern pattern = Pattern.compile("dog", Pattern.CASE_INSENSITIVE); // equivalent
																			// to
																			// Pattern.compile("(?i)dog");
		Matcher matcher = pattern.matcher("blaDogbla");
		matcher.find();
		System.out.println("yes it match start at " + matcher.start() + " end at " + matcher.end());

		// matches
		boolean find = Pattern.matches("^(06)[0-9]{2}\\-[0-9]{6}$", "0603-065769");
		if (find) {
			System.out.println("yes it's match");
		}

		// split
		Pattern p = Pattern.compile("\\d");
		String[] items = p.split("one9two4three7four1five");
		for (String s : items) {
			System.out.println(s);
		}
			     
	}
	
	public static void matcherDemo(){
		// matches vs lookingAt
		String REGEX = "foo";
		String INPUT = "fooooooooooooooooo";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(INPUT);

		System.out.println("Current REGEX is: " + REGEX);
		System.out.println("Current INPUT is: " + INPUT);

		System.out.println("lookingAt(): " + matcher.lookingAt());
		System.out.println("matches(): " + matcher.matches());

		// replaceFirst(String) and replaceAll(String)
		REGEX = "dog";
		INPUT = "The dog says meow. All dogs say meow.";
		String REPLACE = "cat";

		pattern = Pattern.compile(REGEX);
		Matcher m = pattern.matcher(INPUT);
		System.out.println(m.replaceAll(REPLACE));
		System.out.println(m.replaceFirst(REPLACE));
	}
	
	public static void patternSyntaxExceptionDemo(){

		 
		try {
			Pattern pattern = Pattern.compile("?i)");
		} catch (PatternSyntaxException pse) {
			System.out.printf("There is a problem" + " with the regular expression!%n");
			System.out.printf("The pattern in question is: %s%n", pse.getPattern());
			System.out.printf("The description is: %s%n", pse.getDescription());
			System.out.printf("The message is: %s%n", pse.getMessage());
			System.out.printf("The index is: %s%n", pse.getIndex());
			System.exit(0);
		}
	}
}
