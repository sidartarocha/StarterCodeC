package util.AST;

import scanner.Token;

public class TOpMul extends Terminal {
	
	
	public TOpMul(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getToken().getKind().name();
	}

}
