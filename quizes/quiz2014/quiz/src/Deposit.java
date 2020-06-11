public class Deposit {
    private ATM atm;
    private Session s;
    private Card c;
    private double deposit;
    public Deposit(ATM atm, Session s, Card c, double deposit) {
        this.atm = atm;
        this.s = s;
        this.c = c;
        this.deposit = deposit;
    }
}
