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
				if(fieldToGen.isStatic()){
					result.append(STATIC + " ");
				}
				result.append(fieldToGen.getType() + " " + fieldToGen.getName() + ";" + getLineEnd());
			}
		}
		if(classToGen.getMethods() != null){
			for(MethodToGen methodToGen : classToGen.getMethods()){
				if(methodToGen.getAccessModifier() == AM.EMPT){
					result.append(getIndent());
				} else {
					result.append(getIndent() + methodToGen.getAccessModifier() + " ");
				}
				if(methodToGen.isStatic()){
					result.append(STATIC + " ");
				}
				result.append(methodToGen.getReturnType());
				result.append(" " + methodToGen.getName() + "(");
				for(ParamToGen param : methodToGen.getParams()){
					result.append(param.getType() + " " + param.getName() + ", ");
				}
				if(result.toString().endsWith(", ")){
					result.delete(result.length() - 2, result.length());
				}
				String returnStatement = "";
				if(!methodToGen.getReturnType().equals(TypeUtils.VOID_TYPE)){
					returnStatement = "return " + TypeUtils.getDefaultReturnValue(methodToGen.getReturnType()) +
							";";
				}
				result.append("){" + returnStatement + "}" + getLineEnd());
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

	private static String lineEnd = System.lineSeparator(); //"\r\n";
	private static String indent = "	";
	
	public static final String CLASS = "class";
	public static final String STATIC = "static";
}
