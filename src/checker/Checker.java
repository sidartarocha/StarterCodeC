package checker;

import util.AST.AST;
import util.AST.Arguments;
import util.AST.CallFunc;
import util.AST.Command;
import util.AST.Declaration;
import util.AST.Expression;
import util.AST.FactorBoolean;
import util.AST.FactorCallFunc;
import util.AST.FactorID;
import util.AST.FactorNumber;
import util.AST.FunDeclaration;
import util.AST.Identifier;
import util.AST.IterationStmt;
import util.AST.ParamDeclaration;
import util.AST.Program;
import util.AST.SelectionStmt;
import util.AST.SimpleExpression;
import util.AST.StarVarStmt;
import util.AST.Statement;
import util.AST.TBoolean;
import util.AST.TOpAr;
import util.AST.TOpBool;
import util.AST.TOpMul;
import util.AST.Term;
import util.AST.Terminal;
import util.AST.Tinteger;
import util.AST.TypeAst;
import util.AST.VarDeclaration;
import util.AST.VarDeclarationStmt;
import util.symbolsTable.IdentificationTable;

public class Checker implements Visitor {
	
	private IdentificationTable identificationTable;

	public void check(AST ast) throws SemanticException{
		identificationTable = new IdentificationTable();
		ast.visit(this, null);
	}

	public Object visitProgram(Program program, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitArguments(Arguments arguments, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCallFunc(CallFunc callFunc, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCommand(Command command, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitDeclaration(Declaration declaration, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitExpression(Expression expression, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFunDeclaration(FunDeclaration funDeclaration, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFactorBoolean(FactorBoolean factorBoolean, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object vistFactorCallFunc(FactorCallFunc factorCallFunc, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFactorId(FactorID factorID, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFactorNumber(FactorNumber factorNumber, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFactorCallFunc(Visitor v, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIterationStmt(IterationStmt iterationStmt, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParmDeclaration(ParamDeclaration paramDeclaration, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitSelectionStmt(SelectionStmt selectionStmt, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitSimpleExpression(SimpleExpression simpleExpression, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitStarVarStmt(StarVarStmt starVarStmt, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitStatement(Statement statement, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTerm(Term term, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTerminal(Terminal terminal, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarDeclarationStmt(VarDeclarationStmt varDeclarationStmt, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTBoolean(TBoolean tBoolean, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIdentifier(Identifier identifier, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTinteger(Tinteger tinteger, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTOpAr(TOpAr tOpAr, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTOpBool(TOpBool tOpBool, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTOpMul(TOpMul tOpMul, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTypeAst(TypeAst typeAst, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarDeclaration(VarDeclaration varDeclaration, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
