// Generated from /Users/chenjiachen/Documents/UCSD/WI21/CSE 232B/XPath/src/XPath.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, ID=21, STRING=22, WS=23;
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_f = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc('", "')'", "'/'", "'//'", "'*'", "'.'", "'..'", "'text()'", 
			"'@'", "'('", "'['", "']'", "','", "'='", "'eq'", "'=='", "'is'", "'and'", 
			"'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "ID", "STRING", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ApContext extends ParserRuleContext {
		public Token fileName;
		public Token op;
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(T__0);
			setState(7);
			((ApContext)_localctx).fileName = match(STRING);
			setState(8);
			match(T__1);
			setState(9);
			((ApContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
				((ApContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(10);
			rp(0);
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

	public static class RpContext extends ParserRuleContext {
		public Token tagName;
		public Token op;
		public Token attName;
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(13);
				((RpContext)_localctx).tagName = match(ID);
				}
				break;
			case T__4:
				{
				setState(14);
				((RpContext)_localctx).op = match(T__4);
				}
				break;
			case T__5:
				{
				setState(15);
				((RpContext)_localctx).op = match(T__5);
				}
				break;
			case T__6:
				{
				setState(16);
				((RpContext)_localctx).op = match(T__6);
				}
				break;
			case T__7:
				{
				setState(17);
				((RpContext)_localctx).op = match(T__7);
				}
				break;
			case T__8:
				{
				setState(18);
				((RpContext)_localctx).op = match(T__8);
				setState(19);
				((RpContext)_localctx).attName = match(ID);
				}
				break;
			case T__9:
				{
				setState(20);
				((RpContext)_localctx).op = match(T__9);
				setState(21);
				rp(0);
				setState(22);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(37);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(26);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(27);
						((RpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((RpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(28);
						rp(4);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(29);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(30);
						((RpContext)_localctx).op = match(T__12);
						setState(31);
						rp(2);
						}
						break;
					case 3:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(32);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(33);
						((RpContext)_localctx).op = match(T__10);
						setState(34);
						f(0);
						setState(35);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FContext extends ParserRuleContext {
		public Token op;
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(43);
				rp(0);
				}
				break;
			case 2:
				{
				setState(44);
				rp(0);
				setState(45);
				((FContext)_localctx).op = match(T__13);
				setState(46);
				rp(0);
				}
				break;
			case 3:
				{
				setState(48);
				rp(0);
				setState(49);
				((FContext)_localctx).op = match(T__14);
				setState(50);
				rp(0);
				}
				break;
			case 4:
				{
				setState(52);
				rp(0);
				setState(53);
				((FContext)_localctx).op = match(T__15);
				setState(54);
				rp(0);
				}
				break;
			case 5:
				{
				setState(56);
				rp(0);
				setState(57);
				((FContext)_localctx).op = match(T__16);
				setState(58);
				rp(0);
				}
				break;
			case 6:
				{
				setState(60);
				rp(0);
				setState(61);
				((FContext)_localctx).op = match(T__13);
				setState(62);
				match(STRING);
				}
				break;
			case 7:
				{
				setState(64);
				((FContext)_localctx).op = match(T__9);
				setState(65);
				f(0);
				setState(66);
				match(T__1);
				}
				break;
			case 8:
				{
				setState(68);
				((FContext)_localctx).op = match(T__19);
				setState(69);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(78);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(72);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(73);
						((FContext)_localctx).op = match(T__17);
						setState(74);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(75);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(76);
						((FContext)_localctx).op = match(T__18);
						setState(77);
						f(3);
						}
						break;
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 2:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31V\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4I"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4Q\n\4\f\4\16\4T\13\4\3\4\2\4\4\6\5\2\4"+
		"\6\2\3\3\2\5\6\2d\2\b\3\2\2\2\4\32\3\2\2\2\6H\3\2\2\2\b\t\7\3\2\2\t\n"+
		"\7\30\2\2\n\13\7\4\2\2\13\f\t\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\17\b\3"+
		"\1\2\17\33\7\27\2\2\20\33\7\7\2\2\21\33\7\b\2\2\22\33\7\t\2\2\23\33\7"+
		"\n\2\2\24\25\7\13\2\2\25\33\7\27\2\2\26\27\7\f\2\2\27\30\5\4\3\2\30\31"+
		"\7\4\2\2\31\33\3\2\2\2\32\16\3\2\2\2\32\20\3\2\2\2\32\21\3\2\2\2\32\22"+
		"\3\2\2\2\32\23\3\2\2\2\32\24\3\2\2\2\32\26\3\2\2\2\33)\3\2\2\2\34\35\f"+
		"\5\2\2\35\36\t\2\2\2\36(\5\4\3\6\37 \f\3\2\2 !\7\17\2\2!(\5\4\3\4\"#\f"+
		"\4\2\2#$\7\r\2\2$%\5\6\4\2%&\7\16\2\2&(\3\2\2\2\'\34\3\2\2\2\'\37\3\2"+
		"\2\2\'\"\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,"+
		"-\b\4\1\2-I\5\4\3\2./\5\4\3\2/\60\7\20\2\2\60\61\5\4\3\2\61I\3\2\2\2\62"+
		"\63\5\4\3\2\63\64\7\21\2\2\64\65\5\4\3\2\65I\3\2\2\2\66\67\5\4\3\2\67"+
		"8\7\22\2\289\5\4\3\29I\3\2\2\2:;\5\4\3\2;<\7\23\2\2<=\5\4\3\2=I\3\2\2"+
		"\2>?\5\4\3\2?@\7\20\2\2@A\7\30\2\2AI\3\2\2\2BC\7\f\2\2CD\5\6\4\2DE\7\4"+
		"\2\2EI\3\2\2\2FG\7\26\2\2GI\5\6\4\3H,\3\2\2\2H.\3\2\2\2H\62\3\2\2\2H\66"+
		"\3\2\2\2H:\3\2\2\2H>\3\2\2\2HB\3\2\2\2HF\3\2\2\2IR\3\2\2\2JK\f\5\2\2K"+
		"L\7\24\2\2LQ\5\6\4\6MN\f\4\2\2NO\7\25\2\2OQ\5\6\4\5PJ\3\2\2\2PM\3\2\2"+
		"\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2TR\3\2\2\2\b\32\')HPR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}