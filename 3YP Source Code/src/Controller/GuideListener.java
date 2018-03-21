package Controller;

import View.MainFrame;
import View.PlatformGuidePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuideListener implements ActionListener{

    public GuideListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new PlatformGuidePage(MainFrame.WIDTH/6, 0, MainFrame.PANEL_WIDTH, MainFrame.HEIGHT));
    }
}
