package View;

import Controller.QuizCalculator;
import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class QuizScreen extends JPanel {

    private JPanel title, quizPanel;
    private JLabel name, instruction;
    private GridBagConstraints gbc;
    private JScrollPane scrollPanel;
    private JLabel[] questionLabels;
    private CheckboxGroup[] checkBoxGroup;
    private JButton submit;

    public QuizScreen(int x, int y, int width, int height, QuizListener quizListener)
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

        quizPanel = new JPanel();
        //quizPanel.setPreferredSize(new Dimension(width, height*5/6));

        questionLabels = new JLabel[10];
        checkBoxGroup = new CheckboxGroup[10];

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth=4;
        //quizPanel.setBorder(BorderFactory.createEmptyBorder(0, this.getWidth()/9, 0, 0));
        quizPanel.setLayout(new GridBagLayout());
        quizPanel.setBackground(new Color(0x3396ff));
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        instruction = new JLabel("Please answer\n the following ten questions, selecting one of the 4 answers for each");
        quizPanel.add(instruction, gbc);
        gbc.gridy++;

        for (int i = 0; i < 10; i++)
        {
            questionLabels[i] = new JLabel(i+1 + ") " + quizListener.getQuestions().get(i));
            questionLabels[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            questionLabels[i].setForeground(Color.WHITE);
            gbc.gridwidth=4;
            quizPanel.add(questionLabels[i], gbc);
            gbc.gridy++;
            checkBoxGroup[i] = new CheckboxGroup();
            Checkbox cb1 = new Checkbox(quizListener.getAnswers().get(i)[0], checkBoxGroup[i],false);
            System.out.println(quizListener.getAnswers().get(i)[0]);
            cb1.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb1.setForeground(new Color(0x003166));
            Checkbox cb2 = new Checkbox(quizListener.getAnswers().get(i)[1], checkBoxGroup[i],false);
            System.out.println(quizListener.getAnswers().get(i)[1]);
            cb2.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb2.setForeground(new Color(0x003166));
            Checkbox cb3 = new Checkbox(quizListener.getAnswers().get(i)[2], checkBoxGroup[i],false);
            System.out.println(quizListener.getAnswers().get(i)[2]);
            cb3.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb3.setForeground(new Color(0x003166));
            Checkbox cb4 = new Checkbox(quizListener.getAnswers().get(i)[3], checkBoxGroup[i],false);
            System.out.println(quizListener.getAnswers().get(i)[3]);
            cb4.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb4.setForeground(new Color(0x003166));
            gbc.gridwidth=1;
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

        submit = new JButton("Submit");
        quizPanel.add(submit, gbc);
        submit.addActionListener(new QuizCalculator());
        scrollPanel = new JScrollPane(quizPanel);
        scrollPanel.setLayout(new ScrollPaneLayout());
        scrollPanel.setPreferredSize(new Dimension(width, height*4/5));
        //quizPanel.setAutoscrolls(true);
        this.add(scrollPanel);
    }
}
