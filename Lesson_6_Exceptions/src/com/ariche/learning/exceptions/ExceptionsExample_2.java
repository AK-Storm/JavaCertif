package com.ariche.learning.exceptions;

import java.util.Enumeration;
import java.util.zip.ZipEntry;

/**
 * 		The try-with-resources Statement : (jdk 7 and later)
 * 		- is used to solve the closing problem that happen when an exception occurs and we could not close the opened resource.
 * 		- it can be used with any class that implements java.lang.AutoCloseable or his subInterface java.io.Closeable.
 * 		- it could support more than one resource
 * 
 */
public class ExceptionsExample_2 {

	public static void main(String[] args) throws Exception{
		java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get("outputFileName");

		// Open zip file and create output file with
		// try-with-resources statement

		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile("zipFileName");
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
			// Enumerate each entry
			for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}
}
