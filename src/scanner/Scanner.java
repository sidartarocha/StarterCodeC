package scanner;

import compiler.Properties;

import java.util.HashMap;
import java.util.Map;

import compiler.Compiler;

import parser.GrammarSymbols;
import util.Arquivo;

/**
 * Scanner class
 * @version 2010-september-04
 * @discipline Compiladores
 * @author Gustavo H P Carvalho
 * @email gustavohpcarvalho@ecomp.poli.br
 */
public class Scanner {

	// The file object that will be used to read the source code
	private Arquivo file;
	// The last char read from the source code
	private char currentChar;
	// The kind of the current token
	private GrammarSymbols currentKind;
	// Buffer to append characters read from file
	private StringBuffer currentSpelling;
	// Current line and column in the source file
	private int line, column;
	// Keywords
	private Map<String,GrammarSymbols> keywords;
	/**
	 * Default constructor
	 */
	public Scanner() {
		this.file = new Arquivo(Properties.sourceCodeLocation);		
		this.line = 0;
		this.column = 0;
		this.currentChar = this.file.readChar(); 
		this.currentSpelling = new StringBuffer();
		
		keywords = new HashMap<String,GrammarSymbols>();
		keywords.put("int", GrammarSymbols.INT);
		keywords.put("boolean", GrammarSymbols.BOOLEAN);
		keywords.put("main", GrammarSymbols.MAIN);
		keywords.put("if", GrammarSymbols.IF);
		keywords.put("else", GrammarSymbols.ELSE);
		keywords.put("while", GrammarSymbols.WHILE);
		keywords.put("true", GrammarSymbols.TRUE);
		keywords.put("false", GrammarSymbols.FALSE);
		keywords.put("void", GrammarSymbols.VOID);
		keywords.put("while", GrammarSymbols.WHILE);
		keywords.put("break", GrammarSymbols.BREAK);
		keywords.put("printf", GrammarSymbols.PRINTF);
		keywords.put("continue", GrammarSymbols.CONTINUE);
		keywords.put("return", GrammarSymbols.RETURN);
		
	}
	
	/**
	 * Returns the next token
	 * @return
	 * @throws LexicalException 
	 */ //TODO
	public Token getNextToken() throws LexicalException {
		while (this.isSeparator(this.currentChar)) {
			this.scanSeparator();
		}
		
		currentSpelling.delete(0, currentSpelling.length());
		
		GrammarSymbols kind = this.scanToken();
		
		return new Token(kind, currentSpelling.toString(), line, column);
	}
	
	/**
	 * Returns if a character is a separator
	 * @param c
	 * @return
	 */
	private boolean isSeparator(char c) {
		if ( c == '$' || c == ' ' || c == '\n' || c == '\t' ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Reads (and ignores) a separator
	 * @throws LexicalException
	 */ //TODO
	private void scanSeparator() throws LexicalException {
		if ( this.currentChar == '$' ) {
			while (this.currentChar != '\n') {
				this.getNextChar();
			}
		} else {
			this.getNextChar();
		}
	}
	
	/**
	 * Gets the next char
	 */
	private void getNextChar() {
		// Appends the current char to the string buffer
		this.currentSpelling.append(this.currentChar);
		// Reads the next one
		this.currentChar = this.file.readChar();
		// Increments the line and column
		this.incrementLineColumn();
	}
	
	/**
	 * Increments line and column
	 */
	private void incrementLineColumn() {
		// If the char read is a '\n', increments the line variable and assigns 0 to the column
		if ( this.currentChar == '\n' ) {
			this.line++;
			this.column = 0;
		// If the char read is not a '\n' 
		} else {
			// If it is a '\t', increments the column by 4
			if ( this.currentChar == '\t' ) {
				this.column = this.column + 4;
			// If it is not a '\t', increments the column by 1
			} else {
				this.column++;
			}
		}
	}
	
	/**
	 * Returns if a char is a digit (between 0 and 9)
	 * @param c
	 * @return
	 */
	private boolean isDigit(char c) {
		if ( c >= '0' && c <= '9' ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns if a char is a letter (between a and z or between A and Z)
	 * @param c
	 * @return
	 */
	private boolean isLetter(char c) {
		if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns if a char is a graphic (any ASCII visible character)
	 * @param c
	 * @return
	 */
	private boolean isGraphic(char c) {
		if ( c >= ' ' && c <= '~' ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Scans the next token
	 * Simulates the DFA that recognizes the language described by the lexical grammar
	 * @return
	 * @throws LexicalException
	 */ //TODO
	private GrammarSymbols scanToken() throws LexicalException {
		int estado = 0 ;
		while(true) {
			switch (estado) {
			case 0:
				if (currentChar == ';') {
					estado = 1;
				} else if (currentChar == '(') {
					estado = 2 ;
				} else if (currentChar == ')' ) {
					estado = 3 ; 
				} else if (currentChar == '{') {
					estado = 4 ;
				} else if (currentChar == '}') {
					estado = 5 ;
				} else if (currentChar == '=') {
					estado = 6 ;
				} else if (currentChar == '+' || currentChar == '-') {
					estado = 7 ;
				} else if (currentChar == '*' || currentChar == '/') {
					estado = 8 ;
				} else if (currentChar == ',') {
					estado = 9 ;
				} else if (currentChar == '<') {
					estado = 10 ;
				} else if (currentChar == '>') {
					estado = 10 ;
				} else if (currentChar == '!') {
					estado = 10 ;
				} else if (currentChar == '\000') {
					estado = 13 ;
				} else if (isLetter(currentChar)) {
					estado = 14 ;
				} else if (isDigit(currentChar)) {
					estado = 15 ;
				} else {
					estado = 17 ;
					break ;
				}

				//pegando o proximo char
				getNextChar();
				break;

			case 1 :
				return GrammarSymbols.SEMICOLON;

			case 2 :
				return GrammarSymbols.LP;
				//				if(isLetter(currentChar)){
				//					estado = 17;
				//				}else if(isDigit(currentChar)) {
				//					estado = 18;
				//				}else if(currentChar == ')'){
				//					estado = 3;
				//				}
				//				break;
			case 3 :
				return GrammarSymbols.RP;

			case 4 :
				return GrammarSymbols.LB;

			case 5 :
				return GrammarSymbols.RB;

			case 6 :
				if(currentChar == '='){
					estado = 15;
					break;
					//return GrammarSymbols.OP_BOOL;
				}
				return GrammarSymbols.EQUAL;

			case 7 :
				return GrammarSymbols.OP_AR;

			case 8 :
				return GrammarSymbols.OP_MUL;

			case 9 :
				return GrammarSymbols.COMMA;

			case 10 :
				if (currentChar == '=') {
					estado = 15;
					break;
					//return GrammarSymbols.OP_BOOL;
				}else {
					return GrammarSymbols.OP_BOOL;
				}

			case 13 :
				return GrammarSymbols.EOT;


			case 14 :
				while (isLetter(currentChar) || isDigit(currentChar)) {
					getNextChar();					
				}

				if (keywords.containsKey(currentSpelling.toString())) {
					return keywords.get(currentSpelling.toString());
				} else {
					return GrammarSymbols.ID;
				}

			case 15: 
				return GrammarSymbols.OP_BOOL;

			}
		}

	}
}





