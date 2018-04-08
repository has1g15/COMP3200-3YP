package View;

import Controller.QuizCalculator;
import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizScreen extends JPanel {

    private JPanel title, quizPanel;
    private JLabel name, instruction;
    private GridBagConstraints gbc;
    private JScrollPane scrollPanel;
    private JLabel[] questionLabels;
    private CheckboxGroup[] checkBoxGroup;
    private Checkbox[] cb1, cb2, cb3, cb4;
    private JButton submit;
    private String[] chosenAnswers;
    private List<String> correctAnswers;
    private int i;

    public QuizScreen(int x, int y, int width, int height, QuizListener quizListener)
    {
        correctAnswers = new ArrayList<>();
        chosenAnswers = new String[10];

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

        questionLabels = new JLabel[10];
        checkBoxGroup = new CheckboxGroup[10];
        cb1 = new Checkbox[10];
        cb2 = new Checkbox[10];
        cb3 = new Checkbox[10];
        cb4 = new Checkbox[10];

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth=4;
        quizPanel.setLayout(new GridBagLayout());
        quizPanel.setBackground(new Color(0x3396ff));
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        instruction = new JLabel("Please answer the following ten questions, selecting one of the 4 answers for each");
        instruction.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        instruction.setForeground(new Color(0x003166));
        quizPanel.add(instruction, gbc);
        gbc.gridy++;

        for (i = 0; i < 10; i++)
        {
            correctAnswers.add(quizListener.getAnswers().get(i)[4]);
            questionLabels[i] = new JLabel(i+1 + ") " + quizListener.getQuestions().get(i));
            questionLabels[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            questionLabels[i].setForeground(Color.WHITE);
            gbc.gridwidth=4;
            quizPanel.add(questionLabels[i], gbc);
            gbc.gridy++;
            checkBoxGroup[i] = new CheckboxGroup();
            cb1[i] = new Checkbox(quizListener.getAnswers().get(i)[0], checkBoxGroup[i],false);
            cb1[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb1[i].setForeground(new Color(0x003166));
            cb1[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if (e.getStateChange() == ItemEvent.SELECTED)
                    {
                        chosenAnswers[Arrays.asList(cb1).indexOf(e.getSource())] = (String)e.getItem();
                    }
                }
            });
            cb2[i] = new Checkbox(quizListener.getAnswers().get(i)[1], checkBoxGroup[i],false);
            cb2[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb2[i].setForeground(new Color(0x003166));
            cb2[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if (e.getStateChange() == ItemEvent.SELECTED)
                    {
                        chosenAnswers[Arrays.asList(cb2).indexOf(e.getSource())] = (String)e.getItem();
                    }
                }
            });
            cb3[i] = new Checkbox(quizListener.getAnswers().get(i)[2], checkBoxGroup[i],false);
            cb3[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb3[i].setForeground(new Color(0x003166));
            cb3[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if (e.getStateChange() == ItemEvent.SELECTED)
                    {
                        chosenAnswers[Arrays.asList(cb3).indexOf(e.getSource())] = (String)e.getItem();
                    }
                }
            });
            cb4[i] = new Checkbox(quizListener.getAnswers().get(i)[3], checkBoxGroup[i],false);
            cb4[i].setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            cb4[i].setForeground(new Color(0x003166));
            cb4[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if (e.getStateChange() == ItemEvent.SELECTED)
                    {
                        chosenAnswers[Arrays.asList(cb4).indexOf(e.getSource())] = (String)e.getItem();
                    }
                }
            });

            gbc.gridwidth=1;
            quizPanel.add(cb1[i], gbc);
            gbc.gridx++;
            quizPanel.add(cb2[i], gbc);
            gbc.gridx++;
            quizPanel.add(cb3[i], gbc);
            gbc.gridx++;
            quizPanel.add(cb4[i], gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        submit = new JButton("Submit");
        quizPanel.add(submit, gbc);
        submit.addActionListener(new QuizCalculator(quizListener, this, quizListener.getQuiz()));
        scrollPanel = new JScrollPane(quizPanel);
        scrollPanel.setLayout(new ScrollPaneLayout());
        scrollPanel.setPreferredSize(new Dimension(width, height*4/5));
        this.add(scrollPanel);
    }

    public String[] getSelectedAnswers()
    {
        return chosenAnswers;
    }

    public List<String> getCorrectAnswers()
    {
        return correctAnswers;
    }
}
