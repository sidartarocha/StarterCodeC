package util.AST;

import checker.SemanticException;
import checker.Visitor;

public class FactorBoolean extends FactorExpression{
	private TBoolean bool;

	public FactorBoolean(TBoolean bool) {
		this.bool = bool;
	}
	
	@Override
    public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("FactorBoolean Star\n");

        s.append(this.getSpaces(level + 1));
        s.append(bool.toString() + '\n');

        s.append(this.getSpaces(level));
        s.append("FactorBoolean End\n");
        return s.toString();
    }
	
	@Override
	public Object visit(Visitor v, Object arg) throws SemanticException{
		return v.visitFactorBoolean(this, arg);
	}
	
}
