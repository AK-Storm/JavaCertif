package com.ariche.learning.JunitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ariche.learning.Junit.MySecondClass;

public class MySecondClassTest {

	@Test
	public void addShouldBeCorrect() {
		MySecondClass tester = new MySecondClass();
		assertEquals("1 + 2 must be 3", 3, tester.addition(1, 2)); 
	}
}
