import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab5 extends JPanel implements Runnable
 {
  double circleMove = 0;
  double squareRotate = 0;
  
     double x = 0;
     double y = 500;
     double angle = -60;
     double velocityX, velocityY;
     double move_x = 0.2;
     double width = 600;
     
  public static void main (String[]args) 
  {
   Lab5 m = new Lab5();
   JFrame f = new  JFrame();
   f.add(m);
   f.setTitle("Animation");  
   f.setSize(600,600); 
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   f.setVisible(true);  
   (new Thread (m)).start();
  }
  public void run() 
  {
   double lastTime= System.currentTimeMillis();
   double currentTime, elapsedTime;
   double Alltime = 0;
 
   while(true) 
   {
    

    currentTime = System.currentTimeMillis();
    elapsedTime = currentTime - lastTime;
    lastTime = currentTime;
 

           circleMove += 50.0 * elapsedTime / 1000.0;
          
           x += velocityX * elapsedTime / 1000.0;
           y += velocityY * elapsedTime / 1000.0;
     
           Alltime +=  elapsedTime/1000;
     if((Alltime) > 3 )
     {
      squareRotate += 100 * elapsedTime / 1000.0;
     }
 
    repaint();
          }
   
  }
 
  public void paintComponent (Graphics g)
  {
   Graphics2D g2 = (Graphics2D)g;
   g2.setColor(Color.black);
   g2.fillRect(0, 0, 600, 600);
   
   
   //g2.translate((int)circleMove, 0);
   
   
   g2.setColor(Color.ORANGE);
   g2.fillOval((int)circleMove, 0, 100, 100);
   
   
    circleMove = circleMove + move_x;
       if (circleMove < 0) {
              circleMove = 0;
              move_x = -move_x;
       } else if (circleMove >= width - 100) {
              circleMove = width - 100;
              move_x = -move_x;
       }
     
      g2.translate(0, -squareRotate);
 
   g2.setColor(Color.BLUE);
   g2.fillRect(0, 500, 120, 120); 
  }
  
 } 
