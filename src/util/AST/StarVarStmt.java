package util.AST;

public class StarVarStmt extends Statement{
	
	private Identifier identifier;
	private Expression expression;
	
	public StarVarStmt(Identifier identifier, Expression expression) {
		super();
		this.identifier = identifier;
		this.expression = expression;
	}


	@Override
	public String toString(int level) {
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Variable Initialize \n");
        s.append(identifier.toString(level+1) + " --- ");
        s.append("to receive");
        s.append(expression.toString(level+1));
       
        
        
		return s.toString();
	}
	
}

