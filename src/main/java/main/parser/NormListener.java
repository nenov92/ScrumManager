// Generated from Norm.g4 by ANTLR 4.5.2
package main.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NormParser}.
 */
public interface NormListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NormParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NormParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NormParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#norm}.
	 * @param ctx the parse tree
	 */
	void enterNorm(NormParser.NormContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#norm}.
	 * @param ctx the parse tree
	 */
	void exitNorm(NormParser.NormContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#obligation}.
	 * @param ctx the parse tree
	 */
	void enterObligation(NormParser.ObligationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#obligation}.
	 * @param ctx the parse tree
	 */
	void exitObligation(NormParser.ObligationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#prohibition}.
	 * @param ctx the parse tree
	 */
	void enterProhibition(NormParser.ProhibitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#prohibition}.
	 * @param ctx the parse tree
	 */
	void exitProhibition(NormParser.ProhibitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#activationCondition}.
	 * @param ctx the parse tree
	 */
	void enterActivationCondition(NormParser.ActivationConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#activationCondition}.
	 * @param ctx the parse tree
	 */
	void exitActivationCondition(NormParser.ActivationConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#expirationCondition}.
	 * @param ctx the parse tree
	 */
	void enterExpirationCondition(NormParser.ExpirationConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#expirationCondition}.
	 * @param ctx the parse tree
	 */
	void exitExpirationCondition(NormParser.ExpirationConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#fulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void enterFulfilledCondition(NormParser.FulfilledConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#fulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void exitFulfilledCondition(NormParser.FulfilledConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#notFulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void enterNotFulfilledCondition(NormParser.NotFulfilledConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#notFulfilledCondition}.
	 * @param ctx the parse tree
	 */
	void exitNotFulfilledCondition(NormParser.NotFulfilledConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(NormParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(NormParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(NormParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(NormParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(NormParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(NormParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(NormParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(NormParser.ValueContext ctx);
}