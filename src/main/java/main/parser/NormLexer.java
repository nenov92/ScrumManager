// Generated from Norm.g4 by ANTLR 4.5.2
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
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, LPAREN=12, RPAREN=13, INTEGER=14, ROLE=15, NAME=16, 
		LOGICAL_OPERATOR=17, NEWLINE=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "LPAREN", "RPAREN", "INTEGER", "ROLE", "NAME", "LOGICAL_OPERATOR", 
		"NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'obligation'", "','", "'prohibition'", "'true'", "'false'", "'=='", 
		"'!='", "'>'", "'<'", "'>='", "'<='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"LPAREN", "RPAREN", "INTEGER", "ROLE", "NAME", "LOGICAL_OPERATOR", "NEWLINE", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public NormLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Norm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\6\17c\n\17\r\17\16"+
		"\17d\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0089\n\20\3\21\6\21\u008c\n"+
		"\21\r\21\16\21\u008d\3\22\3\22\3\22\3\22\5\22\u0094\n\22\3\23\5\23\u0097"+
		"\n\23\3\23\3\23\3\24\6\24\u009c\n\24\r\24\16\24\u009d\3\24\3\24\2\2\25"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25\3\2\5\3\2\62;\4\2C\\c|\4\2\13\13\"\"\u00a7\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\64\3\2\2\2\7\66\3\2\2\2\tB\3\2\2"+
		"\2\13G\3\2\2\2\rM\3\2\2\2\17P\3\2\2\2\21S\3\2\2\2\23U\3\2\2\2\25W\3\2"+
		"\2\2\27Z\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35b\3\2\2\2\37\u0088\3\2\2\2"+
		"!\u008b\3\2\2\2#\u0093\3\2\2\2%\u0096\3\2\2\2\'\u009b\3\2\2\2)*\7q\2\2"+
		"*+\7d\2\2+,\7n\2\2,-\7k\2\2-.\7i\2\2./\7c\2\2/\60\7v\2\2\60\61\7k\2\2"+
		"\61\62\7q\2\2\62\63\7p\2\2\63\4\3\2\2\2\64\65\7.\2\2\65\6\3\2\2\2\66\67"+
		"\7r\2\2\678\7t\2\289\7q\2\29:\7j\2\2:;\7k\2\2;<\7d\2\2<=\7k\2\2=>\7v\2"+
		"\2>?\7k\2\2?@\7q\2\2@A\7p\2\2A\b\3\2\2\2BC\7v\2\2CD\7t\2\2DE\7w\2\2EF"+
		"\7g\2\2F\n\3\2\2\2GH\7h\2\2HI\7c\2\2IJ\7n\2\2JK\7u\2\2KL\7g\2\2L\f\3\2"+
		"\2\2MN\7?\2\2NO\7?\2\2O\16\3\2\2\2PQ\7#\2\2QR\7?\2\2R\20\3\2\2\2ST\7@"+
		"\2\2T\22\3\2\2\2UV\7>\2\2V\24\3\2\2\2WX\7@\2\2XY\7?\2\2Y\26\3\2\2\2Z["+
		"\7>\2\2[\\\7?\2\2\\\30\3\2\2\2]^\7*\2\2^\32\3\2\2\2_`\7+\2\2`\34\3\2\2"+
		"\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\36\3\2\2\2fg\7R"+
		"\2\2gh\7T\2\2hi\7Q\2\2ij\7F\2\2jk\7W\2\2kl\7E\2\2lm\7V\2\2mn\7a\2\2no"+
		"\7Q\2\2op\7Y\2\2pq\7P\2\2qr\7G\2\2r\u0089\7T\2\2st\7U\2\2tu\7E\2\2uv\7"+
		"T\2\2vw\7W\2\2wx\7O\2\2xy\7a\2\2yz\7O\2\2z{\7C\2\2{|\7U\2\2|}\7V\2\2}"+
		"~\7G\2\2~\u0089\7T\2\2\177\u0080\7F\2\2\u0080\u0081\7G\2\2\u0081\u0082"+
		"\7X\2\2\u0082\u0083\7G\2\2\u0083\u0084\7N\2\2\u0084\u0085\7Q\2\2\u0085"+
		"\u0086\7R\2\2\u0086\u0087\7G\2\2\u0087\u0089\7T\2\2\u0088f\3\2\2\2\u0088"+
		"s\3\2\2\2\u0088\177\3\2\2\2\u0089 \3\2\2\2\u008a\u008c\t\3\2\2\u008b\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\"\3\2\2\2\u008f\u0090\7(\2\2\u0090\u0094\7(\2\2\u0091\u0092\7~\2\2\u0092"+
		"\u0094\7~\2\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094$\3\2\2\2\u0095"+
		"\u0097\7\17\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3"+
		"\2\2\2\u0098\u0099\7\f\2\2\u0099&\3\2\2\2\u009a\u009c\t\4\2\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\b\24\2\2\u00a0(\3\2\2\2\t\2d\u0088\u008d\u0093"+
		"\u0096\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}