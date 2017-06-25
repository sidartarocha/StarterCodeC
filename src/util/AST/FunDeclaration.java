package util.AST;

import java.util.ArrayList;

import checker.SemanticException;
import checker.Visitor;

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
        s.append(this.getSpaces(level));
        s.append("Function Start \n");
        //s.append(this.getSpaces(level+1));
        //s.append(auxType.toString() + '\n');
        //s.append(" ");
        s.append(this.getSpaces(level +1));
        s.append("Type Function " + auxType.toString() + '\n');
        s.append(this.getSpaces(level +1));
        s.append("Name Function \n");
        s.append(auxID.toString(level +1) + '\n');
        //s.append(" ");
        
        for(ParamDeclaration param : paramDeclaration){
        	s.append(param.toString(level + 1));
        }
        s.append(this.getSpaces(level +1));   
        s.append("Statement Start \n");
        for(Statement statement : statement){
        	if(statement!=null){
        		s.append(statement.toString(level + 2));
        	}
        }
        s.append(this.getSpaces(level +1));  
        s.append("Statement End \n");    
//        s.append(" receives: \n");	
        s.append(this.getSpaces(level));
        s.append("Function End");
//        s.append(expression.toString(level + 1));

        return s.toString();
    }


	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitFunDeclaration(this, arg);
	}
	
}
