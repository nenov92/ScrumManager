// Generated from Norm.g4 by ANTLR 4.4
package main.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NormParser}.
 */
public interface NormListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NormParser#obligation}.
	 * @param ctx the parse tree
	 */
	void enterObligation(@NotNull NormParser.ObligationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#obligation}.
	 * @param ctx the parse tree
	 */
	void exitObligation(@NotNull NormParser.ObligationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#prohibition}.
	 * @param ctx the parse tree
	 */
	void enterProhibition(@NotNull NormParser.ProhibitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#prohibition}.
	 * @param ctx the parse tree
	 */
	void exitProhibition(@NotNull NormParser.ProhibitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull NormParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull NormParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#norm}.
	 * @param ctx the parse tree
	 */
	void enterNorm(@NotNull NormParser.NormContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#norm}.
	 * @param ctx the parse tree
	 */
	void exitNorm(@NotNull NormParser.NormContext ctx);
}