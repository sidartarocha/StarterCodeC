package checker;

import util.AST.*;
import util.AST.Program;

public interface Visitor {

	public Object visitProgram(Program program, Object arg) throws SemanticException;
	
	//Commands	
	public Object visitArguments(Arguments arguments, Object arg) throws SemanticException;
	
	public Object visitCallFunc(CallFunc callFunc, Object arg) throws SemanticException;
	
	public Object visitCommand(Command command, Object arg) throws SemanticException;
	
	public Object visitDeclaration(Declaration declaration, Object arg) throws SemanticException;
	
	public Object visitExpression(Expression expression, Object arg) throws SemanticException;
	
	public Object visitFunDeclaration(FunDeclaration funDeclaration, Object arg) throws SemanticException;
	
	
	//Factor
	public Object visitFactorBoolean(FactorBoolean factorBoolean, Object arg) throws SemanticException;
	
	public Object vistFactorCallFunc(FactorCallFunc factorCallFunc, Object arg) throws SemanticException;
	
	public Object visitFactorId(FactorID factorID, Object arg) throws SemanticException;
	
	public Object visitFactorNumber(FactorNumber factorNumber, Object arg) throws SemanticException;
		
	
	//Statement
	public Object visitIterationStmt(IterationStmt iterationStmt, Object arg) throws SemanticException;
	
	public Object visitParmDeclaration(ParamDeclaration paramDeclaration, Object arg) throws SemanticException;
	
	public Object visitSelectionStmt(SelectionStmt selectionStmt, Object arg) throws SemanticException;
	
	public Object visitSimpleExpression(SimpleExpression simpleExpression, Object arg) throws SemanticException;
	
	public Object visitStarVarStmt(StarVarStmt starVarStmt, Object arg) throws SemanticException;
	
	public Object visitStatement(Statement statement, Object arg) throws SemanticException;
	
	public Object visitTerm(Term term, Object arg) throws SemanticException;
	
	public Object visitTerminal(Terminal terminal, Object arg) throws SemanticException;
		
	
	//Terminal type
	public Object visitTBoolean(TBoolean tBoolean, Object arg) throws SemanticException;
	
	public Object visitIdentifier(Identifier identifier, Object arg) throws SemanticException;
	
	public Object visitTinteger(Tinteger tinteger, Object arg) throws SemanticException;
	
	public Object visitTOpAr(TOpAr tOpAr, Object arg) throws SemanticException;
	
	public Object visitTOpBool(TOpBool tOpBool, Object arg) throws SemanticException;
	
	public Object visitTOpMul(TOpMul tOpMul, Object arg) throws SemanticException;
	
	public Object visitTypeAst(TypeAst typeAst, Object arg) throws SemanticException;
	
	public Object visitVarDeclaration(VarDeclaration varDeclaration, Object arg) throws SemanticException;
	
	//Types Stmt
	public Object visitVarDeclarationStmt(VarDeclarationStmt varDeclarationStmt, Object arg) throws SemanticException;
	
}
