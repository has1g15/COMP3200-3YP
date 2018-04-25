package View;

import Controller.ExerciseListener;
import Controller.NextListener;
import Controller.PrevListener;
import Controller.QuizListener;
import Model.Tutorial;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TutorialScreen extends JPanel {

    private JPanel graphicsPanel, guidePanel, prevPanel, labelPanel, nextPanel, console, codePanel;
    private JScrollPane guidePane;
    private JTextArea guideText, consoleText, initial;
    private JLabel taskLabel;
    private JButton prev, next, quiz, exercise;
    private JLayeredPane layeredPane;
    private GridBagConstraints gbc;
    private Tutorial tutorial;

    public TutorialScreen(int x, int y, int width, int height, String language, String skill, Tutorial tutorial)
    {
        this.tutorial = tutorial;
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(0x3396ff));
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);

        codePanel = new JPanel();
        codePanel.setPreferredSize(new Dimension(this.getWidth()*2/3, this.getHeight()*6/7));
        graphicsPanel = new JPanel();
        graphicsPanel.setPreferredSize(new Dimension(this.getWidth()*2/3,this.getHeight()*5/7));
        graphicsPanel.setBackground(new Color(0xebebe0));
        graphicsPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;

        console = new JPanel();
        console.setPreferredSize(new Dimension(this.getWidth()*2/3, this.getHeight()/7));
        console.setBackground(Color.BLACK);
        console.setLayout(new BorderLayout());
        console.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        consoleText = new JTextArea();
        consoleText.setBackground(Color.BLACK);
        consoleText.setForeground(Color.WHITE);
        consoleText.setFont(new Font("Courier New", Font.BOLD, 14));
        console.add(consoleText);

        codePanel.add(graphicsPanel);
        codePanel.add(console);

        guidePanel = new JPanel();
        guidePanel.setPreferredSize(new Dimension(this.getWidth()/3, this.getHeight()*6/7));
        guidePanel.setBackground(new Color(0x3396ff));
        guidePanel.setLayout(new FlowLayout());
        guideText = new JTextArea("", 30, 24);
        guideText.setFont(new Font("Balsamiq Sand", Font.BOLD, 14));
        guideText.setLineWrap(true);
        guideText.setWrapStyleWord(true);
        guidePane = new JScrollPane(guideText);
        quiz = new JButton("Quiz Out");
        exercise = new JButton("Take Exercise");
        quiz.setFont(new Font("Balsamiq Sans", Font.PLAIN, 14));
        quiz.addActionListener(new QuizListener(language, skill));
        exercise.setFont(new Font("Balsamiq Sans", Font.PLAIN, 14));
        exercise.addActionListener(new ExerciseListener(language, skill));
        guidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        guidePanel.add(guidePane);
        guidePanel.add(quiz);
        guidePanel.add(exercise);

        prevPanel = new JPanel();
        prevPanel.setPreferredSize(new Dimension(width/5, height/7));
        prev = new JButton("prev");
        prev.addActionListener(new PrevListener(tutorial, this));
        prevPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        prevPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        prevPanel.setBackground(new Color(0x0063cc));
        prevPanel.add(prev);

        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(width*3/5, height/7));
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        labelPanel.setBackground(new Color(0x0063cc));
        taskLabel = new JLabel(language + ": " + skill);
        taskLabel.setForeground(Color.WHITE);
        taskLabel.setFont(new Font("Balsamiq Sans", Font.BOLD, 16));
        labelPanel.add(taskLabel);

        nextPanel = new JPanel();
        nextPanel.setPreferredSize(new Dimension(width/5, height/7));
        next = new JButton("next");
        next.addActionListener(new NextListener(tutorial, this));
        nextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nextPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        nextPanel.setBackground(new Color(0x0063cc));
        nextPanel.add(next);

        this.add(codePanel);
        this.add(guidePanel);
        this.add(prevPanel);
        this.add(labelPanel);
        this.add(nextPanel);
    }

    public void createLayeredPanes(ArrayList<String> code)
    {
        int xOffset = 60;
        int yOffset = 40;

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(graphicsPanel.getWidth()*3/4, graphicsPanel.getHeight()*3/4));
        Color colour;
        for (int i = 0; i < code.size(); i++)
        {
            String[] lines = code.get(i).split("\r\n|\r|\n");
            int yScale = lines.length;
            JTextArea text = new JTextArea();
            text.setEditable(false);
            text.setFont(new Font("Courier New", Font.BOLD, 16));
            if (code.get(i).contains("£"))
            {
                String remove = code.get(i).replace("£", "");
                colour = Color.ORANGE;
                text.setBackground(colour);
                text.setText(remove);
            }
            else
            {
                colour = new Color(0xebebe0);
                text.setBackground(colour);
                text.setText(code.get(i));
            }
            text.setBounds(xOffset * i/2,yOffset,graphicsPanel.getWidth()*2/5, graphicsPanel.getHeight()/21*yScale);
            layeredPane.add(text, new Integer(i));
            yOffset = yOffset + (graphicsPanel.getHeight()/20)*2;
        }
        if (tutorial.getCurrentIndex() == 1)
        {
            graphicsPanel.remove(initial);
        }
        graphicsPanel.add(layeredPane, gbc);
        System.out.println("adding");
    }

    public void changeGuideText(String text)
    {
        guideText.setText(text);
    }

    public void changeCode(String text)
    {
        System.out.println(tutorial.getCurrentIndex());
        if (tutorial.getCurrentIndex() > 1) {
            graphicsPanel.remove(layeredPane);
        }
        if (tutorial.getCurrentIndex() == 0)
        {
            initial = new JTextArea(text);
            initial.setBackground(new Color(0xebebe0));
            initial.setFont(new Font("Courier New", Font.BOLD, 16));
            graphicsPanel.add(initial, gbc);
        }
        else {
            createLayeredPanes(new ArrayList(Arrays.asList(text.split("@"))));
        }
    }

    public void changeConsoleText(String text)
    {
        consoleText.setText(text);
    }
}
