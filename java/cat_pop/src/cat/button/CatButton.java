/*
    Marshall Haymond
    1/1/17
    Cat Button.java
    Pops up images of cats
 */
package cat.button;

//imports
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.lang.*;
 



public class CatButton 
        {
          
   JButton cat1;
   JFrame frame = new JFrame();
   
   CatButton()
   {
    ImageIcon catImage = new ImageIcon("cat2.png"); 
    cat1 = new JButton(catImage);
    cat1.setRolloverIcon(new ImageIcon ("cat1.png"));
    frame.setLayout(new FlowLayout());
    
    
    frame.setVisible(true);
    frame.setSize(200,150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    JPanel panel = new JPanel();
    frame.add(panel);
    frame.setResizable(false);
    panel.add(cat1); //adds button to panel

   
   
    for (int i = 0; i < 10; i++)
    {
    cat1.addActionListener(new Action());//makes button do somthing
    }

   }
    
    
    
    //main
    public static void main(String[] args) 
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

