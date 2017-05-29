package util.AST;

public class ParamDeclaration extends AST{

	private final TypeAst auxType;
	private final Identifier auxID;
	

	

	public ParamDeclaration(TypeAst auxType, Identifier auxID) {
		super();
		this.auxType = auxType;
		this.auxID = auxID;
	}




	public String toString(int level) {
        StringBuilder s = new StringBuilder();
        s.append(this.getSpaces(level));
        s.append("Parameters Start \n");
        //s.append(this.getSpaces(level) + '\n');
        s.append(this.getSpaces(level+1));
      
        s.append(auxType.toString(level +1) + '\n');
    	s.append(this.getSpaces(level + 2));
        s.append(auxID.toString(level + 2) + '\n');
    

        s.append(this.getSpaces(level));
        //s.append("	");
        s.append("Parameters End \n");
        return s.toString();
    }

}
