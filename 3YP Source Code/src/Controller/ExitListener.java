package Controller;

import Model.DataHandler;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    public ExitListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.dispose();
        DataHandler.dataHandler.finish();
    }
}
