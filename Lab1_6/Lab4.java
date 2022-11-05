
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Lab4 extends JPanel {
    public static void main(String[] args) {
        Lab4 m = new Lab4();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("lab4: Circle & Ellipse");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        // task 2 of Ex.1
        g.setColor(Color.RED);
        midpointCircle(g, 50, 300, 200);

        // task 2 of Ex.2
        g.setColor(Color.BLUE);
        midpointEllipse(g, 300, 350, 150, 100);
        g.setColor(Color.BLUE);
        midpointEllipse(g, 300, 350, 100, 150);

        g.setColor(Color.GREEN);
        midpointEllipse(g, 300, 350, 200, 100);

        g.setColor(Color.ORANGE);
        midpointEllipse(g, 300, 300, 195, 100);

        g.setColor(Color.ORANGE);
        midpointEllipse(g, 300, 350, 195, 100);
    }

    public void midpointCircle(Graphics g, int r, int xc, int yc) {
        int x = 0;
        int y = r;
        int d = 1 - r;

        while (x <= y) {
            plot(g, x + xc, y + yc, 2);
            plot(g, x + xc, -y + yc, 2);
            plot(g, -x + xc, y + yc, 2);
            plot(g, -x + xc, -y + yc, 2);

            plot(g, y + xc, x + yc, 2);
            plot(g, y + xc, -x + yc, 2);
            plot(g, -y + xc, x + yc, 2);
            plot(g, -y + xc, -x + yc, 2);

            x++;

            d = d + 2 * x + 1;

            if (d >= 0) {
                y--;
                d = d - 2 * y;
            }
        }
    }

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        // Region 1
        int x = 0;
        int y = b;

        int d = Math.round(b * b - a * a * b + a * a / 4);

        while (b * b * x <= a * a * y) {
            plot(g, x + xc, y + yc, 3);
            plot(g, -x + xc, y + yc, 3);
            plot(g, x + xc, -y + yc, 3);
            plot(g, -x + xc, -y + yc, 3);
            x++;

            d = d + 2 * b * b * x + b * b;
            if (d >= 0) {
                y--;
                d = d - 2 * a * a * y;
            }
        }

        // Region 2
        x = a;
        y = 0;

        d = Math.round(a * a - b * b * a + b * b / 4);

        while (b * b * x >= a * a * y) {
            plot(g, x + xc, y + yc, 1);
            plot(g, -x + xc, y + yc, 1);
            plot(g, x + xc, -y + yc, 1);
            plot(g, -x + xc, -y + yc, 1);

            y++;

            d = d + 2 * a * a * y + a * a;
            if (d >= 0) {
                x--;
                d = d - 2 * b * b * x;
            }
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}