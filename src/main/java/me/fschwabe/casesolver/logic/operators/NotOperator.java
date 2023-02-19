package me.fschwabe.casesolver.logic.operators;

public class NotOperator implements UnaryOperator {

    public static final UnaryOperator INSTANCE = new NotOperator();

    private NotOperator() {

    }

    @Override
    public boolean apply(boolean value) {
        return !value;
    }

    @Override
    public String toString() {
        return "NOT";
    }
}
