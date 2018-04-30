package View;

import Controller.ExerciseListener;
import Controller.MenuListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ExerciseResult extends JPanel{

    private JPanel title, panel;
    private JLabel name, announce, scoreDisplay, menuPrompt, userAnswer, answer;
    private JButton menu;
    private GridBagConstraints gbc;
    private JTextArea displayUserAnswer, displayAnswer;
    private Border border, raised, lowered;
    private MatteBorder titlePanelBorder;

    public ExerciseResult(int x, int y, int width, int height, int score, ExerciseListener exerciseListener, String userAns)
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

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height*5/6));
        panel.setBackground(new Color(0xebebe0));
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);

        gbc.gridwidth = 2;
        announce = new JLabel("You Scored:");
        announce.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        announce.setForeground(new Color(0x003166));
        panel.add(announce, gbc);
        gbc.gridy++;

        scoreDisplay = new JLabel(Integer.toString(score) + " / 10");
        scoreDisplay.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
        scoreDisplay.setForeground(new Color(0x003166));
        panel.add(scoreDisplay, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);

        raised = BorderFactory.createRaisedBevelBorder();
        lowered = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createCompoundBorder(raised, lowered);

        gbc.gridwidth = 1;
        userAnswer = new JLabel("Your answer:");
        userAnswer.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        userAnswer.setForeground(new Color(0x003166));
        panel.add(userAnswer, gbc);
        gbc.gridx++;
        displayUserAnswer = new JTextArea();
        displayUserAnswer.setText(userAns);
        displayUserAnswer.setRows(15);
        displayUserAnswer.setColumns(20);
        displayUserAnswer.setEditable(false);
        displayUserAnswer.setFont(new Font("Courier New", Font.PLAIN, 18));
        displayUserAnswer.setBorder(border);

        answer = new JLabel("Answer:");
        answer.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        answer.setForeground(new Color(0x003166));
        displayAnswer = new JTextArea();
        displayAnswer.setText(exerciseListener.getExercise().getAnswer());
        displayAnswer.setRows(15);
        displayAnswer.setColumns(20);
        displayAnswer.setEditable(false);
        displayAnswer.setFont(new Font("Courier New", Font.PLAIN, 18));
        displayAnswer.setBorder(border);
        panel.add(answer, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(displayUserAnswer, gbc);
        gbc.gridx++;
        panel.add(displayAnswer, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 2;
        menuPrompt = new JLabel("Return to Menu:");
        menuPrompt.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        menuPrompt.setForeground(new Color(0x003166));
        panel.add(menuPrompt,gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 20, 0);

        menu = new JButton("Menu");
        menu.addActionListener(new MenuListener());
        panel.add(menu, gbc);
        this.add(panel);
    }
}
