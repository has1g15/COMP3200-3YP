package View;

import Controller.ExerciseListener;
import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class QuizResult extends JPanel {

    private JPanel title, panel;
    private JLabel name, announce, scoreDisplay, exercisePrompt;
    private JButton exercise;

    public QuizResult(int x, int y, int width, int height, int score, QuizListener quizListener)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/6));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel(quizListener.getLanguage() + ": " + quizListener.getSkill() + " Quiz");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height*5/6));
        panel.setBackground(new Color(0x3396ff));
        announce = new JLabel("You Scored:");
        announce.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        announce.setForeground(new Color(0x003166));
        panel.add(announce);
        scoreDisplay = new JLabel(Integer.toString(score));
        scoreDisplay.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
        scoreDisplay.setForeground(new Color(0x003166));
        panel.add(scoreDisplay);
        exercisePrompt = new JLabel(Integer.toString(score));
        exercisePrompt.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        exercisePrompt.setForeground(new Color(0x003166));
        panel.add(exercisePrompt);
        exercise = new JButton("Complete Exercise");
        exercise.addActionListener(new ExerciseListener(quizListener.getLanguage(), quizListener.getSkill()));
        panel.add(exercise);
        this.add(panel);
    }
}
