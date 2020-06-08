import java.util.ArrayList;
import java.util.List;

public class LogicVariable {
    private String name;
    private boolean value = false;
    private LogicGate logicGate;
    private String formula;
    private List<LogicVariable> reachedBy = new ArrayList<>();

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public LogicVariable(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        if (logicGate != null)
            logicGate.updateValues();
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object){
        if (object == null || object.getClass() != getClass()) return false;
        LogicVariable var = (LogicVariable) object;
        return var.getName().equals(name);
    }

    public LogicGate getCalculatedBy() {
        return logicGate;
    }

    public void setLogicGate(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<LogicVariable> getReachedBy() {
        return reachedBy;
    }

    public void addReached(LogicVariable variable) {
        reachedBy.add(variable);
        for (LogicVariable var : variable.getReachedBy())
            reachedBy.add(var);
    }

    public boolean verifyCicle(){
        for (LogicVariable variable : reachedBy)
            if (equals(variable)) return true;
        return false;
    }
}
