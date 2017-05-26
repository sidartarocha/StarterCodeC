package util.AST;

import java.util.ArrayList;

public class Declaration extends AST{
	private ArrayList<VarDeclaration> varD;
	private ArrayList<FunDeclaration> funcD;

	
	public Declaration(ArrayList<VarDeclaration> varD, ArrayList<FunDeclaration> funcD) {
		this.varD = varD;
		this.funcD = funcD;
	}
	
	public ArrayList<VarDeclaration> getVar(){
		return varD;
	}
	
	public ArrayList<FunDeclaration> getFunc(){
		return funcD;
	}
	
	
	
	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public String toString(int level) {
		String str = "BEGIN Declaration\n";
		int nextLevel = level+1;
		
		for(int i=0; i<funcD.size(); i++)
			str += funcD.get(i).toString(nextLevel) + '\n';
		
		for(int i=0; i<varD.size(); i++)
			str += varD.get(i).toString(nextLevel) + ";\n";
		
		return str.substring(0, str.length() - 2) + "\nEND Declaration\n";
	}
}
