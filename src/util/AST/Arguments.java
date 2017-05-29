package util.AST;

import java.util.ArrayList;

public class Arguments extends Statement{

	private ArrayList<Expression> expressionList;
	
	public Arguments(ArrayList<Expression> expressionList) {
		this.expressionList = expressionList;
	}

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
