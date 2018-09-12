package application;
import java.util.*;
public class Maze {
    ArrayList<Room> rooms;
    public Maze() {
        rooms = new ArrayList<>();
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void addConnection(Room from, Room to, Direction direction) {
        from.addExit(to, direction);
        to.addExit(from, direction.getReversed());
    }


}
