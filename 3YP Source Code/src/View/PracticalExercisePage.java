package View;

import Controller.ExerciseListener;
import Controller.ExerciseParser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class PracticalExercisePage extends JPanel{

    private JPanel title, panel;
    private JLabel name;
    private JTextArea problem, answer;
    private JButton submit;
    private GridBagConstraints gbc;
    private Border border, raised, lowered;
    private MatteBorder titlePanelBorder;

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
        titlePanelBorder = new MatteBorder(10, 0, 10, 0, new Color(0x003166));
        title.setBorder(titlePanelBorder);
        title.add(name);
        this.add(title);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(0xebebe0));
        panel.setPreferredSize(new Dimension(width, height*4/5));

        problem = new JTextArea("Problem: " + exerciseListener.getExercise().getProblem());

        problem.setColumns(50);
        problem.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        problem.setBackground(new Color(0xebebe0));
        //problem.setLineWrap(true);
        //problem.setWrapStyleWord(true);
        problem.setForeground(new Color(0x003166));
        problem.setEditable(false);

        raised = BorderFactory.createRaisedBevelBorder();
        lowered = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createCompoundBorder(raised, lowered);
        answer = new JTextArea();
        answer.setFont(new Font("Courier New", Font.PLAIN, 18));
        answer.setEditable(true);
        answer.setRows(15);
        answer.getCaret().setVisible(true);
        answer.getCaret().setBlinkRate(500);
        answer.setBorder(border);

        submit = new JButton("Submit");
        submit.setPreferredSize(new Dimension(80,30));

        panel.add(problem, gbc);
        gbc.gridy++;
        panel.add(answer, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(submit, gbc);

        submit.addActionListener(new ExerciseParser(exerciseListener, this, exerciseListener.getExercise()));
        this.add(panel);
    }

    public String getUserAnswer()
    {
        return answer.getText();
    }
}
