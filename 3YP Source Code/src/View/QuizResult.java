package View;

import Controller.ExerciseListener;

import javax.swing.*;

public class QuizResult extends JPanel {

    private JButton exercise;

    public QuizResult(int score)
    {
        exercise = new JButton("Complete Exercise");
        exercise.addActionListener(new ExerciseListener());
        this.add(exercise);
    }
}
