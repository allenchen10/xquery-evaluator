// Generated from /Users/chenjiachen/Documents/UCSD/WI21/CSE 232B/cse-232b-project/src/Rewrite.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RewriteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RewriteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq(RewriteParser.XqContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(RewriteParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(RewriteParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#sep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSep(RewriteParser.SepContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(RewriteParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(RewriteParser.CondContext ctx);
}