package main.aima;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Provides information which might be useful for a caller of a constraint
 * propagation algorithm. It maintains old domains for variables and provides
 * means to restore the initial state of the CSP (before domain reduction
 * started). Additionally, a flag indicates whether an empty domain has been
 * found during propagation.
 * 
 * @author Ruediger Lunde
 * 
 */
public class DomainLog<VAR extends Variable, VAL> implements InferenceLog<VAR, VAL> {
	private List<Pair<VAR, Domain<VAL>>> savedDomains;
	private HashSet<VAR> affectedVariables;
	private boolean emptyDomainObserved;

	public DomainLog() {
		savedDomains = new ArrayList<>();
		affectedVariables = new HashSet<>();
	}

	public void clear() {
		savedDomains.clear();
		affectedVariables.clear();
	}

	/**
	 * Stores the specified domain for the specified variable if a domain has
	 * not yet been stored for the variable.
	 */
	public void storeDomainFor(VAR var, Domain<VAL> domain) {
		if (!affectedVariables.contains(var)) {
			savedDomains.add(new Pair<>(var, domain));
			affectedVariables.add(var);
		}
	}

	public void setEmptyDomainFound(boolean b) {
		emptyDomainObserved = b;
	}

	/**
	 * Can be called after all domain information has been collected to reduce
	 * storage consumption.
	 * 
	 * @return this object, after removing one hashtable.
	 */
	public DomainLog<VAR, VAL> compactify() {
		affectedVariables = null;
		return this;
	}

	
	public boolean isEmpty() {
		return savedDomains.isEmpty();
	}

	
	public void undo(CSP<VAR, VAL> csp) {
		getSavedDomains().forEach(pair -> csp.setDomain(pair.getFirst(), pair.getSecond()));
	}

	public boolean inconsistencyFound() {
		return emptyDomainObserved;
	}

	private List<Pair<VAR, Domain<VAL>>> getSavedDomains() {
		return savedDomains;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Pair<VAR, Domain<VAL>> pair : savedDomains)
			result.append(pair.getFirst()).append("=").append(pair.getSecond()).append(" ");
		if (emptyDomainObserved)
			result.append("!");
		return result.toString();
	}
}
