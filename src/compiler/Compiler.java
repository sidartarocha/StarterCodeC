package compiler;

import checker.Checker;
import checker.SemanticException;
import parser.Parser;
import parser.SyntacticException;
import scanner.LexicalException;
import util.AST.AST;
import util.symbolsTable.IdentificationTable;

/**
 * Compiler driver
 * @version 2010-september-04
 * @discipline Compiladores
 * @author Gustavo H P Carvalho
 * @email gustavohpcarvalho@ecomp.poli.br
 */
public class Compiler {
	
	// Compiler identification table
	public static IdentificationTable identificationTable = null;

	/**
	 * Compiler start point
	 * @param args - none
	 * @throws LexicalException 
	 * @throws SemanticException 
	 */
	public static void main(String[] args) throws LexicalException, SemanticException {
		// Initializes the identification table with the reserved words 
		Compiler.initIdentificationTable();
		
		// Creates the parser object
		Parser p ;//= new Parser();
		Checker c ;//= null;
		// Creates the AST object
		AST astRoot = null;
		
		try {
			// Parses the source code
			p = new Parser();
			c = new Checker();
			astRoot = p.parse();
			System.out.println("\n-- AST STRUCTURE --");
			if ( astRoot != null ) {
				System.out.println(astRoot.toString(0));
				System.out.println("\n-- AST STRUCTURE END --");
			}
			  	System.out.println ("Contextual Analysis Init");
			  	c.check(astRoot);
			  	c.toString();
			  	System.out.println ("Contextual Analysis End");
		} catch (SyntacticException e) {
			// Shows the syntactic/lexical error stack trace 
			e.printStackTrace();
		} catch (SemanticException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	
	/**
	 * Initializes the identification table with the reserved words
	 */
	private static void initIdentificationTable() {
		// Calls the initializer methods
		Compiler.identificationTable = new IdentificationTable();
	}
	
}
