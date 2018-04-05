package Controller;

import Model.PracticalExercise;
import View.MainFrame;
import View.PracticalExercisePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseListener implements ActionListener{

    private String language, skill;
    private PracticalExercise exercise;

    public ExerciseListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        exercise = new PracticalExercise(language, skill);
        MainFrame.mainFrame.updatePanel(new PracticalExercisePage(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, this));
    }

    public String getLanguage()
    {
        return language;
    }

    public String getSkill()
    {
        return skill;
    }

    public PracticalExercise getExercise()
    {
        return exercise;
    }
}
