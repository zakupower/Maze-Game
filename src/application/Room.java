package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Room {

    private boolean hasItems;
    private boolean hasMonster;
    private boolean isWinningRoom;
    private Room topRoom,botRoom,leftRoom,rightRoom;
    private ImageView roomImage;
    private Monster monster;
    private int roomDecor;
    public Room(){
        this(generateRandomBoolean(),generateRandomBoolean());
    }
    private static boolean generateRandomBoolean() {
        return Math.random()>=0.5;
    }
    public Room(boolean hasItems, boolean hasMonster) {
        this.hasItems = hasItems;
        this.hasMonster = hasMonster;
        if(hasMonster) {
            monster = new Orc("Normal Orc",5,10,50);
        }
        Random random = new Random();
        roomDecor = random.nextInt(4);
    }
    private void setCorrectImage() {

        StringBuilder imageName = new StringBuilder("file:images/");
        imageName.append(leftRoom!=null?"LEFT":"");
        imageName.append(rightRoom!=null?"RIGHT":"");
        imageName.append(topRoom!=null?"TOP":"");
        imageName.append(botRoom!=null?"BOT":"");
        imageName.append(""+roomDecor);
        imageName.append(hasMonster ?"MON":"");
        imageName.append(hasItems ?"ITEM":"");
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
                break;
            case BOT:
                if(botRoom!=null)return false;
                botRoom = room;
                break;
            case LEFT:
                if(leftRoom!=null)return false;
                leftRoom = room;
                break;
            case RIGHT:
                if(rightRoom!=null)return false;
                rightRoom = room;
                break;
        }
        return true;
    }

    public boolean hasItems() {
        return hasItems;
    }

    public boolean hasMonster() {
        return hasMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setHasItems(boolean hasItems) {
        this.hasItems = hasItems;
        setCorrectImage();
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
        setCorrectImage();
    }

    public boolean isWinningRoom() {
        return isWinningRoom;
    }
    public void setWinningRoom(boolean isWinningRoom) {
        this.isWinningRoom = isWinningRoom;
    }
    public ImageView getImageView() {
        if(roomImage==null)setCorrectImage();
        return roomImage;
    }
}

