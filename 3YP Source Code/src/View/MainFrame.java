package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //TODO: line breaks in formatting table

    Menu menu;
    private JPanel panel;
    public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final int PANEL_X_POS = WIDTH/6;
    public static final int PANEL_WIDTH = WIDTH*5/6;

    public static MainFrame mainFrame = new MainFrame();

    public void start()
    {
        this.setTitle("Graphical Programming E-Learning Platform");
        panel = new MainPanel(PANEL_X_POS, 0, PANEL_WIDTH, HEIGHT);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setLayout(null);
        menu = new Menu(0,0,PANEL_X_POS, HEIGHT);
        this.add(menu);
        this.add(panel);
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
