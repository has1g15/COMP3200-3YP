package View;

import Controller.QuizListener;

import javax.swing.*;
import java.awt.*;

public class TutorialScreen extends JPanel {

    private JPanel graphicsPanel, guidePanel, prevPanel, labelPanel, nextPanel, blank;
    private JScrollPane guidePane;
    private JTextArea guideText;
    private JLabel taskLabel;
    private JButton prev, next, quiz;

    public TutorialScreen(int width, int height, String language, String skill)
    {
        this.setSize(width, height);
        this.setBackground(new Color(0x3396ff));
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
        graphicsPanel = new JPanel();
        graphicsPanel.setPreferredSize(new Dimension(this.getWidth()*3/4,this.getHeight()*5/6));
        graphicsPanel.setBackground(new Color(0xebebe0));

        guidePanel = new JPanel();
        guidePanel.setPreferredSize(new Dimension(this.getWidth()/4, this.getHeight()*5/6));
        guidePanel.setBackground(new Color(0x3396ff));
        guidePanel.setLayout(new FlowLayout());
        guideText = new JTextArea("test test test test test test test test test test", 29, 24);
        guideText.setFont(new Font("Balsamiq Sand", Font.BOLD, 14));
        guideText.setLineWrap(true);
        guidePane = new JScrollPane(guideText);
        quiz = new JButton("Quiz Out");
        quiz.setFont(new Font("Balsamiq Sans", Font.PLAIN, 14));
        quiz.addActionListener(new QuizListener(language, skill));
        guidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        guidePanel.add(guidePane);
        guidePanel.add(quiz);

        blank = new JPanel();
        blank.setPreferredSize(new Dimension(this.getWidth()/6, 200));

        prevPanel = new JPanel();
        prevPanel.setPreferredSize(new Dimension(200, 200));
        prev = new JButton("prev");
        prevPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        prevPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        prevPanel.setBackground(new Color(0x0063cc));
        prevPanel.add(prev);

        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(738, 200));
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        labelPanel.setBackground(new Color(0x0063cc));
        taskLabel = new JLabel(language + ": " + skill);
        taskLabel.setForeground(Color.WHITE);
        taskLabel.setFont(new Font("Balsamiq Sans", Font.BOLD, 16));
        labelPanel.add(taskLabel);

        nextPanel = new JPanel();
        nextPanel.setPreferredSize(new Dimension(200, 200));
        next = new JButton("next");
        nextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nextPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        nextPanel.setBackground(new Color(0x0063cc));
        nextPanel.add(next);

        this.add(graphicsPanel);
        this.add(guidePanel);
        this.add(blank);
        this.add(prevPanel);
        this.add(labelPanel);
        this.add(nextPanel);
    }

    public void drawGraphic(Graphics2D g2)
    {

    }

    public void changeGuideText(String text)
    {
        guideText.setText(text);
    }
}
