package util.AST;

import checker.SemanticException;
import checker.Visitor;
import scanner.Token;

public class TBoolean extends Terminal {

	public TBoolean(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        //s.append(this.getSpaces());
        s.append(this.getToken().getKind() +": ( "+ this.getToken().getSpelling()+" )");
		return s.toString();
	}

	
	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitTBoolean(this, arg);
	}

}
