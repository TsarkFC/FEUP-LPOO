public class GateNot extends LogicGate {
    public GateNot(LogicVariable y1, LogicVariable w2) throws ColisionException, CycleException {
        super(y1, w2);
        symbol = "NOT";
        y1.setFormula("NOT(" + w2.getFormula() + ")");
        y1.setValue(!w2.getValue());
    }

    @Override
    public void updateValues() {
        output.setValue(!input1.getValue());
    }
}
