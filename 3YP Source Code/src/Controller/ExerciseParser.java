package Controller;

import View.ExerciseResult;
import View.MainFrame;
import View.QuizResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseParser implements ActionListener{

    private int score;
    private ExerciseListener exerciseListener;

    public ExerciseParser()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.updatePanel(new ExerciseResult(MainFrame.PANEL_X_POS, 0, MainFrame.PANEL_WIDTH,
                MainFrame.HEIGHT, score, exerciseListener));
    }
}
