import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * A Program for viewing images
 * @version 1.31 2018-04-10
 * @author Cay Hortsmann
 */

public class ImageViewer {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/*
* A Frame with a label to show an image
*/

class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int  DEFAULT_HEIGHT = 400;

    public ImageViewerFrame(){
        setSize( DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // Use a label to display the images
        var label = new JLabel();
        add(label);
        // Set up the file chooser
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        // Set up the menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        var menu = new JMenu("File");
        menuBar.add(menu);
        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
           // Show file chooser dialog
           int result = chooser.showOpenDialog(null);
           // If file selected, set it as icon of the label
            if(result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}