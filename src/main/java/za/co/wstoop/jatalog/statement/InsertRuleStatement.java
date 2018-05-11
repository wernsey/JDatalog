package za.co.wstoop.jatalog.statement;

import java.util.Collection;
import java.util.Map;

import za.co.wstoop.jatalog.DatalogException;
import za.co.wstoop.jatalog.Jatalog;
import za.co.wstoop.jatalog.Rule;
import za.co.wstoop.jatalog.Term;

class InsertRuleStatement implements Statement {
	
	private final Rule rule;
	
	InsertRuleStatement(Rule rule) {
		this.rule = rule;
	}

	@Override
	public Collection<Map<String, Term>> execute(Jatalog datalog, Map<String, Term> bindings) throws DatalogException {
		Rule newRule;
		if(bindings != null) {
			newRule = rule.substitute(bindings);
		} else {
			newRule = rule;
		}
		datalog.rule(newRule);
		return null;
	}

}
