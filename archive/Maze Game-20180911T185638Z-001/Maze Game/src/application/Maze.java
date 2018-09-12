package application;
import java.util.*;
public class Maze {
	Room playerPosition;
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
	public Room getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(Room room) {
		playerPosition = room;
	}
	public boolean tryToMove(Direction direction) {
		Room room = playerPosition.getRoom(direction);
		if(room!=null) {
		playerPosition = room;
		return true;
    	} else {
    		return false;
    	}
	}
	
}
