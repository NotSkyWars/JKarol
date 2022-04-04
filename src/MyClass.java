import enums.Direction;

public class MyClass {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        for(;;){
            game.sendBoard();
        }
    }

    private void te(Game game) {

        game.getBoard().setDirection(Direction.RIGHT);
        game.getBoard().moveForward();
        game.getBoard().setDirection(Direction.DOWN);
        game.getBoard().moveForward();
        game.getBoard().setDirection(Direction.UP);
        game.getBoard().moveForward();
        game.getBoard().setDirection(Direction.LEFT);
        game.getBoard().setStone();
        game.getBoard().setDirection(Direction.DOWN);
        game.getBoard().moveForward();
        game.getBoard().setDirection(Direction.UP);
        game.getBoard().setDirection(Direction.DOWN);
    }
}
