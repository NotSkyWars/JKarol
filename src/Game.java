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
        this.board = new Board(53, 6, 11);
        this.game = this;
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