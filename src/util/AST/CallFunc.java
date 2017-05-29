package util.AST;

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

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
