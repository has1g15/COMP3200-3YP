package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    Menu menu;
    private JPanel panel;

    public static MainFrame mainFrame = new MainFrame();

    public void start()
    {
        this.setName("Graphical Programming E-Learning Platform");
        //this.setLayout(new FlowLayout());
        System.out.println((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        System.out.println((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        panel = new MainPanel((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        //this.setSize(1200,600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu = new Menu((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6,
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.add(menu);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updatePanel(JPanel newPanel)
    {
        mainFrame.remove(panel);
        mainFrame.add(newPanel);
        this.setVisible(true);
        panel = newPanel;
    }
}
