package enums;

public enum Direction {
    LEFT("<"),
    RIGHT(">"),
    DOWN("v"),
    UP("^");

    private String symbole;

    public static Direction[] getDir() {
        return new Direction[]{LEFT, RIGHT, DOWN, UP};
    }

    Direction(String s) {
        this.symbole = s;
    }

    public String getSymbole() {
        return symbole;
    }
}
