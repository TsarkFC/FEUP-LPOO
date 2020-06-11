public class Session extends Countable{
    private ATM atm;
    public Session(ATM atm){
        this.atm = atm;
    }

    public ATM getATM() {
        return atm;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != getClass())
            return false;
        Session s = (Session) o;
        return atm.equals(s.getATM());
    }
}
