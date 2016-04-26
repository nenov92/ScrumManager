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
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, LPAREN=13, RPAREN=14, INTEGER=15, ROLE=16, 
		NAME=17, LOGICAL_OPERATOR=18, NEWLINE=19, WS=20;
	public static final String[] tokenNames = {
		"<INVALID>", "'prohibition'", "'obligation'", "'<='", "'norm'", "'true'", 
		"'!='", "'>='", "'<'", "'=='", "','", "'>'", "'false'", "'('", "')'", 
		"INTEGER", "ROLE", "NAME", "LOGICAL_OPERATOR", "NEWLINE", "WS"
	};
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(24); norm();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(25); match(NEWLINE);
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
			setState(38);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); obligation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); prohibition();
				}
				break;
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
		public FulfilledConditionContext fulfilledCondition() {
			return getRuleContext(FulfilledConditionContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public ActivationConditionContext activationCondition() {
			return getRuleContext(ActivationConditionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
		public ExpirationConditionContext expirationCondition() {
			return getRuleContext(ExpirationConditionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(NormParser.RPAREN, 0); }
		public NotFulfilledConditionContext notFulfilledCondition() {
			return getRuleContext(NotFulfilledConditionContext.class,0);
		}
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
			setState(40); match(T__8);
			setState(41); match(LPAREN);
			setState(42); match(INTEGER);
			setState(43); match(T__2);
			setState(44); match(T__10);
			setState(45); match(T__2);
			setState(46); match(ROLE);
			setState(47); match(T__2);
			setState(48); match(NAME);
			setState(49); match(T__2);
			setState(50); activationCondition();
			setState(51); match(T__2);
			setState(52); expirationCondition();
			setState(53); match(T__2);
			setState(54); fulfilledCondition();
			setState(55); match(T__2);
			setState(56); notFulfilledCondition();
			setState(57); match(RPAREN);
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
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public ActivationConditionContext activationCondition() {
			return getRuleContext(ActivationConditionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
		public ExpirationConditionContext expirationCondition() {
			return getRuleContext(ExpirationConditionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(NormParser.LPAREN, 0); }
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
			setState(59); match(T__8);
			setState(60); match(LPAREN);
			setState(61); match(INTEGER);
			setState(62); match(T__2);
			setState(63); match(T__11);
			setState(64); match(T__2);
			setState(65); match(ROLE);
			setState(66); match(T__2);
			setState(67); match(NAME);
			setState(68); match(T__2);
			setState(69); activationCondition();
			setState(70); match(T__2);
			setState(71); expirationCondition();
			setState(72); match(RPAREN);
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
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
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
			setState(74); tuple();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(75); match(LOGICAL_OPERATOR);
				setState(76); tuple();
				}
				}
				setState(81);
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
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
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
			setState(82); tuple();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(83); match(LOGICAL_OPERATOR);
				setState(84); tuple();
				}
				}
				setState(89);
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
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
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
			setState(90); tuple();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(91); match(LOGICAL_OPERATOR);
				setState(92); tuple();
				}
				}
				setState(97);
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
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(NormParser.LOGICAL_OPERATOR, i);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(NormParser.LOGICAL_OPERATOR); }
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
			setState(98); tuple();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(99); match(LOGICAL_OPERATOR);
				setState(100); tuple();
				}
				}
				setState(105);
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
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NAME() { return getToken(NormParser.NAME, 0); }
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
			setState(106); match(NAME);
			setState(107); comparator();
			setState(108); value();
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
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__1))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode INTEGER() { return getToken(NormParser.INTEGER, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
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
			setState(116);
			switch (_input.LA(1)) {
			case T__7:
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(114); bool();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); match(INTEGER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\3\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6\3\7\3\7\3\7\7\7X"+
		"\n\7\f\7\16\7[\13\7\3\b\3\b\3\b\7\b`\n\b\f\b\16\bc\13\b\3\t\3\t\3\t\7"+
		"\th\n\t\f\t\16\tk\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rw"+
		"\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4\4\2\7\7\16\16\5\2\5"+
		"\5\b\13\r\rt\2#\3\2\2\2\4(\3\2\2\2\6*\3\2\2\2\b=\3\2\2\2\nL\3\2\2\2\f"+
		"T\3\2\2\2\16\\\3\2\2\2\20d\3\2\2\2\22l\3\2\2\2\24p\3\2\2\2\26r\3\2\2\2"+
		"\30v\3\2\2\2\32\36\5\4\3\2\33\35\7\25\2\2\34\33\3\2\2\2\35 \3\2\2\2\36"+
		"\34\3\2\2\2\36\37\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"%\3\2"+
		"\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2&)\5\6\4\2\')\5\b\5\2(&\3"+
		"\2\2\2(\'\3\2\2\2)\5\3\2\2\2*+\7\6\2\2+,\7\17\2\2,-\7\21\2\2-.\7\f\2\2"+
		"./\7\4\2\2/\60\7\f\2\2\60\61\7\22\2\2\61\62\7\f\2\2\62\63\7\23\2\2\63"+
		"\64\7\f\2\2\64\65\5\n\6\2\65\66\7\f\2\2\66\67\5\f\7\2\678\7\f\2\289\5"+
		"\16\b\29:\7\f\2\2:;\5\20\t\2;<\7\20\2\2<\7\3\2\2\2=>\7\6\2\2>?\7\17\2"+
		"\2?@\7\21\2\2@A\7\f\2\2AB\7\3\2\2BC\7\f\2\2CD\7\22\2\2DE\7\f\2\2EF\7\23"+
		"\2\2FG\7\f\2\2GH\5\n\6\2HI\7\f\2\2IJ\5\f\7\2JK\7\20\2\2K\t\3\2\2\2LQ\5"+
		"\22\n\2MN\7\24\2\2NP\5\22\n\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2"+
		"R\13\3\2\2\2SQ\3\2\2\2TY\5\22\n\2UV\7\24\2\2VX\5\22\n\2WU\3\2\2\2X[\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\r\3\2\2\2[Y\3\2\2\2\\a\5\22\n\2]^\7\24\2\2"+
		"^`\5\22\n\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\17\3\2\2\2ca\3\2"+
		"\2\2di\5\22\n\2ef\7\24\2\2fh\5\22\n\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij"+
		"\3\2\2\2j\21\3\2\2\2ki\3\2\2\2lm\7\23\2\2mn\5\26\f\2no\5\30\r\2o\23\3"+
		"\2\2\2pq\t\2\2\2q\25\3\2\2\2rs\t\3\2\2s\27\3\2\2\2tw\5\24\13\2uw\7\21"+
		"\2\2vt\3\2\2\2vu\3\2\2\2w\31\3\2\2\2\n\36#(QYaiv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}