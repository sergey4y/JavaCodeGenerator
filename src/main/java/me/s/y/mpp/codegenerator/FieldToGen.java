package me.s.y.mpp.codegenerator;

/**
 * Contains field generation information: name, type and access modifier.
 * 
 * @author Sergey Yakimovich
 *
 */
public class FieldToGen {
	private String name;
	private String type;
	private AM accessModifier;
	
	public FieldToGen(){
		
	}
	
	public FieldToGen(AM _accessModifier, String _type, String _name){
		this.accessModifier = _accessModifier;
		this.type = _type;
		this.name = _name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public AM getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(AM accessModifier) {
		this.accessModifier = accessModifier;
	}
}
