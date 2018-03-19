package View;

import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class QuizScreen extends JPanel {

    private JPanel title, quizPanel;
    private JLabel name;
    private GridBagConstraints gbc;
    private JScrollPane scrollPanel;
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
        scrollPanel = new JScrollPane(quizPanel);
        quizPanel.setAutoscrolls(true);

        checkBoxGroup = new CheckboxGroup[9];
        for (int i = 0; i < 9; i++)
        {
            checkBoxGroup[i] = new CheckboxGroup();
        }

        Checkbox cb1 = new Checkbox("test1", checkBoxGroup[0],false);
        Checkbox cb2 = new Checkbox("test2", checkBoxGroup[0],false);
        Checkbox cb3 = new Checkbox("test3", checkBoxGroup[0],false);
        gbc = new GridBagConstraints();
        quizPanel.setLayout(new GridBagLayout());
        quizPanel.setBackground(new Color(0x3396ff));
        quizPanel.add(cb1, gbc);
        quizPanel.add(cb2, gbc);
        quizPanel.add(cb3, gbc);
        this.add(scrollPanel);
    }
}
