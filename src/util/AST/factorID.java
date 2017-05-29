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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
