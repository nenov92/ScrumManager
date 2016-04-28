package main.norms;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Miroslav Nenov
 * object holding the run-time instances of all norms
 */
public class Norm {

	private Set<Obligation> obligations = new HashSet<Obligation>();
	private Set<Prohibition> prohibitions = new HashSet<Prohibition>();

	// empty constructor 
	public Norm() {
	}

	public Norm(Set<Obligation> obligations, Set<Prohibition> prohibitions) {
		this.obligations = obligations;
		this.prohibitions = prohibitions;
	}

	public Set<Obligation> getObligations() {
		return obligations;
	}

	/**
	 * @param obligations
	 * default setter
	 */
	public void setObligations(Set<Obligation> obligations) {
		this.obligations = obligations;
	}

	/**
	 * @param obligation
	 * add an obligation to the set of obligations
	 */
	public void addObligation(Obligation obligation) {
		getObligations().add(obligation);
	}

	/**
	 * @param obligation
	 * delete an obligation from the set of obligations
	 */
	public void deleteObligation(Obligation obligation) {
		getObligations().remove(obligation);
	}

	public Set<Prohibition> getProhibitions() {
		return prohibitions;
	}

	/**
	 * @param prohibitions
	 * default setter
	 */
	public void setProhibitions(Set<Prohibition> prohibitions) {
		this.prohibitions = prohibitions;
	}

	/**
	 * @param prohibition
	 * add a prohibition to the set of prohibitions
	 */
	public void addProhibition(Prohibition prohibition) {
		getProhibitions().add(prohibition);
	}

	/**
	 * @param prohibition
	 * delete a prohibition from the set of prohibitions
	 */
	public void deleteProhibition(Prohibition prohibition) {
		getProhibitions().remove(prohibition);
	}
}
