package checker;

import util.AST.AST;
import util.symbolsTable.IdentificationTable;

public class Checker implements Visitor {
	
	private IdentificationTable identificationTable;

	public void check(AST ast) throws SemanticException{
		identificationTable = new IdentificationTable();
		ast.visit(this, null);
	}
	
	
	
}
