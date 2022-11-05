
import javax.swing.*;
import java.awt.*;

public class Lab1 extends JPanel {
    public static void main(String[] args) {

        Lab1 panel = new Lab1(); // Create panel from JPanel

        JFrame frame = new JFrame(); // Create frame
        frame.add(panel);
        frame.setTitle("62050185 Nanthawat Mingjindakul");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics paint) {

        paint.drawString("Hello", 40, 40); 
        paint.drawString("1", 40, 80);
        paint.setColor(Color.BLUE); 
        paint.fillRect(130, 60, 100, 80); 
        paint.drawOval(300, 80, 50, 60); 

        paint.setColor(Color.BLACK);
        paint.drawString("2", 40, 180);
        paint.setColor(Color.RED);
        paint.drawLine(130, 160, 400, 230); 

        paint.setColor(Color.BLACK);
        paint.drawString("3", 40, 280);
        paint.setColor(Color.green);
        paint.fillOval(130, 230, 50, 60); 
        paint.setColor(Color.black);
        paint.drawArc(40, 385, 40, 50, 90, 60); 

        paint.fillArc(100, 360, 50, 50, 0, 45);
        cross(paint); // HOMEWORK 2.

    }

    public void cross(Graphics crooss) {

        // row
        plot(crooss, 298, 300, Color.RED);
        plot(crooss, 299, 300, Color.ORANGE);
        plot(crooss, 300, 300, Color.YELLOW);
        plot(crooss, 301, 300, Color.GREEN);
        plot(crooss, 302, 300, Color.BLUE);

        // column
        plot(crooss, 300, 298, Color.PINK);
        plot(crooss, 300, 299, Color.red);
        plot(crooss, 300, 301, Color.BLACK);
        plot(crooss, 300, 302, Color.ORANGE);
        plot(crooss, 300, 303, Color.red);
    }

    public void plot(Graphics plot, int x, int y, Color color) {
        plot.setColor(color);
        plot.fillRect(x, y, 1, 1);

    }
}