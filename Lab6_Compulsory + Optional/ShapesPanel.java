package com.company;

import javax.swing.*;

/*Consider creating a new panel, containing a list of available shapes. The configuration panel must adapt according to the type of the selected shape.*/
public class ShapesPanel extends JPanel {
    private MainFrame frame;
    JComboBox<String> shapes;

    public ShapesPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
    String[] shapeName = {"square", "ellipse", "edge"};
    shapes = new JComboBox<>(shapeName);
    add(shapes);
    }
}
