package util.AST;

import java.util.List;

public class SelectionStmt extends Statement{
	private final Expression expression;
	private final List<Statement> statement;
	
	
	public SelectionStmt(Expression expression, List<Statement> statement) {
		this.expression = expression;
		this.statement = statement;
	}

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
