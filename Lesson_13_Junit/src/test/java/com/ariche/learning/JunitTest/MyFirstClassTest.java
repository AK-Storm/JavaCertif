package com.ariche.learning.JunitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ariche.learning.Junit.MyFirstClass;

public class MyFirstClassTest {

	@Test
	public void multipShouldReturnZero() {
		MyFirstClass tester = new MyFirstClass();
		assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
		assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
		assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
		
	}
	@Test (expected = Exception.class)
	public void exceptionShouldBeOK(){
		int a = 1/0; 
	}
}
