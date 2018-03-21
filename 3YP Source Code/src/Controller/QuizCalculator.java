package Controller;

import Model.Quiz;
import View.QuizResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizCalculator implements ActionListener {

    private int score;

    public QuizCalculator(Quiz quiz)
    {
        //calcScore()
        //quiz.setScore()
        //quiz.setDate()
    }

    public void calcScore()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        calcScore();
        new QuizResult(score);
    }

    public void updateAppData()
    {
        //TODO: update app data using method in DataHandler
    }
}
