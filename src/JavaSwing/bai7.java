package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai7 extends JFrame implements ItemListener {

    Checkbox checkbox_male;
    Checkbox checkbox_female;
    Choice choice;
    List animalList;

    JPanel panel;
    JLabel jLabel_display;
    JScrollPane sb;
    public  void GUI(){
        checkbox_male = new Checkbox("Male");
        checkbox_female = new Checkbox("Female");
        choice = new Choice();
        animalList = new List();
        panel = new JPanel(new FlowLayout());
        jLabel_display = new JLabel("The event is displayed here");

        jLabel_display.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_display.setVerticalAlignment(SwingConstants.CENTER);

        animalList.add("Tiger");
        animalList.add("Lion");
        animalList.add("Elephant");
        animalList.add("Monkey");
        animalList.add("Horse");
        animalList.add("Cat");

        choice.add("MS DOS");
        choice.add("WINDOW");
        choice.add("LINUX");
        choice.add("MAC OS");

        checkbox_male.addItemListener(this);
        checkbox_female.addItemListener(this);
        choice.addItemListener(this);
        animalList.addItemListener(this);

        sb = new JScrollPane(animalList);
        panel.add(checkbox_male);
        panel.add(checkbox_female);
        panel.add(choice);
        panel.add(animalList);
        panel.add(jLabel_display);



        this.add(panel);
        this.setTitle("ItemEventTest");
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }





    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == checkbox_male){
            jLabel_display.setText("You clicked : " + "male");
        }
        if(e.getSource() == checkbox_female){
            jLabel_display.setText("You clicked : " + "female");
        }
        if(e.getSource() == choice){
            jLabel_display.setText("You clicked : " + choice.getSelectedItem());
        }
        if(e.getSource() == animalList){
            jLabel_display.setText("You clicked : " + animalList.getSelectedItem());
        }
    }

    public static void main(String[] args) {
        bai7 test = new bai7();
        test.GUI();
    }
}
