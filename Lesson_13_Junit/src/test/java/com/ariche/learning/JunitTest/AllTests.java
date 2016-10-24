package com.ariche.learning.JunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MyFirstClassTest.class, MySecondClassTest.class })
public class AllTests {

}
