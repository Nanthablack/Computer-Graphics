import javax.swing.*;
import java.awt.*;

public class DDALine extends JPanel {
    public static void main(String[] args) {

        DDALine m = new DDALine(); // Create panel from JPanel

        JFrame frame = new JFrame(); // Create frame
        frame.add(m);
        frame.setTitle("Nanthawat Mingjindakul");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        DDAline(g, 100, 100, 400, 200);
    }

    public void DDAline(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        double y, x;
        double m = dy / dx;

        if (m <= 1 && m >= 0) {
            y = Math.min(y1, y2);
            for (x = Math.min(x1, x2); x <= Math.max(x2, x1); x++) {
                y = y + m;
                plot(g, (int) Math.round(x), (int) Math.round(y), 1);
            }

        } else if (m >= -1 && m < 0) {
            y = Math.min(y1, y2);
            for (x = Math.max(x2, x1); x <= Math.min(x1, x2); x--) {
                y = y - m;
                plot(g, (int) Math.round(x), (int) Math.round(y), 1);
            }

        } else if (m > 1) {

            x = Math.min(x1, x2);
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x = x + 1 / m;
                plot(g, (int) Math.round(x), (int) Math.round(y), 1);
            }

        } else {
            x = Math.min(x1, x2);
            for (y = Math.max(y1, y2); y <= Math.min(y1, y2); y--) {
                x = x - 1 / m;
                plot(g, (int) Math.round(x), (int) Math.round(y), 1);
            }
        }

    }

    private void plot(Graphics plot, int x, int y, int size) {
        plot.fillRect(x, y, size, size);

    }
}