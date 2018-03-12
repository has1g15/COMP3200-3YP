package Controller;

import Model.Progress;
import View.MainFrame;
import View.StatsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsListener implements ActionListener {

    private Progress progress;

    public StatsListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new StatsPage(900, 600));
    }
}
