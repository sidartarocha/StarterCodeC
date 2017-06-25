package util.AST;

import checker.SemanticException;
import checker.Visitor;

public class ParamDeclaration extends AST{

	private final TypeAst auxType;
	private final Identifier auxID;
	
	public ParamDeclaration(TypeAst auxType, Identifier auxID) {
		super();
		this.auxType = auxType;
		this.auxID = auxID;
	}

	public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Parameters Start \n");
        //s.append(this.getSpaces(level) + '\n');
        s.append(this.getSpaces(level+1));
        s.append("Type Parameter: " + auxType.toString(level) + '\n');
    	s.append(this.getSpaces(level));
        s.append(auxID.toString(level) + '\n');
        s.append(this.getSpaces(level));
        //s.append("	");
        s.append("Parameters End \n");
        return s.toString();
    }
	
	
	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitParmDeclaration(this, arg);
	}

}
