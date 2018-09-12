package application;

public enum Direction {
    TOP,BOT,LEFT,RIGHT;
    public Direction getReversed() {
        switch(this) {
            case TOP:
                return BOT;
            case BOT:
                return TOP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
        }
        return null;
    }
}
