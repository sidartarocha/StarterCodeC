package util.AST;

import scanner.Token;

public class TBoolean extends Terminal {

	public TBoolean(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        //s.append(this.getSpaces());
        s.append(this.getToken().getKind() +": ( "+ this.getToken().getSpelling()+" )");
		return s.toString();
	}

}
