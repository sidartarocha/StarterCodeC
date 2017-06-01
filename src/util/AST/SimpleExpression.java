package util.AST;

public class SimpleExpression extends AST{
	private Term headTerm;
	private TOpAr opAr;
	private Term bodyTerm;
	
	
	
	
	public SimpleExpression(Term headTerm, TOpAr opAr, Term bodyTerm) {
		super();
		this.headTerm = headTerm;
		this.opAr = opAr;
		this.bodyTerm = bodyTerm;
	}




	@Override
	public String toString(int level) {
		  StringBuilder s = new StringBuilder();
	        s.append(this.getSpaces(level));
	        s.append("SimpleExpression Start\n");

	        //s.append(this.getSpaces(level));
	        s.append(headTerm.toString(level + 1));
	        
	        if(opAr != null) {
	            s.append(this.getSpaces(level + 1));
	            s.append("Operator: ");
	            s.append(opAr.toString() + "\n");
	        }
	        
	        if(bodyTerm != null) {
	            s.append(bodyTerm.toString(level + 1));
	        }

	        s.append(this.getSpaces(level));
	        s.append("SimpleExpression End\n");
	        return s.toString();
	}
	
	

}
