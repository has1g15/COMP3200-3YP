package Controller;

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
        //TODO: save progress when exiting
        MainFrame.mainFrame.dispose();
    }
}
