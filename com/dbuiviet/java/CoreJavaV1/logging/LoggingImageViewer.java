package com.dbuiviet.java.CoreJavaV1.logging;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;


/**
 * A modification of the image viewer program that logs various event
 * @version 1.0
 * @author dbuiviet
 */
public class LoggingImageViewer
{
    public static void main(String[] args) {
        
        if (System.getProperty("java.util.logging.config.class") == null
            && System.getProperty("java.util.logging.config.file") == null)
        {
            try
            {
                Logger.getLogger("com.dbuiviet.java.CoreJavaV1").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler fh = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.dbuiviet.java.CoreJavaV1").addHandler(fh);
            }
            catch (IOException e)
            {
                Logger.getLogger("com.dbuiviet.java.CoreJavaV1").log(Level.SEVERE, "Can't create a logfile handler", e);
            }
        }

        EventQueue.invokeLater(() -> 
        {
            Handler wh = new WindowHandler();
            wh.setLevel(Level.ALL);
            Logger.getLogger("com.dbuiviet.java.CoreJavaV1").addHandler(wh);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.dbuiviet.java.CoreJavaV1").fine("Showing frame");
            frame.setVisible(true);
        }
        );

    }
}

/**
 * The frame that shows the image
 */
class ImageViewerFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("com.dbuiviet.java.CoreJavaV1");

    //construtor
    public ImageViewerFrame()
    {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //setup menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        //use label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", ae);

            //setup FileChooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            
            //accept all files ending with .gif
            chooser.setFileFilter(new FileFilter(){
            
                @Override
                public String getDescription() {
                    return "GIF images";
                }
            
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }
            });

            //show file chooser dialog
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            //if image file accepted, set it as icon of the label
            if (r == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            }
            else
            {
                logger.fine("FileOpenDialog canceled");
            }

            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
        
    }
}

/**
 * A handler that displays log records in a window
 */
class WindowHandler extends StreamHandler
{
    private JFrame frame;

    //constructor
    public WindowHandler()
    {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        setOutputStream(new OutputStream(){
        
            @Override
            public void write(int arg0) throws IOException {
                //not called
            }

            public void write(byte[] b, int off, int len)
            {
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish(LogRecord lr)
    {
        if (!frame.isVisible()) return;
        super.publish(lr);
        flush();
    }
}