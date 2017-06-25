package util.AST;

import scanner.Token;

public abstract class Terminal extends AST {
	private Token token;
	
	public Terminal(Token token){
		this.token = token;
	}

	/**
	 * @return the token
	 */
	public Token getToken() {
		return token;
	}

	@Override
    public String toString(int level) {
        return this.toString();
    }
	
	
	
}
