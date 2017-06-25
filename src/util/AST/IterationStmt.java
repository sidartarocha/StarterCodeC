package util.AST;

import java.util.List;

import checker.SemanticException;
import checker.Visitor;

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
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("IterationStmt Start (WHILE) \n");

        s.append(this.getSpaces(level+1));
        s.append("Condition Expression \n");
        	s.append(expression.toString(level+2));
        	s.append(this.getSpaces(level+1));
        s.append("Condition Expression End \n");
        
        for(Statement statement : statement){
        	
        	if(statement.toString(level)!=null){
        		s.append(statement.toString(level+1));
        	}
        	
        	
        }
        
        
        s.append(this.getSpaces(level));
        s.append("IterationStmt End (WHILE) \n");
        
        return s.toString();
	}




	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitIterationStmt(this, arg);
	}

}
