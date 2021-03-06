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
		T__9=10, T__10=11, T__11=12, LPAREN=13, RPAREN=14, INTEGER=15, ROLE=16, 
		NAME=17, LOGICAL_OPERATOR=18, NEWLINE=19, WS=20;
	public static final int
		RULE_prog = 0, RULE_norm = 1, RULE_obligation = 2, RULE_prohibition = 3, 
		RULE_activationCondition = 4, RULE_expirationCondition = 5, RULE_fulfilledCondition = 6, 
		RULE_notFulfilledCondition = 7, RULE_violatedCondition = 8, RULE_tuple = 9, 
		RULE_bool = 10, RULE_comparator = 11, RULE_value = 12;
	public static final String[] ruleNames = {
		"prog", "norm", "obligation", "prohibition", "activationCondition", "expirationCondition", 
		"fulfilledCondition", "notFulfilledCondition", "violatedCondition", "tuple", 
		"bool", "comparator", "value"
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(26);
				norm();
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(27);
					match(NEWLINE);
					}
					}
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(37);
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
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				obligation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				prohibition();
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
			setState(42);
			match(T__0);
			setState(43);
			match(LPAREN);
			setState(44);
			match(INTEGER);
			setState(45);
			match(T__1);
			setState(46);
			match(T__2);
			setState(47);
			match(T__1);
			setState(48);
			match(ROLE);
			setState(49);
			match(T__1);
			setState(50);
			match(NAME);
			setState(51);
			match(T__1);
			setState(52);
			activationCondition();
			setState(53);
			match(T__1);
			setState(54);
			expirationCondition();
			setState(55);
			match(T__1);
			setState(56);
			fulfilledCondition();
			setState(57);
			match(T__1);
			setState(58);
			notFulfilledCondition();
			setState(59);
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
		public ViolatedConditionContext violatedCondition() {
			return getRuleContext(ViolatedConditionContext.class,0);
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
			setState(61);
			match(T__0);
			setState(62);
			match(LPAREN);
			setState(63);
			match(INTEGER);
			setState(64);
			match(T__1);
			setState(65);
			match(T__3);
			setState(66);
			match(T__1);
			setState(67);
			match(ROLE);
			setState(68);
			match(T__1);
			setState(69);
			match(NAME);
			setState(70);
			match(T__1);
			setState(71);
			activationCondition();
			setState(72);
			match(T__1);
			setState(73);
			expirationCondition();
			setState(74);
			match(T__1);
			setState(75);
			violatedCondition();
			setState(76);
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
			setState(102);
			tuple();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(103);
				match(LOGICAL_OPERATOR);
				setState(104);
				tuple();
				}
				}
				setState(109);
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

	public static class ViolatedConditionContext extends ParserRuleContext {
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
		public ViolatedConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_violatedCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).enterViolatedCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormListener ) ((NormListener)listener).exitViolatedCondition(this);
		}
	}

	public final ViolatedConditionContext violatedCondition() throws RecognitionException {
		ViolatedConditionContext _localctx = new ViolatedConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_violatedCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			tuple();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(111);
				match(LOGICAL_OPERATOR);
				setState(112);
				tuple();
				}
				}
				setState(117);
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
		enterRule(_localctx, 18, RULE_tuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(NAME);
			setState(119);
			comparator();
			setState(120);
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
		enterRule(_localctx, 20, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
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
		enterRule(_localctx, 22, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(128);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				bool();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0085\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6T\n\6\f\6\16"+
		"\6W\13\6\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\3\b\3\b\7\bd\n\b\f\b"+
		"\16\bg\13\b\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\n\3\n\3\n\7\nt\n\n\f"+
		"\n\16\nw\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16\u0083"+
		"\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\7\b\3\2\t\16"+
		"\u0080\2%\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b?\3\2\2\2\nP\3\2\2\2\fX\3\2\2"+
		"\2\16`\3\2\2\2\20h\3\2\2\2\22p\3\2\2\2\24x\3\2\2\2\26|\3\2\2\2\30~\3\2"+
		"\2\2\32\u0082\3\2\2\2\34 \5\4\3\2\35\37\7\25\2\2\36\35\3\2\2\2\37\"\3"+
		"\2\2\2 \36\3\2\2\2 !\3\2\2\2!$\3\2\2\2\" \3\2\2\2#\34\3\2\2\2$\'\3\2\2"+
		"\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2(+\5\6\4\2)+\5\b\5\2*(\3\2"+
		"\2\2*)\3\2\2\2+\5\3\2\2\2,-\7\3\2\2-.\7\17\2\2./\7\21\2\2/\60\7\4\2\2"+
		"\60\61\7\5\2\2\61\62\7\4\2\2\62\63\7\22\2\2\63\64\7\4\2\2\64\65\7\23\2"+
		"\2\65\66\7\4\2\2\66\67\5\n\6\2\678\7\4\2\289\5\f\7\29:\7\4\2\2:;\5\16"+
		"\b\2;<\7\4\2\2<=\5\20\t\2=>\7\20\2\2>\7\3\2\2\2?@\7\3\2\2@A\7\17\2\2A"+
		"B\7\21\2\2BC\7\4\2\2CD\7\6\2\2DE\7\4\2\2EF\7\22\2\2FG\7\4\2\2GH\7\23\2"+
		"\2HI\7\4\2\2IJ\5\n\6\2JK\7\4\2\2KL\5\f\7\2LM\7\4\2\2MN\5\22\n\2NO\7\20"+
		"\2\2O\t\3\2\2\2PU\5\24\13\2QR\7\24\2\2RT\5\24\13\2SQ\3\2\2\2TW\3\2\2\2"+
		"US\3\2\2\2UV\3\2\2\2V\13\3\2\2\2WU\3\2\2\2X]\5\24\13\2YZ\7\24\2\2Z\\\5"+
		"\24\13\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_]\3\2\2\2"+
		"`e\5\24\13\2ab\7\24\2\2bd\5\24\13\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3"+
		"\2\2\2f\17\3\2\2\2ge\3\2\2\2hm\5\24\13\2ij\7\24\2\2jl\5\24\13\2ki\3\2"+
		"\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\21\3\2\2\2om\3\2\2\2pu\5\24\13\2q"+
		"r\7\24\2\2rt\5\24\13\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\23\3\2"+
		"\2\2wu\3\2\2\2xy\7\23\2\2yz\5\30\r\2z{\5\32\16\2{\25\3\2\2\2|}\t\2\2\2"+
		"}\27\3\2\2\2~\177\t\3\2\2\177\31\3\2\2\2\u0080\u0083\5\26\f\2\u0081\u0083"+
		"\7\21\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\33\3\2\2\2\13"+
		" %*U]emu\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}