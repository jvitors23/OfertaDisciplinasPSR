package main.aima;


/**
 * Defines a common interface for backtracking inference strategies.
 *
 * @author Ruediger Lunde
 */
public interface InferenceStrategy<VAR extends Variable, VAL> {

    /**
     * Inference method which is called before backtracking is started.
     */
    InferenceLog<VAR, VAL> apply(CSP<VAR, VAL> csp);

    /**
     * Inference method which is called after the assignment has (recursively) been extended by a value assignment
     * for <code>var</code>.
     */
    InferenceLog<VAR, VAL> apply(CSP<VAR, VAL> csp, Assignment<VAR, VAL> assignment, VAR var);
}
