package me.fschwabe.casesolver.logic.expressions;

import me.fschwabe.casesolver.logic.VariableContext;

public interface BooleanExpression {

    boolean getValue(VariableContext context);

}
