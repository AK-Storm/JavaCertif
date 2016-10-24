package com.ariche.learning.environment;

import java.util.Map;

/**
 * 
 *  
 *
 */
public class EnvironmentExample_1 {

	public static void main(String[] args) {
//		Map<String, String> env = System.getenv();
//		for (String envName : env.keySet()) {
//			System.out.format("%s=%s%n", envName, env.get(envName));
//		}
		
		
		String value = System.getenv("path");
		if (value != null) {
			System.out.format("%s=%s%n", "path", value);
		} else {
			System.out.format("%s is" + " not assigned.%n", "path");
		}
	}

}
