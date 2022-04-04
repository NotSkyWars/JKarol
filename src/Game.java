import enums.Direction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Board board;
    private Window frame;
    private Game game;

    public Game() {
        this.board = new Board(21, 6, 6);
        this.game = this;
        Direction direction = Direction.LEFT;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Window(board, game);
                frame.setVisible(true);
            }
        });
    }



    public JFrame getFrame() {
        return frame;
    }

    public void sendBoard() throws InterruptedException {
        Thread.sleep(200);
        frame.reDraw();
    }

    public Board getBoard() {
        try {
            sendBoard();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return board;
    }
}