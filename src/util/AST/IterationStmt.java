package util.AST;

import java.util.List;

public class IterationStmt extends Statement {

	private final Expression expression;
	private final List<Statement> statement;
	
	
	
	public IterationStmt(Expression expression, List<Statement> statement) {
		super();
		this.expression = expression;
		this.statement = statement;
	}



	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
