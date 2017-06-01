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
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Command " + token.getSpelling() + " Start \n");
        
        if(expression!=null){
        	s.append(expression.toString(level +1));	
        }
        
        
        
        //s.append("	");
        s.append(this.getSpaces(level));
        s.append("Command " + token.getSpelling() + " End \n");
        return s.toString();
    }

}
