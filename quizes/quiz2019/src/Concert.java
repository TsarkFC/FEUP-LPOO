import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private int ticket_count = 1;
    private List<Act> acts;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        acts = new ArrayList<>();
    }

    public void addAct(Act act){ acts.add(act); }
    public List<Act> getActs() { return acts; }

    public String getCity() { return city; }
    public String getCountry() { return country; }
    public String getDate() { return date; }
    public int getTicket_count() { return ticket_count; }
    public void incrementTickets() {ticket_count++;}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Concert concert = (Concert) object;
        return city.equals(concert.city) && country.equals(concert.country) && date.equals(concert.date);
    }

    @Override
    public int hashCode(){
        return Objects.hash(city, country, date);
    }

    public boolean isValid(Ticket ticket){
        return ticket.getConcert() == this;
    }

    public boolean participates(Artist artist){
        for (Act act : acts){
            if (act.equals(artist)) return true;
            else if (act instanceof Band) {
                Band band = (Band) act;
                for (Artist art : band.getArtists())
                    if (art.equals(artist)) return true;
            }
        }
        return false;
    }
}
