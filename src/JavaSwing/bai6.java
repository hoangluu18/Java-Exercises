package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai6 extends JFrame implements ActionListener  {

    JButton jButton_ok ;
    JTextField jTextField_input;
    List animalList;

    JLabel jLabel_display;
    JPanel panel_main;
    JPanel panel_header;
    JScrollPane sb;

    public  void GUI(){
        jButton_ok = new JButton("OK");
        jTextField_input = new JTextField("");
        animalList = new List();
        jLabel_display = new JLabel("The event is displayed here");
        panel_header = new JPanel(new FlowLayout());
        panel_main = new JPanel(new FlowLayout());

        jLabel_display.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_display.setVerticalAlignment(SwingConstants.CENTER);
        jTextField_input.setColumns(15);
        animalList.add("Tiger");
        animalList.add("Lion");
        animalList.add("Elephant");
        animalList.add("Horse");
        animalList.add("Cat");



        sb = new JScrollPane(animalList);
        panel_header.add(jButton_ok);
        panel_header.add(jTextField_input);
        panel_header.add(sb);
        panel_main.add(panel_header);
        panel_main.add(jLabel_display);

        jButton_ok.addActionListener(this);
        jTextField_input.addActionListener(this);
        animalList.addActionListener(this);


        this.add(panel_main);
        this.setTitle("ActionEventTest");
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton_ok){
            jLabel_display.setText("Button is clicked");
        }
        if(e.getSource() == jTextField_input){
            String text = jTextField_input.getText();
            jLabel_display.setText("TextField is written: " + text);
        }
        if(e.getSource() == animalList){
            String text = animalList.getSelectedItem();
            jLabel_display.setText("You double click on the " + text);
        }
    }

    public static void main(String[] args) {
        bai6 test = new bai6();
        test.GUI();
    }


}
