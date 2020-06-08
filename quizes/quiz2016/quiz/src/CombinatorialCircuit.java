import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    private List<LogicVariable> variables = new ArrayList<>();

    public boolean addVariable(LogicVariable variable){
        for (LogicVariable var : variables)
            if (var.equals(variable)) return false;

        variables.add(variable);
        return true;
    }

    public LogicVariable getVariableByName(String name) {
        for (LogicVariable variable : variables)
            if (variable.getName() == name) return variable;
        return null;
    }
}
