package casesolver.logic.operators;

public class AndOperator implements BinaryOperator {

    public static final BinaryOperator INSTANCE = new AndOperator();

    private AndOperator() {

    }

    @Override
    public boolean apply(boolean left, boolean right) {
        return left && right;
    }

    @Override
    public String toString() {
        return "AND";
    }
}
