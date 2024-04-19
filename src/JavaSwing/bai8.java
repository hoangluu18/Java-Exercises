package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class bai8 extends JFrame implements KeyListener {
    JPanel panel;
    JLabel label;

    public void GUI() {
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel = new JPanel(new GridLayout());
        FlowLayout fl = new FlowLayout();

        panel.add(label, fl);

        this.add(panel, BorderLayout.CENTER);

        this.addKeyListener(this);

        this.setTitle("Key Event Test");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyPressed = e.getKeyChar();
        label.setText("You Pressed: " + keyPressed);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        bai8 test = new bai8();
        test.GUI();
    }
}
