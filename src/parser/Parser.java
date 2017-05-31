package parser;

import scanner.Scanner;

import java.util.ArrayList;
import java.util.List;

import scanner.LexicalException;
import scanner.Token;

import util.AST.AST;
import util.AST.Arguments;
import util.AST.CallFunc;
import util.AST.Command;
import util.AST.Declaration;
import util.AST.Expression;
import util.AST.FactorBoolean;
import util.AST.FactorExpression;
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
import util.AST.Tinteger;
import util.AST.TypeAst;
import util.AST.VarDeclaration;
import util.AST.VarDeclarationStmt;
import util.AST.factorID;

/**
 * Parser class
 * @version 2010-august-29
 * @discipline Projeto de Compiladores
 * @author Gustavo H P Carvalho
 * @email gustavohpcarvalho@ecomp.poli.br
 */
public class Parser {

	// The current token
	private Token currentToken = null;
	// The scanner
	private Scanner scanner = null;
	
	/**
	 * Parser constructor
	 */
	public Parser() throws LexicalException{
		// Initializes the scanner object
		this.scanner = new Scanner();
		this.currentToken = this.scanner.getNextToken();
	}
	
	/**
	 * Veririfes if the current token kind is the expected one
	 * @param kind
	 * @throws SyntacticException
	 * @throws LexicalException
	 */ //TODO
	private void accept(GrammarSymbols kind) throws SyntacticException, LexicalException {
		//funcao para verificar o token corrente
		if (this.currentToken.getKind() == kind) {
			//System.out.println("(" + "\"" + currentToken.getSpelling() +"\"" + "," + currentToken.getKind() + ")");
			this.acceptIt();
		}else{
			throw new SyntacticException("SyntacticException error: expecting " 
					+ kind 
					+ ", but found "
					+ this.currentToken.getKind(), this.currentToken);
		}
	}
	
	/**
	 * Gets next token
	 * @param kind
	 * @throws LexicalException
	 */
	
	private void acceptIt() throws SyntacticException, LexicalException {
		//Fun��o para aceitar o token corrente
		this.currentToken = this.scanner.getNextToken();
	}

	/**
	 * Verifies if the source program is syntactically correct
	 * @throws SyntacticException
	 * @throws LexicalException
	 */ 
	public AST parse() throws SyntacticException, LexicalException {
			Program ast = parseProgram();
		
			accept(GrammarSymbols.EOT);

			return ast;
			

	}

	private Program parseProgram() throws SyntacticException, LexicalException {
		Program prog = null;
		ArrayList<Declaration> declaration = new ArrayList<Declaration>();
		while (this.currentToken.getKind() != GrammarSymbols.EOT){
			
			declaration.add(parseDeclaration());
			
		}
		prog = new Program(declaration);
		
		
		return prog;	
	}		

	/*	Chamada da funcao parserDeclaration
	 *	tipo void 
	 * 
	*/
	private Declaration parseDeclaration() throws SyntacticException, LexicalException {
		/*Analisa se o que foi passado  um VarDeclaratio ou uma functionDeclaration
		 * Esse if faz a verificacao se esta sendo recebido um token tipo INT, BOOLEAN ou VOID
		 *  
		 */
		Declaration decl = null;
		ArrayList<VarDeclaration> varD = new ArrayList<VarDeclaration>();
		ArrayList<FunDeclaration> funD = new ArrayList<FunDeclaration>();
		Identifier auxID;
		TypeAst auxType; 
		
		if(this.currentToken.getKind()== GrammarSymbols.VOID){
			auxType = parseType();
			auxID = new Identifier(this.currentToken); 
			accept(GrammarSymbols.ID);
			funD.add(parseFunDeclaration(auxType, auxID));
		}else{
			auxType = parseType();
			auxID = new Identifier(this.currentToken); 
			accept(GrammarSymbols.ID);
			if(this.currentToken.getKind() == GrammarSymbols.LP){
				//accept(GrammarSymbols.LP);
				funD.add(parseFunDeclaration(auxType, auxID));
			}else{
				varD.add(parseVarDeclaration(auxType, auxID));
			}
			
		}
	decl = new Declaration(varD, funD);		
	return decl;
	}
				
	

	private TypeAst parseType() throws SyntacticException, LexicalException {
		TypeAst type = new TypeAst(this.currentToken);
		
		if(this.currentToken.getKind() == GrammarSymbols.INT){
			accept(GrammarSymbols.INT);
		}else{
			if(this.currentToken.getKind() == GrammarSymbols.BOOLEAN){
				accept(GrammarSymbols.BOOLEAN );
			}else{
				accept(GrammarSymbols.VOID);
			}
		}
		
		return type;
	
	}

	//Declaracao de Variavel
	private VarDeclaration parseVarDeclaration(TypeAst auxType, Identifier auxID) throws SyntacticException, LexicalException {
				
		ArrayList<Identifier> auxIDlist = new ArrayList<Identifier>();
		auxIDlist.add(auxID);
		
		if(this.currentToken.getKind() == GrammarSymbols.COMMA){
			while(this.currentToken.getKind() != GrammarSymbols.SEMICOLON ){
				accept(GrammarSymbols.COMMA);
				auxIDlist.add(new Identifier(this.currentToken));
				accept(GrammarSymbols.ID);
			}
			accept(GrammarSymbols.SEMICOLON);
		}else{
			accept(GrammarSymbols.SEMICOLON);
		}
			
		return new VarDeclaration(auxType, auxIDlist); 
	}
	
	//Declaracao de funcao
	private FunDeclaration parseFunDeclaration(TypeAst auxType, Identifier auxID) throws SyntacticException, LexicalException {
		ArrayList<ParamDeclaration> paramDeclaration = new ArrayList<ParamDeclaration>();
		ArrayList<Statement> statement = new ArrayList<Statement>();
		accept(GrammarSymbols.LP);
		while (this.currentToken.getKind()!=GrammarSymbols.RP){
			paramDeclaration.add(parseParamDeclaration());
			if(this.currentToken.getKind()==GrammarSymbols.COMMA){
				accept(GrammarSymbols.COMMA);
			}else{
				break;
			}
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while(this.currentToken.getKind()!=GrammarSymbols.RB){
			statement.add(parseStatement());
//			int validacaoStatmant = parseStatement(); 
//			if(validacaoStatmant==1){ //esse if tem a função de impedir que o codigo entre em loop
//				break;
//			}
		}
		accept(GrammarSymbols.RB);
		return new FunDeclaration(auxType, auxID, paramDeclaration, statement);
		
	}

	private ParamDeclaration parseParamDeclaration() throws SyntacticException, LexicalException {
		if (this.currentToken.getKind()!=GrammarSymbols.RP){ 
			TypeAst auxType = parseType();
			Identifier auxID = new Identifier(this.currentToken); 
			accept(GrammarSymbols.ID);
			return new ParamDeclaration(auxType, auxID);	
			//parseVarDeclaration(auxType, auxID);
		}else{
			return null;	
		}
		
	}

	private Statement parseStatement() throws SyntacticException, LexicalException {
		Statement statementlist = null;
		if (this.currentToken.getKind()!=GrammarSymbols.RB){
			switch (this.currentToken.getKind()) {
			case IF:
				statementlist = parseSelectionStmt();
				break;

			case WHILE:
				statementlist = parseIterationStmt();
				break;
				
			case RETURN:
				statementlist = parseReturnStmt();
				break;
			
			case PRINTF:
				statementlist = parsePrintfStmt();
				break;
			
			case BREAK:
				statementlist = new Command(this.currentToken, null );
				accept(GrammarSymbols.BREAK);
				break;
				
			case CONTINUE:	
				statementlist = new Command(this.currentToken, null );
				accept(GrammarSymbols.CONTINUE);
				
			case ID:
				Identifier Id = new Identifier(this.currentToken);
				accept(GrammarSymbols.ID);
				//StarVarStmt startVar;
				if(this.currentToken.getKind()==GrammarSymbols.EQUAL){
					accept(GrammarSymbols.EQUAL);
					Expression expression = parseExpression();
					accept(GrammarSymbols.SEMICOLON);
					statementlist = new StarVarStmt(Id, expression);
					break;
				}else{
					//Chamada de funcao
					//Identifier Id = new Identifier(this.currentToken); 
					accept(GrammarSymbols.ID);
					Arguments arguments = null;
					if(this.currentToken.getKind()==GrammarSymbols.LP){
						accept(GrammarSymbols.LP);
						if(this.currentToken.getKind()!=GrammarSymbols.RP){
							arguments = parseAgrms();
						}
						accept(GrammarSymbols.RP);
						accept(GrammarSymbols.SEMICOLON);
					}
					statementlist = new CallFunc(Id, arguments);
					break;
				}
				
					
			default:					
				while(this.currentToken.getKind()!=GrammarSymbols.SEMICOLON){
					TypeAst auxType = parseType();
					Identifier auxID = new Identifier(this.currentToken); 
					accept(GrammarSymbols.ID);
					statementlist = parseVarDeclarationStmt(auxType, auxID);
					}
					accept(GrammarSymbols.SEMICOLON);
					break;
		}
	}
			return statementlist;
	}		
										
			
//		caso ele entre nesse return quer dizer que ele achou um token que não esta 
//		nesse laço e não era esperado
//		
			
	
	//Declaracao de Variavel local
	private VarDeclarationStmt parseVarDeclarationStmt(TypeAst auxType, Identifier auxID) throws SyntacticException, LexicalException  {
					
			ArrayList<Identifier> auxIDlist = new ArrayList<Identifier>();
			auxIDlist.add(auxID);
			
			if(this.currentToken.getKind() == GrammarSymbols.COMMA){
				while(this.currentToken.getKind() != GrammarSymbols.SEMICOLON ){
					accept(GrammarSymbols.COMMA);
					auxIDlist.add(new Identifier(this.currentToken));
					accept(GrammarSymbols.ID);
				}
				//accept(GrammarSymbols.SEMICOLON);
			}else{
				//accept(GrammarSymbols.SEMICOLON);
			}
				
			return new VarDeclarationStmt(auxType, auxIDlist); 
		}
		
	private Arguments parseAgrms() throws SyntacticException, LexicalException {
		ArrayList<Expression> expressionList = new ArrayList<Expression>();
		expressionList.add(parseExpression());
		while(this.currentToken.getKind()==GrammarSymbols.COMMA){
			accept(GrammarSymbols.COMMA);
			expressionList.add(parseExpression());
		}
		return new Arguments(expressionList);
	}

	private Command parsePrintfStmt() throws SyntacticException, LexicalException {
		Token token = this.currentToken;
		Expression expression = null;
		accept(GrammarSymbols.PRINTF);
		accept(GrammarSymbols.LP);
		if(this.currentToken.getKind()!=GrammarSymbols.RP){
			expression = parseExpression();
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.SEMICOLON);
		return new Command(token, expression);
		
	}

	private Command parseReturnStmt() throws SyntacticException, LexicalException {
		Token token = this.currentToken;
		Expression expression = null;
		accept(GrammarSymbols.RETURN);
		if(this.currentToken.getKind()==GrammarSymbols.SEMICOLON){
			accept(GrammarSymbols.SEMICOLON);
		}else{
			expression = parseExpression();
			accept(GrammarSymbols.SEMICOLON);
		}
		return new Command(token, expression);
	}

	private IterationStmt parseIterationStmt() throws SyntacticException, LexicalException {
		ArrayList<Statement> statement = new ArrayList<Statement>(); 
		accept(GrammarSymbols.WHILE);
		accept(GrammarSymbols.LP);
		Expression expression = parseExpression();
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while (this.currentToken.getKind()!=GrammarSymbols.RB) {
			statement.add(parseStatement()); 
//			if(validacaoStatmant==1){ //esse if tem a função de impedir que o 
//				break;
//			}
		}
		accept(GrammarSymbols.RB);
		return new IterationStmt(expression, statement);
		
	}

	private SelectionStmt parseSelectionStmt() throws SyntacticException, LexicalException {
		Expression expression;
		ArrayList<Statement> statemant =  new ArrayList<Statement>();
		accept(GrammarSymbols.IF);
		accept(GrammarSymbols.LP);
			expression = parseExpression();
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while (this.currentToken.getKind()!=GrammarSymbols.RB) {
			statemant.add(parseStatement());

		}
		accept(GrammarSymbols.RB);
		if(this.currentToken.getKind()==GrammarSymbols.ELSE){
			accept(GrammarSymbols.ELSE);
			if(this.currentToken.getKind()==GrammarSymbols.LB){
				accept(GrammarSymbols.LB);
				while (this.currentToken.getKind()!=GrammarSymbols.RB) {
					statemant.add(parseStatement());
				}accept(GrammarSymbols.RB);
			}else if(this.currentToken.getKind()==GrammarSymbols.IF){
				parseSelectionStmt();
			}
			
			//
		}
		
		return new SelectionStmt(expression, statemant);
		
	}

	private Expression parseExpression() throws SyntacticException, LexicalException {
		SimpleExpression headSExpression = parseSimpleExpression();
		TBoolean tBool = null;
		SimpleExpression bodyExpression = null;
		while(this.currentToken.getKind()==GrammarSymbols.OP_BOOL){
			tBool = new TBoolean(this.currentToken);
			accept(GrammarSymbols.OP_BOOL);
			bodyExpression = parseSimpleExpression();
		}
		return new Expression(headSExpression, tBool, bodyExpression);
		
	}

	private SimpleExpression parseSimpleExpression() throws SyntacticException, LexicalException {
		Term headTerm = parseTerm();
		TOpAr tOpAr = null;
		Term bodyTerm = parseTerm();
		while(this.currentToken.getKind()==GrammarSymbols.OP_AR){
			tOpAr = new TOpAr(currentToken);
			accept(GrammarSymbols.OP_AR);
			bodyTerm = parseTerm();
		}
		return new SimpleExpression(headTerm, tOpAr, bodyTerm);
	}

	private Term parseTerm() throws SyntacticException, LexicalException {
		FactorExpression headFactor = parseFactor();
		TOpMul tOpMul = null;
		FactorExpression bodyFactor = parseFactor();
		while(this.currentToken.getKind()==GrammarSymbols.OP_MUL){
			tOpMul = new TOpMul(currentToken);
			accept(GrammarSymbols.OP_MUL);
			bodyFactor = parseFactor();
		}
		return new Term(headFactor, tOpMul, bodyFactor);
	}

	private FactorExpression parseFactor() throws SyntacticException, LexicalException {
		FactorExpression factorExpresion = null;
		if(this.currentToken.getKind()==GrammarSymbols.TRUE){
			factorExpresion = new FactorBoolean(new TBoolean(currentToken));
			accept(GrammarSymbols.TRUE);
		}else{
			if(this.currentToken.getKind()==GrammarSymbols.FALSE){
				factorExpresion = new FactorBoolean(new TBoolean(currentToken));
				accept(GrammarSymbols.FALSE);
			}else{
				if(this.currentToken.getKind()==GrammarSymbols.ID){
					factorExpresion = new factorID(new Identifier(this.currentToken));
					accept(GrammarSymbols.ID);
//					if(this.currentToken.getKind()==GrammarSymbols.LP){
//						accept(GrammarSymbols.LP);
//						while(this.currentToken.getKind()!=GrammarSymbols.RP){
//							parseAgrms();
//						}accept(GrammarSymbols.RP);
//					}
//				}else{
//					if(this.currentToken.getKind()==GrammarSymbols.COMMA){
//						accept(GrammarSymbols.COMMA);
//						parseAgrms();
					}else{
						//if(this.currentToken.getKind()==GrammarSymbols.NUMBER){
						factorExpresion = new FactorNumber(new Tinteger(this.currentToken));	
						accept(GrammarSymbols.NUMBER);
						//}
					}
			
				}
			}
		
		return factorExpresion;
	}
	

//	public static final int ID = 0;
//	public static final int LETTER = 1;
//	public static final int DIGIT = 2;
//	public static final int NUMBER = 3;
//	
//	public static final int INT = 5 ; 
//	public static final int OP_AR = 6 ; 
//	public static final int OP_MUL = 7 ; 
//	public static final int OP_BOOL = 8 ;
//	public static final int LP = 09; // simbolo '('
//	public static final int RP = 10; // simbolo ')'
//	public static final int LB = 11; // simbolo '{'
//	public static final int RB = 12; // simbolo '}'
//	public static final int vir = 13; // simbolo ','
//	public static final int SEMICOLON = 13; // simbolo ';'
//	public static final int EQUAL = 15; // simbolo '='
//	public static final int MAIN = 16; 
//	public static final int IF = 17;
//	public static final int ELSE = 18;
//	public static final int WHILE = 19;
//	public static final int PRINTF = 20;
//	public static final int RETURN = 21;
//	public static final int CONTINUE = 24;
//	public static final int BREAK = 25;
//	public static final int VOID = 26;
//	public static final int EOT = 100; //final do programa
	
	
}


