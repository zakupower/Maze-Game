package application;

import java.util.List;

public interface Monster {
    public void attack(Player player);
    public List<Item> getLoot();
    public void damage(double damage);
    public boolean isAlive();
}
