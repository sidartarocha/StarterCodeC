package parser;

import scanner.Scanner;



import scanner.LexicalException;
import scanner.Token;

import util.AST.AST;

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
		//função para verificar o token corrente
				if (this.currentToken.getKind() == kind) {
					System.out.println("(" + "\"" + currentToken.getSpelling() +"\"" + "," + currentToken.getKind() + ")");
					this.acceptIt();
				}else{
					throw new SyntacticException("SyntacticException error: expecting " + kind + ", but found " 
							+ this.currentToken.getKind(), this.currentToken);
				}
	}
	
	/**
	 * Gets next token
	 * @param kind
	 * @throws LexicalException
	 */
	
	private void acceptIt() throws SyntacticException, LexicalException {
		//Função para aceitar o token corrente
		this.currentToken = this.scanner.getNextToken();
	}

	/**
	 * Verifies if the source program is syntactically correct
	 * @throws SyntacticException
	 * @throws LexicalException
	 */ 
	public AST parse() throws SyntacticException, LexicalException {
		this.parseProgram();
		accept(GrammarSymbols.EOT);
		
		return null;
	}

	private void parseProgram() throws SyntacticException, LexicalException {
		while (this.currentToken.getKind() != GrammarSymbols.EOT){
			parseDeclaration();
		}	
	}		
	
	
//	while (this.currentToken.getKind() != GrammarSymbols.EOT) {
//		if (this.currentToken.getKind() == GrammarSymbols.VAR) {
//			parseVariableDeclaration();
//			accept(GrammarSymbols.SEMICOLON);
//		} else {
//			parseFunctionDeclaration();
//		}
//	}
	
	private void parseDeclaration() throws SyntacticException, LexicalException {
		//Analisa se o que foi passado é um void se positivo chama parseFunDeclaration
		if (this.currentToken.getKind() == GrammarSymbols.VOID) {
			acceptIt();
			accept(GrammarSymbols.ID);
			accept(GrammarSymbols.LP);
			parseFunDeclaration();
			
		}			
		//Analisa se o que foi passado é um VarDeclaratio ou uma function 
		if (this.currentToken.getKind() == GrammarSymbols.INT 
				|| this.currentToken.getKind() == GrammarSymbols.BOOLEAN) {
			//acceptIt();
			accept(GrammarSymbols.INT);
			if(this.currentToken.getKind()==GrammarSymbols.MAIN){
				accept(GrammarSymbols.MAIN);
			}else if(this.currentToken.getKind()==GrammarSymbols.ID){
				accept(GrammarSymbols.ID);
			}
			if (this.currentToken.getKind() == GrammarSymbols.LP){
				parseFunDeclaration();
			} else {
				if(this.currentToken.getKind() == GrammarSymbols.COMMA) {
					accept(GrammarSymbols.COMMA);
					while (this.currentToken.getKind()!=GrammarSymbols.SEMICOLON){
						parseVarDeclaration();
					}
					accept(GrammarSymbols.SEMICOLON);
					

				}else if(this.currentToken.getKind() == GrammarSymbols.SEMICOLON){
					accept(GrammarSymbols.SEMICOLON);
				}
				
			}
		}
	}

	//Declaração de Variavel
	private void parseVarDeclaration() throws SyntacticException, LexicalException {
			accept(GrammarSymbols.ID);
			if(this.currentToken.getKind() == GrammarSymbols.COMMA){
				accept(GrammarSymbols.COMMA);
			}	
	}
	
	//Declaração de função
	private void parseFunDeclaration() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.LP);
		while (this.currentToken.getKind()!=GrammarSymbols.RP){
			parseParmDeclaration();
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while(this.currentToken.getKind()!=GrammarSymbols.RB){
			int validacaoStatmant = parseStatement(); 
			if(validacaoStatmant==1){ //esse if tem a função de impedir que o 
				break;
			}
		}
		accept(GrammarSymbols.RB);
		
	}

	private void parseParmDeclaration() throws SyntacticException, LexicalException {
		if(this.currentToken.getKind()==GrammarSymbols.BOOLEAN){
			accept(GrammarSymbols.BOOLEAN);
			accept(GrammarSymbols.ID);
			if(this.currentToken.getKind()==GrammarSymbols.COMMA){
				accept(GrammarSymbols.COMMA);
			}
		}
		if(this.currentToken.getKind()==GrammarSymbols.INT){
			accept(GrammarSymbols.INT);
			accept(GrammarSymbols.ID);
			if(this.currentToken.getKind()==GrammarSymbols.COMMA){
				accept(GrammarSymbols.COMMA);
			}
		}
	}

	private int parseStatement() throws SyntacticException, LexicalException {
		while (this.currentToken.getKind()!=GrammarSymbols.RB){
			if(this.currentToken.getKind()==GrammarSymbols.IF){
				parseSelectionStmt();
			}else if (this.currentToken.getKind()==GrammarSymbols.WHILE){
				parseIterationStmt();				
			}else if(this.currentToken.getKind()==GrammarSymbols.RETURN){
				parseReturnStmt();
			}else if (this.currentToken.getKind()==GrammarSymbols.PRINTF) {
				parsePrintfStmt();				
			}else if (this.currentToken.getKind()==GrammarSymbols.BREAK){
				accept(GrammarSymbols.BREAK);
				//break;
			}else if(this.currentToken.getKind()==GrammarSymbols.CONTINUE){
				accept(GrammarSymbols.CONTINUE);
				//continue;
			}else if(this.currentToken.getKind()==GrammarSymbols.INT){ //declaração de variavel local
				accept(GrammarSymbols.INT);
				while(this.currentToken.getKind()!=GrammarSymbols.SEMICOLON){
					parseVarDeclaration();
				}
				accept(GrammarSymbols.SEMICOLON);
			}else if(this.currentToken.getKind()==GrammarSymbols.BOOLEAN){ //declaração de variavel local
				accept(GrammarSymbols.BOOLEAN);
				parseVarDeclaration();
				accept(GrammarSymbols.SEMICOLON);
			}else if(this.currentToken.getKind()==GrammarSymbols.ID){
				accept(GrammarSymbols.ID);
				if(this.currentToken.getKind()==GrammarSymbols.EQUAL){
					accept(GrammarSymbols.EQUAL);
					parseExpression();
					accept(GrammarSymbols.SEMICOLON);
				}else if(this.currentToken.getKind()==GrammarSymbols.LP){
					accept(GrammarSymbols.LP);
						while(this.currentToken.getKind()!=GrammarSymbols.RP){
							parseAgrms();
						}
					accept(GrammarSymbols.RP);
					accept(GrammarSymbols.SEMICOLON);
					
				}
			}else{
//		caso ele entre nesse return quer dizer que ele achou um token que não esta 
//		nesse laço e não era esperado
//		
				return 1;
				
			}
			
		}
		return 0;
		
	}

	private void parseAgrms() throws SyntacticException, LexicalException {
		parseExpression();
		while(this.currentToken.getKind()==GrammarSymbols.COMMA){
			accept(GrammarSymbols.COMMA);
			parseExpression();
		}
		
	}

	private void parsePrintfStmt() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.PRINTF);
		accept(GrammarSymbols.LP);
		while(this.currentToken.getKind()!=GrammarSymbols.RP){
			parseExpression();
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.SEMICOLON);
		
	}

	private void parseReturnStmt() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.RETURN);
		if(this.currentToken.getKind()==GrammarSymbols.SEMICOLON){
			accept(GrammarSymbols.SEMICOLON);
		}else{
			parseExpression();
			accept(GrammarSymbols.SEMICOLON);
		}
		
	}

	private void parseIterationStmt() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.WHILE);
		accept(GrammarSymbols.LP);
			parseExpression();
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while (this.currentToken.getKind()!=GrammarSymbols.RB) {
			int validacaoStatmant = parseStatement(); 
			if(validacaoStatmant==1){ //esse if tem a função de impedir que o 
				break;
			}
		}
		accept(GrammarSymbols.RB);
		
	}

	private void parseSelectionStmt() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.IF);
		accept(GrammarSymbols.LP);
			parseExpression();
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while (this.currentToken.getKind()!=GrammarSymbols.RB) {
			int validacaoStatmant = parseStatement(); 
			if(validacaoStatmant==1){ //esse if tem a função de impedir que o 
				break;
			}
		}
		accept(GrammarSymbols.RB);
		if(this.currentToken.getKind()==GrammarSymbols.ELSE){
			accept(GrammarSymbols.ELSE);
			if(this.currentToken.getKind()==GrammarSymbols.LB){
				accept(GrammarSymbols.LB);
				while (this.currentToken.getKind()!=GrammarSymbols.RB) {
					int validacaoStatmant = parseStatement(); 
					if(validacaoStatmant==1){ //esse if tem a função de impedir que o 
						break;
					}
				}
			}else if(this.currentToken.getKind()==GrammarSymbols.IF){
				parseSelectionStmt();
			}
			
			accept(GrammarSymbols.RB);
		}
		
	}

	private void parseExpression() throws SyntacticException, LexicalException {
		parseSimpleExpression();
		if(this.currentToken.getKind()==GrammarSymbols.OP_BOOL){
			accept(GrammarSymbols.OP_BOOL);
			if(this.currentToken.getKind()==GrammarSymbols.OP_BOOL){
				accept(GrammarSymbols.OP_BOOL);
			}parseSimpleExpression();
		}
		
	}

	private void parseSimpleExpression() throws SyntacticException, LexicalException {
		parseTerm();
		if(this.currentToken.getKind()==GrammarSymbols.OP_AR){
			accept(GrammarSymbols.OP_AR);
			parseTerm();
		}
	}

	private void parseTerm() throws SyntacticException, LexicalException {
		parseFactor();
		if(this.currentToken.getKind()==GrammarSymbols.OP_MUL){
			accept(GrammarSymbols.OP_MUL);
			parseFactor();
		}
	}

	private void parseFactor() throws SyntacticException, LexicalException {
		if(this.currentToken.getKind()==GrammarSymbols.TRUE){
			accept(GrammarSymbols.TRUE);
		}
		if(this.currentToken.getKind()==GrammarSymbols.FALSE){
			accept(GrammarSymbols.FALSE);
		}
		if(this.currentToken.getKind()==GrammarSymbols.ID){
			accept(GrammarSymbols.ID);
			if(this.currentToken.getKind()==GrammarSymbols.LP){
				accept(GrammarSymbols.LP);
					while(this.currentToken.getKind()!=GrammarSymbols.RP){
						parseAgrms();
					}
				accept(GrammarSymbols.RP);
			}else if(this.currentToken.getKind()==GrammarSymbols.COMMA){
				accept(GrammarSymbols.COMMA);
				parseAgrms();
			}
		}
		if(this.currentToken.getKind()==GrammarSymbols.NUMBER){
			accept(GrammarSymbols.NUMBER);
		}
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


