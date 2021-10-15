package PO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_GUI extends JFrame{
	ViewPresLayer VPL = new ViewPresLayer(this);
	JTextField number_field_1 = new JTextField(3);
    JTextField number_field_2 = new JTextField(3);
    JLabel equal = new JLabel("=");
    JLabel result = new JLabel("",SwingConstants.CENTER);
    JButton sum = new JButton("+");
    JButton subtract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    
    public Calculator_GUI() {
    	super("GUI");
        setBounds(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,
        		(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1));
        Font font = new Font("TimesRoman",Font.BOLD, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/30);
        
        JPanel panel_1 = new JPanel();
        number_field_1.setFont(font);
        panel_1.add(number_field_1);
        panel_1.add(number_field_1);
        number_field_2.setFont(font);
        panel_1.add(number_field_2);
        equal.setFont(font);
        panel_1.add(equal);
        result.setFont(font);
        panel_1.add(result);
        container.add(panel_1);
       
        JPanel panel_2 = new JPanel();
        sum.setFont(font);
        subtract.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);
        panel_2.add(sum);
        panel_2.add(subtract);
        panel_2.add(multiply);
        panel_2.add(divide);
        container.add(panel_2);

        sum.addActionListener(new PlusListener());
        subtract.addActionListener(new MinusListener());
        multiply.addActionListener(new MultListener());
        divide.addActionListener(new DivListener());
    }

    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	VPL.onPlusClicked();
        }
    }
    class MinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	VPL.onMinusClicked();
        }
    }
    class MultListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	VPL.onMultiplyClicked();
        }
    }
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	VPL.onDivideClicked();
        }
    }
    
    

    public static void main(String[] args) {
        var app = new Calculator_GUI();
        app.setVisible(true);
    }
}