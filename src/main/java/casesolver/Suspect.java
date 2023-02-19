package casesolver;

import casesolver.logic.expressions.BooleanExpression;

public class Suspect {

    private final String name;
    private final BooleanExpression testimony;

    public Suspect(String name, BooleanExpression testimony) {
        this.name = name;
        this.testimony = testimony;
    }

    public String getName() {
        return name;
    }

    public BooleanExpression getTestimony() {
        return testimony;
    }
}
