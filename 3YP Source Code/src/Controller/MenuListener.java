package Controller;

import View.MainFrame;
import View.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    public MenuListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //TODO: save progress
        MainFrame.mainFrame.updatePanel(new MainPanel(900, 600));
    }
}
