package util.AST;

import java.util.ArrayList;

public class VarDeclaration extends AST{
	
	private TypeAst auxType;
	private ArrayList<Identifier> auxIDlist;

	public VarDeclaration(TypeAst auxType, ArrayList<Identifier> auxIDlist) {
		this.auxType = auxType;
		this.auxIDlist = auxIDlist;
	}

	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Var Declaration Start \n");
//        s.append(this.getSpaces(level) + '\n');
//        s.append(this.getSpaces(level+1));
        //s.append("		");
        s.append(this.getSpaces(level +1));
        s.append("Type: " + auxType.toString(level) + '\n');
        //s.append("	");
        
        for(Identifier iD : auxIDlist){
        	s.append(this.getSpaces(level));
        	//s.append("			");
            s.append(iD.toString(level) + '\n');
        }
//        s.append(" receives: \n");	
        
        
//        s.append(expression.toString(level + 1));
        s.append(this.getSpaces(level));
        s.append("Var Declaration End");
        return s.toString();
    }
	
}
