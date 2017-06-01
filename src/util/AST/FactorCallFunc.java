package util.AST;

public class FactorCallFunc extends FactorExpression{

	private final Identifier identifier;
	private Arguments arguments;
	
	public Identifier getIdentifier() {
		return identifier;
	}

	public Arguments getArguments() {
		return arguments;
	}

	public FactorCallFunc(Identifier identifier, Arguments arguments) {
		super();
		this.identifier = identifier;
		this.arguments = arguments;
	}

	public String toString(int level) {
		StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Factor Call Func Start \n");
        s.append(identifier.toString(level+1) + "\n");
        //s.append(this.getSpaces(level));
        
        //Chamada dos argumentos
        s.append(arguments.toString(level+1));
        
        s.append(this.getSpaces(level));
        s.append("Factor Call Func End \n");
        
        return s.toString();
	}

}
