package main.norms;

import java.util.HashSet;
import java.util.Set;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
