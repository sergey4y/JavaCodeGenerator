package me.s.y.mpp.codegenerator;

public class ParamToGen {
	private String type;
	private String name;
	
	public ParamToGen(){
		
	}
	
	public ParamToGen(String _type, String _name){
		this.type = _type;
		this.name = _name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
