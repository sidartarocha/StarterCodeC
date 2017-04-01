package parser;

import scanner.Scanner;

import com.sun.xml.internal.fastinfoset.vocab.ParserVocabulary;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

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
					System.out.println("(" + currentToken.getSpelling() + "," + currentToken.getKind() + ")");
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
			acceptIt();
			accept(GrammarSymbols.ID);
			if (this.currentToken.getKind() == GrammarSymbols.LP){
				parseFunDeclaration();
			} else {
				if(this.currentToken.getKind() == GrammarSymbols.COMMA) {
					accept(GrammarSymbols.COMMA);
					while (this.currentToken.getKind()!=GrammarSymbols.SEMICOLON){
						parseVarDeclaration();
					}
					accept(GrammarSymbols.SEMICOLON);

				}	
			}
		}
	}

	//Declaração de Variavel
	private void parseVarDeclaration() throws SyntacticException, LexicalException {
			accept(GrammarSymbols.ID);
			accept(GrammarSymbols.COMMA);
	}
	
	//Declaração de função
	private void parseFunDeclaration() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.LP);
		while (this.currentToken.getKind()!=GrammarSymbols.RP){
			parseVarDeclaration();
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while(this.currentToken.getKind()!=GrammarSymbols.RB){
			parseStatement();
		}
		accept(GrammarSymbols.RB);
		
	}

	private void parseStatement() {
		// TODO Auto-generated method stub
		
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


