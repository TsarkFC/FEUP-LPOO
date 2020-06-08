import java.util.ArrayList;
import java.util.List;

public class Party extends Event{
    List<Event> events = new ArrayList<>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public Party(Event e) {
        super(e);
    }

    public void addEvent(Event e){
        events.add(e);
    }

    @Override
    public int getAudienceCount(){
        int total = 0;
        total += super.getAudienceCount();
        for (Event e : events)
            total += e.getAudienceCount();
        return total;
    }
}
