package com.ariche.learning.iostream;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/** 
 *     A- Scanner : Objects of type Scanner are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.
 *     	 		  1- By default the scanner use whitespace like separator to generate tokens.
 *     
 *     B- Formatting : to format streams there are two classes PrintWriter and PrintStream ,the provide two levels of formatting are provided:
 				  1- print and println format individual values in a standard way.
				  2- format formats almost any number of values based on a format string, with many options for precise formatting.
 *     			 (for more details see https://docs.oracle.com/javase/tutorial/essential/io/formatting.html)
 *     
 *     C- IO Standard : java has 3 elements for IO standard 
 *     		System.out,System.err :  PrintStream object
 *     		System.in : InputStreamReader object
 *     
 *     D - Console : is an alternative for IO Standard mostly used for passwords,to get the Console object (if the os support)
 *     		         we use System.console
 *     
 *  
 *
 */
public class IoStreamExample_2 {

	private static final String XANADU_TXT = "resources\\file\\xanadu.txt";
	
	public static void scannerReader() throws FileNotFoundException{
		Scanner s = null;

		try {
			
			s = new Scanner(new BufferedReader(new FileReader(XANADU_TXT)));
			// to modify the scanner's default separator ,here is a comma followed by whitespace
			s.useDelimiter(",\\s*");
			// to set the local support
			s.useLocale(Locale.US);
			
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}	
	// to test outside the IDE
	public static void consoleDemo() {
		Console c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}

		String login = c.readLine("Enter your login: ");
		char[] oldPassword = c.readPassword("Enter your old password: ");

		if (verify(login, oldPassword)) {
			boolean noMatch;
			do {
				char[] newPassword1 = c.readPassword("Enter your new password: ");
				char[] newPassword2 = c.readPassword("Enter new password again: ");
				noMatch = !Arrays.equals(newPassword1, newPassword2);
				if (noMatch) {
					c.format("Passwords don't match. Try again.%n");
				} else {
					change(login, newPassword1);
					c.format("Password for %s changed.%n", login);
				}
				Arrays.fill(newPassword1, ' ');
				Arrays.fill(newPassword2, ' ');
			} while (noMatch);
		}

		Arrays.fill(oldPassword, ' ');
	}

	// Dummy change method.
	static boolean verify(String login, char[] password) {
		// This method always returns
		// true in this example.
		// Modify this method to verify
		// password according to your rules.
		return true;
	}

	// Dummy change method.
	static void change(String login, char[] password) {
		// Modify this method to change
		// password according to your rules.
	}
	public static void main(String[] args) throws FileNotFoundException {
		//scannerReader();
		consoleDemo();
	}
}
