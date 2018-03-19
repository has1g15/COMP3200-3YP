package Controller;

import Model.Quiz;
import View.MainFrame;
import View.QuizScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizListener implements ActionListener {

    private String language, skill;
    private Quiz quiz;
    private List<String> questions;
    private List<String[]> answers;

    public QuizListener(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        quiz = new Quiz(language, skill);
        MainFrame.mainFrame.updatePanel(new QuizScreen(900, 600, this));
    }

    public String getLanguage()
    {
        return language;
    }

    public String getSkill()
    {
        return skill;
    }

    public List<String> getQuestions()
    {
        return quiz.getQuestions();
    }

    public List<String[]> getAnswers()
    {
        return quiz.getAnswers();
    }
}
