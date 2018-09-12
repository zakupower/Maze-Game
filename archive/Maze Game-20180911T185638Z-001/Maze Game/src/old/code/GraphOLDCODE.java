//package old.code;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.stream.Stream;
//
//import application.Direction;
//import application.Room;
//
//import java.util.*;
//public class GraphOLDCODE {
//    HashMap<Room,ArrayList<Room>> graph;
//    Room playerPosition;
//    public GraphOLDCODE(){
//        graph = new HashMap<>();
//    }
//    public void addRoom(Room room){
//        graph.put(room,new ArrayList<>());
//    }
//    //undirected
//    public void addConnection(Room from, Room to ){
//        if(graph.containsKey(from) && graph.containsKey(to)){
//            graph.get(from).add(to);
//            graph.get(to).add(from);
//        } else {
//            throw new RuntimeException("No such room");
//        }
//    }
//
//    public ArrayList<Room> getConnections(Room room){
//        if(graph.containsKey(room)){
//            return new ArrayList<>(graph.get(room));
//        } else {
//            throw new RuntimeException("No such room");
//        }
//    }
//    public void setPlayerPosition(Room playerPosition) {
//    	this.playerPosition = playerPosition;
//    }
//    public boolean attemptToMovePlayer(Direction direction) {
//    	switch(direction) {
//    	case TOP:
//    		break;
//    	case BOT:
//    		
//    		break;
//    	case LEFT:
//    		
//    		break;
//    	case RIGHT:
//    		
//    		break;
//    	}
//    }
//    public static void main(String[] args) {
//        GraphOLDCODE graph = new GraphOLDCODE();
//        Room room = new Room();
//        graph.addRoom(room);
//        Room room1 = new Room();
//        graph.addRoom(room1);
//        Room room2 = new Room();
//        graph.addRoom(room2);
//        graph.addConnection(room,room1);
//        graph.addConnection(room1,room2);
//        System.out.println(graph.getConnections(room1));
//        System.out.println(graph.getConnections(room));
//        
//
//    }
//}
//
