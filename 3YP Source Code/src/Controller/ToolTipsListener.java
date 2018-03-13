package Controller;

import View.MainFrame;
import View.ToolTipsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolTipsListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new ToolTipsPage(900, 600));
    }
}
