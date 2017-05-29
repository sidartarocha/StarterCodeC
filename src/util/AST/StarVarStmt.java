package util.AST;

public class StarVarStmt extends Statement{
	
	private Identifier identifier;
	private Expression expression;
	
	public StarVarStmt(Identifier identifier, Expression expression) {
		super();
		this.identifier = identifier;
		this.expression = expression;
	}

	

	public Identifier getIdentifier() {
		return identifier;
	}



	public Expression getExpression() {
		return expression;
	}



	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
