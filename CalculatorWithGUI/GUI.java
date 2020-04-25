import javax.swing.*;
import java.awt.*;

/**
 * this is a class for graphic user interface that makes calculator user friendly
 * @author Alireza Ghafari
 * @verion 1.0
 */
public class GUI {

    JFrame calcFrame;
    private JTabbedPane tabbedPane;
    private JPanel basicPanel;
    private JPanel advancePane;
    private JTextArea display;
    private JScrollPane scrollPane;



    public GUI() {
        init();
    }
    public void init(){
        calcFrame = new JFrame();

        calcFrame.setTitle("Calculator");
        calcFrame.setSize(480, 330);
        calcFrame.setLocation(650,380);
        calcFrame.setLayout(null);
        //calcFrame.setResizable(false);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
        calcFrame.setVisible(true);
    }
    public void draw(){
        tabbedPane = new JTabbedPane();
        basicPanel = new JPanel();

        tabbedPane.setSize(80, 263);
        tabbedPane.setLocation(395,8);
        tabbedPane.add("Basic",basicPanel);
        screen();
        setKeyboard();
        setAdvancedKeyboard();
        calcFrame.add(tabbedPane);
    }
    /**
     * a method to add keyboard to calculator
     */
    public void setKeyboard(){
        JPanel keyboard = new JPanel();
        keyboard.setLocation(0,120);
        keyboard.setSize(250,150);
        keyboard.setLayout(new GridLayout(4,3));
        for(int i =9 ;i>=0 ;i--){
            JButton button = new JButton(""+i);
            keyboard.add(button);
            if(i==1){
                JButton button2 = new JButton(".");
                keyboard.add(button2);
            }
        }
        JButton mod = new JButton("%");
        keyboard.add(mod);

        JPanel operators = new JPanel();
        operators.setLocation(250,120);
        operators.setSize(95,150);
        operators.setLayout(new GridLayout(2,2));

        JButton addition = new JButton("+");
        JButton multiplication = new JButton("*");
        JButton subtraction = new JButton("-");
        JButton division = new JButton("/");
        operators.add(addition);
        operators.add(multiplication);
        operators.add(subtraction);
        operators.add(division);

        JPanel AC = new JPanel();
        AC.setLocation(345,120);
        AC.setSize(50,40);
        AC.setLayout(new GridLayout(1,1));
        JButton ACButton = new JButton("AC");
        AC.add(ACButton);

        JPanel equal = new JPanel();
        equal.setLocation(345,160);
        equal.setSize(50,110);
        equal.setLayout(new GridLayout(1,1));
        JButton equalButton = new JButton("=");
        equal.add(equalButton);

        calcFrame.add(AC);
        calcFrame.add(equal);
        calcFrame.add(keyboard);
        calcFrame.add(operators);
    }

    /**
     * a method to add advance panel to calculator
     */
    private void setAdvancedKeyboard() {
        advancePane = new JPanel();
        advancePane.setLocation(300,0);
        advancePane.setSize(60,300);
        advancePane.setLayout(new GridLayout(6, 1));

        JButton[] buttons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", 10, 12));
            advancePane.add(buttons[i]);
        }
        buttons[0].setText("shift");
        buttons[1].setText("sin");
        buttons[2].setText("tan");
        buttons[3].setText("log");
        buttons[4].setText("\u03c0");
        buttons[5].setText("e");

        tabbedPane.add("adv", advancePane);
    }

    /**
     * a method to add output display to calculator
     */
    public void screen(){
        display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Arial", 14, 16));

        scrollPane = new JScrollPane(display);
        scrollPane.setLocation(8, 8);
        scrollPane.setSize(385, 110);


        calcFrame.add(scrollPane);
    }

}
