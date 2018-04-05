package View;

import Controller.ExerciseListener;
import Controller.QuizListener;

import javax.swing.*;

public class QuizResult extends JPanel {

    private JButton exercise;

    public QuizResult(int score, QuizListener quizListener)
    {
        exercise = new JButton("Complete Exercise");
        exercise.addActionListener(new ExerciseListener(quizListener.getLanguage(), quizListener.getSkill()));
        this.add(exercise);
    }
}
