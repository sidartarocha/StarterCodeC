package util.AST;

import scanner.Token;

public class Identifier extends Terminal{

	public Identifier(Token astToken) {
		super(astToken);
	}

	 @Override
    public String toString() {
        return this.getToken().getSpelling();
    }
}
