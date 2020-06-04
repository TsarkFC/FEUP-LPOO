import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concert, int numOfTickets) throws InvalidTicket {
        List<Ticket> ret = new ArrayList<>();
        for (int i = 0; i < numOfTickets; i++){
            ret.add(new Ticket(concert.getTicket_count(), concert));
            concert.incrementTickets();
        }
        return ret;
    }
}
