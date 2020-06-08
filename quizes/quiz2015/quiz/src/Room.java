public class Room extends Facility{
    private Building building;
    private String number;
    private int floor;

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        super(0);
        this.building = building;
        this.number = number;
        if (floor < building.getMinFloor() || floor > building.getMaxFloor())
            throw new IllegalArgumentException();
        this.floor = floor;
        if (this.building.addRoom(this))
            throw new DuplicateRoomException();
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        super(capacity);
        this.building = building;
        this.number = number;
        if (floor < building.getMinFloor() || floor > building.getMaxFloor())
            throw new IllegalArgumentException();
        this.floor = floor;
        building.addCapacity(capacity);
        if (this.building.addRoom(this))
            throw new DuplicateRoomException();
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getName(){
        return building.getName() + number;
    }

    @Override
    public void authorize(User user) {
        authorized.add(user);
        building.authorized.add(user);
    }

    @Override
    public String toString(){
        return "Room(" + building.getName() + "," + number + ")";
    }

    @Override
    public boolean equals(Object object){
        if (object.getClass() != getClass())
            return false;
        Room room = (Room) object;
        return room.getBuilding().getName().equals(building.getName()) &&
                room.getNumber().equals(number) &&
                room.getFloor() == floor;
    }
}
