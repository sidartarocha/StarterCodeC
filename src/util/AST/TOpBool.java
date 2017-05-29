package util.AST;

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

	
}
