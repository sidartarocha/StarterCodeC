package util.AST;

import checker.SemanticException;
import checker.Visitor;

public class Expression extends AST {
	private final SimpleExpression head;
	private final TBoolean opBool;
	private final SimpleExpression body;
	
	
	
	
	
	public Expression(SimpleExpression head, TBoolean opBool, SimpleExpression body) {
		super();
		this.head = head;
		this.opBool = opBool;
		this.body = body;
	}



	public Object visit(Visitor v, Object arg) throws SemanticException{
		return v.visitExpression(this, arg);
	}
	


	@Override
	public String toString(int level) {
		  StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        
	        s.append("Expression Start\n");
	        s.append(head.toString(level + 1));
	        
	        if(opBool != null) {
	            s.append(this.getSpaces(level + 1));
	            s.append("Operator ");
	            s.append(opBool.toString() + '\n');
	            
	        }

	        //s.append(head.toString(level + 1));

	        if(body != null) {
	        	s.append(body.toString(level + 1));
	        }

	        s.append(this.getSpaces(level));
	        s.append("Expression End\n");
	        return s.toString();
	}
	
	
}
