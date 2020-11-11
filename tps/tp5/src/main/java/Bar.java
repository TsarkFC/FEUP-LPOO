import java.util.ArrayList;
import java.util.List;

public abstract class Bar implements BarObserver{
    protected boolean happyHour;
    protected List<BarObserver> observers;

    public Bar(){
        happyHour = false;
        observers = new ArrayList<>();
    }

    public boolean isHappyHour() {
        return happyHour;
    }
    public void startHappyHour() {
        this.happyHour = true;
        notifyObservers();
    }
    public void endHappyHour() {
        this.happyHour = false;
        notifyObservers();
    }
    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

    public void happyHourStarted(Bar bar){

    }
    public void happyHourEnded(Bar bar){

    }
}
