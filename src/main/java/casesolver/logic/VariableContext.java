package casesolver.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class VariableContext {

    private final Map<String, BooleanSupplier> variables = new HashMap<>();

    public boolean get(String varName) {
        if (!variables.containsKey(varName)) {
            throw new IllegalArgumentException("No variable with name " + varName + " found");
        }

        return variables.get(varName).getAsBoolean();
    }

    public void set(String varName, boolean value) {
        set(varName, () -> value);
    }

    public void set(String varName, BooleanSupplier valueSupplier) {
        variables.put(varName, valueSupplier);
    }

    @Override
    public String toString() {
        return "{%s}".formatted(
            String.join(
                ", ",
                this.variables.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue().getAsBoolean()).toList()
            )
        );
    }
}
