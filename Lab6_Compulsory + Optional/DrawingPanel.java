package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random numberR=new Random();
        int radius = numberR.nextInt(50)+50; //generate a random number
        int sides = (int) frame.configPanel.sidesField.getValue(); //get the value from UI (in ConfigPanel)
        int r=numberR.nextInt(255);
        int g=numberR.nextInt(255);
        int b=numberR.nextInt(255);
        int transparence=numberR.nextInt(255);
        Color color =new Color(r, g, b, transparence); //create a transparent random Color.
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        /*Add support for drawing multiple types of components. Implement at least two types of shapes.*/
        if(Objects.equals(frame.shapesPanel.shapes.getSelectedItem(), "square")) sides=4;
        /*Daca colorCombo e setat pe random se vor genera forme cu rgb random, daca e setat pe Black se vor genera forme Black.*/
        if(Objects.equals(frame.shapesPanel.shapes.getSelectedItem(), "ellipse")) {
            if(!Objects.equals(frame.configPanel.colorCombo.getSelectedItem(), "Random")){
                graphics.setColor(Color.BLACK);
            }
            graphics.fill(new nodeShape(x, y, radius));}
        else{
            if (frame.shapesPanel.shapes.getSelectedItem().equals("arc")) {
                if (!Objects.equals(frame.configPanel.colorCombo.getSelectedItem(), "Random")) {
                    graphics.setColor(Color.BLACK);
                }
                graphics.fill(new Arc2D.Double(x, y, numberR.nextInt(150)+50, numberR.nextInt(150)+50, 0, 50, Arc2D.OPEN));
            }
        }
    }

    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);}
}

