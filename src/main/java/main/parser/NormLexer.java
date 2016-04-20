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
		T__9=10, T__10=11, T__11=12, LPAREN=13, RPAREN=14, INTEGER=15, ROLE=16, 
		NAME=17, LOGICAL_OPERATOR=18, NEWLINE=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "LPAREN", "RPAREN", "INTEGER", "ROLE", "NAME", 
		"LOGICAL_OPERATOR", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'norm'", "','", "'obligation'", "'prohibition'", "'true'", "'false'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LPAREN", "RPAREN", "INTEGER", "ROLE", "NAME", "LOGICAL_OPERATOR", 
		"NEWLINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00a7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\6\20j\n\20\r\20\16\20k\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u008f"+
		"\n\21\3\22\6\22\u0092\n\22\r\22\16\22\u0093\3\23\3\23\3\23\3\23\5\23\u009a"+
		"\n\23\3\24\5\24\u009d\n\24\3\24\3\24\3\25\6\25\u00a2\n\25\r\25\16\25\u00a3"+
		"\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\5\3\2\62;\4\2C\\c|\4\2"+
		"\13\13\"\"\u00ad\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\60"+
		"\3\2\2\2\7\62\3\2\2\2\t=\3\2\2\2\13I\3\2\2\2\rN\3\2\2\2\17T\3\2\2\2\21"+
		"W\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31a\3\2\2\2\33d\3\2\2\2"+
		"\35f\3\2\2\2\37i\3\2\2\2!\u008e\3\2\2\2#\u0091\3\2\2\2%\u0099\3\2\2\2"+
		"\'\u009c\3\2\2\2)\u00a1\3\2\2\2+,\7p\2\2,-\7q\2\2-.\7t\2\2./\7o\2\2/\4"+
		"\3\2\2\2\60\61\7.\2\2\61\6\3\2\2\2\62\63\7q\2\2\63\64\7d\2\2\64\65\7n"+
		"\2\2\65\66\7k\2\2\66\67\7i\2\2\678\7c\2\289\7v\2\29:\7k\2\2:;\7q\2\2;"+
		"<\7p\2\2<\b\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7j\2\2AB\7k\2\2BC\7d"+
		"\2\2CD\7k\2\2DE\7v\2\2EF\7k\2\2FG\7q\2\2GH\7p\2\2H\n\3\2\2\2IJ\7v\2\2"+
		"JK\7t\2\2KL\7w\2\2LM\7g\2\2M\f\3\2\2\2NO\7h\2\2OP\7c\2\2PQ\7n\2\2QR\7"+
		"u\2\2RS\7g\2\2S\16\3\2\2\2TU\7?\2\2UV\7?\2\2V\20\3\2\2\2WX\7#\2\2XY\7"+
		"?\2\2Y\22\3\2\2\2Z[\7@\2\2[\24\3\2\2\2\\]\7>\2\2]\26\3\2\2\2^_\7@\2\2"+
		"_`\7?\2\2`\30\3\2\2\2ab\7>\2\2bc\7?\2\2c\32\3\2\2\2de\7*\2\2e\34\3\2\2"+
		"\2fg\7+\2\2g\36\3\2\2\2hj\t\2\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2l \3\2\2\2mn\7R\2\2no\7T\2\2op\7Q\2\2pq\7F\2\2qr\7W\2\2rs\7E\2\2s"+
		"t\7V\2\2tu\7a\2\2uv\7Q\2\2vw\7Y\2\2wx\7P\2\2xy\7G\2\2y\u008f\7T\2\2z{"+
		"\7U\2\2{|\7E\2\2|}\7T\2\2}~\7W\2\2~\177\7O\2\2\177\u0080\7a\2\2\u0080"+
		"\u0081\7O\2\2\u0081\u0082\7C\2\2\u0082\u0083\7U\2\2\u0083\u0084\7V\2\2"+
		"\u0084\u0085\7G\2\2\u0085\u008f\7T\2\2\u0086\u0087\7F\2\2\u0087\u0088"+
		"\7G\2\2\u0088\u0089\7X\2\2\u0089\u008a\7a\2\2\u008a\u008b\7V\2\2\u008b"+
		"\u008c\7G\2\2\u008c\u008d\7C\2\2\u008d\u008f\7O\2\2\u008em\3\2\2\2\u008e"+
		"z\3\2\2\2\u008e\u0086\3\2\2\2\u008f\"\3\2\2\2\u0090\u0092\t\3\2\2\u0091"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094$\3\2\2\2\u0095\u0096\7(\2\2\u0096\u009a\7(\2\2\u0097\u0098"+
		"\7~\2\2\u0098\u009a\7~\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"&\3\2\2\2\u009b\u009d\7\17\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u009f\7\f\2\2\u009f(\3\2\2\2\u00a0\u00a2\t"+
		"\4\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\b\25\2\2\u00a6*\3\2\2\2"+
		"\t\2k\u008e\u0093\u0099\u009c\u00a3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}