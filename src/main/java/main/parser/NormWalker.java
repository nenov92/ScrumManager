package main.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.norms.Obligation;
import main.norms.Prohibition;
import main.parser.NormParser.ObligationContext;
import main.parser.NormParser.TupleContext;
import main.scrum.roles.Role;

import org.antlr.v4.runtime.tree.TerminalNode;


/**
 * @author Miroslav Nenov
 * This object traverses the parse tree and loads the norms in data sets
 */
public class NormWalker extends NormBaseListener {
	private Set<Obligation> obligations = new HashSet<Obligation>();
	private Set<Prohibition> prohibitions = new HashSet<Prohibition>();

	public NormWalker() {
	}

	public Set<Obligation> getObligations() {
		return obligations;
	}

	public Set<Prohibition> getProhibitions() {
		return prohibitions;
	}

	
	/* (non-Javadoc)
	 * take tokens of the obligation and create object
	 */
	@Override
	public void enterObligation(ObligationContext ctx) {
		String activationCondition = returnConditionAsString(ctx.activationCondition().tuple(), ctx.activationCondition().LOGICAL_OPERATOR());
		String expirationCondition = returnConditionAsString(ctx.expirationCondition().tuple(), ctx.expirationCondition().LOGICAL_OPERATOR());
		String fulfilledCondition = returnConditionAsString(ctx.fulfilledCondition().tuple(), ctx.fulfilledCondition().LOGICAL_OPERATOR());
		String notFulfilledCondition = returnConditionAsString(ctx.notFulfilledCondition().tuple(), ctx.notFulfilledCondition().LOGICAL_OPERATOR());

		Obligation obligation = new Obligation(Integer.parseInt(ctx.INTEGER().getText()), Role.valueOf(ctx.ROLE().getText()), ctx.NAME().getText(), activationCondition, expirationCondition, fulfilledCondition, notFulfilledCondition);
		obligations.add(obligation);
	}

	/* (non-Javadoc)
	 * take tokens of the prohibition and create object
	 */
	@Override
	public void enterProhibition(main.parser.NormParser.ProhibitionContext ctx) {
		String activationCondition = returnConditionAsString(ctx.activationCondition().tuple(), ctx.activationCondition().LOGICAL_OPERATOR());
		String expirationCondition = returnConditionAsString(ctx.expirationCondition().tuple(), ctx.expirationCondition().LOGICAL_OPERATOR());
		String violatedCondition = returnConditionAsString(ctx.violatedCondition().tuple(), ctx.violatedCondition().LOGICAL_OPERATOR());

		Prohibition prohibition = new Prohibition(Integer.parseInt(ctx.INTEGER().getText()), Role.valueOf(ctx.ROLE().getText()), ctx.NAME().getText(), activationCondition, expirationCondition, violatedCondition);
		prohibitions.add(prohibition);
	}

	/**
	 * @param tc
	 * @param logicalOperators
	 * @return a string representing a conditional expression 
	 * 
	 *  as the conditional expression is constructed by multiple simple conditions
	 *  and in turn these conditions are made up by name comparator value
	 *  concatenate all values to a signle string
	 */
	private String returnConditionAsString(List<TupleContext> tc, List<TerminalNode> logicalOperators) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc.size(); i++) {
			sb.append(tc.get(i).NAME().toString() + " ");
			sb.append(tc.get(i).comparator().getText() + " ");
			if (i == tc.size() - 1) {
				sb.append(tc.get(i).value().getText());
			} else {
				sb.append(tc.get(i).value().getText() + " ");
				sb.append(logicalOperators.get(i) + " ");
			}
		}
		return sb.toString();
	}
}
