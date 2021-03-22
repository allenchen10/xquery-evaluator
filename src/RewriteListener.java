// Generated from /Users/chenjiachen/github/cse-232b-project/src/Rewrite.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RewriteParser}.
 */
public interface RewriteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq(RewriteParser.XqContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq(RewriteParser.XqContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(RewriteParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(RewriteParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(RewriteParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(RewriteParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(RewriteParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(RewriteParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(RewriteParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(RewriteParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(RewriteParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(RewriteParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(RewriteParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(RewriteParser.CondContext ctx);
}