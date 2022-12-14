//Resources in shape class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenSaver extends JPanel 
{
    static DefaultListModel<String> l1 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(l1);
    JFrame frame = new JFrame();
    int count;
    Timer timer;
    Shape[] shapes = new Shape[20];

    public ScreenSaver() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(list1);
        drawingPanel drawPanel = new drawingPanel();
        add(drawPanel);
       
        timer = new Timer(20, new ActionListener() 
        {
          public void actionPerformed(ActionEvent ae) 
          {
            for (int i = 1; i < shapes.length; i++) 
            {
              if (shapes[i] != null) 
              {
                  shapes[i].move();
              }
              repaint();
            }
          }
        });
      }
    //main method
    public static void main(String[] args) 
    {
      //cretes frame
      JFrame frame = new JFrame ();
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  
      //creates screensaver
      ScreenSaver screensaver = new ScreenSaver();
      frame.getContentPane().add (screensaver);

      for (int i = 0; i < 20; i++) 
      {
        screensaver.addShape(i);
      }
      screensaver.start();
      frame.pack();
      frame.setVisible(true);
    }

    //adds a new shape if the amount of shapes on screensaver is less than shapes.length
    public  void addShape(int i) 
    {
      if (count < shapes.length) 
      {
        shapes[i] = new Shape();
      }
    }
//starts the timer
    public  void start() 
    {
      timer.start();    
    }
    
  private class drawingPanel extends JPanel 
  {
    public drawingPanel() 
    {
      setPreferredSize (new Dimension(600, 600));
      setBackground (Color.blue);
    }

    //calls the display on every shape
    public void paintComponent (Graphics g) 
    {
      super.paintComponent(g);
      for (int i = 0; i < shapes.length; i++) 
      {
        if (shapes[i] != null) 
        {
          if(i % 2 == 0)
          shapes[i].display(g);
          else 
          {
          shapes[i].display2(g);
          }
        }
      }
    }
  }
}