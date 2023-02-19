package me.fschwabe.casesolver.logic.expressions;

import me.fschwabe.casesolver.logic.VariableContext;

public class VariableBooleanExpression implements BooleanExpression {

    private final String variableName;

    public VariableBooleanExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public boolean getValue(VariableContext context) {
        return context.get(this.variableName);
    }

    @Override
    public String toString() {
        return ":" + this.variableName;
    }
}
