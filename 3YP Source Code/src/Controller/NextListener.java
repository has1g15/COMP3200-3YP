package Controller;

import Model.Tutorial;
import View.TutorialScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextListener implements ActionListener {

    private Tutorial tutorial;
    private TutorialScreen tutorialScreen;

    public NextListener(Tutorial tutorial, TutorialScreen tutorialScreen)
    {
        this.tutorial = tutorial;
        this.tutorialScreen = tutorialScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        tutorial.incrementIndex();
        if (!tutorial.isMaxIndex())
        {
            tutorialScreen.changeCode(tutorial.getCurrentCode());
            tutorialScreen.changeConsoleText(tutorial.getCurrentOutput());
            tutorialScreen.changeGuideText(tutorial.getCurrentGuide());
        }
        else
        {
            //End of tutorial screen?
        }
    }
}
