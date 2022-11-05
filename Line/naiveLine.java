import javax.swing.*;
import java.awt.*;

public class naiveLine extends JPanel {
    public static void main(String[] args) {

        naiveLine m = new naiveLine(); // Create panel from JPanel

        JFrame frame = new JFrame(); // Create frame
        frame.add(m);
        frame.setTitle("Nanthawat Mingjindakul");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        naiveline(g, 100, 100, 400, 200);
    }

    public void naiveline(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        double m = dy / dx;
        double b = y1 - m * x1;

        for (int x = x1; x <= x2; x++) {
            int y = (int) Math.round(m * x + b);
            plot(g, x, y, 1);
        }
    }

    private void plot(Graphics plot, int x, int y, int size) {
        plot.fillRect(x, y, size, size);

    }
}