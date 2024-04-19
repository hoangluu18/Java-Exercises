package JavaSwing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class bai9 extends JFrame implements MouseListener {
    public void GUI(){
        this.addMouseListener(this);
        this.setTitle("MouseTest");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) { //left
            System.out.println("You left click the mouse at: " + e.getX() + " " + e.getY());
        }

        if(e.getButton() == MouseEvent.BUTTON3) { //right
            System.out.println("You right click the mouse at: " + e.getX() + " " + e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You press the mouse at: " + e.getX() + " " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("You release the mouse at: " + e.getX() + " " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("You enter the window at: " + e.getX() + " " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("You exit the window at: " + e.getX() + " " + e.getY());
    }

    public static void main(String[] args) {
        bai9 test = new bai9();
        test.GUI();
    }
}
