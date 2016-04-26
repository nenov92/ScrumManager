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
	 * Enter a parse tree produced by {@link NormParser#expirationCondition}.
	 * @param ctx the parse tree
	 */
	void enterExpirationCondition(@NotNull NormParser.ExpirationConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#expirationCondition}.
	 * @param ctx the parse tree
	 */
	void exitExpirationCondition(@NotNull NormParser.ExpirationConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(@NotNull NormParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(@NotNull NormParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(@NotNull NormParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(@NotNull NormParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#fulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void enterFulfilledCondition(@NotNull NormParser.FulfilledConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#fulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void exitFulfilledCondition(@NotNull NormParser.FulfilledConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#notFulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void enterNotFulfilledCondition(@NotNull NormParser.NotFulfilledConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#notFulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void exitNotFulfilledCondition(@NotNull NormParser.NotFulfilledConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#activationCondition}.
	 * @param ctx the parse tree
	 */
	void enterActivationCondition(@NotNull NormParser.ActivationConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#activationCondition}.
	 * @param ctx the parse tree
	 */
	void exitActivationCondition(@NotNull NormParser.ActivationConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull NormParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull NormParser.BoolContext ctx);
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
	 * Enter a parse tree produced by {@link NormParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull NormParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull NormParser.ValueContext ctx);
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