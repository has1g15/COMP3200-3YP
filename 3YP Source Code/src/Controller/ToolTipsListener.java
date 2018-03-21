package Controller;

import View.MainFrame;
import View.ToolTipsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolTipsListener implements ActionListener{

    public ToolTipsListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new ToolTipsPage(MainFrame.WIDTH/6, 0, MainFrame.PANEL_WIDTH, MainFrame.HEIGHT));
    }
}
