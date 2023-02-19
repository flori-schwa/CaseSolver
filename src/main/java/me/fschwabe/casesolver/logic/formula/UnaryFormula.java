package me.fschwabe.casesolver.logic.formula;

import me.fschwabe.casesolver.logic.VariableContext;
import me.fschwabe.casesolver.logic.expressions.BooleanExpression;
import me.fschwabe.casesolver.logic.operators.UnaryOperator;

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
