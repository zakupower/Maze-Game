package application;

import java.util.Random;

public class Player {
    Room playerPosition;
    double health;
    Inventory inventory;
    static Random r = new Random();
    //Weapon weapon;
    double damageMin;
    double damageMax;
    public Player(){
        health = 100;
        //CHANGE WITH WEAPON LATER
        damageMin = 10;
        damageMax = 20;

        inventory = new Inventory();
    }
    public void attack(Monster monster) {
        double randomDamage = damageMin  + (damageMax - damageMin) * r.nextDouble();
        randomDamage = round(randomDamage,2);
        Controller.textArea.setText("You did " + randomDamage + " damage!");
        monster.damage(randomDamage);

    }
    //FIX THIS ABOMINATION
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

//    public Weapon getWeapon() {
//        return weapon;
//    }
//
//    public void setWeapon(Weapon weapon) {
//        this.weapon = weapon;
//    }
    public boolean isAlive(){
        return health>0;
    }
    public void damage(double dmg){
        health-=dmg;
        health = round(health,2);
        Controller.textArea.setText(Controller.textArea.getText() + "\n" + "Your remaining health:" + health);
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
