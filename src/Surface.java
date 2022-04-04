import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Surface extends JPanel {

    private BufferedImage VISITED ;
    Graphics graphics;
    private BufferedImage UP;
    private BufferedImage DOWN;
    private BufferedImage RIGHT;
    private BufferedImage LEFT;
    private BufferedImage DEAD;
    private BufferedImage AMOGUS;
    private BufferedImage BRICKS;
    private BufferedImage DIRT;
    private Board board;

    public Surface(Board board) {
        this.board = board;
        loadImages();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        graphics = g2d;
        //g2d.fillRect(30, 20, 50, 50);
        //g2d.fillRect(120, 20, 90, 60);
        //g2d.fillRoundRect(250, 20, 70, 60, 25, 25);

        //g2d.fill(new Ellipse2D.Double(10, 100, 80, 100));
        //g2d.fillArc(120, 130, 110, 100, 5, 150);

    }

    private void loadImages() {

        try {

            UP = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DREAM_DOWN.png"));
            DOWN = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DREAM_UP.png"));
            RIGHT = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DREAM_RIGHT.png"));
            LEFT = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DREAM_LEFT.png"));
            DEAD = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DREAM_DEAD.png"));
            AMOGUS = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\AMOGUS.png"));
            BRICKS = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\BRICK.png"));
            DIRT = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\DIRT.png"));
            VISITED = ImageIO.read(new File("C:\\USers\\Christian\\Desktop\\VISITED.png"));
        } catch (IOException ex) {

            Logger.getLogger(Surface.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void render() {
        int i = 50;
        int y = 20;
        int count = 0;
        for (Character s : board.getBoard().toCharArray()) {
            String string = Character.toString(s);
            if (string.equalsIgnoreCase("o") || string.equalsIgnoreCase("o\n")) {
                graphics.drawImage(DIRT, i, y, null);
                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("y") || string.equalsIgnoreCase("y\n")) {
                graphics.drawImage(VISITED, i, y, null);
                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("X") || string.equalsIgnoreCase("X\n")) {
                graphics.drawImage(BRICKS, i, y, null);
                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("<") || string.equalsIgnoreCase("<\n")) {
                graphics.drawImage(LEFT, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("^") || string.equalsIgnoreCase("^\n")) {
                graphics.drawImage(UP, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("v") || string.equalsIgnoreCase("v\n")) {
                graphics.drawImage(DOWN, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase(">") || string.equalsIgnoreCase(">\n")) {
                graphics.drawImage(RIGHT, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("d") || string.equalsIgnoreCase("d\n")) {
                graphics.drawImage(DEAD, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("I") || string.equalsIgnoreCase("I\n")) {
                graphics.setColor(new Color(2, 167, 2));
                graphics.fillRoundRect(i, y, 70, 60, 25, 25);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            } else if (string.equalsIgnoreCase("A") || string.equalsIgnoreCase("A\n")) {
                graphics.drawImage(AMOGUS, i, y, null);

                i += 70;
                count++;
                if (count == 6) {
                    y += 60;
                    count = 0;
                    i = 50;
                }
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
        render();
        Thread one = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    render();
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };
        one.start();
    }
}
