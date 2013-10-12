package me.s.y.mpp.codegenerator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

/**
 * Tests for SimpleReader class.
 * 
 * @author Sergey Yakimovich
 *
 */
public class TestSimpleReader {
	@Test
	public void testPrivPublFields(){
		try {
			String path = getClass().getResource("/priv_publ_fields.txt").getPath();
			List<ClassToGen> classes = SimpleReader.readClass(path);
			assertEquals(2, classes.size());
			ClassToGen class1 = classes.get(0);
			assertNotNull(class1);
			assertEquals("Person",class1.getName());
			List<FieldToGen> class1Fields = class1.getFields();
			assertEquals(1, class1Fields.size());
			FieldToGen class1Field1 = class1Fields.get(0);
			assertNotNull(class1Field1);
			assertEquals(AM.PUBL, class1Field1.getAccessModifier());
			assertEquals("String", class1Field1.getType());
			assertEquals("name", class1Field1.getName());
			ClassToGen class2 = classes.get(1);
			assertNotNull(class2);
			List<FieldToGen> class2Fields = class2.getFields();
			assertEquals(2, class2Fields.size());
			FieldToGen class2Field1 = class2Fields.get(0);
			assertNotNull(class2Field1);
			assertEquals(AM.PRIV, class2Field1.getAccessModifier());
			assertEquals("boolean", class2Field1.getType());
			assertEquals("key", class2Field1.getName());
			FieldToGen class2Field2 = class2Fields.get(1);
			assertNotNull(class2Field2);
			assertEquals(AM.PUBL, class2Field2.getAccessModifier());
			assertEquals("long", class2Field2.getType());
			assertEquals("river", class2Field2.getName());
		} catch (IOException e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testProtNoAMFields(){
		try {
			String path = getClass().getResource("/prot_no_am_fields.txt").getPath();
			List<ClassToGen> classes = SimpleReader.readClass(path);
			assertEquals(2, classes.size());
			ClassToGen class1 = classes.get(0);
			assertNotNull(class1);
			assertEquals("Bread",class1.getName());
			List<FieldToGen> class1Fields = class1.getFields();
			assertEquals(2, class1Fields.size());
			FieldToGen class1Field1 = class1Fields.get(0);
			assertNotNull(class1Field1);
			assertEquals(AM.PROT, class1Field1.getAccessModifier());
			assertEquals("int", class1Field1.getType());
			assertEquals("taste", class1Field1.getName());
			FieldToGen class1Field2 = class1Fields.get(1);
			assertNotNull(class1Field2);
			assertEquals(AM.EMPT, class1Field2.getAccessModifier());
			assertEquals("float", class1Field2.getType());
			assertEquals("mass", class1Field2.getName());
			ClassToGen class2 = classes.get(1);
			assertNotNull(class2);
			List<FieldToGen> class2Fields = class2.getFields();
			assertEquals(1, class2Fields.size());
			FieldToGen class2Field1 = class2Fields.get(0);
			assertNotNull(class2Field1);
			assertEquals(AM.PROT, class2Field1.getAccessModifier());
			assertEquals("double", class2Field1.getType());
			assertEquals("density", class2Field1.getName());
		} catch (IOException e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testPrivPublMethods(){
		try {
			String path = getClass().getResource("/priv_publ_methods.txt").getPath();
			List<ClassToGen> classes = SimpleReader.readClass(path);
			assertEquals(2, classes.size());
			ClassToGen class1 = classes.get(0);
			assertNotNull(class1);
			assertEquals("Person",class1.getName());
			List<MethodToGen> class1Methods = class1.getMethods();
			assertEquals(1, class1Methods.size());
			MethodToGen class1Method1 = class1Methods.get(0);
			assertNotNull(class1Method1);
			assertEquals(AM.PUBL, class1Method1.getAccessModifier());
			assertEquals("String", class1Method1.getReturnType());
			assertEquals("getName", class1Method1.getName());
			ParamToGen[] class1Method1Params = class1Method1.getParams();
			assertNotNull(class1Method1Params);
			assertEquals(2, class1Method1Params.length);
			assertNotNull(class1Method1Params[0]);
			assertEquals("id", class1Method1Params[0].getName());
			assertEquals("int", class1Method1Params[0].getType());
			assertNotNull(class1Method1Params[1]);
			assertEquals("flag", class1Method1Params[1].getName());
			assertEquals("boolean", class1Method1Params[1].getType());
			ClassToGen class2 = classes.get(1);
			assertNotNull(class2);
			List<MethodToGen> class2Methods = class2.getMethods();
			assertEquals(1, class2Methods.size());
			MethodToGen class2Method1 = class2Methods.get(0);
			assertNotNull(class2Method1);
			assertEquals(AM.PRIV, class2Method1.getAccessModifier());
			assertEquals("void", class2Method1.getReturnType());
			assertEquals("water", class2Method1.getName());
			ParamToGen[] class2Method1Params = class2Method1.getParams();
			assertNotNull(class2Method1Params);
			assertEquals(1, class2Method1Params.length);
			assertNotNull(class2Method1Params[0]);
			assertEquals("volume", class2Method1Params[0].getName());
			assertEquals("double", class2Method1Params[0].getType());
		} catch (IOException e) {
			fail(e.toString());
		}
	}
}
