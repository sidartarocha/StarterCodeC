package util.AST;

import java.util.ArrayList;

public class Arguments extends Statement{

	private ArrayList<Expression> expressionList;
	
	public Arguments(ArrayList<Expression> expressionList) {
		this.expressionList = expressionList;
	}

	@Override
	public String toString(int level) {
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
		s.append("Arguments:  \n");
        for(Expression expressionList :expressionList){
        	s.append(expressionList.toString(level+1));	
        }
        s.append(this.getSpaces(level));
        s.append("Arguments END  \n");
        
        return s.toString();
	}

}
