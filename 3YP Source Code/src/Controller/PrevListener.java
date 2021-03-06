package Controller;

import Model.Tutorial;
import View.TutorialScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrevListener implements ActionListener {

    private Tutorial tutorial;
    private TutorialScreen tutorialScreen;

    public PrevListener(Tutorial tutorial, TutorialScreen tutorialScreen)
    {
        this.tutorial = tutorial;
        this.tutorialScreen = tutorialScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (tutorial.getCurrentIndex() == 0)
        {
            tutorialScreen.graphicsPanel.remove(tutorialScreen.layeredPane);
            tutorialScreen.graphicsPanel.revalidate();
            tutorialScreen.graphicsPanel.repaint();
        }
        else
        {
            tutorial.decrementIndex();
            tutorialScreen.changeCode(tutorial.getCurrentCode());
            tutorialScreen.changeConsoleText(tutorial.getCurrentOutput());
            tutorialScreen.changeGuideText(tutorial.getCurrentGuide());
        }
    }
}
