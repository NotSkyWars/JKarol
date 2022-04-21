import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame {
    private Game game;

    public Window(Board board, Game game) {
        this.game = game;
        initUI(board);

    }

    private Surface surface;

    private void initUI(Board board) {
        this.surface = new Surface(board);
        add(surface);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(1000, 1000, 500, 500);
        jTextArea.setVisible(true);
        jTextArea.setPreferredSize(new Dimension(500, 500));
        jTextArea.setFont(new Font("Arial", 1, 20));
        surface.add(jTextArea);


        ImageIcon icon = new ImageIcon("Button.png");
        JButton button = new JButton(icon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String s = jTextArea.getText();
                System.out.println("232332");

                String classNameA = "ExampleClass";
                String codeA =
                        "import enums.Direction;\npublic class ExampleClass {" + "\n" +
                                "    public static void exampleMethod(String name,Game game) {" + "\n"
                                + "try{\n";

                String[] ss = jTextArea.getText().split(";");
                new Thread(new Runnable() {
                    String codeB =  "import enums.Direction;\npublic class ExampleClass {" + "\n" +
                            "    public static void exampleMethod(String name,Game game) {" + "\n"
                            + "try{\n";
                    @Override
                    public void run() {
                        for(int i =0; i < ss.length;i++) {
                            try {

                                String end = ss[i];
                                end = end.replace("JKarol", "game.getBoard()");
                                if (end.contains("setDirection(")) {
                                    String dir = end.split("\\.")[2].replace("setDirection(", "").replace(")", "");
                                    System.out
                                            .println(end);
                                    end = "game.getBoard().setDirection(Direction." + dir + ");\n";
                                    System.out.println(end);
                                    reDraw();
                                }
                                codeB += end + ";\n";
                                codeB += "Thread.sleep(200);";
                                game.sendBoard();
                                game.getFrame().repaint();
                                reDraw();
                                surface.repaint();

                                TimeUnit.MILLISECONDS.sleep(10);
                            } catch (InterruptedException e1) {
                                System.out.println("ERROR");
                            }

                        }
                        String footer =
                                "}catch(Exception e){}" +
                                        "    }" + "\n" +
                                        "}" + "\n";

                        RuntimeCompiler r = new RuntimeCompiler();
                        r.addClass(classNameA, codeB + footer);
                        r.compile();

                        MethodInvocationUtils.invokeStaticMethod(
                                r.getCompiledClass(classNameA),
                                "exampleMethod", s, game);
                    }
                }).start();


            }
        });
        surface.add(button);

        setTitle("Basic shapes");
        setSize(2000, 2500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void add(JTextArea jTextArea) {
    }

    public void reDraw() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                repaint();
            }
        });
    }

}
