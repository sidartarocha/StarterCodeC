package util.AST;

public class Term extends AST{
	private FactorExpression headFactor;
	private TOpMul opMul;
	private FactorExpression bodyFactor;
	
	public Term(FactorExpression headFactor, TOpMul opMul, FactorExpression bodyFactor) {
		super();
		this.headFactor = headFactor;
		this.opMul = opMul;
		this.bodyFactor = bodyFactor;
	}

	@Override
	public String toString(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
