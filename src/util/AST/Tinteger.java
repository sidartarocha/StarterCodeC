package util.AST;

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

}
