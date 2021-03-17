// Generated from /Users/chenjiachen/Documents/UCSD/WI21/CSE 232B/cse-232b-project/src/Rewrite.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RewriteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, ID=21, STRING=22, WS=23;
	public static final int
		RULE_xq = 0, RULE_var = 1, RULE_path = 2, RULE_sep = 3, RULE_ret = 4, 
		RULE_cond = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "var", "path", "sep", "ret", "cond"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'for'", "'in'", "','", "'where'", "'return'", "'$'", "'doc'", 
			"'('", "')'", "'text()'", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'eq'", "'='", "'and'"
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
	public String getGrammarFileName() { return "Rewrite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RewriteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XqContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		XqContext _localctx = new XqContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(T__0);
			setState(20);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(13);
					var();
					setState(14);
					match(T__1);
					setState(15);
					path();
					setState(16);
					match(T__2);
					}
					} 
				}
				setState(22);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(23);
			var();
			setState(24);
			match(T__1);
			setState(25);
			path();
			setState(26);
			match(T__3);
			setState(27);
			cond(0);
			setState(28);
			match(T__4);
			setState(29);
			ret(0);
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

	public static class VarContext extends ParserRuleContext {
		public Token varName;
		public TerminalNode ID() { return getToken(RewriteParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__5);
			setState(32);
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

	public static class PathContext extends ParserRuleContext {
		public Token fileName;
		public Token tagName;
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode STRING() { return getToken(RewriteParser.STRING, 0); }
		public List<TerminalNode> ID() { return getTokens(RewriteParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RewriteParser.ID, i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_path);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(34);
				match(T__6);
				setState(35);
				match(T__7);
				setState(36);
				((PathContext)_localctx).fileName = match(STRING);
				setState(37);
				match(T__8);
				}
				break;
			case T__5:
				{
				setState(38);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(41);
					sep();
					setState(42);
					match(ID);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(49);
			sep();
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(50);
				((PathContext)_localctx).tagName = match(ID);
				}
				break;
			case T__9:
				{
				setState(51);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SepContext extends ParserRuleContext {
		public Token op;
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitSep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitSep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((SepContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
				((SepContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class RetContext extends ParserRuleContext {
		public Token tagName;
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<RetContext> ret() {
			return getRuleContexts(RetContext.class);
		}
		public RetContext ret(int i) {
			return getRuleContext(RetContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(RewriteParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RewriteParser.ID, i);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		return ret(0);
	}

	private RetContext ret(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RetContext _localctx = new RetContext(_ctx, _parentState);
		RetContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_ret, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(57);
				var();
				}
				break;
			case 2:
				{
				setState(58);
				match(T__12);
				setState(59);
				((RetContext)_localctx).tagName = match(ID);
				setState(60);
				match(T__13);
				setState(61);
				match(T__14);
				setState(62);
				ret(0);
				setState(63);
				match(T__15);
				setState(64);
				match(T__16);
				setState(65);
				((RetContext)_localctx).tagName = match(ID);
				setState(66);
				match(T__13);
				}
				break;
			case 3:
				{
				setState(68);
				path();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RetContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ret);
					setState(71);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(72);
					match(T__2);
					setState(73);
					ret(4);
					}
					} 
				}
				setState(78);
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

	public static class CondContext extends ParserRuleContext {
		public Token constant;
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(RewriteParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RewriteParser.STRING, i);
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
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RewriteListener ) ((RewriteListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RewriteVisitor ) return ((RewriteVisitor<? extends T>)visitor).visitCond(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(80);
				var();
				}
				break;
			case STRING:
				{
				setState(81);
				((CondContext)_localctx).constant = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(85);
				var();
				}
				break;
			case STRING:
				{
				setState(86);
				((CondContext)_localctx).constant = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cond);
					setState(89);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(90);
					match(T__19);
					setState(91);
					cond(2);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		case 4:
			return ret_sempred((RetContext)_localctx, predIndex);
		case 5:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ret_sempred(RetContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\5\4*\n\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\4\3\4\3"+
		"\4\5\4\67\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6H\n\6\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\7\3\7\3\7\5\7U\n\7"+
		"\3\7\3\7\3\7\5\7Z\n\7\3\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13\7\3\7\2\4\n\f"+
		"\b\2\4\6\b\n\f\2\4\3\2\r\16\3\2\24\25\2g\2\16\3\2\2\2\4!\3\2\2\2\6)\3"+
		"\2\2\2\b8\3\2\2\2\nG\3\2\2\2\fQ\3\2\2\2\16\26\7\3\2\2\17\20\5\4\3\2\20"+
		"\21\7\4\2\2\21\22\5\6\4\2\22\23\7\5\2\2\23\25\3\2\2\2\24\17\3\2\2\2\25"+
		"\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31"+
		"\32\5\4\3\2\32\33\7\4\2\2\33\34\5\6\4\2\34\35\7\6\2\2\35\36\5\f\7\2\36"+
		"\37\7\7\2\2\37 \5\n\6\2 \3\3\2\2\2!\"\7\b\2\2\"#\7\27\2\2#\5\3\2\2\2$"+
		"%\7\t\2\2%&\7\n\2\2&\'\7\30\2\2\'*\7\13\2\2(*\5\4\3\2)$\3\2\2\2)(\3\2"+
		"\2\2*\60\3\2\2\2+,\5\b\5\2,-\7\27\2\2-/\3\2\2\2.+\3\2\2\2/\62\3\2\2\2"+
		"\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\66\5\b\5\2\64"+
		"\67\7\27\2\2\65\67\7\f\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\7\3\2\2\289"+
		"\t\2\2\29\t\3\2\2\2:;\b\6\1\2;H\5\4\3\2<=\7\17\2\2=>\7\27\2\2>?\7\20\2"+
		"\2?@\7\21\2\2@A\5\n\6\2AB\7\22\2\2BC\7\23\2\2CD\7\27\2\2DE\7\20\2\2EH"+
		"\3\2\2\2FH\5\6\4\2G:\3\2\2\2G<\3\2\2\2GF\3\2\2\2HN\3\2\2\2IJ\f\5\2\2J"+
		"K\7\5\2\2KM\5\n\6\6LI\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\13\3\2\2"+
		"\2PN\3\2\2\2QT\b\7\1\2RU\5\4\3\2SU\7\30\2\2TR\3\2\2\2TS\3\2\2\2UV\3\2"+
		"\2\2VY\t\3\2\2WZ\5\4\3\2XZ\7\30\2\2YW\3\2\2\2YX\3\2\2\2Z`\3\2\2\2[\\\f"+
		"\3\2\2\\]\7\26\2\2]_\5\f\7\4^[\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a"+
		"\r\3\2\2\2b`\3\2\2\2\13\26)\60\66GNTY`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}