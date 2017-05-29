package util.AST;

import scanner.Token;

public class TBoolean extends Terminal {

	public TBoolean(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getToken().getKind().name();
	}

}
