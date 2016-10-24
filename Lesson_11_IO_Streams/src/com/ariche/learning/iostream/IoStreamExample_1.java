package com.ariche.learning.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 		I\O Streams :
 * 
 * 		1-There are two types of streams :
 * 			a- Byte streams : Programs use byte streams to perform input and output of 8-bit bytes.
							  All byte stream classes are descended from InputStream and OutputStream.
							  
			b- Character Streams : Programs use character streams to perform input and output of 16-bit bytes.
							  All byte stream classes are descended from Reader and Writer.
							  
		2- java.io classes : the stream classes' names are composed from two parts : prefix + suffix :
			a- suffix (4) : refer to the stream types (byte or char) and the direction (i\o)  
					Character stream : Reader,Writer
					Byte Stream 	 : InputStream,OutputStream
					
			b- prefix : there are two types of prefixes :
			
					  --> data types : ByteArray,CharArray,File,pipe, Object,String.
					  --> filters (treatment) : Buffer,Sequence,Data,LineNumber,PushBack,Print,Object.
					  
			 ex : BufferWriter,DataOutputStream ... (not all combination are possible)
			 	   (see the complete list : http://www.jmdoudoux.fr/java/dej/chap-flux.htm#flux) 
 * 
 *
 */

// Character Stream : see charStreamReader.gif,charStreamWriter.gif
class CharacterStreamDemo{
	// Reader,and Writer are two abstract classes that define some methods
	
	private static final String RESOURCES_XANADU_TXT = "resources\\file\\xanadu.txt";
	private static final String RESOURCES_CHARACTEROUTPUT_TXT = "resources\\file\\characteroutput.txt";

	// Example-1- with File data source : FileWriter ,FileReadder that extends Writer,Reader 
	public static void simpleFileCharStreamDemo() throws IOException {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			fileReader = new FileReader(RESOURCES_XANADU_TXT);
			fileWriter = new FileWriter(RESOURCES_CHARACTEROUTPUT_TXT);

			int c;
			// here read return data in the last 16 bits
			while ((c = fileReader.read()) != -1) {
				fileWriter.write(c);
			}
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
	
	//  Example-2- Buffer treatment on file reading and write lines
	// BufferedReader,BufferedWriter take a Reader ,Writer stream in argument in constructor
	
	public static void bufferCharStream() throws IOException{
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(RESOURCES_XANADU_TXT));
			bufferedWriter = new BufferedWriter(new FileWriter(RESOURCES_CHARACTEROUTPUT_TXT));

			String l;
			// readLine read one line
			while ((l = bufferedReader.readLine()) != null) {
				bufferedWriter.write(l);
				bufferedWriter.newLine();
			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	} 
}


// Byte Stream : see byteStreamInput.png,byteStreamOutput.gif
class ByteStreamDemo {

	private static final String OUTAGAIN_TXT = "resources\\file\\outagain.txt";
	private static final String XANADU_TXT = "resources\\file\\xanadu.txt";

	// Example 1- File reading and writing
	public static void simpleFileByteStreamDemo() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream(XANADU_TXT);
			out = new FileOutputStream(OUTAGAIN_TXT);
			int c;
			// c store the information
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	// Example 2 - Data streams : support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values. 
	// there are two interfaces : DataInput and DataOutput , that are implemented by DataInputStream ,DataOutputStream
	// for each primitive types there are a method to read and another to write
	// ex : int readInt,writeInt, string readUTF, writeUTF
	
	public static void dataStreamDemo() throws IOException {
		final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		final int[] units = { 12, 8, 13, 29, 50 };
		final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

		// writing
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(OUTAGAIN_TXT)));
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// reading
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(OUTAGAIN_TXT)));

			while (true) {
				double price = in.readDouble();
				int unit = in.readInt();
				String desc = in.readUTF();
				System.out.format("You ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
			}
		}
		// DataStreams detects an end-of-file condition by catching
		// EOFException, instead of testing for an invalid return value.
		// All implementations of DataInput methods use EOFException instead of
		// return values.
		catch (EOFException e) {
			in.close();
		}
	}
	
	// Example 3 - Object Stream : is used to serialize objects and deserialize them after 
	// there are two interfaces  ObjectInput , ObjectOutput that all object Stream classes implements  (ObjectInputStream and ObjectOutputStream)
	// Serialize interface is an marker interface (which deosn't have any method or constant)
	// we use transient keyword to say that is variable is not to save when serializing like password
	public static void serializeObject(Object obj,String fileName)throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close(); 
	}
	public static Object deserializeObject(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
	}
} 
public class IoStreamExample_1 {

	private static final String RESOURCES_FILE_USER_DAT = "resources\\file\\user.dat";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//CharacterStreamDemo.simpleReadWritedemo();
		//CharacterStreamDemo.bufferCharStream();
		//ByteStreamDemo.simpleFileByteStreamDemo();
		//ByteStreamDemo.dataStreamDemo();
		User user = new User("khalid","ariche","123456");
		ByteStreamDemo.serializeObject(user, RESOURCES_FILE_USER_DAT);
		user = (User) ByteStreamDemo.deserializeObject(RESOURCES_FILE_USER_DAT);
		System.out.println(user); 
	}

}
