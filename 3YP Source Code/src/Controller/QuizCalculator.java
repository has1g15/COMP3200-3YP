package Controller;

import Model.DataHandler;
import Model.Progress;
import Model.Quiz;
import View.MainFrame;
import View.QuizResult;
import View.QuizScreen;
import View.TutorialScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class QuizCalculator implements ActionListener {

    private int score;
    private QuizListener quizListener;
    private QuizScreen quizScreen;
    private Quiz quiz;
    private List<String> correctAnswers;
    private String[] selectedAnswers;

    public QuizCalculator(QuizListener quizListener, QuizScreen quizScreen, Quiz quiz)
    {
        this.quizListener = quizListener;
        this.quizScreen = quizScreen;
        this.quiz = quiz;
    }

    public void calcScore()
    {
        int index = 0;
        score = 0;
        for (String chosenAnswer: selectedAnswers)
        {
            if (chosenAnswer.equals(correctAnswers.get(index)))
            {
                score++;
            }
            index++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        List<String> chosenAnswers = new ArrayList<>();
        selectedAnswers = quizScreen.getSelectedAnswers();
        for (int i = 0; i < 10; i++)
        {
            if (selectedAnswers[i] != null)
            {
                chosenAnswers.add(selectedAnswers[i]);
            }
        }
        correctAnswers = quizScreen.getCorrectAnswers();
        if (chosenAnswers.size() != 10)
        {
            JOptionPane.showMessageDialog(null, "Please select an answer for every question");
        }
        else {
        calcScore();
        updateProgress(score);
        MainFrame.mainFrame.updatePanel(new QuizResult(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, score, quizListener));
        }
    }

    public void updateProgress(int score)
    {
        new Progress(quizListener.getLanguage(), "Quiz" + DataHandler.dataHandler.skillMap.get(quizListener.getSkill()), Integer.toString(score));
    }
}
