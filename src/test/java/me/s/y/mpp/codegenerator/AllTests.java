package me.s.y.mpp.codegenerator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Running all tests
 * 
 * @author Sergey Yakimovich
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestCodeGenerator.class, TestSimpleReader.class, TestTextToText.class })
public class AllTests {
	
}