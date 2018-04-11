package Controller;

import Model.Tutorial;
import View.MainFrame;
import View.TutorialScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoListener implements ActionListener {

    private String language, skill;
    private Tutorial tutorial;
    private TutorialScreen tutorialScreen;

    public GoListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        tutorial = new Tutorial(language, skill);
        tutorialScreen = new TutorialScreen(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, language, skill, tutorial);
        tutorialScreen.changeCode(tutorial.getCurrentCode());
        tutorialScreen.changeConsoleText(tutorial.getCurrentOutput());
        tutorialScreen.changeGuideText(tutorial.getCurrentGuide());
        MainFrame.mainFrame.updatePanel(tutorialScreen);
    }

    public String getSkillGuide()
    {
        String skill = "";
        //TODO: extract info from table using DataHandler() - .get() from hashmap
        return skill;
    }
}
