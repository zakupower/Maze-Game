package application;

import java.util.List;
import java.util.Random;

public class Orc implements Monster {
    private String name;
    private double damageMin;
    private double damageMax;
    private double health;
    static Random r = new Random();

    public Orc(String name, double damageMin, double damageMax, double health) {
        this.name = name;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.health = health;
    }

    @Override
    public void attack(Player player) {
        double randomDamage = damageMin  + (damageMax - damageMin) * r.nextDouble();
        randomDamage = round(randomDamage,2);
        Controller.textArea.setText(Controller.textArea.getText() + "\n" + name + " did " + randomDamage + " damage!");
        player.damage(randomDamage);
    }

    @Override
    public List<Item> getLoot() {
        return null;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    @Override
    public void damage(double damage) {
        health -= damage;
        health = round(health,2);
        Controller.textArea.setText(Controller.textArea.getText() + "\n" + name + " remaining health:" + health);
    }

    @Override
    public boolean isAlive() {
        return health>0;
    }
}
