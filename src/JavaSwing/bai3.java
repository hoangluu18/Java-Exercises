package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai3 extends JFrame implements ActionListener {
    JButton jButton_red, jButton_green, jButton_blue, jButton_exit;
    Panel pn;

    void GUI(){
        jButton_blue = new JButton("BLUE");
        jButton_red = new JButton("RED");
        jButton_green = new JButton("GREEN");
        jButton_exit = new JButton("EXIT");

        pn = new Panel(new FlowLayout());

        pn.add(jButton_red);
        pn.add(jButton_green);
        pn.add(jButton_blue);
        pn.add(jButton_exit);

        jButton_red.addActionListener(this);
        jButton_green.addActionListener(this);
        jButton_blue.addActionListener(this);
        jButton_exit.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(pn,BorderLayout.PAGE_END );
        this.setSize(600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton_exit){
            System.exit(0);
        }

        if(e.getSource() == jButton_red){
            this.getContentPane().setBackground(Color.RED);
            pn.setBackground(Color.RED);
        }
        if(e.getSource() == jButton_blue){
            this.getContentPane().setBackground(Color.BLUE);
            pn.setBackground(Color.BLUE);
        }
        if(e.getSource() == jButton_green){
            this.getContentPane().setBackground(Color.green);
            pn.setBackground(Color.GREEN);
        }

    }

    public static void main(String[] args) {
        bai3 test_bai3 = new bai3();
        test_bai3.GUI();
    }
}
