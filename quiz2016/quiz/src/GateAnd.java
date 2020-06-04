public class GateAnd extends LogicGate {
    public GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException, CycleException {
        super(w1, x1, x2);
        symbol = "AND";
        w1.setFormula("AND(" + x1.getFormula() + "," + x2.getFormula() + ")");
        w1.setValue(x1.getValue() && x2.getValue());
    }

    @Override
    public void updateValues() {
        output.setValue(input1.getValue() && input2.getValue());
    }
}
