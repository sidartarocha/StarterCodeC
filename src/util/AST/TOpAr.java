package util.AST;

import scanner.Token;

public class TOpAr extends Terminal {

	public TOpAr(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getToken().getKind().name();
	}

}
