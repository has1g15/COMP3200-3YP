package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    Menu menu;
    private JPanel panel;

    public static MainFrame mainFrame = new MainFrame();

    public void start()
    {
        panel = new MainPanel(900,600);
        this.setSize(900,600);
        menu = new Menu(200, 600);
        this.add(menu);
        this.add(panel);
       // this.pack();
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
