import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class Lab3 extends JPanel {
    public static void main(String[] args) {
        Lab3 m = new Lab3();

        JFrame frame = new JFrame();
        frame.add(m);
        frame.setTitle("Lab 3 62050185 Nanthawat Mingjindakul");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.MAGENTA);
        bezierCurve(g2, 140, 400, 280, 380, 200, 90, 500, 210);

        g2.setColor(Color.BLACK);
        plot(g2, 140, 400, 5);
        plot(g2, 280, 380, 5);
        plot(g2, 200, 90, 5);
        plot(g2, 500, 210, 5);

        g2.setColor(Color.GRAY);
        int xPoly[] = { 150, 250, 325, 375, 400, 275, 100 };
        int yPoly[] = { 150, 100, 125, 225, 325, 375, 300 };
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g2.drawPolygon(poly);

        buffer = floodFill(buffer, 200, 150, Color.WHITE, Color.BLUE);
        g.drawImage(buffer, 0, 0, null);
    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * t * t * (1 - t) * x3 +
                    t * t * t * x4);
            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * t * t * (1 - t) * y3 +
                    t * t * t * y4);
            plot(g, x, y, 3);
        }
    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {
        Queue<Point> q = new LinkedList<Point>();
        Graphics2D g2 = m.createGraphics();

        g2.setColor(replacement_colour);
        plot(g2, x, y, 1);
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            // north
            if (p.y > 0 && new Color(m.getRGB(p.x, p.y - 1)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // south
            if (p.y < 600 && new Color(m.getRGB(p.x, p.y + 1)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }

            // west
            if (p.x > 0 && new Color(m.getRGB(p.x - 1, p.y)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
            // east
            if (p.x < 600 && new Color(m.getRGB(p.x + 1, p.y)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
        }
        return m;
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
