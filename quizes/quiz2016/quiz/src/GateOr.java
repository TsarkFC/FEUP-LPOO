public class GateOr extends LogicGate {
    public GateOr(LogicVariable w2, LogicVariable w1, LogicVariable x3) throws ColisionException, CycleException {
        super(w2, w1, x3);
        symbol = "OR";
        w2.setFormula("OR(" + w1.getFormula() + "," + x3.getFormula() + ")");
        w2.setValue(w1.getValue() || x3.getValue());
    }

    @Override
    public void updateValues() {
        output.setValue(input1.getValue() || input2.getValue());
    }
}
