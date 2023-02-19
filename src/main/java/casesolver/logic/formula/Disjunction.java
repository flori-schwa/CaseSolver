package casesolver.logic.formula;

import casesolver.logic.VariableContext;
import casesolver.logic.expressions.BooleanExpression;

import java.util.Collection;
import java.util.List;

public class Disjunction extends Junction {

    public Disjunction(Collection<BooleanExpression> expressions) {
        super(expressions);
    }

    @Override
    public boolean getValue(VariableContext context) {
        boolean result = false;

        for (BooleanExpression expression : this.expressions) {
            result |= expression.getValue(context);
        }

        return result;
    }

    @Override
    public String toString() {
        return "(%s)".formatted(
                String.join(" OR ", this.expressions.stream().map(Object::toString).toList())
        );
    }
}
