package util.AST;

import checker.SemanticException;
import checker.Visitor;

public class Term extends AST{
	private FactorExpression headFactor;
	private TOpMul opMul;
	private FactorExpression bodyFactor;
	
	public Term(FactorExpression headFactor, TOpMul opMul, FactorExpression bodyFactor) {
		super();
		this.headFactor = headFactor;
		this.opMul = opMul;
		this.bodyFactor = bodyFactor;
	}

	@Override
	public String toString(int level) {
		  StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("Term Start\n");

	        //s.append(this.getSpaces(level));
	        s.append(headFactor.toString(level+1));
	        
	        if(opMul != null) {
	            s.append(this.getSpaces(level+1));
	            s.append("Operator: ");
	            s.append(opMul.toString() + "\n");
	        }
	        
	        if(bodyFactor != null) {
	            s.append(bodyFactor.toString(level+1));
	        }

	        s.append(this.getSpaces(level));
	        s.append("Term End\n");
	        return s.toString();
	}

	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitTerm(this, arg);
	}

}
