package View;

import Controller.ExerciseListener;
import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class TutorialEnd extends JPanel{

    private JPanel title, panel;
    private JLabel name, instruction;
    private JButton quiz, exercise;
    private GridBagConstraints gbc;

    public TutorialEnd(int x, int y, int width, int height, String language, String skill)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/6));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("End of " + language + " " + skill + " tutorial");
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
        gbc.insets = new Insets(0, 0, 50, 0);

        instruction = new JLabel("Now you've completed the tutorial, try a quiz or exercise");
        instruction.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        instruction.setForeground(new Color(0x003166));
        quiz = new JButton("Take Quiz");
        exercise = new JButton("Take Exercise");
        quiz.setFont(new Font("Balsamiq Sans", Font.PLAIN, 14));
        quiz.addActionListener(new QuizListener(language, skill));
        exercise.setFont(new Font("Balsamiq Sans", Font.PLAIN, 14));
        exercise.addActionListener(new ExerciseListener(language, skill));

        panel.add(instruction, gbc);
        gbc.gridy++;
        panel.add(quiz, gbc);
        gbc.gridy++;
        panel.add(exercise, gbc);
        this.add(panel);
    }
}
