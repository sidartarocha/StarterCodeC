package util.AST;

import scanner.Token;

public class Command extends Statement {
	Token token;
	Expression expression;
	
	
	
	
	public Command(Token token, Expression expression) {
		super();
		this.token = token;
		this.expression = expression;
	}

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
