package casesolver.logic.expressions;

import casesolver.logic.VariableContext;

public class LiteralBooleanExpression implements BooleanExpression {

    public static final BooleanExpression TRUE = new LiteralBooleanExpression(true);
    public static final BooleanExpression FALSE = new LiteralBooleanExpression(false);

    private final boolean value;

    public LiteralBooleanExpression(boolean value) {
        this.value = value;
    }

    public boolean getLiteralValue() {
        return value;
    }

    @Override
    public boolean getValue(VariableContext context) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
