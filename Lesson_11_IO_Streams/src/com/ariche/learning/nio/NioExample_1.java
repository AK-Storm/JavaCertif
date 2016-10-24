package com.ariche.learning.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 		NIO - Path 
 * 		1- creating a Path class 
 * 
 * 		2- retrieving Information about a Path:
 * 		the path object is organized like a table of element, each element is a level example :
 * 		C:\Users\pc\logs\foo.log == > [Users,pc,logs,foo.log]
 *      
 *      3- other operations :
 *      	a - retrieve the real path without the . and .. toRealPath(),The file need to exist for this method to work.
 *      	b - convert the path to String  that can be opened from a browser : toUri()
 *      	c - to get the absolute path : toAbsolutePath  ,The file does not need to exist for this method to work.
 *			d - join two paths : resolve,Passing an absolute path to the resolve method returns the passed-in path
 * 			e - to create a relative to a path : source.relativize(dest);
 * 			f - comparing : equals ,startsWith ,endsWith.
 * 
 * 	    4- Path implements Comparable,and Iterator
 * 
 * 
 */
public class NioExample_1 {
 
	public static void main(String[] args) throws IOException { 
		// 1 - the get method take in parameter a list of string to concatenate
				// them and create after that a Path object 
				String home = System.getProperty("user.home");
				Path firstPath = Paths.get(home, "logs", "foo.log");
				System.out.println(firstPath);
				// the same 
				Path secondPath = FileSystems.getDefault().getPath(home+"\\logs\\foo.log");
				System.out.println(secondPath);
				
				// 2
				System.out.println("path info");
				System.out.format("toString: %s%n", firstPath.toString());
				System.out.format("getFileName: %s%n", firstPath.getFileName()); 
				System.out.format("getName(0): %s%n", firstPath.getName(0));
				System.out.format("getNameCount: %d%n", firstPath.getNameCount());
				System.out.format("subpath(0,2): %s%n", firstPath.subpath(0,2));
				System.out.format("getParent: %s%n", firstPath.getParent());
				System.out.format("getRoot: %s%n", firstPath.getRoot());
				
				//3 
				firstPath = Paths.get(home+"\\logs\\.\\foo.log");
				Path realPath = firstPath.toRealPath();
				System.out.println(realPath);
				System.out.format("%s%n", realPath.toUri());
				System.out.println(realPath.resolve("foo2.log"));
				
				Path homePath = Paths.get(home);
				System.out.println(secondPath.relativize(homePath));
				if (firstPath.equals(secondPath)) {
				   System.out.println("Equals");
				} else if (firstPath.startsWith(home)) {
				   System.out.println("start with ");
				} else if (firstPath.endsWith(Paths.get("foo.log"))) {
				   System.out.println("End with");
				}
				// we iterate over paths' elements 
				for (Path path : firstPath) {
					System.out.println(path);
				}
	}
}
