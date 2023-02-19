package casesolver.logic.formula;

import casesolver.logic.VariableContext;
import casesolver.logic.expressions.BooleanExpression;
import casesolver.logic.operators.UnaryOperator;

public class UnaryFormula implements BooleanExpression {

    private final UnaryOperator operator;
    private final BooleanExpression expression;

    public UnaryFormula(UnaryOperator operator, BooleanExpression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public boolean getValue(VariableContext context) {
        return operator.apply(expression.getValue(context));
    }

    @Override
    public String toString() {
        return "(" + operator + " " + expression + ")";
    }
}
