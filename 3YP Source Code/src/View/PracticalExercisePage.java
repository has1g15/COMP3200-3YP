package View;

import Controller.ExerciseListener;
import Controller.ExerciseParser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PracticalExercisePage extends JPanel{

    private JPanel title, panel;
    private JLabel name;
    private JTextArea problem, answer;
    private JButton submit;
    private GridBagConstraints gbc;
    private Border border, raised, lowered;

    public PracticalExercisePage(int x, int y, int width, int height, ExerciseListener exerciseListener)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/6));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel(exerciseListener.getLanguage() + ": " + exerciseListener.getSkill() + " Exercise");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(0x3396ff));
        panel.setPreferredSize(new Dimension(width, height*4/5));

        problem = new JTextArea("Problem: This is a problem");
        problem.setColumns(50);
        problem.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        problem.setBackground(new Color(0x3396ff));
        problem.setLineWrap(true);
        problem.setWrapStyleWord(true);
        problem.setForeground(Color.WHITE);
        problem.setEditable(false);
        panel.add(problem, gbc);
        gbc.gridy++;

        raised = BorderFactory.createRaisedBevelBorder();
        lowered = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createCompoundBorder(raised, lowered);
        answer = new JTextArea();
        answer.setRows(20);
        answer.setColumns(50);
        answer.setEditable(true);
        answer.getCaret().setVisible(true);
        answer.getCaret().setBlinkRate(500);
        answer.setBorder(border);
        panel.add(answer, gbc);
        gbc.gridy++;

        submit = new JButton("Submit");
        submit.setSize(30, 10);
        panel.add(submit, gbc);

        submit.addActionListener(new ExerciseParser(exerciseListener, this, exerciseListener.getExercise()));
        this.add(panel);
    }

    public String getUserAnswer()
    {
        return answer.getText();
    }
}
