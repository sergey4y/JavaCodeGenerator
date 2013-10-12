package me.s.y.mpp.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains class generation information: fields and methods.
 * 
 * @author Sergey Yakimovich
 *
 */
public class ClassToGen {

	private String name;
	private List<FieldToGen> fields;
	private List<MethodToGen> methods;
	
	public ClassToGen(){
		fields = new ArrayList<FieldToGen>();
		methods = new ArrayList<MethodToGen>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<FieldToGen> getFields() {
		return fields;
	}

	public void setFields(List<FieldToGen> fields) {
		this.fields = fields;
	}
	
	public void addField(FieldToGen field){
		this.fields.add(field);
	}

	public List<MethodToGen> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodToGen> methods) {
		this.methods = methods;
	}
	
	public void addMethod(MethodToGen method){
		this.methods.add(method);
	}

}
