package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;
import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapesPanel shapesPanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
     /*   controlPanel.resetButton.addActionListener();
        controlPanel.saveBtn.addActionListener();
        controlPanel.loadButton.addActionListener();
        controlPanel.exitButton.addActionListener(); */
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        add(shapesPanel, WEST);
        //invoke the layout manager
        pack();
    }
}

