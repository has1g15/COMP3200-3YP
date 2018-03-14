package Controller;

import Model.Quiz;
import View.MainFrame;
import View.QuizScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizListener implements ActionListener {

    private String language, skill;

    public QuizListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new QuizScreen(900, 600, language, skill));
        new Quiz(language, skill);
    }
}
