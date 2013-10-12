package me.s.y.mpp.codegenerator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for CodeGenerator class.
 * 
 * @author Sergey Yakimovich
 *
 */
public class TestCodeGenerator {

	@Test
	public void testClassPublicPrivateFields() {
		ClassToGen ben = new ClassToGen();
		ben.setName("Ben");
		FieldToGen nameField = new FieldToGen(AM.PRIV, "String", "name");
		ben.addField(nameField);
		FieldToGen ageField = new FieldToGen(AM.PUBL, "int", "age");
		ben.addField(ageField);
		String code = CodeGenerator.generateClassCode(ben);
		String[] codeLines = code.split(CodeGenerator.getLineEnd());
		assertEquals(4, codeLines.length);
		assertEquals("public class Ben {", codeLines[0]);
		assertEquals(CodeGenerator.getIndent() + "private String name;", codeLines[1]);
		assertEquals(CodeGenerator.getIndent() + "public int age;", codeLines[2]);
		assertEquals("}", codeLines[3]);
	}
	
	@Test
	public void testClassProtectedEmptyModifFields(){
		ClassToGen pine = new ClassToGen();
		pine.setName("Pine");
		FieldToGen needleField = new FieldToGen(AM.PROT, "long", "needle");
		pine.addField(needleField);
		FieldToGen coneField = new FieldToGen(AM.EMPT, "boolean", "cone");
		pine.addField(coneField);
		String code = CodeGenerator.generateClassCode(pine);
		String[] codeLines = code.split(CodeGenerator.getLineEnd());
		assertEquals(4, codeLines.length);
		assertEquals("public class Pine {", codeLines[0]);
		assertEquals(CodeGenerator.getIndent() + "protected long needle;", codeLines[1]);
		assertEquals(CodeGenerator.getIndent() + "boolean cone;", codeLines[2]);
		assertEquals("}", codeLines[3]);
	}
	
	@Test
	public void testClassPublPrivMethods(){
		ClassToGen class1 = new ClassToGen();
		class1.setName("Class1Name");
		MethodToGen method1 = new MethodToGen(AM.PUBL, "int", "abc", "int", "param1", "boolean", "param2");
		class1.addMethod(method1);
		MethodToGen method2 = new MethodToGen(AM.PRIV, "void", "bcd");
		class1.addMethod(method2);
		String code = CodeGenerator.generateClassCode(class1);
		String[] codeLines = code.split(CodeGenerator.getLineEnd());
		assertEquals(4, codeLines.length);
		assertEquals("public class Class1Name {", codeLines[0]);
		assertEquals(CodeGenerator.getIndent() + "public int abc(int param1, boolean param2){}", codeLines[1]);
		assertEquals(CodeGenerator.getIndent() + "private void bcd(){}", codeLines[2]);
		assertEquals("}", codeLines[3]);
	}
	
	@Test
	public void testClassProtectedEmptyModifMethods(){
		ClassToGen class1 = new ClassToGen();
		class1.setName("Class2Name");
		MethodToGen method1 = new MethodToGen(AM.PROT, "void", "aaa", "boolean", "b", "int", "i", "float", "f");
		class1.addMethod(method1);
		MethodToGen method2 = new MethodToGen(AM.EMPT, "String", "bbb");
		class1.addMethod(method2);
		String code = CodeGenerator.generateClassCode(class1);
		String[] codeLines = code.split(CodeGenerator.getLineEnd());
		assertEquals(4, codeLines.length);
		assertEquals("public class Class2Name {", codeLines[0]);
		assertEquals(CodeGenerator.getIndent() + "protected void aaa(boolean b, int i, float f){}", codeLines[1]);
		assertEquals(CodeGenerator.getIndent() + "String bbb(){}", codeLines[2]);
		assertEquals("}", codeLines[3]);
	}

}
