package View;

import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class QuizScreen extends JPanel {

    private JPanel title, quizPanel;
    private JLabel name;
    private GridBagConstraints gbc;
    private JScrollPane scrollPanel;
    private JLabel[] questionLabels;
    private CheckboxGroup[] checkBoxGroup;

    public QuizScreen(int width, int height, QuizListener quizListener)
    {
        this.setSize(width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/6));
        title.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 0));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel(quizListener.getLanguage() + ": " + quizListener.getSkill() + " Quiz");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        quizPanel = new JPanel();
        quizPanel.setPreferredSize(new Dimension(width, height*5/6));

        questionLabels = new JLabel[9];
        checkBoxGroup = new CheckboxGroup[9];

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        quizPanel.setBorder(BorderFactory.createEmptyBorder(0, 300, 0, 0));
        quizPanel.setLayout(new GridBagLayout());
        quizPanel.setBackground(new Color(0x3396ff));

        for (int i = 0; i < 9; i++)
        {
            questionLabels[i] = new JLabel(quizListener.getQuestions().get(i));
            questionLabels[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            questionLabels[i].setForeground(Color.WHITE);
            quizPanel.add(questionLabels[i], gbc);
            gbc.gridy++;
            checkBoxGroup[i] = new CheckboxGroup();
            Checkbox cb1 = new Checkbox(quizListener.getAnswers().get(i)[0], checkBoxGroup[i],false);
            Checkbox cb2 = new Checkbox(quizListener.getAnswers().get(i)[1], checkBoxGroup[i],false);
            Checkbox cb3 = new Checkbox(quizListener.getAnswers().get(i)[2], checkBoxGroup[i],false);
            Checkbox cb4 = new Checkbox(quizListener.getAnswers().get(i)[3], checkBoxGroup[i],false);
            quizPanel.add(cb1, gbc);
            gbc.gridx++;
            quizPanel.add(cb2, gbc);
            gbc.gridx++;
            quizPanel.add(cb3, gbc);
            gbc.gridx++;
            quizPanel.add(cb4, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        scrollPanel = new JScrollPane(quizPanel);
        //quizPanel.setAutoscrolls(true);
        this.add(scrollPanel);
    }
}
