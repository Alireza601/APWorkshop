package ceit.aut.ac.ir;

import ceit.aut.ac.ir.gui.CFrame;
import javax.swing.*;
import java.io.IOException;

/**
 * this is the Main class that creates mainFrame and runs main method
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {

        CFrame frame = new CFrame("iNote");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
