package util.AST;

public class FactorNumber extends FactorExpression {
	private Tinteger number;
	
	
	public FactorNumber(Tinteger number) {
		this.number = number;
	}

	public Tinteger getNumber() {
		return number;
	}

	
	 @Override
	    public String toString(int level) {
	        StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("Number Start\n");

	        s.append(this.getSpaces(level + 1));
	        s.append(number.toString() + '\n');

	        s.append(this.getSpaces(level));
	        s.append("Number End\n");
	        return s.toString();
	    }

}
