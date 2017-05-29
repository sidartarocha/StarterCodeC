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
        s.append("Var Declaration Start");
        s.append(this.getSpaces(level));
        s.append(auxType.toString());
        s.append(" ");
        
        for(Identifier iD : auxIDlist)
            s.append(iD.toString(level + 1));
        
//        s.append(" receives: \n");	
        
        
//        s.append(expression.toString(level + 1));
        s.append("Var Declaration End");
        return s.toString();
    }
	
}
