package main.norms;

import java.util.HashSet;
import java.util.Set;

public class Norm {

	private Set<Obligation> obligations = new HashSet<Obligation>();

	public Norm() {
	}

	public Norm(Set<Obligation> obligations) {
		this.setObligations(obligations);
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

}
