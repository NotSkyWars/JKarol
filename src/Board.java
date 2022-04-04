import enums.Direction;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private String[] board;
    public int ploc;
    public int pY;
    public Direction direction;
    private int row;
    private int length;
    private List<Integer> visted;

    public Board(int ploc, int row, int length) {
        this.board = new String[]{
                "X", "X", "X", "X", "X", "X\n",
                "X", "I", "X", "o", "o", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "X", "o", "X", "X\n",
                "X", "o", "o", "o", "o", "o\n",
                "X", "X", "X", "X", "X", "^\n",
                "X", "X", "X", "X", "X", "X\n",

        };
        this.visted = new ArrayList<>();
        this.ploc = ploc;
        this.row = row;
        this.length = length;
        this.direction = Direction.UP;
        //setUP();
    }

    public int getSize() {
        return board.length;
    }

    public void setUP() {
        String s = "";
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < row - 1; i2++) {
                s += "o ";
            }
            s += "o\n";
        }
        board = s.split(" ");
    }

    public String getBoard() {
        String result = "";
        for (String s : board) {
            result += s;
        }
        return result;
    }

    public List<Integer> getVisted() {
        return visted;
    }

    public void setChar(int x, int y, String s) {
        Arrays.asList(board).set(x * y, s);
    }

    public void setChar(int num, String s) {
        Arrays.asList(board).set(num, s);
    }

    public String get(int x, int y) {
        return board[x * y];
    }

    public String getInfrontType() {
        int num = ploc;
        if (direction == Direction.LEFT) {
            num--;
        } else if (direction == Direction.RIGHT) {
            num++;
        } else if (direction == Direction.UP) {
            num -= row;
        } else {
            num += row;
        }
        return get(num, 1);
    }

    public int getInfront() {
        int num = ploc;
        if (direction == Direction.LEFT) {
            num--;
        } else if (direction == Direction.RIGHT) {
            num++;
        } else if (direction == Direction.UP) {
            num -= row;
        } else {
            num += row;
        }
        return num;
    }

    public void setStone() {
        if (getInfrontType().contains("\n"))
            setChar(getInfront(), "X\n");
        else
            setChar(getInfront(), "X");

    }

    public void movePlayer(int num) {
        if (get(ploc, 1).contains("\n"))
            setChar(ploc, "o\n");
        else
            setChar(ploc, "o");

        if (get(num, 1).contains("\n"))
            setChar(num, direction.getSymbole() + "\n");
        else
            setChar(num, direction.getSymbole());
        ploc = num;
        setChar(num, "o\n");
        visted.add(num);
    }

    public void moveForward() {
        int num = ploc;
        if (direction == Direction.LEFT) {
            num--;
        } else if (direction == Direction.RIGHT) {
            num++;
        } else if (direction == Direction.UP) {
            num -= row;
        } else {
            num += row;
        }
        if (getInfrontType().equalsIgnoreCase("X"))
            MyClass.setStopped();
        else {
            if (get(ploc, 1).contains("\n"))
                setChar(ploc, "y\n");
            else
                setChar(ploc, "y");

            if (get(num, 1).contains("\n"))
                setChar(num, direction.getSymbole() + "\n");
            else
                setChar(num, direction.getSymbole());
            ploc = num;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        if (get(ploc, 1).contains("\n"))
            setChar(ploc, direction.getSymbole() + "\n");
        else
            setChar(ploc, direction.getSymbole());

    }

    public void lookRandom() {
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        Direction direction = Direction.getDir()[random];
        this.direction = direction;
    }

    public void turn() {
        if (direction == Direction.UP)
            direction = Direction.DOWN;
        else if (direction == Direction.RIGHT)
            direction = Direction.LEFT;
        else if (direction == Direction.DOWN)
            direction = Direction.UP;
        else if (direction == Direction.LEFT)
            direction = Direction.RIGHT;

    }

    public void right() {
        if (direction == Direction.UP)
            direction = Direction.RIGHT;
        else if (direction == Direction.RIGHT)
            direction = Direction.DOWN;
        else if (direction == Direction.DOWN)
            direction = Direction.LEFT;
        else if (direction == Direction.LEFT)
            direction = Direction.UP;

    }

    public void left() {
        if (direction == Direction.UP)
            direction = Direction.LEFT;
        else if (direction == Direction.RIGHT)
            direction = Direction.UP;
        else if (direction == Direction.DOWN)
            direction = Direction.RIGHT;
        else if (direction == Direction.LEFT)
            direction = Direction.DOWN;

    }
}

