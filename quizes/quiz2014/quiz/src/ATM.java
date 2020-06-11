public class ATM {
    private int id;
    private String city, bank;
    public ATM(int id, String city, String bank) {
        this.id = id;
        this.city = city;
        this.bank = bank;
    }

    public int getID() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != getClass())
            return false;
        ATM atm = (ATM) o;
        return id == atm.id && city == atm.city && bank == atm.bank;
    }
}
