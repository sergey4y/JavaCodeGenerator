package me.s.y.mpp.codegenerator;

public class MethodToGen {
	private String name;
	private String returnType;
	private ParamToGen[] params;
	private AM accessModifier;
	private boolean isStatic;
	
	public MethodToGen(){
		
	}
	
	public MethodToGen(AM _accessModifier, boolean _isStatic, String _returnType, String _name, String... _params){
		this.accessModifier = _accessModifier;
		this.isStatic = _isStatic;
		this.returnType = _returnType;
		this.name = _name;
		ParamToGen[] aParams = new ParamToGen[_params.length/2];
		for(int i = 0; i < aParams.length; i++){
			aParams[i] = new ParamToGen();
			aParams[i].setType(_params[2*i]);
			aParams[i].setName(_params[(2*i)+1]);
		}
		this.params = aParams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public ParamToGen[] getParams() {
		return params;
	}

	public void setParams(ParamToGen[] params) {
		this.params = params;
	}

	public AM getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(AM accessModifier) {
		this.accessModifier = accessModifier;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	
}
