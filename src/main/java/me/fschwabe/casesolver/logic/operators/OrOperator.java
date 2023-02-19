package me.fschwabe.casesolver.logic.operators;

public class OrOperator implements BinaryOperator {

    public static final BinaryOperator INSTANCE = new OrOperator();

    private OrOperator() {

    }

    @Override
    public boolean apply(boolean left, boolean right) {
        return left || right;
    }

    @Override
    public String toString() {
        return "OR";
    }
}
