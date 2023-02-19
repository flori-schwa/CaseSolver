package casesolver.logic.operators;

public class XorOperator implements BinaryOperator {

    public static final BinaryOperator INSTANCE = new XorOperator();

    private XorOperator() {

    }

    @Override
    public boolean apply(boolean left, boolean right) {
        return left != right;
    }

    @Override
    public String toString() {
        return "XOR";
    }
}
