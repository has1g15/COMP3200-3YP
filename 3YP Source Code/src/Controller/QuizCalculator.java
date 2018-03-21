package Controller;

import Model.Quiz;
import View.QuizResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuizCalculator implements ActionListener {

    private int score;

    public QuizCalculator(Quiz quiz)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate date = LocalDate.now();
        System.out.println(formatter.format(date));
        quiz.setScore(calcScore());
        quiz.setDateCompleted(formatter.format(date));
    }

    public int calcScore()
    {
        //temp
        return 5;
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
