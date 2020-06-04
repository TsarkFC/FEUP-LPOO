import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    private List<Artist> artists;

    public Band(String name, String country) {
        super(name, country);
        artists = new ArrayList<>();
    }

    public void addArtist(Artist artist){
        if (!containsArtist(artist))
            artists.add(artist);
    }
    public List<Artist> getArtists() { return artists; }

    public boolean containsArtist(Artist artist){
        for (Artist art : artists)
            if (art.equals(artist)) return true;
        return false;
    }
}
