package util.AST;

import checker.SemanticException;
import checker.Visitor;
import scanner.Token;

public class TOpBool extends Terminal {

	public TOpBool(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getToken().getKind().name();
	}


	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitTOpBool(this, arg);
	}

	
	
}
