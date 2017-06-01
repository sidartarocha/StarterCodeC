package util.AST;

public class factorID extends FactorExpression {
	private Identifier tIdentifier;
	
	
	
	public factorID(Identifier tIdentifier) {
		super();
		this.tIdentifier = tIdentifier;
	}


	public Identifier gettIdentifier() {
		return tIdentifier;
	}
	
	
	@Override
	public String toString(int level) {
		  StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("Factor ID : \n");

	        //s.append(this.getSpaces(level));
	        s.append(tIdentifier.toString(level + 1) + "\n");
	        
	        
	        return s.toString();
	}
	
	

}
