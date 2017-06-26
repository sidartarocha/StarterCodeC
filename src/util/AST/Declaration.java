package util.AST;

import java.util.ArrayList;

import checker.SemanticException;
import checker.Visitor;

public class Declaration extends AST{
	public ArrayList<VarDeclaration> varD;
	public ArrayList<FunDeclaration> funcD;

	
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
	

	public Object visit(Visitor v, Object arg) throws SemanticException{
		return v.visitDeclaration(this, arg);
	}
	
	

	@Override
	public String toString(int level) {
	        StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("Declaration Start \n");
	        //s.append(this.getSpaces(level) + '\n');

	        
	        for(VarDeclaration varD : varD){
	        	s.append(varD.toString(level + 1) + '\n');
	        }
	        
	        for(FunDeclaration funcD : funcD){
	        	s.append(funcD.toString(level + 1) + '\n');
	        }
	            
	        

	        
	        

	        s.append(this.getSpaces(level));
	      
	        s.append("Declaration End \n");
	        return s.toString();
    }
}
