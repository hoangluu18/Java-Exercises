package JavaSwing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class bai2 extends JFrame implements ActionListener {
    JLabel headerJLabel;
    JLabel number1JLabel;
    JLabel number2JLabel;
    JLabel resultJLabel;

    JTextField number1jTextField;
    JTextField number2jTextField;
    JTextField resulJTextField;

    JButton addButton;
    JButton subButton;
    JButton multiButton;
    JButton divButton;
    JButton resetButton;
    JButton exitButton;

    Panel pn,pn1,pn2,pn3,pn4;

    public void GUI() {
        headerJLabel = new JLabel("Basic Arithmetic Operations") ;
        number1JLabel = new JLabel ("Number1");
        number2JLabel = new JLabel("Number2");
        resultJLabel = new JLabel("Result");

        number1jTextField = new JTextField();
        number2jTextField = new JTextField();
        resulJTextField = new JTextField();

        addButton = new JButton("Addition");
        subButton = new JButton("Subtraction");
        multiButton = new JButton("Multiplication");
        divButton = new JButton("Division");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        pn = new Panel(new GridLayout(4,1));
        pn1 = new Panel(new FlowLayout());
        pn2 = new Panel(new GridLayout(3,2));
        pn3 = new Panel(new FlowLayout());
        pn4 = new Panel(new FlowLayout());
        pn1.add(headerJLabel);
        pn2.add(number1JLabel);
        pn2.add(number1jTextField);
        pn2.add( number2JLabel);
        pn2.add(number2jTextField );
        pn2.add( resultJLabel );
        pn2.add( resulJTextField );

        pn3.add( addButton);
        pn3.add( subButton);
        pn3.add(  multiButton);
        pn3.add(divButton);

        pn4.add(resetButton); pn4.add(exitButton);


        addButton.addActionListener(this);
        subButton.addActionListener(this);
        multiButton.addActionListener(this);
        divButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);


        resulJTextField.setEditable(false);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        this.add(pn);
        this.setTitle("Arithmetic Operations");
        this.setSize(600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);



    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exitButton) {
            System.exit(0);
        }

        String num1Text = number1jTextField.getText();
        String num2Text = number2jTextField.getText();

        if(num1Text.isEmpty() || num2Text.isEmpty()) {
            resulJTextField.setText("Please enter both numbers");
            return;
        }


        float a = Float.parseFloat(num1Text);
        float b = Float.parseFloat(num2Text);
        if(e.getSource() == addButton) {
            Float result = a + b;
            resulJTextField.setText(result.toString());
        }
        if(e.getSource() == subButton) {
            Float result = a - b;
            resulJTextField.setText(result.toString());
        }
        if(e.getSource() == multiButton) {
            Float result = a * b;
            resulJTextField.setText(result.toString());
        }
        if(e.getSource() == divButton) {
            Float result = (float)a / b;
            resulJTextField.setText(result.toString());
        }
        if(e.getSource() == resetButton) {
            number1jTextField.setText("");
            number2jTextField.setText("");
            resulJTextField.setText("");
        }




    }

    public static void main(String[] args) {

        bai2 testBai2 = new bai2(); testBai2.GUI();

    }

}
