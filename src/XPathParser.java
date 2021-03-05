// Generated from /Users/chenjiachen/Documents/UCSD/WI21/CSE 232B/cse-232b-project/src/XPath.g4 by ANTLR 4.9.1
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, ID=36, STRING=37, WS=38;
	public static final int
		RULE_xq = 0, RULE_var = 1, RULE_forClause = 2, RULE_letClause = 3, RULE_whereClause = 4, 
		RULE_returnClause = 5, RULE_cond = 6, RULE_ap = 7, RULE_rp = 8, RULE_f = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "var", "forClause", "letClause", "whereClause", "returnClause", 
			"cond", "ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'$'", "'for'", "'in'", "'let'", "':='", "'where'", "'return'", 
			"'='", "'eq'", "'=='", "'is'", "'empty'", "'some'", "'satisfies'", "'and'", 
			"'or'", "'not'", "'doc'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "STRING", "WS"
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

	public static class XqContext extends ParserRuleContext {
		public Token text;
		public Token op;
		public Token tagName;
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(XPathParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(XPathParser.ID, i);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(21);
				var();
				}
				break;
			case STRING:
				{
				setState(22);
				((XqContext)_localctx).text = match(STRING);
				}
				break;
			case T__27:
				{
				setState(23);
				ap();
				}
				break;
			case T__0:
				{
				setState(24);
				((XqContext)_localctx).op = match(T__0);
				setState(25);
				xq(0);
				setState(26);
				match(T__1);
				}
				break;
			case T__5:
				{
				setState(28);
				((XqContext)_localctx).op = match(T__5);
				setState(29);
				((XqContext)_localctx).tagName = match(ID);
				setState(30);
				match(T__6);
				setState(31);
				match(T__7);
				setState(32);
				xq(0);
				setState(33);
				match(T__8);
				setState(34);
				match(T__9);
				setState(35);
				((XqContext)_localctx).tagName = match(ID);
				setState(36);
				match(T__6);
				}
				break;
			case T__11:
				{
				setState(38);
				forClause();
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(39);
					letClause();
					}
				}

				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(42);
					whereClause();
					}
				}

				setState(45);
				returnClause();
				}
				break;
			case T__13:
				{
				setState(47);
				letClause();
				setState(48);
				xq(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(58);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(52);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(53);
						((XqContext)_localctx).op = match(T__2);
						setState(54);
						xq(6);
						}
						break;
					case 2:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(55);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(56);
						((XqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((XqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(57);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class VarContext extends ParserRuleContext {
		public Token varName;
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__10);
			setState(64);
			((VarContext)_localctx).varName = match(ID);
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

	public static class ForClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__11);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					var();
					setState(68);
					match(T__12);
					setState(69);
					xq(0);
					setState(70);
					match(T__2);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(77);
			var();
			setState(78);
			match(T__12);
			setState(79);
			xq(0);
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_letClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__13);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(82);
					var();
					setState(83);
					match(T__14);
					setState(84);
					xq(0);
					setState(85);
					match(T__2);
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(92);
			var();
			setState(93);
			match(T__14);
			setState(94);
			xq(0);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__15);
			setState(97);
			cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__16);
			setState(100);
			xq(0);
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

	public static class CondContext extends ParserRuleContext {
		public Token op;
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(103);
				xq(0);
				setState(104);
				((CondContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
					((CondContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(105);
				xq(0);
				}
				break;
			case 2:
				{
				setState(107);
				((CondContext)_localctx).op = match(T__21);
				setState(108);
				match(T__0);
				setState(109);
				xq(0);
				setState(110);
				match(T__1);
				}
				break;
			case 3:
				{
				setState(112);
				((CondContext)_localctx).op = match(T__22);
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(113);
						var();
						setState(114);
						match(T__12);
						setState(115);
						xq(0);
						setState(116);
						match(T__2);
						}
						} 
					}
					setState(122);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(123);
				var();
				setState(124);
				match(T__12);
				setState(125);
				xq(0);
				setState(126);
				match(T__23);
				setState(127);
				cond(4);
				}
				break;
			case 4:
				{
				setState(129);
				((CondContext)_localctx).op = match(T__0);
				setState(130);
				cond(0);
				setState(131);
				match(T__1);
				}
				break;
			case 5:
				{
				setState(133);
				((CondContext)_localctx).op = match(T__26);
				setState(134);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cond);
					setState(137);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(138);
					((CondContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__24 || _la==T__25) ) {
						((CondContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(139);
					cond(3);
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 14, RULE_ap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__27);
			setState(146);
			match(T__0);
			setState(147);
			((ApContext)_localctx).fileName = match(STRING);
			setState(148);
			match(T__1);
			setState(149);
			((ApContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
				((ApContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(150);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(153);
				((RpContext)_localctx).tagName = match(ID);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__31:
				{
				setState(154);
				((RpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
					((RpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__32:
				{
				setState(155);
				((RpContext)_localctx).op = match(T__32);
				setState(156);
				((RpContext)_localctx).attName = match(ID);
				}
				break;
			case T__0:
				{
				setState(157);
				((RpContext)_localctx).op = match(T__0);
				setState(158);
				rp(0);
				setState(159);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(163);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(164);
						((RpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
							((RpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						rp(3);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(166);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(167);
						((RpContext)_localctx).op = match(T__33);
						setState(168);
						f(0);
						setState(169);
						match(T__34);
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(177);
				rp(0);
				}
				break;
			case 2:
				{
				setState(178);
				rp(0);
				setState(179);
				((FContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
					((FContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(180);
				rp(0);
				}
				break;
			case 3:
				{
				setState(182);
				rp(0);
				setState(183);
				((FContext)_localctx).op = match(T__17);
				setState(184);
				match(STRING);
				}
				break;
			case 4:
				{
				setState(186);
				((FContext)_localctx).op = match(T__0);
				setState(187);
				f(0);
				setState(188);
				match(T__1);
				}
				break;
			case 5:
				{
				setState(190);
				((FContext)_localctx).op = match(T__26);
				setState(191);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_f);
					setState(194);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(195);
					((FContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__24 || _la==T__25) ) {
						((FContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(196);
					f(3);
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 6:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 8:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 9:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00cd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2+\n\2\3\2\5\2.\n\2\3\2\3\2\3\2\3\2\3\2\5\2\65\n\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\7\2=\n\2\f\2\16\2@\13\2\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\by"+
		"\n\b\f\b\16\b|\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u008a\n\b\3\b\3\b\3\b\7\b\u008f\n\b\f\b\16\b\u0092\13\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a4\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ae\n\n\f\n\16\n\u00b1\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00c3\n\13\3\13\3\13\3\13\7\13\u00c8\n\13\f\13\16\13\u00cb\13"+
		"\13\3\13\2\6\2\16\22\24\f\2\4\6\b\n\f\16\20\22\24\2\7\3\2\6\7\3\2\24\27"+
		"\3\2\33\34\3\2\37\"\3\2\5\7\2\u00de\2\64\3\2\2\2\4A\3\2\2\2\6D\3\2\2\2"+
		"\bS\3\2\2\2\nb\3\2\2\2\fe\3\2\2\2\16\u0089\3\2\2\2\20\u0093\3\2\2\2\22"+
		"\u00a3\3\2\2\2\24\u00c2\3\2\2\2\26\27\b\2\1\2\27\65\5\4\3\2\30\65\7\'"+
		"\2\2\31\65\5\20\t\2\32\33\7\3\2\2\33\34\5\2\2\2\34\35\7\4\2\2\35\65\3"+
		"\2\2\2\36\37\7\b\2\2\37 \7&\2\2 !\7\t\2\2!\"\7\n\2\2\"#\5\2\2\2#$\7\13"+
		"\2\2$%\7\f\2\2%&\7&\2\2&\'\7\t\2\2\'\65\3\2\2\2(*\5\6\4\2)+\5\b\5\2*)"+
		"\3\2\2\2*+\3\2\2\2+-\3\2\2\2,.\5\n\6\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/"+
		"\60\5\f\7\2\60\65\3\2\2\2\61\62\5\b\5\2\62\63\5\2\2\3\63\65\3\2\2\2\64"+
		"\26\3\2\2\2\64\30\3\2\2\2\64\31\3\2\2\2\64\32\3\2\2\2\64\36\3\2\2\2\64"+
		"(\3\2\2\2\64\61\3\2\2\2\65>\3\2\2\2\66\67\f\7\2\2\678\7\5\2\28=\5\2\2"+
		"\b9:\f\6\2\2:;\t\2\2\2;=\5\22\n\2<\66\3\2\2\2<9\3\2\2\2=@\3\2\2\2><\3"+
		"\2\2\2>?\3\2\2\2?\3\3\2\2\2@>\3\2\2\2AB\7\r\2\2BC\7&\2\2C\5\3\2\2\2DL"+
		"\7\16\2\2EF\5\4\3\2FG\7\17\2\2GH\5\2\2\2HI\7\5\2\2IK\3\2\2\2JE\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\5\4\3\2PQ\7\17\2"+
		"\2QR\5\2\2\2R\7\3\2\2\2S[\7\20\2\2TU\5\4\3\2UV\7\21\2\2VW\5\2\2\2WX\7"+
		"\5\2\2XZ\3\2\2\2YT\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]"+
		"[\3\2\2\2^_\5\4\3\2_`\7\21\2\2`a\5\2\2\2a\t\3\2\2\2bc\7\22\2\2cd\5\16"+
		"\b\2d\13\3\2\2\2ef\7\23\2\2fg\5\2\2\2g\r\3\2\2\2hi\b\b\1\2ij\5\2\2\2j"+
		"k\t\3\2\2kl\5\2\2\2l\u008a\3\2\2\2mn\7\30\2\2no\7\3\2\2op\5\2\2\2pq\7"+
		"\4\2\2q\u008a\3\2\2\2rz\7\31\2\2st\5\4\3\2tu\7\17\2\2uv\5\2\2\2vw\7\5"+
		"\2\2wy\3\2\2\2xs\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2"+
		"\2\2}~\5\4\3\2~\177\7\17\2\2\177\u0080\5\2\2\2\u0080\u0081\7\32\2\2\u0081"+
		"\u0082\5\16\b\6\u0082\u008a\3\2\2\2\u0083\u0084\7\3\2\2\u0084\u0085\5"+
		"\16\b\2\u0085\u0086\7\4\2\2\u0086\u008a\3\2\2\2\u0087\u0088\7\35\2\2\u0088"+
		"\u008a\5\16\b\3\u0089h\3\2\2\2\u0089m\3\2\2\2\u0089r\3\2\2\2\u0089\u0083"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0090\3\2\2\2\u008b\u008c\f\4\2\2\u008c"+
		"\u008d\t\4\2\2\u008d\u008f\5\16\b\5\u008e\u008b\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\17\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7\36\2\2\u0094\u0095\7\3\2\2\u0095\u0096\7"+
		"\'\2\2\u0096\u0097\7\4\2\2\u0097\u0098\t\2\2\2\u0098\u0099\5\22\n\2\u0099"+
		"\21\3\2\2\2\u009a\u009b\b\n\1\2\u009b\u00a4\7&\2\2\u009c\u00a4\t\5\2\2"+
		"\u009d\u009e\7#\2\2\u009e\u00a4\7&\2\2\u009f\u00a0\7\3\2\2\u00a0\u00a1"+
		"\5\22\n\2\u00a1\u00a2\7\4\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009a\3\2\2\2"+
		"\u00a3\u009c\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00af"+
		"\3\2\2\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\t\6\2\2\u00a7\u00ae\5\22\n\5"+
		"\u00a8\u00a9\f\3\2\2\u00a9\u00aa\7$\2\2\u00aa\u00ab\5\24\13\2\u00ab\u00ac"+
		"\7%\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\23\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\b\13\1\2\u00b3\u00c3\5\22\n\2\u00b4"+
		"\u00b5\5\22\n\2\u00b5\u00b6\t\3\2\2\u00b6\u00b7\5\22\n\2\u00b7\u00c3\3"+
		"\2\2\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\7\24\2\2\u00ba\u00bb\7\'\2\2\u00bb"+
		"\u00c3\3\2\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be\5\24\13\2\u00be\u00bf\7"+
		"\4\2\2\u00bf\u00c3\3\2\2\2\u00c0\u00c1\7\35\2\2\u00c1\u00c3\5\24\13\3"+
		"\u00c2\u00b2\3\2\2\2\u00c2\u00b4\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2\u00bc"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c9\3\2\2\2\u00c4\u00c5\f\4\2\2\u00c5"+
		"\u00c6\t\4\2\2\u00c6\u00c8\5\24\13\5\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3"+
		"\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\25\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\21*-\64<>L[z\u0089\u0090\u00a3\u00ad\u00af\u00c2\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}