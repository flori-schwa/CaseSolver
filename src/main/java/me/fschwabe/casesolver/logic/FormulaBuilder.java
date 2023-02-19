package me.fschwabe.casesolver.logic;

import me.fschwabe.casesolver.logic.expressions.BooleanExpression;
import me.fschwabe.casesolver.logic.expressions.LiteralBooleanExpression;
import me.fschwabe.casesolver.logic.expressions.VariableBooleanExpression;
import me.fschwabe.casesolver.logic.formula.BinaryFormula;
import me.fschwabe.casesolver.logic.formula.Conjunction;
import me.fschwabe.casesolver.logic.formula.Disjunction;
import me.fschwabe.casesolver.logic.formula.UnaryFormula;
import me.fschwabe.casesolver.logic.operators.NotOperator;
import me.fschwabe.casesolver.logic.operators.XorOperator;

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
