package parser;


/**
 * This class contains codes for each grammar terminal
 * @version 2010-september-04
 * @discipline Compiladores
 * @author Gustavo H P Carvalho
 * @email gustavohpcarvalho@ecomp.poli.br
 */
public class GrammarSymbols {

	// Language terminals (starts from 0)
	//public static final int ID = 0;
	//TODO
	//public static final int EOT = 1000;
	
	
	apoio

	public static final int IDENTIFIER = 0;
	public static final int letter = 1
	public static final int digit = 2;
	public static final int number = 3;
	public static final int type = 4 ;
	public static final int INT = 5 ; 
	public static final int op_ar = 6 ; 
	public static final int op_mul = 7 ; 
	public static final int op_bool = 8 ;
	public static final int lp = 09; // simbolo '('
	public static final int rp = 10; // simbolo ')'
	public static final int lb = 11; // simbolo '{'
	public static final int rb = 12; // simbolo '}'
	public static final int vir = 13; // simbolo ','
	public static final int sc = 13; // simbolo ';'
	public static final int co = 14; // simbolo ':'	
	public static final int eq = 15; // simbolo '='
//	public static final int dot = 32; // simbolo '.'
	
	public static final int eof = 100; //final do programa
	
	public static final int MAIN = 16; 
	public static final int IF = 17;
	public static final int ELSE = 18;
	public static final int DO = 19;
	public static final int WHILE = 20;
	public static final int PRINTF = 21;
	public static final int RETURN = 22;
	public static final int TRUE = 23;
	public static final int FALSE = 24;
	public static final int CONTINUE = 25;
	public static final int BREAK = 26;
	public static final int VOID = 27;
	
	


	Identifier, 
	Op_Ar,
	Op_Mul,
	Op_Bool,
	Number,
	Boolean,
	RP,
	LP,
	SEMICOLON,
	RB,
	LB, 
	if,
	else , while , do , void , break , continue , return , printf 
	, main , int , return
	
}
