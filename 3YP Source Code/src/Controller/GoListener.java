package Controller;

import Model.Tutorial;
import View.MainFrame;
import View.TutorialScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoListener implements ActionListener {

    private String language, skill;
    private Tutorial tutorial;

    public GoListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        tutorial = new Tutorial(language, skill);
        MainFrame.mainFrame.updatePanel(new TutorialScreen(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, language, skill, tutorial));
    }

    public String getSkillGuide()
    {
        String skill = "";
        //TODO: extract info from table using DataHandler() - .get() from hashmap
        return skill;
    }
}
