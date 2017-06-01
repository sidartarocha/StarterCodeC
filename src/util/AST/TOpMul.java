package util.AST;

import scanner.Token;

public class TOpMul extends Terminal {
	
	
	public TOpMul(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
        //s.append(this.getSpaces());
        s.append(this.getToken().getKind() +": ( "+ this.getToken().getSpelling()+" )");
		return s.toString();
	}

}
