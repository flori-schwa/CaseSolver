package casesolver;

import casesolver.logic.VariableContext;
import casesolver.logic.expressions.BooleanExpression;
import casesolver.logic.formula.Conjunction;
import casesolver.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class Case {

    private final Suspect[] suspects;
    private final int amountGuilty;

    public Case(int amountGuilty, Suspect... suspects) {
        this.amountGuilty = amountGuilty;
        this.suspects = suspects;
    }

    private boolean doesNotContradict(boolean[] suspectState, VariableContext context) {
        List<BooleanExpression> junction = new ArrayList<>();

        for (int i = 0; i < this.suspects.length; i++) {
            if (suspectState[i]) {
                continue;
            }

            junction.add(this.suspects[i].getTestimony());
        }

        BooleanExpression formula = new Conjunction(junction);

        System.out.println("Evaluating [" + formula + "] with " + context);
        boolean result = formula.getValue(context);
        System.out.println("    Result: " + result);

        return result;
    }

    private List<Suspect> getCulprits(boolean[] suspectState) {
        List<Suspect> result = new ArrayList<>();

        for (int i = 0; i < this.suspects.length; i++) {
            if (suspectState[i]) {
                result.add(suspects[i]);
            }
        }

        return result;
    }

    public List<Suspect> solve() {
        // initialize suspectState array

        boolean[] suspectState = new boolean[this.suspects.length];

        for (int i = 0; i < amountGuilty; ++i) {
            suspectState[i] = true;
        }

        // initialize variable context

        VariableContext variableContext = new VariableContext();

        for (int i = 0; i < this.suspects.length; i++) {
            int finalI = i;
            variableContext.set(suspects[i].getName(), () -> suspectState[finalI]);
        }

        // permutation algo (https://www.baeldung.com/java-array-permutations)
        int[] indexes = new int[suspectState.length];

        int i = 0;
        while (i < suspectState.length) {
            if (doesNotContradict(suspectState, variableContext)) {
                return getCulprits(suspectState);
            }

            if (indexes[i] < i) {
                ArrayUtil.swap(suspectState, i % 2 == 0 ? 0 : indexes[i], i);
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                ++i;
            }
        }

        throw new RuntimeException("unsolvable");
    }
}
