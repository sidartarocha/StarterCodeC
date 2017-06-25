package util.AST;

import checker.SemanticException;
import checker.Visitor;
import scanner.Token;

public class TypeAst extends Terminal {

	public TypeAst(Token astToken) {
		super(astToken);
	}

	
	  @Override
	    public String toString() {
	        return this.getToken().getKind().name();
	    }


	@Override
	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitTypeAst(this, arg);
	}


	
}
