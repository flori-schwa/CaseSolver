package casesolver.logic.expressions;

import casesolver.logic.VariableContext;

public interface BooleanExpression {

    boolean getValue(VariableContext context);

}
