package util.AST;

import java.util.ArrayList;

import checker.SemanticException;
import checker.Visitor;

public class Program extends AST{
	private ArrayList<Declaration> declarations;

	public Program(ArrayList<Declaration> declarations) {
		this.declarations = declarations;
	}

	/**
	 * @return the declaration
	 */
	public ArrayList<Declaration> getDeclaration() {
		return declarations;
	}
	
	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append("Program Start\n");
        //s.append(level + 1);
        for(Declaration decl : declarations){
        	//s.append("	");
        	s.append(decl.toString(level + 1));
        	//s.append("	");
        }
           
        

        s.append("Program End\n");
        return s.toString();
    }

	
	public Object visit(Visitor v, Object arg) throws SemanticException {
		return v.visitProgram(this, arg);
	}

	
	
	
	
	
}
