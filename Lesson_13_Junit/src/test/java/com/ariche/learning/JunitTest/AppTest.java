package com.ariche.learning.JunitTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.ariche.learning.JunitTest.categories.CategoriesDemo_1;
import com.ariche.learning.JunitTest.categories.CategoriesDemo_2;

/**
 *      JUnit:
 *      
 *      - running automatically tests help to identify the regressions.
 *      
 *      - terminology : 
 *      			- an application under test .
 *      			- a code under test.
 *      			- test fixture (is the input to a method to test his behavior,or precondition)
 *      			- unit test is a written code that test a method or a class (test coverage) ,independently to external elements (use mock)
 *      			- integration tests : check that the whole system works as intended also called functional tests
 *      			- State testing is about validating the result. Behavior testing is about testing the behavior (interaction between methods).
 *		
 *		- name conventions : - classes should be suffixed with Test,and put in a package test.
 *							 - One possible convention is to use the word "should" in the test method name (ex : ordersShouldBeCreated).
 *							 - surfire maven plugin load automatically the classes suffixed with Test
 *							 - 
 *		- Test suites : we can organize test classes into a suite to be run in a specific order,
 *		
 *		- We can run test using the static method runClasses(),that return Result Object in This object can be used to retrieve information about the tests.
 *		
 *		- JUnit annotations : - @Test (expected = Exception.class) : the test have to throw this Exception or the test will fail
 *							  - @Test(timeout=100) 
 *							  - @Before \ @After : executed before \ after each test
 *							  - @BeforeClass \ @AfterClass : executed before the first test in a class \ after the last test in a class
 *  						  - @Ignore or @Ignore("description") : is used to ignore a test (useful if we made a change)
 *  
 *  	 - Assertion statements : - they are defined in the Assert class,the assert statements contains a description, an expected value ,and a result 
 *  							    if the comparison fail AssertionException is thrown.
 *  							  - fail(msg),assertTrue,assertFalse,assertEquals(val),assertNull,assertNotNull,assertSame,assertNotSame(ref)
 *  	 
 *  	 - Test order : the test execution order can be changed  by  @FixMethodOrder annotation with values 
 *  					- MethodSorters.NAME_ASCENDING : lexicographic order 
 *  					- declaration order MethodSorters.DEFAULT
 *  					- JVM order MethodSorters.JVM so it can be different from run to run
 *  
 *  	 - Disabling tests : we use the @ignore ,but we could use assumption
 *  						 Assume.assumeFalse  or Assume.assumeTrue
 *  					
 *  	 - Parameterized test : we can parameter data to test a testCase with many inputs for that {@link ParameterizedTestFields}
 *  			    and {@link ParameterizedTestFieldsWithConstructor}
 *  	 - Categories: It is possible to define categories of tests and include or exclude them based on annotations. 
 *        {@link CategoriesDemo_2} {@link CategoriesDemo_1}
 *
 */
public class AppTest { 
	public static void main(String[] args) {
		// creating a test runner 
		Result result = JUnitCore.runClasses(AllTests.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}
