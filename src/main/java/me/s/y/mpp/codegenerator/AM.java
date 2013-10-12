package me.s.y.mpp.codegenerator;

/**
 * Access modifiers enum.
 * 
 * @author Sergey Yakimovich
 *
 */
public enum AM {
	PRIV, PROT, PUBL, EMPT;
	public String toString(){
		if(this.name().equals(PRIV.name())){
			return PRIVATE;
		} else if(this.name().equals(PROT.name())){
			return PROTECTED;
		} else if(this.name().equals(PUBL.name())){
			return PUBLIC;
		} 
		return "";
	}
	
	private static final String PUBLIC = "public";
	private static final String PRIVATE = "private";
	private static final String PROTECTED = "protected";
}
