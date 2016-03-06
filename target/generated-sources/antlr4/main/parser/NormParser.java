// Generated from Norm.g4 by ANTLR 4.4
package main.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NormParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, LPAREN=4, RPAREN=5, INTEGER=6, ROLE=7, FUNCTION=8, 
		BOOLEAN=9, TUPLE=10, LOGICAL_OPERATOR=11, CONDITION=12, NEWLINE=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "'prohibition'", "'obligation'", "','", "'('", "')'", "INTEGER", 
		"ROLE", "FUNCTION", "BOOLEAN", "TUPLE", "LOGICAL_OPERATOR", "CONDITION", 
		"NEWLINE", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_norm = 1, RULE_obligation = 2, RULE_prohibition = 3;
	public static final String[] ruleNames = {
		"prog", "norm", "obligation", "prohibition"
	};

	@Override
	public String getGrammarFileName() { return "Norm.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NormParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public NormContext norm(int i) {
			return getRuleContext(NormContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(NormParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(NormParser.NEWLINE, i);
		}
		public List<NormContext> norm() {
			return getRuleContexts(NormContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__1) {
				{
				{
				setState(8); norm();
				setState(9); match(NEWLINE);
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormContext extends ParserRuleContext {
		public ProhibitionContext prohibition() {
			return getRuleContext(ProhibitionContext.class,0);
		}
		public ObligationContext obligation() {
			return getRuleContext(ObligationContext.class,0);
		}
		public NormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_norm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterNorm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitNorm(this);
		}
	}

	public final NormContext norm() throws RecognitionException {
		NormContext _localctx = new NormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_norm);
		try {
			setState(18);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16); obligation();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17); prohibition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObligationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(NormParser.FUNCTION, 0); }
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public TerminalNode CONDITION(int i) {
			return getToken(NormParser.CONDITION, i);
		}
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
		public List<TerminalNode> CONDITION() { return getTokens(NormParser.CONDITION); }
		public TerminalNode RPAREN() { return getToken(NormParser.RPAREN, 0); }
		public TerminalNode ROLE() { return getToken(NormParser.ROLE, 0); }
		public ObligationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterObligation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitObligation(this);
		}
	}

	public final ObligationContext obligation() throws RecognitionException {
		ObligationContext _localctx = new ObligationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_obligation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); match(T__1);
			setState(21); match(LPAREN);
			setState(22); match(INTEGER);
			setState(23); match(T__0);
			setState(24); match(ROLE);
			setState(25); match(T__0);
			setState(26); match(FUNCTION);
			setState(27); match(T__0);
			setState(28); match(CONDITION);
			setState(29); match(T__0);
			setState(30); match(CONDITION);
			setState(31); match(T__0);
			setState(32); match(CONDITION);
			setState(33); match(T__0);
			setState(34); match(CONDITION);
			setState(35); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProhibitionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(NormParser.FUNCTION, 0); }
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public TerminalNode CONDITION(int i) {
			return getToken(NormParser.CONDITION, i);
		}
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
		public List<TerminalNode> CONDITION() { return getTokens(NormParser.CONDITION); }
		public TerminalNode RPAREN() { return getToken(NormParser.RPAREN, 0); }
		public TerminalNode ROLE() { return getToken(NormParser.ROLE, 0); }
		public ProhibitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prohibition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterProhibition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitProhibition(this);
		}
	}

	public final ProhibitionContext prohibition() throws RecognitionException {
		ProhibitionContext _localctx = new ProhibitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prohibition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(T__2);
			setState(38); match(LPAREN);
			setState(39); match(INTEGER);
			setState(40); match(T__0);
			setState(41); match(ROLE);
			setState(42); match(T__0);
			setState(43); match(FUNCTION);
			setState(44); match(T__0);
			setState(45); match(CONDITION);
			setState(46); match(T__0);
			setState(47); match(CONDITION);
			setState(48); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3\5"+
		"\3\25\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\2\2\6"+
		"\2\4\6\b\2\2\62\2\17\3\2\2\2\4\24\3\2\2\2\6\26\3\2\2\2\b\'\3\2\2\2\n\13"+
		"\5\4\3\2\13\f\7\17\2\2\f\16\3\2\2\2\r\n\3\2\2\2\16\21\3\2\2\2\17\r\3\2"+
		"\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\17\3\2\2\2\22\25\5\6\4\2\23\25\5\b"+
		"\5\2\24\22\3\2\2\2\24\23\3\2\2\2\25\5\3\2\2\2\26\27\7\4\2\2\27\30\7\6"+
		"\2\2\30\31\7\b\2\2\31\32\7\5\2\2\32\33\7\t\2\2\33\34\7\5\2\2\34\35\7\n"+
		"\2\2\35\36\7\5\2\2\36\37\7\16\2\2\37 \7\5\2\2 !\7\16\2\2!\"\7\5\2\2\""+
		"#\7\16\2\2#$\7\5\2\2$%\7\16\2\2%&\7\7\2\2&\7\3\2\2\2\'(\7\3\2\2()\7\6"+
		"\2\2)*\7\b\2\2*+\7\5\2\2+,\7\t\2\2,-\7\5\2\2-.\7\n\2\2./\7\5\2\2/\60\7"+
		"\16\2\2\60\61\7\5\2\2\61\62\7\16\2\2\62\63\7\7\2\2\63\t\3\2\2\2\4\17\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}