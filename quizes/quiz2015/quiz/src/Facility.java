import java.util.HashSet;
import java.util.Set;

public abstract class Facility {
    private int capacity;
    protected Set<User> authorized = new HashSet<>();

    public Facility(int capacity){
        this.capacity = capacity;
    }
    public abstract String getName();
    public int getCapacity() {
        return capacity;
    }
    public void addCapacity(int capacity){
        this.capacity += capacity;
    }

    public abstract void authorize(User user);
    public boolean canEnter(User user){
        for (User u : authorized)
            if (u.equals(user)) return true;
        return false;
    }
}
