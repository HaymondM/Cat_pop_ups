/*
    Marshall Haymond
    3/20/2021
    Cat Button.java
    Pops up images of cats
 */

//imports
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.Cursor;


public class CatButton 
        {
          
   JButton cat1;
   JFrame frame = new JFrame("Cat pop!");
   JLabel label1 = new JLabel("Timer:");
   
   
   
   CatButton() throws InterruptedException
   {
    
    ImageIcon catImage = new ImageIcon("cat2.png"); 
    cat1 = new JButton(catImage);
    cat1.setRolloverIcon(new ImageIcon ("cat1.png"));
    cat1.setPreferredSize(new Dimension(500, 80));
    cat1.setBackground(Color.white);
    frame.setLayout(new FlowLayout());
    
    

      

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("cat2.png");
    Cursor c = toolkit.createCustomCursor(image , new Point(frame.getX(), 
           frame.getY()), "img");
    
    //set up the frame
    frame.setVisible(true);
    frame.setSize(600,600);
    frame.setIconImage(image);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //DO_NOTHING_ON_CLOSE
    frame.setCursor(c);
    frame.getContentPane().setBackground(Color.darkGray);
    JPanel panel = new JPanel();
    Dimension size = label1.getPreferredSize();
    frame.add(panel);
    label1.setForeground(Color.RED);
    label1.setFont(new Font("Serif", Font.BOLD, 200));
    frame.setResizable(false);
    panel.add(cat1); //adds button to panel
    frame.add(label1);

    
     // int count = 0;
      //while(count < 10){
      
      
     // count+= 1;
     // }
      //int seconds = calendar.get(Calendar.SECOND);
      //String s=Integer.toString(seconds);
      //label1.setText(s);
    
      
      int numcats = 0;

      for(int i = 1; i <= 500; i++)
      {   
        String s=Integer.toString(i);
        label1.setText(s);
        numcats = i;
        Thread.sleep(100);
        if (cat1.getModel().isPressed()){
            System.out.println("worked");
            break;
        }
    }
      

    /*  while(!cat1.getModel().isPressed())
      {
        int seconds = calendar.get(Calendar.SECOND);
        String s=Integer.toString(seconds);

            seconds +=1;
            label1.setText(s);
            System.out.println(seconds);
        }
   */

      for (int i = 0; i < numcats; i++)
      {
        cat1.addActionListener(new Action());//makes button do the action
      }
   }
    
    
    
    //main
    public static void main(String[] args) throws InterruptedException
    {

      
      new CatButton();//main exicution 


    }
    

    static class Action implements ActionListener
   {
    public void actionPerformed (ActionEvent e)
    {
        //set vars
        Random rand1 = new Random(); //sets the frame to popo up somewhere random
        System.out.println(rand1); //test
        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
       
        Random rand2 = new Random();
        int randomImage = rand2.nextInt((7 - 1) + 1) + 1; // set to the number of pictures in the program
        JLabel lbl = new JLabel(new ImageIcon("bigcat"+randomImage+".jpg")); //imports the image && image random
        
        //where image is going to open
        //main code for Dialog
        dialog.add(lbl);
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocation(rand1.nextInt(1250), rand1.nextInt(800));        
    }
   }
}

