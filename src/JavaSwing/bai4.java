package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai4 extends JFrame implements ActionListener {
    JButton jButton_ok, jButton_reset,  jButton_exit;
    JLabel jLabel_enter, jLabel_upper, jLabel_lower,jLabel_lowerUpper, jLabel_number, jLabel_zero;
    JTextField jTextField_string, jTextField_upper, jTextField_lower,jTextField_lowerUpper, jTextField_number, jTextField_zero;
    Panel pn_center, pn_page_end;


    void GUI(){

        jButton_ok = new JButton("OK");
        jButton_reset = new JButton("Reset");
        jButton_exit = new JButton("Exit");

        jLabel_enter = new JLabel("     Enter a String");
        jLabel_upper = new JLabel("     To UpperCase");
        jLabel_lower = new JLabel("     To LowerCase");
        jLabel_lowerUpper = new JLabel("     To LowerUpper");
        jLabel_number = new JLabel("     Number of word");
        jLabel_zero = new JLabel("");

        jTextField_lower = new JTextField();
        jTextField_number = new JTextField();
        jTextField_lowerUpper = new JTextField();
        jTextField_upper = new JTextField();
        jTextField_string = new JTextField();
        jTextField_zero = new JTextField("");

        jLabel_zero.setVisible(false);
        jTextField_zero.setVisible(false);

        //jTextField_number.setEnabled(false);
        jTextField_lower.setEnabled(false);
        jTextField_lowerUpper.setEnabled(false);
        jTextField_upper.setEnabled(false);
        pn_center = new Panel(new GridLayout(6,2,10,20));

        pn_center.add(jLabel_zero);
        pn_center.add(jTextField_zero);
        pn_center.add(jLabel_enter);
        pn_center.add(jTextField_string);
        pn_center.add(jLabel_upper);
        pn_center.add(jTextField_upper);
        pn_center.add(jLabel_lower);
        pn_center.add(jTextField_lower);
        pn_center.add(jLabel_lowerUpper);
        pn_center.add(jTextField_lowerUpper);
        pn_center.add(jLabel_number);
        pn_center.add(jTextField_number);

        pn_page_end = new Panel(new FlowLayout(FlowLayout.CENTER,100,0));
        pn_page_end.add(jButton_ok);
        pn_page_end.add(jButton_reset);
        pn_page_end.add(jButton_exit);

        jButton_exit.addActionListener(this);
        jButton_reset.addActionListener(this);
        jButton_ok.addActionListener(this);

        this.setLayout(new BorderLayout(10,20));

        this.add(pn_center, BorderLayout.CENTER);
        this.add(pn_page_end , BorderLayout.PAGE_END);
        this.setSize(550,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton_exit){
            System.exit(0);
        }
        if(e.getSource() == jButton_reset){
            jTextField_upper.setText("");
            jTextField_lower.setText("");
            jTextField_lowerUpper.setText("");
            jTextField_number.setText("");
            jTextField_string.setText("");
        }
        if(e.getSource() == jButton_ok){
            String text = jTextField_string.getText();
            jTextField_upper.setText(getUpperCase(text));
            jTextField_lower.setText(getLowerCase(text));
            jTextField_lowerUpper.setText(getLowerUpper(text));
            jTextField_number.setText(Integer.toString(count_text(text)));
        }



    }

    public String getUpperCase(String text){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            if(temp >= 'a' && temp <= 'z'){
                temp -= 32;
            }
            result += temp;
        }
        return  result;
    }
    public String getLowerCase(String text){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            if(temp >= 'A' && temp <= 'Z'){
                temp += 32;
            }
            result += temp;
        }
        return  result;
    }
    public String getLowerUpper(String text){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            if(temp >= 'a' && temp <= 'z'){
                temp -= 32;
            }
            else if(temp >= 'A' && temp <= 'Z'){
                temp += 32;
            }
            result += temp;
        }
        return  result;
    }

    public int count_text(String text){
        int count = 0;
        if(text == null){
            return  count;
        }
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);

            if(temp != ' '){
                if(i == text.length() -1){
                    count++;
                }

                else if( i < text.length() - 1 && text.charAt(i + 1) == ' '){
                    count++;
                }
            }
        }

        return  count;
    }




    public static void main(String[] args) {
         bai4 test = new bai4();
         test.GUI();
    }
}
