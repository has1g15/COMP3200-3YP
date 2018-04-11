package View;

import Controller.ExerciseListener;
import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class QuizResult extends JPanel {

    private JPanel title, panel;
    private JLabel name, announce, scoreDisplay, exercisePrompt;
    private JButton exercise;
    private GridBagConstraints gbc;

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
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);

        announce = new JLabel("You Scored:");
        announce.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        announce.setForeground(new Color(0x003166));
        panel.add(announce, gbc);
        gbc.gridy++;

        scoreDisplay = new JLabel(Integer.toString(score));
        scoreDisplay.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
        scoreDisplay.setForeground(new Color(0x003166));
        panel.add(scoreDisplay, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);

        exercisePrompt = new JLabel("Complete Exercise in this Skill:");
        exercisePrompt.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        exercisePrompt.setForeground(new Color(0x003166));
        panel.add(exercisePrompt,gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 20, 0);

        exercise = new JButton("Complete Exercise");
        exercise.addActionListener(new ExerciseListener(quizListener.getLanguage(), quizListener.getSkill()));
        panel.add(exercise, gbc);
        this.add(panel);
    }
}
