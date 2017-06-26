package checker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.TransferHandler;

import parser.GrammarSymbols;
import sun.font.TrueTypeFont;
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
		if(program.declarationList!=null){
			for (Declaration declaration : program.declarationList) {
				declaration.visit(this, null);
			}
		}else{
			throw new 
			SemanticException("SemanticException program invalid context");
		}
		return null;
	}

	public Object visitDeclaration(Declaration declaration, Object arg) throws SemanticException {
		if(declaration.varD!=null){
			for (VarDeclaration varD : declaration.varD) {
				varD.visit(this, null);
			}
		}else{
			throw new SemanticException("SemanticException Declaration varD invalid");
		}
		if(declaration.funcD!=null){
			for (FunDeclaration funcD : declaration.funcD) {
				funcD.visit(this, null);
			}
		}else{
			throw new SemanticException("SemanticException Function Declaration invalid");
		}
		
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
		//identificationTable.containsKey(command.token.getSpelling());
		if(!identificationTable.containsKey(command.token.getSpelling())){
			throw new SemanticException("SemanticException: Command invalid token");
		}
		
		command.expression.visit(this, null);
			
		return null;
	}

	public Object visitExpression(Expression expression, Object arg) throws SemanticException {
		if(expression.head!=null){
			expression.head.visit(this, null);
		}else{
			throw new SemanticException("SemanticException: Expression head invalid");
		}
		
		if(expression.opBool!=null){
			expression.opBool.visit(this, null);
			expression.body.visit(this, null);
		}
		
		return null;
	}

	

	public Object visitFunDeclaration(FunDeclaration funDeclaration, Object arg) throws SemanticException {
		Type type ;
		if(funDeclaration.auxType==null){
			throw new SemanticException("SemanticException: invalid FunDeclaration auxType");
		}else{
			switch (funDeclaration.auxType.getToken().getKind()) {
			case BOOLEAN:
				type = Type.Boolean;
				break;
			case INT:
				type = Type.Integer;
				break;
			case VOID:
				type = Type.Void;
			default:
				break;
			}
			
			funDeclaration.auxID.visit(this, null);
			if(identificationTable.containsKey(funDeclaration.auxID.getToken().getSpelling())){
				identificationTable.retrieve(funDeclaration.auxID.getToken().getSpelling());	
			}else{
				identificationTable.enter(funDeclaration.auxID.getToken().getSpelling(), funDeclaration);
//				throw new SemanticException("SemanticException: invalid FunDeclaration auxID exist " + funDeclaration.auxID.getToken().getSpelling() );
			}
			
			identificationTable.openScope();
			for (ParamDeclaration parmD : funDeclaration.paramDeclaration) {
				parmD.visit(this, null);
			}
			for(Statement stm:funDeclaration.statement){
				stm.visit(this, null);
			}
		}
		
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
		if(factorID.tIdentifier!=null){
			if(identificationTable.containsKey(factorID.gettIdentifier().getToken().getSpelling())){
				identificationTable.retrieve(factorID.tIdentifier.getToken().getSpelling());
			}else{
				throw new SemanticException("SemanticException: factorID: " 
						+factorID.tIdentifier.getToken().getSpelling() 
						+ " not declared");
			}
		}else{
			throw new SemanticException("SemanticException: FactorId Identifier invalid");
		}
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

	
//	public final TypeAst auxType;
//	public final Identifier auxID;
	public Object visitParmDeclaration(ParamDeclaration paramDeclaration, Object arg) throws SemanticException {
		Type type;
		if(paramDeclaration.auxType==null){
			throw new SemanticException("SemanticException: ParamDeclaration invalid auxType");
		}else{
			switch (paramDeclaration.auxType.getToken().getKind()) {
			case BOOLEAN:
				type = Type.Boolean;
				break;
			case INT:
				type = Type.Integer; 
				break;
			default:
				break;
			}
		}
		//paramDeclaration.auxID.visit(this, null);
		if(identificationTable.containsKey(paramDeclaration.auxID.getToken().getSpelling())){
			identificationTable.retrieve(paramDeclaration.auxID.getToken().getSpelling());
		}else{
			identificationTable.enter(paramDeclaration.auxID.getToken().getSpelling(), paramDeclaration);
		}
		
		
		
		return null;
	}

//	public final Expression expression;
//	public final List<Statement> statement;
	public Object visitSelectionStmt(SelectionStmt selectionStmt, Object arg) throws SemanticException {
		selectionStmt.expression.visit(this, null);
		identificationTable.openScope();
		identificationTable.enter("IF", selectionStmt);
		for (Statement stm : selectionStmt.statement) {
			stm.visit(this, null);
		}		
		identificationTable.closeScope();
		return null;
	}

	
//	public Term headTerm;
//	public TOpAr opAr;
//	public Term bodyTerm;
	public Object visitSimpleExpression(SimpleExpression simpleExpression, Object arg) throws SemanticException {
		simpleExpression.headTerm.visit(this, null);
		if(simpleExpression.opAr!=null){
			simpleExpression.opAr.visit(this, null);
			simpleExpression.bodyTerm.visit(this, null);
		}
		return null;
	}

	
//	private Identifier identifier;
//	private Expression expression;
	public Object visitStarVarStmt(StarVarStmt starVarStmt, Object arg) throws SemanticException {
		if(identificationTable.retrieve(starVarStmt.identifier.getToken().getSpelling())!=null){
			identificationTable.openScope();
				starVarStmt.expression.visit(this, null);
			identificationTable.closeScope();
		}else{
			throw new SemanticException("SemanticException: StarVarStmt identifier not declarated ");
		}
		
		return null;
	}

	public Object visitStatement(Statement statement, Object arg) throws SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTerm(Term term, Object arg) throws SemanticException {
		if(term.headFactor!=null){
			term.headFactor.visit(this, null);
		}else{
			throw new SemanticException("SemanticException: Term headFActor invalid");
		}
		
		if(term.opMul!=null){
			term.opMul.visit(this, null);
			term.bodyFactor.visit(this, null);
		}
		return null;
	}

	public Object visitTerminal(Terminal terminal, Object arg) throws SemanticException {
		return null;
	}

	public Object visitVarDeclarationStmt(VarDeclarationStmt varDeclarationStmt, Object arg) throws SemanticException {
		Type type;
		TypeAst typeAst = varDeclarationStmt.auxType;
		
		switch (typeAst.getToken().getKind()) {
		case BOOLEAN:
			type = Type.Boolean;
			break;
		case INT:
			type = Type.Integer;
			break;
		default:
		break;
		}
		
		if(varDeclarationStmt.auxIDlist!=null){
			for (Identifier identifier : varDeclarationStmt.auxIDlist) {
				identifier.visit(this, null);
				//identificationTable.enter(identifier.getToken().getSpelling(), varDeclarationStmt);
			}
		}else{
			throw new SemanticException("SemanticException: VarDeclaration type invalid");
		}
		return null;
	}

	public Object visitTBoolean(TBoolean tBoolean, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIdentifier(Identifier identifier, Object arg) throws SemanticException {
		if(identifier.token.getSpelling()!=null){
			if(!identificationTable.containsKey(identifier.token.getSpelling())){
				identificationTable.enter(identifier.token.getSpelling(), identifier);
			}
		}else{
			throw new SemanticException("SemanticException: Identifier identifier invalid");
		}
				identifier.token.getSpelling();
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

	public Object visitVarDeclaration(VarDeclaration varDeclaration, Object arg) throws SemanticException{
		Type type;
		TypeAst typeAst = varDeclaration.auxType;
		
		switch (typeAst.getToken().getKind()) {
		case BOOLEAN:
			type = Type.Boolean;
			break;
		case INT:
			type = Type.Integer;
			break;
		default:
		break;
		}
		
		if(varDeclaration.auxIDlist!=null){
			for (Identifier identifier : varDeclaration.auxIDlist) {
				identifier.visit(this, null);
				if(identificationTable.containsKey(identifier.getToken().getSpelling())){
					identificationTable.retrieve(identifier.getToken().getSpelling());
				}else{
					identificationTable.enter(identifier.getToken().getSpelling(), varDeclaration);
				}
			}
		}else{
			throw new SemanticException("SemanticException: VarDeclaration type invalid");
		}
		
		
		return null;
	}
	
	
	
}
