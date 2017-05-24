package util.AST;

import java.util.ArrayList;

public class Program extends AST{
//	private ArrayList<VarDeclaration> varD;
//	private ArrayList<FuncDeclaration> funcD;

	private ArrayList<Declaration> declaration;
	public Program(ArrayList<Declaration> declaration){
			this.declaration = declaration;
//			this.funcD = funcD;
//			this.varD = varD;
	}
	
	public ArrayList<Declaration> getDeclaration(){
		return declaration;
	}
	
}
