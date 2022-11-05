import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;

public class Lab6 extends JPanel implements Runnable
{
    double circleMove = 0;
    double squareRotate = 0;
    double x = 0, y = 0;

    double velocity = 100;
    double angle = -60;
    double velocityX, velocityY;


    public static void main (String [] args)
    {
        Lab6 m = new Lab6();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Lab6");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    public void run() 
    {
        double lastTime = System.currentTimeMillis();
        double currentTime, elaspsedTime;
        
        velocityX = velocity * Math.cos(Math.toRadians(angle));
        velocityY = velocity * Math.cos(Math.toRadians(angle));

         while (true) 
         {
            //control time
             while(true){
                currentTime = System.currentTimeMillis();
                elaspsedTime = currentTime - lastTime;
                lastTime = currentTime;
             
             //update 
                velocityY += 9.81 * elaspsedTime / 1000.0;

                x += velocityX * elaspsedTime / 1000.0;
                y += velocityY * elaspsedTime / 1000.0;
            
             //display
             repaint();
            }
         }
    }

    public void paintComponent(Graphics g)  
    {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.decode("#AFF4F9"));
      g2.fillRect(0, 0, 600, 600);
      g2.setColor(Color.BLACK);

      AffineTransform transform = g2.getTransform();
      transform.rotate(Math.toRadians(-30), 200, 200);
      g2.setTransform(transform);
      g2.setColor(Color.BLUE);
      g2.fillRect(200, 200, 200, 200);

      g2.setTransform(new AffineTransform(2, 0, 0, 2, -400, -400));
      g2.translate(-50, 50);
      g2.drawRect(200, 200, 200, 200);

    }
   
}