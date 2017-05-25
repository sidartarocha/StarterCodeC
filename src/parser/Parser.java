package parser;

import scanner.Scanner;

import java.util.ArrayList;

import scanner.LexicalException;
import scanner.Token;

import util.AST.AST;
import util.AST.Declaration;
import util.AST.FunDeclaration;
import util.AST.Identifier;
import util.AST.Program;
import util.AST.TypeAst;
import util.AST.VarDeclaration;

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
			System.out.println("(" + "\"" + currentToken.getSpelling() +"\"" + "," + currentToken.getKind() + ")");
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
		//this.parseProgram();
//		parseProgram();
		
		
		return parseProgram();
	}

	private Program parseProgram() throws SyntacticException, LexicalException {
		Program prog = null;
		ArrayList<Declaration> declaration = new ArrayList<Declaration>();
		while (this.currentToken.getKind() != GrammarSymbols.EOT){
			
			declaration.add(parseDeclaration());
			
		}
		prog = new Program(declaration);
		accept(GrammarSymbols.EOT);
		
		return prog;	
	}		

	/*	Chamada da funcao parserDeclaration
	 *	tipo void 
	 * 
	*/
	private Declaration parseDeclaration() throws SyntacticException, LexicalException {
		/*Analisa se o que foi passado  um VarDeclaratio ou uma functionDeclaration
		 * Esse if faz a verificação se esta sendo recebido um token tipo INT, BOOLEAN ou VOID
		 *  
		 */
		Declaration decl = null;
		ArrayList<VarDeclaration> varD = new ArrayList<VarDeclaration>();
		ArrayList<FunDeclaration> funD = new ArrayList<FunDeclaration>();
		Identifier auxID;
		TypeAst auxType; 
		
			if (this.currentToken.getKind() == GrammarSymbols.INT){
				auxType = parseType(GrammarSymbols.INT);
				//accept(GrammarSymbols.INT);
				auxID = parserIdentifier(GrammarSymbols.ID);
				accept(GrammarSymbols.ID);
				if(this.currentToken.getKind() == GrammarSymbols.COMMA){
						accept(GrammarSymbols.COMMA);
						varD.add(parseVarDeclaration());
						accept(GrammarSymbols.SEMICOLON);
				}else{
						funD.add(parseFunDeclaration());
				}
			}else{
				if(this.currentToken.getKind() == GrammarSymbols.BOOLEAN){
					accept(GrammarSymbols.BOOLEAN);
					accept(GrammarSymbols.ID);
					if(this.currentToken.getKind() == GrammarSymbols.COMMA){
						accept(GrammarSymbols.COMMA);
						varD.add(parseVarDeclaration());
						accept(GrammarSymbols.SEMICOLON);
					}else{
						funD.add(parseFunDeclaration());
					}
				} else {
					accept(GrammarSymbols.VOID);
					accept(GrammarSymbols.ID);
					funD.add(parseFunDeclaration());
				}
			}
	decl = new Declaration(varD, funD);		
	return decl;
	}
				
	

	private TypeAst parseType(GrammarSymbols i) {
		// TODO Auto-generated method stub
		return null;
	}

	private Identifier parserIdentifier(GrammarSymbols i) {
		// TODO Auto-generated method stub
		return null;
	}

	//Declaracao de Variavel
	private VarDeclaration parseVarDeclaration() throws SyntacticException, LexicalException {
		if(this.currentToken.getKind() == GrammarSymbols.INT){
			accept(GrammarSymbols.INT);
			while (this.currentToken.getKind()==GrammarSymbols.ID){
				accept(GrammarSymbols.ID);
				if(this.currentToken.getKind() == GrammarSymbols.COMMA){
					accept(GrammarSymbols.COMMA);
				}else{
					//if(this.currentToken.getKind() == GrammarSymbols.SEMICOLON){
						break;
						//accept(GrammarSymbols.COMMA);
				}
			}
		}else{
			accept(GrammarSymbols.BOOLEAN);
			while (this.currentToken.getKind()==GrammarSymbols.ID){
				accept(GrammarSymbols.ID);
				if(this.currentToken.getKind() == GrammarSymbols.COMMA){
					accept(GrammarSymbols.COMMA);
				}else{
					//if(this.currentToken.getKind() == GrammarSymbols.SEMICOLON){
						break;
						//accept(GrammarSymbols.COMMA);
				}
			}
		}
		return null;
		
	}
	
	//Declaracao de funcao
	private FunDeclaration parseFunDeclaration() throws SyntacticException, LexicalException {
		accept(GrammarSymbols.LP);
		while (this.currentToken.getKind()!=GrammarSymbols.RP){
			parseParmDeclaration();
		}
		accept(GrammarSymbols.RP);
		accept(GrammarSymbols.LB);
		while(this.currentToken.getKind()!=GrammarSymbols.RB){
			int validacaoStatmant = parseStatement(); 
			if(validacaoStatmant==1){ //esse if tem a função de impedir que o codigo entre em loop
				break;
			}
		}
		accept(GrammarSymbols.RB);
		return null;
		
	}

	private void parseParmDeclaration() throws SyntacticException, LexicalException {
		while(this.currentToken.getKind()!=GrammarSymbols.RP){
			parseVarDeclaration();
		}
	}

	private int parseStatement() throws SyntacticException, LexicalException {
		while (this.currentToken.getKind()!=GrammarSymbols.RB){
			if(this.currentToken.getKind()==GrammarSymbols.IF){
				parseSelectionStmt();
			}else{
				if (this.currentToken.getKind()==GrammarSymbols.WHILE){
					parseIterationStmt();
				}else{
					if(this.currentToken.getKind()==GrammarSymbols.RETURN){
					parseReturnStmt();
					}else{
						if (this.currentToken.getKind()==GrammarSymbols.PRINTF) {
							parsePrintfStmt();
						}else{
							if (this.currentToken.getKind()==GrammarSymbols.BREAK){
								accept(GrammarSymbols.BREAK);
								//break;
							}else{
								if(this.currentToken.getKind()==GrammarSymbols.CONTINUE){
									accept(GrammarSymbols.CONTINUE);
									//continue;
								}else{
									//Declaração de Variavel Local
									if(this.currentToken.getKind()==GrammarSymbols.INT ||
											this.currentToken.getKind()==GrammarSymbols.BOOLEAN){
										//while(this.currentToken.getKind()!=GrammarSymbols.SEMICOLON){
											parseVarDeclaration();
										//}
										accept(GrammarSymbols.SEMICOLON);
									}else{//inicialização de variavel
										if(this.currentToken.getKind()==GrammarSymbols.ID){
											accept(GrammarSymbols.ID);
											if(this.currentToken.getKind()==GrammarSymbols.EQUAL){
												accept(GrammarSymbols.EQUAL);
												parseExpression();
												accept(GrammarSymbols.SEMICOLON);
											}													
										}else{
											if(this.currentToken.getKind()==GrammarSymbols.LP){
												accept(GrammarSymbols.LP);
												while(this.currentToken.getKind()!=GrammarSymbols.RP){
													parseAgrms();
												}
											accept(GrammarSymbols.RP);
											accept(GrammarSymbols.SEMICOLON);
											}else{
												return 1;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}	
									
			
//		caso ele entre nesse return quer dizer que ele achou um token que não esta 
//		nesse laço e não era esperado
//		
			

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
		if(this.currentToken.getKind()!=GrammarSymbols.RP){
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
			if(validacaoStatmant==1){ 
				//esse if tem a função de impedir que o 
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
				}accept(GrammarSymbols.RB);
			}else if(this.currentToken.getKind()==GrammarSymbols.IF){
				parseSelectionStmt();
			}
			
			//
		}
		
	}

	private void parseExpression() throws SyntacticException, LexicalException {
		parseSimpleExpression();
		while(this.currentToken.getKind()==GrammarSymbols.OP_BOOL){
			accept(GrammarSymbols.OP_BOOL);
			parseSimpleExpression();
		}
		
	}

	private void parseSimpleExpression() throws SyntacticException, LexicalException {
		parseTerm();
		while(this.currentToken.getKind()==GrammarSymbols.OP_AR){
			accept(GrammarSymbols.OP_AR);
			parseTerm();
		}
	}

	private void parseTerm() throws SyntacticException, LexicalException {
		parseFactor();
		while(this.currentToken.getKind()==GrammarSymbols.OP_MUL){
			accept(GrammarSymbols.OP_MUL);
			parseFactor();
		}
	}

	private void parseFactor() throws SyntacticException, LexicalException {
		if(this.currentToken.getKind()==GrammarSymbols.TRUE){
			accept(GrammarSymbols.TRUE);
		}else{
			if(this.currentToken.getKind()==GrammarSymbols.FALSE){
			accept(GrammarSymbols.FALSE);
			}else{
				if(this.currentToken.getKind()==GrammarSymbols.ID){
					accept(GrammarSymbols.ID);
					if(this.currentToken.getKind()==GrammarSymbols.LP){
						accept(GrammarSymbols.LP);
						while(this.currentToken.getKind()!=GrammarSymbols.RP){
							parseAgrms();
						}accept(GrammarSymbols.RP);
					}
				}else{
					if(this.currentToken.getKind()==GrammarSymbols.COMMA){
						accept(GrammarSymbols.COMMA);
						parseAgrms();
					}else{
						//if(this.currentToken.getKind()==GrammarSymbols.NUMBER){
							accept(GrammarSymbols.NUMBER);
						//}
					}
			
				}
			}
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


