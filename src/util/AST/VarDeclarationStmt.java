package util.AST;

import java.util.ArrayList;

public class VarDeclarationStmt extends Statement{
	
	private TypeAst auxType;
	private ArrayList<Identifier> auxIDlist;

	public VarDeclarationStmt(TypeAst auxType, ArrayList<Identifier> auxIDlist) {
		this.auxType = auxType;
		this.auxIDlist = auxIDlist;
	}

	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Var Declaration Statement Start \n");
        s.append(this.getSpaces(level+1));
        //s.append("		");
        s.append("Type: " + auxType.toString(level +1) + '\n');
        //s.append("	");
        
        for(Identifier iD : auxIDlist){
        	s.append(this.getSpaces(level +2));
        	//s.append("			");
            s.append(iD.toString(level + 2) + '\n');
        }
//        s.append(" receives: \n");	
        
        
//        s.append(expression.toString(level + 1));
        s.append(this.getSpaces(level));
        //s.append("	");
        s.append("Var Declaration Statement End \n");
        return s.toString();
    }
	
}
