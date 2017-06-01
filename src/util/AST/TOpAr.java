package util.AST;

import scanner.Token;

public class TOpAr extends Terminal {

	public TOpAr(Token token) {
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
