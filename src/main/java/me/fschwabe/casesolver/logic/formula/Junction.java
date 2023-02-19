package me.fschwabe.casesolver.logic.formula;

import me.fschwabe.casesolver.logic.expressions.BooleanExpression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Junction implements BooleanExpression {

    protected final List<BooleanExpression> expressions;

    public Junction(Collection<BooleanExpression> expressions) {
        this.expressions = new ArrayList<>(expressions);
    }
}
