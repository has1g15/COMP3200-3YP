package Controller;

import View.MainFrame;
import View.TutorialScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoListener implements ActionListener {

    private String language, skill;

    public GoListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

         MainFrame.mainFrame.updatePanel(new TutorialScreen(900, 600));

    }
}
