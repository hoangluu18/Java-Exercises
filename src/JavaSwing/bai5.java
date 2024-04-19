package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class bai5 extends JFrame implements ActionListener{
    JTextField jTextField_display;
    JButton jButton_1, jButton_2, jButton_3, jButton_4, jButton_5, jButton_6,
            jButton_7, jButton_8, jButton_9, jButton_0, jButton_dot,
            jButton_sum, jButton_minus, jButton_mult, jButton_div,
            jButton_equal, jButton_clear;
    JPanel pn_button, pn_main;

    public void GUI(){
        jTextField_display = new JTextField();
        jTextField_display.setHorizontalAlignment(JTextField.RIGHT);
        jTextField_display.setEditable(false);
        jTextField_display.setPreferredSize(new Dimension(200,40));
        jTextField_display.setFont(new Font("Arial",Font.PLAIN,20));

        jButton_0 = new JButton("0");
        jButton_1 = new JButton("1");
        jButton_2 = new JButton("2");
        jButton_3 = new JButton("3");
        jButton_4 = new JButton("4");
        jButton_5 = new JButton("5");
        jButton_6 = new JButton("6");
        jButton_7 = new JButton("7");
        jButton_8 = new JButton("8");
        jButton_9 = new JButton("9");
        jButton_dot = new JButton(".");
        jButton_sum = new JButton("+");
        jButton_minus = new JButton("-");
        jButton_mult = new JButton("*");
        jButton_div = new JButton("/");
        jButton_equal = new JButton("=");
        jButton_clear = new JButton("C");

        jButton_0.addActionListener(this);
        jButton_1.addActionListener(this);
        jButton_2.addActionListener(this);
        jButton_3.addActionListener(this);
        jButton_4.addActionListener(this);
        jButton_5.addActionListener(this);
        jButton_6.addActionListener(this);
        jButton_7.addActionListener(this);
        jButton_8.addActionListener(this);
        jButton_9.addActionListener(this);
        jButton_dot.addActionListener(this);
        jButton_sum.addActionListener(this);
        jButton_minus.addActionListener(this);
        jButton_mult.addActionListener(this);
        jButton_div.addActionListener(this);
        jButton_equal.addActionListener(this);
        jButton_clear.addActionListener(this);

        pn_button = new JPanel(new GridLayout(4,4));
        pn_button.add(jButton_7);
        pn_button.add(jButton_8);
        pn_button.add(jButton_9);
        pn_button.add(jButton_div);
        pn_button.add(jButton_4);
        pn_button.add(jButton_5);
        pn_button.add(jButton_6);
        pn_button.add(jButton_mult);
        pn_button.add(jButton_1);
        pn_button.add(jButton_2);
        pn_button.add(jButton_3);
        pn_button.add(jButton_minus);
        pn_button.add(jButton_0);
        pn_button.add(jButton_dot);
        pn_button.add(jButton_clear);
        pn_button.add(jButton_sum);


        pn_main = new JPanel(new BorderLayout());
        pn_main.add(jTextField_display, BorderLayout.NORTH);
        pn_main.add(pn_button, BorderLayout.CENTER);
        pn_main.add(jButton_equal, BorderLayout.EAST);

        this.add(pn_main);
        this.setSize(400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        System.out.println(this.getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton_0){
            jTextField_display.setText(jTextField_display.getText() + "0");
        }
        if(e.getSource() == jButton_1){
            jTextField_display.setText(jTextField_display.getText() + "1");
        }
        if(e.getSource() == jButton_2){
            jTextField_display.setText(jTextField_display.getText() + "2");
        }
        if(e.getSource() == jButton_3){
            jTextField_display.setText(jTextField_display.getText() + "3");
        }
        if(e.getSource() == jButton_4){
            jTextField_display.setText(jTextField_display.getText() + "4");
        }
        if(e.getSource() == jButton_5){
            jTextField_display.setText(jTextField_display.getText() + "5");
        }
        if(e.getSource() == jButton_6){
            jTextField_display.setText(jTextField_display.getText() + "6");
        }
        if(e.getSource() == jButton_7){
            jTextField_display.setText(jTextField_display.getText() + "7");
        }
        if(e.getSource() == jButton_8){
            jTextField_display.setText(jTextField_display.getText() + "8");
        }
        if(e.getSource() == jButton_9){
            jTextField_display.setText(jTextField_display.getText() + "9");
        }
        if(e.getSource() == jButton_dot){
            jTextField_display.setText(jTextField_display.getText() + ".");
        }
        if(e.getSource() == jButton_sum){
            jTextField_display.setText(jTextField_display.getText() + "+");
        }
        if(e.getSource() == jButton_minus){
            jTextField_display.setText(jTextField_display.getText() + "-");
        }
        if(e.getSource() == jButton_mult){
            jTextField_display.setText(jTextField_display.getText() + "*");
        }
        if(e.getSource() == jButton_div){
            jTextField_display.setText(jTextField_display.getText() + "/");
        }
        if(e.getSource() == jButton_clear){
            jTextField_display.setText("");
        }
        if(e.getSource() == jButton_equal) {
            String expression = jTextField_display.getText();
            jTextField_display.setText(calculate(expression));
        }



    }

    public String calculate(String expression) {
        String postfix = infixToPostfix(expression);
        double result = evaluatePostfix(postfix);

        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String number = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                number += c;
            } else {
                if (!number.isEmpty()) {
                    result.append(number).append(" ");
                    number = "";
                }

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop()).append(" ");
                    }
                    if (!stack.isEmpty() && stack.peek() != '(') {
                        return "Invalid Expression";
                    } else {
                        stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }
        }

        if (!number.isEmpty()) {
            result.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString();
    }


    public  int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }


    public  double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            char c = token.charAt(0);

            if (Character.isDigit(c) || token.length() > 1) {
                stack.push(Double.parseDouble(token));
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        bai5 test_bai5 = new bai5();
        test_bai5.GUI();
    }

}

