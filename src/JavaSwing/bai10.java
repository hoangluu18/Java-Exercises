package JavaSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai10 extends JFrame implements ActionListener {
    JMenuItem fexit;
    JMenuBar menubar;
    JMenu file;
    JMenu edit;
    JMenuItem eCopy;
    JMenuItem eCut;
    JMenuItem ePaste;
    JMenuItem eProtected;
    JMenu option;
    JMenuItem optFirst;
    JMenuItem optSecond;
    JMenuItem optThird;

    public void GUI() {
        menubar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        eCopy = new JMenuItem("Copy");
        eCut = new JMenuItem("Cut");
        ePaste = new JMenuItem("Paste");
        eProtected = new JMenuItem("Protected");
        option = new JMenu("Option");
        optFirst = new JMenuItem("First");
        optSecond = new JMenuItem("Second");
        optThird = new JMenuItem("Third");
        fexit = new JMenuItem("Exit");
        fexit.addActionListener(this);
        file.add(fexit);
        option.add(optFirst);
        option.add(optSecond);
        option.add(optThird);

        edit.add(eCopy);
        edit.add(eCut);
        edit.add(ePaste);

        edit.add(option);

        edit.add(eProtected);

        menubar.add(file);
        menubar.add(edit);
        this.setJMenuBar(menubar);

        this.setTitle("Menu Demo");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fexit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        bai10 test = new bai10();
        test.GUI();
    }
}
