package Controller;

import View.ExerciseResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseParser implements ActionListener{

    public ExerciseParser()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new ExerciseResult();
    }
}
