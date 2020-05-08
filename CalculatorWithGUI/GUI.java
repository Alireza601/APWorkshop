import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

/**
 * this is a class for graphic user interface that makes calculator user friendly
 *
 * @author Alireza Ghafari
 * @verion 1.0
 */
enum Operation {
    div, mul, add, sub, mod, sin, cos, tan, cot, log, exp
}

public class GUI implements ActionListener {

    private JMenuBar menuBar;
    private JFrame calcFrame;
    private JTabbedPane tabbedPane;
    private JPanel basicPanel;
    private JPanel advancePane;
    private JTextArea display;
    private JScrollPane scrollPane;
    private double result = 0;
    private Operation currentOperation;
    private String formerResult;


    public GUI() {
        init();
    }

    public void init() {
        calcFrame = new JFrame();

        calcFrame.setTitle("Calculator");
        calcFrame.setSize(480, 330);
        calcFrame.setLocation(650, 380);
        calcFrame.setLayout(null);
        calcFrame.setResizable(false);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar=new JMenuBar();
        draw();
        calcFrame.setVisible(true);

        keyHandling();
    }

    public void draw() {
        tabbedPane = new JTabbedPane();
        basicPanel = new JPanel();

        tabbedPane.setSize(80, 263);
        tabbedPane.setLocation(395, 8);
        tabbedPane.add("Basic", basicPanel);
        screen();
        setKeyboard();
        setAdvancedKeyboard();
        calcFrame.add(tabbedPane);
        addMenu();
    }

    /**
     * a method to add keyboard to calculator
     */
    public void setKeyboard() {
        JPanel keyboard = new JPanel();
        keyboard.setLocation(0, 120);
        keyboard.setSize(250, 150);
        keyboard.setLayout(new GridLayout(4, 3));
        for (int i = 9; i >= 0; i--) {
            JButton button = new JButton("" + i);
            button.addActionListener(this);
            keyboard.add(button);
            button.setFocusable(false);
            if (i == 1) {
                JButton button2 = new JButton(".");
                button2.addActionListener(this);
                button2.setFocusable(false);
                keyboard.add(button2);
            }
        }
        JButton mod = new JButton("%");
        mod.setToolTipText("mod");
        mod.addActionListener(this);
        mod.setFocusable(false);
        keyboard.add(mod);

        JPanel operators = new JPanel();
        operators.setLocation(250, 120);
        operators.setSize(95, 150);
        operators.setLayout(new GridLayout(2, 2));

        JButton addition = new JButton("+");
        addition.setFocusable(false);
        addition.setToolTipText("addition");
        addition.addActionListener(this);


        JButton multiplication = new JButton("*");
        multiplication.addActionListener(this);
        multiplication.setFocusable(false);
        multiplication.setToolTipText("multiplication");
        JButton subtraction = new JButton("-");
        subtraction.addActionListener(this);
        subtraction.setFocusable(false);
        subtraction.setToolTipText("subtraction");
        JButton division = new JButton("/");
        division.addActionListener(this);
        division.setFocusable(false);
        division.setToolTipText("division");
        operators.add(addition);
        operators.add(multiplication);
        operators.add(subtraction);
        operators.add(division);

        JPanel AC = new JPanel();
        AC.setLocation(345, 120);
        AC.setSize(50, 40);
        AC.setLayout(new GridLayout(1, 1));
        JButton ACButton = new JButton("AC");
        ACButton.setFocusable(false);
        ACButton.setToolTipText("eraser");
        ACButton.addActionListener(this);
        AC.add(ACButton);

        JPanel equal = new JPanel();
        equal.setLocation(345, 160);
        equal.setSize(50, 110);
        equal.setLayout(new GridLayout(1, 1));
        JButton equalButton = new JButton("=");
        equalButton.setFocusable(false);
        equalButton.setToolTipText("result");
        equalButton.addActionListener(this);
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
        advancePane.setLocation(300, 0);
        advancePane.setSize(60, 300);
        advancePane.setLayout(new GridLayout(6, 1));


        JButton[] buttons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", 10, 12));
            buttons[i].setFocusable(false);
            advancePane.add(buttons[i]);
        }
        buttons[0].setText("shift");
        buttons[0].setToolTipText("Shift operators");
        buttons[0].addActionListener(this);
        buttons[1].setText("sin");
        buttons[1].setToolTipText("sin/cos");
        buttons[1].addActionListener(this);
        buttons[2].setText("tan");
        buttons[2].setToolTipText("tan/cot");
        buttons[2].addActionListener(this);
        buttons[3].setText("log");
        buttons[3].setToolTipText("exp/log");
        buttons[3].addActionListener(this);
        buttons[4].setText("\u03c0");
        buttons[4].setToolTipText("pi number");
        buttons[4].addActionListener(this);
        buttons[5].setText("e");
        buttons[5].setToolTipText("neper number");
        buttons[5].addActionListener(this);

        tabbedPane.add("adv", advancePane);
    }

    /**
     * a method to add output display to calculator
     */
    public void screen() {
        display = new JTextArea("");
        display.setEditable(false);
        display.setFont(new Font("Arial", 14, 16));
        display.setFocusable(false);

        scrollPane = new JScrollPane(display);
        scrollPane.setLocation(8, 8);
        scrollPane.setSize(385, 110);


        calcFrame.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        for (int i = 0; i < 10; i++)
            if (jb.getText().contains("" + i)) {
                String temp = display.getText();
                temp += i;
                display.setText(temp);
            }
        if (jb.getText().equalsIgnoreCase("\u03c0")) {
            String temp = display.getText();
            temp += Math.PI;
            display.setText(temp);
        } else if (jb.getText().equalsIgnoreCase("e")) {
            String temp = display.getText();
            temp += Math.E;
            display.setText(temp);
        } else if (jb.getText().equalsIgnoreCase("=")) {
            result = getResult();
            display.setText("" + result);
            formerResult = display.getText();
            result = 0;
        } else if (jb.getText().equalsIgnoreCase("+")) {
            currentOperation = Operation.add;
            formerResult = display.getText();result+=Double.parseDouble(formerResult);
            display.setText("");
        } else if (jb.getText().equalsIgnoreCase("AC")) {
            result = 0;
            formerResult = display.getText();
            display.setText("");
        } else if (jb.getText().equalsIgnoreCase("-")) {
            currentOperation = Operation.sub;
            formerResult = display.getText();result+=Double.parseDouble(formerResult);
            display.setText("");
        } else if (jb.getText().equalsIgnoreCase("/")) {
            currentOperation = Operation.div;
            formerResult = display.getText();result+=Double.parseDouble(formerResult);
            display.setText("");
        } else if (jb.getText().equalsIgnoreCase("*")) {
            currentOperation = Operation.mul;
            formerResult = display.getText();result+=Double.parseDouble(formerResult);
            display.setText("");
        } else if (jb.getText().equalsIgnoreCase(".")) {
            String temp = display.getText();
            temp += ".";
            display.setText(temp);
        } else if (jb.getText().equalsIgnoreCase("%")) {
            currentOperation = Operation.mod;
            formerResult = display.getText();result+=Double.parseDouble(formerResult);
            display.setText("");
        }

    }

    public void keyHandling() {
        calcFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || (e.getKeyCode() >= 96 && e.getKeyCode() <= 105)) {
                    String temp = display.getText();
                    if (e.getKeyCode() <= 57)
                        temp += e.getKeyCode() - 48;
                    else
                        temp += e.getKeyCode() - 96;
                    display.setText(temp);
                }

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        System.exit(00);
                        break;
                    case KeyEvent.VK_PLUS:
                        currentOperation = Operation.add;
                        formerResult = display.getText();result+=Double.parseDouble(formerResult);
                        display.setText("");
                        break;
                    case KeyEvent.VK_MINUS:
                        currentOperation = Operation.sub;
                        formerResult = display.getText();result+=Double.parseDouble(formerResult);
                        display.setText("");
                        break;
                    case KeyEvent.VK_SLASH:
                        currentOperation = Operation.div;
                        formerResult = display.getText();result+=Double.parseDouble(formerResult);
                        display.setText("");
                        break;
                    case KeyEvent.VK_MULTIPLY:
                        currentOperation = Operation.mul;
                        formerResult = display.getText();result+=Double.parseDouble(formerResult);
                        display.setText("");
                        break;
                    case KeyEvent.VK_EQUALS:
                        if (e.isShiftDown()) {
                            currentOperation = Operation.add;
                            formerResult = display.getText();result+=Double.parseDouble(formerResult);
                            display.setText("");
                        } else {
                            result = getResult();
                            display.setText("" + result);
                            formerResult = display.getText();
                            result = 0;
                        }
                        break;
                    case KeyEvent.VK_PERIOD:
                        String temp = display.getText();
                        temp += ".";
                        display.setText(temp);
                        break;
                    case KeyEvent.VK_5:
                        if (e.isShiftDown()) {
                            currentOperation = Operation.mod;
                            formerResult = display.getText();result+=Double.parseDouble(formerResult);
                            display.setText("");
                        }
                        break;
                    case KeyEvent.VK_8:
                        if (e.isShiftDown()) {
                            currentOperation = Operation.mul;
                            formerResult = display.getText();result+=Double.parseDouble(formerResult);
                            display.setText("");
                        }

                    case KeyEvent.VK_ENTER:
                        result = getResult();
                        display.setText("" + result);
                        formerResult = display.getText();
                        result = 0;
                        break;

                }
            }
        });
        calcFrame.setFocusable(true);
    }
    public void addMenu(){
        JMenu menu = new JMenu("menu");
        menu.setMnemonic(KeyEvent.VK_M);

        JMenuItem copy = new JMenuItem("copy");
        copy.addActionListener(this);
        copy.setMnemonic(KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        JMenuItem exit = new JMenuItem("exit");
        exit.addActionListener(this);
        exit.setMnemonic(KeyEvent.VK_X);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        menu.add(copy);
        menu.add(exit);
        menuBar.add(menu);
        calcFrame.setJMenuBar(menuBar);
    }

    public double getResult() {
        switch (currentOperation) {
            case add:
                return result + Double.parseDouble(display.getText());
            case sub:
                return result - Double.parseDouble(display.getText());
            case div:
                return result / Double.parseDouble(display.getText());
            case mul:
                return result * Double.parseDouble(display.getText());
            case mod:
                return result % Double.parseDouble(display.getText());
        }
        return 0;
    }
}
