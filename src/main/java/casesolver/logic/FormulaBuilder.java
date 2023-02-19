package casesolver.logic;

import casesolver.logic.expressions.BooleanExpression;
import casesolver.logic.expressions.LiteralBooleanExpression;
import casesolver.logic.expressions.VariableBooleanExpression;
import casesolver.logic.formula.BinaryFormula;
import casesolver.logic.formula.Conjunction;
import casesolver.logic.formula.Disjunction;
import casesolver.logic.formula.UnaryFormula;
import casesolver.logic.operators.NotOperator;
import casesolver.logic.operators.XorOperator;

import java.util.Arrays;

public class FormulaBuilder {

    private FormulaBuilder() {

    }

    public static BooleanExpression literal(boolean value) {
        return value ? LiteralBooleanExpression.TRUE : LiteralBooleanExpression.FALSE;
    }

    public static BooleanExpression variable(String varName) {
        return new VariableBooleanExpression(varName);
    }

    public static BooleanExpression or(BooleanExpression... expressions) {
        return new Disjunction(Arrays.asList(expressions));
    }

    public static BooleanExpression and(BooleanExpression... expressions) {
        return new Conjunction(Arrays.asList(expressions));
    }

    public static BooleanExpression xor(BooleanExpression left, BooleanExpression right) {
        return new BinaryFormula(XorOperator.INSTANCE, left, right);
    }

    public static BooleanExpression not(BooleanExpression expression) {
        return new UnaryFormula(NotOperator.INSTANCE, expression);
    }

}
