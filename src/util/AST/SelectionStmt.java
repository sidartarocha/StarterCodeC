package util.AST;

import java.util.List;

public class SelectionStmt extends Statement{
	private final Expression expression;
	private final List<Statement> statemant;
	
	
	public SelectionStmt(Expression expression, List<Statement> statemant) {
		this.expression = expression;
		this.statemant = statemant;
	}

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
