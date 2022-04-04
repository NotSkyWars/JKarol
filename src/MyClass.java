import enums.Direction;

public class MyClass {
    static boolean isStopped;
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        for (; ; ) {
            game.sendBoard();
        }

    }

    public static void setStopped(){
        isStopped = true;
    }
}
