package me.s.y.mpp.codegenerator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class TestTextToText {
	@Test
	public void static_return_test1(){
		try{
			String path = getClass().getResource("/static_return_test1.txt").getPath();
			List<ClassToGen> classes = SimpleReader.readClass(path);
			String resultPath = getClass().getResource("/static_return_test1_result.txt").getPath(); 
			String expectedResult = SimpleReader.readToString(resultPath);
			StringBuffer result = new StringBuffer();
			for(ClassToGen classToGen : classes){
				result.append(CodeGenerator.generateClassCode(classToGen));
				result.append(CodeGenerator.getLineEnd());
			}
			assertEquals(expectedResult, result.toString());
		} catch (IOException e) {
			fail(e.toString());
		}
	}
}
