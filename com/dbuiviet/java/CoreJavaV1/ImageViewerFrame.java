package com.dbuiviet.java.CoreJavaV1;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;

public class ImageViewerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
    private JLabel label;
    private JFileChooser fileChooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    //initialization
    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //use a label to display image
        label = new JLabel();
        add(label);

        //setup a file chooser
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        //setup a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event->{
            //show file chooser dialog
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = fileChooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));                
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event->{
            System.exit(0);
        });
    }
}
