package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.company.DrawingPanel.W;
import static com.company.DrawingPanel.H;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");
 
    public ControlPanel (MainFrame frame) {
        this.frame = frame; init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...
        add(loadButton);
        add(saveBtn);
        add(resetButton);
        add(exitButton);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::saveFile);
        loadButton.addActionListener(this::loadFile);
        resetButton.addActionListener(this::resetKeyboardActions);
        exitButton.addActionListener(this::mouseExit);
 
    }

    private void saveFile (ActionEvent actionEvent){
        try {
            /*Use a file chooser in order to specify the file where the image will be saved (or load).
            * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html*/
            JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnV = jFileChooser.showOpenDialog(null);
            if(returnV==JFileChooser.APPROVE_OPTION){
                File selectedFile=jFileChooser.getSelectedFile();
            ImageIO.write(frame.canvas.image, "PNG", new File(selectedFile.getAbsolutePath()));
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void loadFile (ActionEvent actionEvent){
        try {
            /*Use a file chooser in order to specify the file where the image will be saved (or load).
            * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html*/
            JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnV = jFileChooser.showOpenDialog(null);
            if (returnV == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jFileChooser.getSelectedFile();
                File loadedFile = new File(selectedFile.getAbsolutePath());
                frame.canvas.graphics = frame.canvas.image.createGraphics();
                frame.canvas.image = ImageIO.read(loadedFile);
            }
        }
        catch (IOException ex){ System.err.println(ex); }
    } repaint();
}

    private void resetKeyboardActions (ActionEvent actionEvent){
    frame.canvas.image=new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
    frame.canvas.graphics=frame.canvas.image.createGraphics();
    frame.canvas.graphics.setColor(Color.GRAY);
    frame.canvas.graphics.fillRect(0, 0, W, H);
    }

    private void mouseExit (ActionEvent actionEvent){ System.exit(3);}
}