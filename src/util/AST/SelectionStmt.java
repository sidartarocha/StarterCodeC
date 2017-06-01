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
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("SelectionStmt Start (IF) \n");

        s.append(this.getSpaces(level+1));
        s.append("Condition Expression \n");
        s.append(expression.toString(level+2));
        s.append(this.getSpaces(level+1));
        s.append("Condition Expression End \n");
        
        for(Statement statement : statement){
        	s.append(statement.toString(level+1));
        }
        
        
        s.append(this.getSpaces(level));
        s.append("SelectionStmt End (IF) \n");
        
        return s.toString();
	}

}
