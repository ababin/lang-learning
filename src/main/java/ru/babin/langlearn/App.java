package ru.babin.langlearn;

import javax.swing.JFrame;

import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.ui.FrmMain;

/**
 * Hello world!
 *
 */
public class App{
    
    public static Mediator mediator = new Mediator();
    
    public static void main( String[] args ){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        FrmMain form = new FrmMain(mediator); 
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        //Display the window.
        form.pack();
        form.setVisible(true);
        form.postInit();
    }
    
}
