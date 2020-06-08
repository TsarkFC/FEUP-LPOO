import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Event {
    private String title;
    private String date = "";
    private String description = "";
    private List<Person> people = new ArrayList<>();

    public Event(String title){
        this.title = title;
    }

    public Event(String title, String date){
        this.title = title;
        this.date = date;
    }

    public Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event e){
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
    }

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    public void setTitle(String title) { this.title = title; }
    public void setDate(String date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }

    public String toString(){
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    public boolean equals(Object object){
        if (object == null || object.getClass() != getClass()) return false;
        Event event = (Event) object;
        return title.equals(event.getTitle()) && date.equals(event.getDate()) && description.equals(event.getDescription());
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public int getAudienceCount(){
        Set<String> names = new HashSet<>();
        for (Person person : people)
            names.add(person.getName());
        return names.size();
    }
}
