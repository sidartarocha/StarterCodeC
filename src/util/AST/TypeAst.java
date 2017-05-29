package util.AST;

import scanner.Token;

public class TypeAst extends Terminal {

	public TypeAst(Token astToken) {
		super(astToken);
	}

	
	  @Override
	    public String toString() {
	        return this.getToken().getKind().name();
	    }


	
}
