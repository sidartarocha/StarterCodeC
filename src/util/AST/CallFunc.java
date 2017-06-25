package util.AST;

import checker.SemanticException;
import checker.Visitor;

public class CallFunc extends Statement{

	private final Identifier identifier;
	private Arguments arguments;
	
	public Identifier getIdentifier() {
		return identifier;
	}

	public Arguments getArguments() {
		return arguments;
	}

	public CallFunc(Identifier identifier, Arguments arguments) {
		super();
		this.identifier = identifier;
		this.arguments = arguments;
	}

	public String toString(int level) {
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Call Func Start \n");
        s.append(identifier.toString(level+1) + "\n");
        //s.append(this.getSpaces(level));
        
        //Chamada dos argumentos
        s.append(arguments.toString(level+1));
        
        s.append(this.getSpaces(level));
        s.append("Call Func End \n");
        
        return s.toString();
	}
	

	public Object visit(Visitor v, Object arg) throws SemanticException{
		return v.visitCallFunc(this, arg);
	}
	

}
