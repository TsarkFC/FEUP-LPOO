import java.util.ArrayList;
import java.util.List;

public class Countable {
    protected List<Withdrawal> withdrawals = new ArrayList<>();
    protected List<Deposit> deposits = new ArrayList<>();

    public void addTransaction(Withdrawal w) {
        withdrawals.add(w);
    }

    public void addTransaction(Deposit d) {
        deposits.add(d);
    }
    public int count(){
        return withdrawals.size() + deposits.size();
    }
}
