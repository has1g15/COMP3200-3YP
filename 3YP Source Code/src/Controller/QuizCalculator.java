package Controller;

import Model.Quiz;
import View.QuizResult;
import View.QuizScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class QuizCalculator implements ActionListener {

    private int score;
    private QuizScreen quizScreen;
    private Quiz quiz;
    private List<String> selectedAnswers, correctAnswers;

    public QuizCalculator(Quiz quiz, QuizScreen quizScreen)
    {
        this.quizScreen = quizScreen;

    }

    public int calcScore()
    {
        int index = 0;
        score = 0;
        for (String chosenAnswer: selectedAnswers)
        {
            if (chosenAnswer == correctAnswers.get(index))
            {
                score++;
            }
            index++;
        }
        //return score;
        return 5;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        selectedAnswers = quizScreen.getSelectedAnswers();
        correctAnswers = quizScreen.getCorrectAnswers();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate date = LocalDate.now();
        quiz.setDateCompleted(formatter.format(date));
        calcScore();
        new QuizResult(score);
    }

    public void updateAppData()
    {
        //TODO: update app data using method in DataHandler
        //only update if quiz has scored higher
    }
}
