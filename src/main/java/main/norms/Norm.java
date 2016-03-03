package main.norms;

import java.util.HashSet;
import java.util.Set;

public class Norm {

	private Set<Obligation> obligations = new HashSet<Obligation>();
	private Set<Prohibition> prohibitions = new HashSet<Prohibition>();

	public Norm() {
	}

	public Norm(Set<Obligation> obligations) {
		this.obligations = obligations;
	}

	public Norm(Set<Obligation> obligations, Set<Prohibition> prohibitions) {
		this.obligations = obligations;
		this.prohibitions = prohibitions;
	}

	public Set<Obligation> getObligations() {
		return obligations;
	}

	public void setObligations(Set<Obligation> obligations) {
		this.obligations = obligations;
	}

	public void addObligation(Obligation obligation) {
		getObligations().add(obligation);
	}

	public void deleteObligation(Obligation obligation) {
		getObligations().remove(obligation);
	}

	public Set<Prohibition> getProhibitions() {
		return prohibitions;
	}

	public void setProhibitions(Set<Prohibition> prohibitions) {
		this.prohibitions = prohibitions;
	}

	public void addProhibition(Prohibition prohibition) {
		getProhibitions().add(prohibition);
	}

	public void deleteProhibition(Prohibition prohibition) {
		getProhibitions().remove(prohibition);
	}
}
