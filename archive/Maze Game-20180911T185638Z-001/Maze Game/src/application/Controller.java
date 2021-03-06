package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    Label testLabel;
	Maze maze = new Maze();
    @FXML
    public void initialize() {
    	Room room1 = new Room();
    	Room room2 = new Room();
    	Room room3 = new Room();
    	Room room4 = new Room();
    	Room room5 = new Room();
    	Room room6 = new Room();
    	Room room7 = new Room();
    	
    	maze.addRoom(room1);
    	maze.addRoom(room2);
    	maze.addRoom(room3);
    	maze.addRoom(room4);
    	maze.addRoom(room5);
    	maze.addRoom(room6);
    	maze.addRoom(room7);
    	room7.setWinningRoom(true);
    	
    	maze.addConnection(room1, room2, Direction.RIGHT);
    	maze.addConnection(room1, room4, Direction.TOP);
    	maze.addConnection(room4, room3, Direction.RIGHT);
    	maze.addConnection(room4, room6, Direction.TOP);
    	maze.addConnection(room3, room5, Direction.TOP);
    	maze.addConnection(room6, room5, Direction.RIGHT);
    	maze.addConnection(room6, room7, Direction.TOP);
    	
    	maze.setPlayerPosition(room1);
    	testLabel.setGraphic(room1.getImageView());
    }
    @FXML
    public void keyPressed(KeyEvent ev) throws IOException {
        if(ev.getCode()== KeyCode.LEFT){
        	if(maze.tryToMove(Direction.LEFT)) {
                testLabel.setGraphic(maze.getPlayerPosition().getImageView());
                if(maze.getPlayerPosition().isWinningRoom()) {
                	System.out.println("WINNNERRRRRRRRRR");
                }
        	} else {
        		System.out.println("NO EXIT THAT WAY");
        	}
        } else if(ev.getCode()== KeyCode.RIGHT) {
        	if(maze.tryToMove(Direction.RIGHT)) {
                testLabel.setGraphic(maze.getPlayerPosition().getImageView());
                if(maze.getPlayerPosition().isWinningRoom()) {
                	System.out.println("WINNNERRRRRRRRRR");
                }
        	} else {
        		System.out.println("NO EXIT THAT WAY");
        	}
        } else if(ev.getCode()== KeyCode.DOWN) {
        	if(maze.tryToMove(Direction.BOT)) {
                testLabel.setGraphic(maze.getPlayerPosition().getImageView());
                if(maze.getPlayerPosition().isWinningRoom()) {
                	System.out.println("WINNNERRRRRRRRRR");
                }
        	} else {
        		System.out.println("NO EXIT THAT WAY");
        	}

        } else if(ev.getCode()== KeyCode.UP) {
        	if(maze.tryToMove(Direction.TOP)) {
                testLabel.setGraphic(maze.getPlayerPosition().getImageView());
                if(maze.getPlayerPosition().isWinningRoom()) {
                	System.out.println("WINNNERRRRRRRRRR");
                }
        	} else {
        		System.out.println("NO EXIT THAT WAY");
        	}
        } else {
            testLabel.setText("ANOTHER");
        }
    }

}

