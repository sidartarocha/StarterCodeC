package util.AST;

import java.util.ArrayList;

public class Program extends AST{
	private ArrayList<VarDeclaration> varD;
	private ArrayList<FuncDeclaration> funcD;
	public Program(ArrayList<VarDeclaration> varD, ArrayList<FuncDeclaration> funcD){
			this.funcD = funcD;
			this.varD = varD;
	}
	
	public ArrayList<VarDeclaration> getVar(){
		return varD;
	}
	
}
