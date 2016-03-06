// Generated from Norm.g4 by ANTLR 4.5.2
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
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, LPAREN=12, RPAREN=13, INTEGER=14, ROLE=15, NAME=16, 
		LOGICAL_OPERATOR=17, NEWLINE=18, WS=19;
	public static final int
		RULE_prog = 0, RULE_norm = 1, RULE_obligation = 2, RULE_prohibition = 3, 
		RULE_activationCondition = 4, RULE_expirationCondition = 5, RULE_fulfilledCondition = 6, 
		RULE_notFulfilledCondition = 7, RULE_tuple = 8, RULE_bool = 9, RULE_comparator = 10, 
		RULE_value = 11;
	public static final String[] ruleNames = {
		"prog", "norm", "obligation", "prohibition", "activationCondition", "expirationCondition", 
		"fulfilledCondition", "notFulfilledCondition", "tuple", "bool", "comparator", 
		"value"
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

	@Override
	public String getGrammarFileName() { return "Norm.g4"; }

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
		public List<NormContext> norm() {
			return getRuleContexts(NormContext.class);
		}
		public NormContext norm(int i) {
			return getRuleContext(NormContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(NormParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(NormParser.NEWLINE, i);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(24);
				norm();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(25);
					match(NEWLINE);
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(35);
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
		public ObligationContext obligation() {
			return getRuleContext(ObligationContext.class,0);
		}
		public ProhibitionContext prohibition() {
			return getRuleContext(ProhibitionContext.class,0);
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
			setState(38);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				obligation();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				prohibition();
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
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public TerminalNode ROLE() { return getToken(NormParser.ROLE, 0); }
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
		public ActivationConditionContext activationCondition() {
			return getRuleContext(ActivationConditionContext.class,0);
		}
		public ExpirationConditionContext expirationCondition() {
			return getRuleContext(ExpirationConditionContext.class,0);
		}
		public FulfilledConditionContext fulfilledCondition() {
			return getRuleContext(FulfilledConditionContext.class,0);
		}
		public NotFulfilledConditionContext notFulfilledCondition() {
			return getRuleContext(NotFulfilledConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NormParser.RPAREN, 0); }
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
			setState(40);
			match(T__0);
			setState(41);
			match(LPAREN);
			setState(42);
			match(INTEGER);
			setState(43);
			match(T__1);
			setState(44);
			match(ROLE);
			setState(45);
			match(T__1);
			setState(46);
			match(NAME);
			setState(47);
			match(T__1);
			setState(48);
			activationCondition();
			setState(49);
			match(T__1);
			setState(50);
			expirationCondition();
			setState(51);
			match(T__1);
			setState(52);
			fulfilledCondition();
			setState(53);
			match(T__1);
			setState(54);
			notFulfilledCondition();
			setState(55);
			match(RPAREN);
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
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public TerminalNode ROLE() { return getToken(NormParser.ROLE, 0); }
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
		public ActivationConditionContext activationCondition() {
			return getRuleContext(ActivationConditionContext.class,0);
		}
		public ExpirationConditionContext expirationCondition() {
			return getRuleContext(ExpirationConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NormParser.RPAREN, 0); }
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
			setState(57);
			match(T__2);
			setState(58);
			match(LPAREN);
			setState(59);
			match(INTEGER);
			setState(60);
			match(T__1);
			setState(61);
			match(ROLE);
			setState(62);
			match(T__1);
			setState(63);
			match(NAME);
			setState(64);
			match(T__1);
			setState(65);
			activationCondition();
			setState(66);
			match(T__1);
			setState(67);
			expirationCondition();
			setState(68);
			match(RPAREN);
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

	public static class ActivationConditionContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public ActivationConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activationCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterActivationCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitActivationCondition(this);
		}
	}

	public final ActivationConditionContext activationCondition() throws RecognitionException {
		ActivationConditionContext _localctx = new ActivationConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_activationCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			tuple();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(71);
				match(LOGICAL_OPERATOR);
				setState(72);
				tuple();
				}
				}
				setState(77);
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

	public static class ExpirationConditionContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public ExpirationConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expirationCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterExpirationCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitExpirationCondition(this);
		}
	}

	public final ExpirationConditionContext expirationCondition() throws RecognitionException {
		ExpirationConditionContext _localctx = new ExpirationConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expirationCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			tuple();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(79);
				match(LOGICAL_OPERATOR);
				setState(80);
				tuple();
				}
				}
				setState(85);
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

	public static class FulfilledConditionContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public FulfilledConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fulfilledCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterFulfilledCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitFulfilledCondition(this);
		}
	}

	public final FulfilledConditionContext fulfilledCondition() throws RecognitionException {
		FulfilledConditionContext _localctx = new FulfilledConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fulfilledCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			tuple();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(87);
				match(LOGICAL_OPERATOR);
				setState(88);
				tuple();
				}
				}
				setState(93);
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

	public static class NotFulfilledConditionContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public NotFulfilledConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notFulfilledCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterNotFulfilledCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitNotFulfilledCondition(this);
		}
	}

	public final NotFulfilledConditionContext notFulfilledCondition() throws RecognitionException {
		NotFulfilledConditionContext _localctx = new NotFulfilledConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_notFulfilledCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			tuple();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(95);
				match(LOGICAL_OPERATOR);
				setState(96);
				tuple();
				}
				}
				setState(101);
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

	public static class TupleContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitTuple(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(NAME);
			setState(103);
			comparator();
			setState(104);
			value();
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

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ComparatorContext extends ParserRuleContext {
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitComparator(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ValueContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value);
		try {
			setState(112);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				bool();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(INTEGER);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\3\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\7\3\7\3\7\7\7T\n\7\f\7\16\7W\13"+
		"\7\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\t\3\t\3\t\7\td\n\t\f\t\16\t"+
		"g\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rs\n\r\3\r\2\2\16\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\2\4\3\2\6\7\3\2\b\rp\2#\3\2\2\2\4(\3\2\2"+
		"\2\6*\3\2\2\2\b;\3\2\2\2\nH\3\2\2\2\fP\3\2\2\2\16X\3\2\2\2\20`\3\2\2\2"+
		"\22h\3\2\2\2\24l\3\2\2\2\26n\3\2\2\2\30r\3\2\2\2\32\36\5\4\3\2\33\35\7"+
		"\24\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\"\3\2"+
		"\2\2 \36\3\2\2\2!\32\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2"+
		"%#\3\2\2\2&)\5\6\4\2\')\5\b\5\2(&\3\2\2\2(\'\3\2\2\2)\5\3\2\2\2*+\7\3"+
		"\2\2+,\7\16\2\2,-\7\20\2\2-.\7\4\2\2./\7\21\2\2/\60\7\4\2\2\60\61\7\22"+
		"\2\2\61\62\7\4\2\2\62\63\5\n\6\2\63\64\7\4\2\2\64\65\5\f\7\2\65\66\7\4"+
		"\2\2\66\67\5\16\b\2\678\7\4\2\289\5\20\t\29:\7\17\2\2:\7\3\2\2\2;<\7\5"+
		"\2\2<=\7\16\2\2=>\7\20\2\2>?\7\4\2\2?@\7\21\2\2@A\7\4\2\2AB\7\22\2\2B"+
		"C\7\4\2\2CD\5\n\6\2DE\7\4\2\2EF\5\f\7\2FG\7\17\2\2G\t\3\2\2\2HM\5\22\n"+
		"\2IJ\7\23\2\2JL\5\22\n\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\13\3"+
		"\2\2\2OM\3\2\2\2PU\5\22\n\2QR\7\23\2\2RT\5\22\n\2SQ\3\2\2\2TW\3\2\2\2"+
		"US\3\2\2\2UV\3\2\2\2V\r\3\2\2\2WU\3\2\2\2X]\5\22\n\2YZ\7\23\2\2Z\\\5\22"+
		"\n\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\17\3\2\2\2_]\3\2\2\2`e"+
		"\5\22\n\2ab\7\23\2\2bd\5\22\n\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2"+
		"\2f\21\3\2\2\2ge\3\2\2\2hi\7\22\2\2ij\5\26\f\2jk\5\30\r\2k\23\3\2\2\2"+
		"lm\t\2\2\2m\25\3\2\2\2no\t\3\2\2o\27\3\2\2\2ps\5\24\13\2qs\7\20\2\2rp"+
		"\3\2\2\2rq\3\2\2\2s\31\3\2\2\2\n\36#(MU]er";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}