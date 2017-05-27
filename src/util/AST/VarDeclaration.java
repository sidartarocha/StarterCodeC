package util.AST;

public class VarDeclaration extends AST{
	
	
	
	
	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append(type.toString());
        s.append(" ");
        s.append(identifier.toString());
        s.append(" receives: \n");
        s.append(expression.toString(level + 1));

        return s.toString();
    }
	
}
