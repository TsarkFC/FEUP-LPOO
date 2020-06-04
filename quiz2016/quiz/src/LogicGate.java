public abstract class LogicGate {
    protected LogicVariable output;
    protected LogicVariable input1;
    protected LogicVariable input2;
    protected String symbol;

    public LogicGate(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
        this.input1 = input;
        if (input1.getFormula() == null)
            this.input1.setFormula(input.getName());

        this.output = output;
        if (this.output.getCalculatedBy() != null) throw new ColisionException();
        this.output.addReached(input1);
        if (this.output.verifyCicle()) throw new CycleException();
        this.output.setLogicGate(this);
    }

    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
        this.input1 = input1;
        if (input1.getFormula() == null)
            this.input1.setFormula(input1.getName());

        this.input2 = input2;
        if (input2.getFormula() == null)
            this.input2.setFormula(input2.getName());

        this.output = output;
        if (this.output.getCalculatedBy() != null)
            throw new ColisionException();

        this.output.addReached(input1);
        this.output.addReached(input2);
        if (this.output.verifyCicle()) throw new CycleException();
        this.output.setLogicGate(this);
    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs(){
        if (input2 == null)
            return new LogicVariable[] {input1};
        else
            return new LogicVariable[] {input1, input2};
    }

    public String getSymbol() {
        return symbol;
    }

    public String getFormula(){
        return output.getFormula();
    }

    public abstract void updateValues();
}
