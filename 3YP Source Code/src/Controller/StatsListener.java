package Controller;

import Model.DataHandler;
import Model.Progress;
import View.MainFrame;
import View.StatsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatsListener implements ActionListener {

    public StatsListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new StatsPage(MainFrame.WIDTH/6, 0, MainFrame.PANEL_WIDTH, MainFrame.HEIGHT, this));
    }

    public HashMap<String, String> getStatsData(String language)
    {
        return DataHandler.dataHandler.getAppData(language);
    }
}
