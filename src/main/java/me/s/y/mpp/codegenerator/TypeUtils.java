package me.s.y.mpp.codegenerator;

/**
 * Used to produce type-specific behavior.
 * 
 * @author Sergey Yakimovich
 *
 */
public class TypeUtils {
	public static final String BOOLEAN_TYPE = "boolean";
	public static final String INT_TYPE = "int";
	public static final String FLOAT_TYPE = "float";
	public static final String DOUBLE_TYPE = "double";
	public static final String BYTE_TYPE = "byte";
	public static final String SHORT_TYPE = "short";
	public static final String CHAR_TYPE = "char";
	public static final String VOID_TYPE = "void";
	
	public static String getDefaultReturnValue(String typeName){
		if(typeName.equals(BOOLEAN_TYPE)){
			return "false";
		} else if(typeName.equals(INT_TYPE)){
			return "0";
		} else if(typeName.equals(FLOAT_TYPE)){
			return "0.0";
		} else if(typeName.equals(DOUBLE_TYPE)){
			return "0.0";
		} else if(typeName.equals(BYTE_TYPE)){
			return "0";
		} else if(typeName.equals(SHORT_TYPE)){
			return "0";
		} else if(typeName.equals(CHAR_TYPE)){
			return "0";
		} else {
			return "null";
		}
	}
}
