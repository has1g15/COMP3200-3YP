package Controller;

import Model.DataHandler;
import Model.PracticalExercise;
import Model.Progress;
import Model.Quiz;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseParser implements ActionListener{

    private int score;
    private ExerciseListener exerciseListener;
    private PracticalExercisePage practicalExercisePage;
    private PracticalExercise practicalExercise;
    private String userAnswer;

    public ExerciseParser(ExerciseListener exerciseListener, PracticalExercisePage practicalExercisePage,
                          PracticalExercise practicalExercise)
    {
        this.exerciseListener = exerciseListener;
        this.practicalExercisePage = practicalExercisePage;
        this.practicalExercise = practicalExercise;
    }

    public void parseSolution()
    {
        score = 0;
        String[] modelAnswerSplit = practicalExercise.getAnswer().split("\\r?\\n");
        String[] userAnswerSplit = userAnswer.split("\\r?\\n");
        for (int i = 0; i < userAnswerSplit.length; i++)
        {
            if (userAnswerSplit[i].equals(modelAnswerSplit[i]))
            {
                score +=2;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        userAnswer = practicalExercisePage.getUserAnswer();
        parseSolution();
        updateProgress(score);
        MainFrame.mainFrame.updatePanel(new ExerciseResult(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, score, exerciseListener, userAnswer));
    }

    public void updateProgress(int score)
    {
        new Progress(exerciseListener.getLanguage(), "Exercise" +
                DataHandler.dataHandler.skillMap.get(exerciseListener.getSkill()), Integer.toString(score));
    }
}
