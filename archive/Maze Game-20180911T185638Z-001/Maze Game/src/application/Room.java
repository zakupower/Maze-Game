package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Room {
    private static int nextID = 0;
    private int ID;
    private boolean TOP_EXIT;
    private boolean BOT_EXIT;
    private boolean LEFT_EXIT;
    private boolean RIGHT_EXIT;
    private final boolean HAS_ITEMS;
    private final boolean HAS_MONSTER;
    private boolean isWinningRoom;
    private Room topRoom,botRoom,leftRoom,rightRoom;
    private ImageView roomImage;
    public Room(){
        this(false,false,false,false,generateRandomBoolean(),generateRandomBoolean());
    	ID = nextID++;
    }
    private static boolean generateRandomBoolean() {
    	return Math.random()>=0.5;
    }
    public Room(boolean topExit, boolean botExit, boolean leftExit, boolean rightExit, boolean hasItems, boolean hasMonster) {
    	TOP_EXIT = topExit;
    	BOT_EXIT = botExit;
    	LEFT_EXIT = leftExit;
    	RIGHT_EXIT = rightExit;
    	HAS_ITEMS = hasItems;
    	HAS_MONSTER = hasMonster;
    	ID = nextID++;
    }
    private void setCorrectImage() {
    	StringBuilder imageName = new StringBuilder("file:images/");
    	imageName.append(LEFT_EXIT?"LEFT":"");
    	imageName.append(RIGHT_EXIT?"RIGHT":"");
    	imageName.append(TOP_EXIT?"TOP":"");
    	imageName.append(BOT_EXIT?"BOT":"");
    	imageName.append(".png");
    	System.out.println(imageName.toString());
        Image image = new Image(imageName.toString());
        roomImage = new ImageView(image);
        roomImage.setFitHeight(500);
        roomImage.setFitWidth(500);
    }
    public Room getRoom(Direction direction) {
		switch(direction) {
    	case TOP:
    		return topRoom;
    	case BOT:
    		return botRoom;
    	case LEFT:
    		return leftRoom;
    	case RIGHT:
    		return rightRoom;
    	}
		return null;
    }
    public boolean addExit(Room room, Direction direction) {
    	switch(direction) {
    	case TOP:
    		if(topRoom!=null)return false;
    		topRoom = room;
    		TOP_EXIT = true;
    		break;
    	case BOT:
    		if(botRoom!=null)return false;
    		botRoom = room;
    		BOT_EXIT = true;
    		break;
    	case LEFT:
    		if(leftRoom!=null)return false;
    		leftRoom = room;
    		LEFT_EXIT = true;
    		break;
    	case RIGHT:
    		if(rightRoom!=null)return false;
    		rightRoom = room;
    		RIGHT_EXIT = true;
    		break;
    	}
    	return true;
    }
    
    public boolean isWinningRoom() {
		return isWinningRoom;
	}
	public void setWinningRoom(boolean isWinningRoom) {
		this.isWinningRoom = isWinningRoom;
	}
	public int getID(){
        return ID;
    }
    public ImageView getImageView() {
    	if(roomImage==null)setCorrectImage();
    	return roomImage;
    }
    @Override
    public String toString(){
        return ID+"";
    }
}

