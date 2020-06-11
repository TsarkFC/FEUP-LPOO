public class Withdrawal {
    private ATM atm;
    private Session s;
    private Card c;
    private double amount;
    public Withdrawal(ATM atm, Session s, Card c, double amount) {
        this.atm = atm;
        this.s = s;
        this.c = c;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private String amountOnCents(){
        String s = String.format("%.2f", amount);
        s = s.replace(',', '.');
        return s;
    }

    @Override
    public String toString(){
        return "Withdrawal at ATM " + atm.getID() + " (" + atm.getCity() + ", " + atm.getBank() + ") of " + amountOnCents();
    }
}
