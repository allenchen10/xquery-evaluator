// Generated from /Users/chenjiachen/Documents/UCSD/WI21/CSE 232B/cse-232b-project/src/XPath.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XPathParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XPathParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XPathParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XPathParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(XPathParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(XPathParser.FContext ctx);
}