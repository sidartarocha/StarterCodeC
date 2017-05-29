package util.AST;

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
}
