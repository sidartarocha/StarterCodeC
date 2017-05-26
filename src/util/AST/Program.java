package util.AST;

import java.util.ArrayList;

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

        for(Declaration decl : declarations)
            s.append(decl.toString(level + 1));
       

        s.append("Program End\n");
        return s.toString();
    }

	
	
	
	
	
}
