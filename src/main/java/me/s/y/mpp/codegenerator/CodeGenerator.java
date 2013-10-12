package me.s.y.mpp.codegenerator;

/**
 * Generates java code from ClassToGen object.
 * 
 * @author Sergey Yakimovich
 *
 */
public class CodeGenerator {

	public static String generateClassCode(ClassToGen classToGen){
		StringBuilder result = new StringBuilder();
		result.append(AM.PUBL + " " + CLASS + " " + classToGen.getName() + " {" + getLineEnd());
		if(classToGen.getFields() != null){
			for(FieldToGen fieldToGen : classToGen.getFields()){
				if(fieldToGen.getAccessModifier() == AM.EMPT){
					result.append(getIndent());
				} else {
					result.append(getIndent() + fieldToGen.getAccessModifier() + " ");
				}
				result.append(fieldToGen.getType() + " " + fieldToGen.getName() + ";" + getLineEnd());
			}
		}
		if(classToGen.getMethods() != null){
			for(MethodToGen methodToGen : classToGen.getMethods()){
				if(methodToGen.getAccessModifier() == AM.EMPT){
					result.append(getIndent() + methodToGen.getReturnType());
				} else {
					result.append(getIndent() + methodToGen.getAccessModifier() + " " + methodToGen.getReturnType());
				}
				result.append(" " + methodToGen.getName() + "(");
				for(ParamToGen param : methodToGen.getParams()){
					result.append(param.getType() + " " + param.getName() + ", ");
				}
				if(result.toString().endsWith(", ")){
					result.delete(result.length() - 2, result.length());
				}
				result.append("){}" + getLineEnd());
			}
		}
		result.append("}");
		return result.toString();
	}
	
	public static String getLineEnd() {
		return lineEnd;
	}

	public static void setLineEnd(String lineEnd) {
		CodeGenerator.lineEnd = lineEnd;
	}
	
	public static String getIndent() {
		return indent;
	}

	public static void setIndent(String indent) {
		CodeGenerator.indent = indent;
	}

	private static String lineEnd = "\r\n";
	private static String indent = "	";
	
	public static final String CLASS = "class";
}
