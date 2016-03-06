// Generated from Norm.g4 by ANTLR 4.4
package main.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NormLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, LPAREN=4, RPAREN=5, INTEGER=6, ROLE=7, FUNCTION=8, 
		BOOLEAN=9, TUPLE=10, LOGICAL_OPERATOR=11, CONDITION=12, NEWLINE=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "LPAREN", "RPAREN", "INTEGER", "ROLE", "FUNCTION", 
		"BOOLEAN", "TUPLE", "LOGICAL_OPERATOR", "CONDITION", "NEWLINE", "WS"
	};


	public NormLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Norm.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20\u00a4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\6\7>\n\7\r\7\16\7?\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bd\n\b\3\t\6\tg\n\t\r\t\16"+
		"\th\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\13\6\13w\n\13\r\13"+
		"\16\13x\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0084\n\13\3"+
		"\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r\3\r\3\r"+
		"\7\r\u0094\n\r\f\r\16\r\u0097\13\r\3\16\5\16\u009a\n\16\3\16\3\16\3\17"+
		"\6\17\u009f\n\17\r\17\16\17\u00a0\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\6\3\2\62;\4\2C"+
		"\\c|\4\2>>@@\4\2\13\13\"\"\u00b2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\3\37\3\2\2\2\5+\3\2\2\2\7\66\3\2\2\2\t8\3\2\2\2\13:\3\2\2\2\r=\3\2\2"+
		"\2\17c\3\2\2\2\21f\3\2\2\2\23s\3\2\2\2\25v\3\2\2\2\27\u008d\3\2\2\2\31"+
		"\u008f\3\2\2\2\33\u0099\3\2\2\2\35\u009e\3\2\2\2\37 \7r\2\2 !\7t\2\2!"+
		"\"\7q\2\2\"#\7j\2\2#$\7k\2\2$%\7d\2\2%&\7k\2\2&\'\7v\2\2\'(\7k\2\2()\7"+
		"q\2\2)*\7p\2\2*\4\3\2\2\2+,\7q\2\2,-\7d\2\2-.\7n\2\2./\7k\2\2/\60\7i\2"+
		"\2\60\61\7c\2\2\61\62\7v\2\2\62\63\7k\2\2\63\64\7q\2\2\64\65\7p\2\2\65"+
		"\6\3\2\2\2\66\67\7.\2\2\67\b\3\2\2\289\7*\2\29\n\3\2\2\2:;\7+\2\2;\f\3"+
		"\2\2\2<>\t\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\16\3\2\2\2A"+
		"B\7R\2\2BC\7T\2\2CD\7Q\2\2DE\7F\2\2EF\7W\2\2FG\7E\2\2GH\7V\2\2HI\7a\2"+
		"\2IJ\7Q\2\2JK\7Y\2\2KL\7P\2\2LM\7G\2\2Md\7T\2\2NO\7U\2\2OP\7E\2\2PQ\7"+
		"T\2\2QR\7W\2\2RS\7O\2\2ST\7a\2\2TU\7O\2\2UV\7C\2\2VW\7U\2\2WX\7V\2\2X"+
		"Y\7G\2\2Yd\7T\2\2Z[\7F\2\2[\\\7G\2\2\\]\7X\2\2]^\7G\2\2^_\7N\2\2_`\7Q"+
		"\2\2`a\7R\2\2ab\7G\2\2bd\7T\2\2cA\3\2\2\2cN\3\2\2\2cZ\3\2\2\2d\20\3\2"+
		"\2\2eg\t\3\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\22\3\2\2\2jk\7"+
		"v\2\2kl\7t\2\2lm\7w\2\2mt\7g\2\2no\7h\2\2op\7c\2\2pq\7n\2\2qr\7u\2\2r"+
		"t\7g\2\2sj\3\2\2\2sn\3\2\2\2t\24\3\2\2\2uw\t\3\2\2vu\3\2\2\2wx\3\2\2\2"+
		"xv\3\2\2\2xy\3\2\2\2y\u0083\3\2\2\2z{\7?\2\2{\u0084\7?\2\2|}\7#\2\2}\u0084"+
		"\7?\2\2~\u0084\t\4\2\2\177\u0080\7@\2\2\u0080\u0084\7?\2\2\u0081\u0082"+
		"\7>\2\2\u0082\u0084\7?\2\2\u0083z\3\2\2\2\u0083|\3\2\2\2\u0083~\3\2\2"+
		"\2\u0083\177\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0088"+
		"\5\23\n\2\u0086\u0088\5\r\7\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2"+
		"\u0088\26\3\2\2\2\u0089\u008a\7(\2\2\u008a\u008e\7(\2\2\u008b\u008c\7"+
		"~\2\2\u008c\u008e\7~\2\2\u008d\u0089\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\30\3\2\2\2\u008f\u0095\5\25\13\2\u0090\u0091\5\27\f\2\u0091\u0092\5\25"+
		"\13\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\32\3\2\2\2\u0097\u0095\3\2\2"+
		"\2\u0098\u009a\7\17\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009c\7\f\2\2\u009c\34\3\2\2\2\u009d\u009f\t\5\2"+
		"\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\17\2\2\u00a3\36\3\2\2\2\16"+
		"\2?chsx\u0083\u0087\u008d\u0095\u0099\u00a0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}