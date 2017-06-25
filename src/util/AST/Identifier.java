package util.AST;

import checker.SemanticException;
import checker.Visitor;
import scanner.Token;

public class Identifier extends Terminal{

	public Identifier(Token astToken) {
		super(astToken);
	}

	@Override
	public String toString(int level) {
			StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("ID: " + this.getToken().getSpelling());
	        
    
        return s.toString();
    }


	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitIdentifier(this, arg);
	}

	
}
