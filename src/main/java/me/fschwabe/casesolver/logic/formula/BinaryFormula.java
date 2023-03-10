package me.fschwabe.casesolver.logic.formula;

import me.fschwabe.casesolver.logic.VariableContext;
import me.fschwabe.casesolver.logic.expressions.BooleanExpression;
import me.fschwabe.casesolver.logic.operators.BinaryOperator;

public class BinaryFormula implements BooleanExpression {

    private final BinaryOperator operator;

    private final BooleanExpression left, right;

    public BinaryFormula(BinaryOperator operator, BooleanExpression left, BooleanExpression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean getValue(VariableContext context) {
        return operator.apply(left.getValue(context), right.getValue(context));
    }

    @Override
    public String toString() {
        return "(%s %s %s)".formatted(left, operator, right);
    }
}
