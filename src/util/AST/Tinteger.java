package util.AST;

import checker.SemanticException;
import checker.Visitor;
import scanner.Token;

public class Tinteger extends Terminal{

	public Tinteger(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getToken().getSpelling();
	}

	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitTinteger(this, arg);
	}

}
