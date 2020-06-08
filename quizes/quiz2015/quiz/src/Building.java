import java.util.ArrayList;
import java.util.List;

public class Building extends Facility{
    private String name;
    private int minFloor;
    private int maxFloor;
    private List<Room> rooms = new ArrayList<>();

    public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
        super(0);
        this.name = name;
        if (maxFloor < minFloor)
            throw new IllegalArgumentException();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public String getName() {
        return name;
    }

    @Override
    public void authorize(User user) {
        authorized.add(user);
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    @Override
    public String toString(){
        return "Building(" + name + ")";
    }

    public boolean addRoom(Room room){
        for (Room r : rooms)
            if (r.equals(room)) return true;
        rooms.add(room);
        return false;
    }
}
