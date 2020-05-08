import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * this is the Main class that runs main method and creates instance from GUI class
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Run {
    public static void main(String[] args){
        try{
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e){
        }
        GUI Calc = new GUI();

    }
}
