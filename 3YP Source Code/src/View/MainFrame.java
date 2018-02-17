package View;

import javax.swing.*;

public class MainFrame extends JFrame {

    Menu menu;
    MainPanel mainPanel;

    public MainFrame(int width, int height)
    {
        this.setSize(width,height);
        menu = new Menu(200, 600);
        mainPanel = new MainPanel(900,600);

        this.add(menu);
        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
