package util.AST;

import java.util.ArrayList;

public class FunDeclaration extends AST {

	private TypeAst auxType;
	private Identifier auxID;
	private ArrayList<ParamDeclaration> paramDeclaration;
	private ArrayList<Statement> statement;

	public FunDeclaration(TypeAst auxType, Identifier auxID , ArrayList<ParamDeclaration> paramDeclaration, ArrayList<Statement> statement) {
		this.auxType = auxType;
		this.auxID = auxID;
		this.paramDeclaration = paramDeclaration;
		this.statement = statement;
	}

	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append("Function Start \n");
        s.append(this.getSpaces(level+1));
        s.append(auxType.toString() + '\n');
        //s.append(" ");
        s.append(this.getSpaces(level+2));
        s.append(auxID.toString() + '\n');
        //s.append(" ");
        
        for(ParamDeclaration param : paramDeclaration)
            s.append(param.toString(level + 3));
        
        for(Statement statement : statement)
            s.append(statement.toString(level + 3));
//        s.append(" receives: \n");	
        s.append(this.getSpaces(level));
        s.append("Function End");
//        s.append(expression.toString(level + 1));

        return s.toString();
    }
	
}
