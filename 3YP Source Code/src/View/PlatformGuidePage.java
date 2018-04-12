package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlatformGuidePage extends JPanel {

    private LineBorder border;
    private TitledBorder menuNavBorder, tutorialBorder, quizBorder, exerciseBorder, statsBorder, rewardsBorder;
    private JPanel title, guide, menuNav, tutorial, quiz, exercise, stats, rewards;
    private JTextArea menuText, tutorialText, quizText, exerciseText, statsText, rewardsText;
    private JLabel name;
    private JScrollPane guideScroll;

    public PlatformGuidePage(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height/5));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("Platform Guide");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        border = new LineBorder(Color.WHITE);

        guide = new JPanel();
        guide.setLayout(new GridLayout(6,1));
        menuNav = new JPanel();
        menuNav.setPreferredSize(new Dimension(width - 20, height/7));
        menuNav.setBackground(new Color(0x3396ff));
        menuNavBorder = new TitledBorder(border, "Menu Navigation Tips");
        menuNavBorder.setTitleColor(Color.WHITE);
        menuNavBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        menuNav.setBorder(menuNavBorder);
        menuText = new JTextArea("The application menu consists of a progress overview and some navigation options. You" +
                " can view your progress percentage in each individual language at the top via the progress bars. There are" +
                " also options to view a full breakdown of your statistics, access this guide, return to the main menu and" +
                " exit the application. The menu is available on every page of the application.");
        menuText.setColumns(90);
        menuText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        menuText.setBackground(new Color(0x3396ff));
        menuText.setLineWrap(true);
        menuText.setWrapStyleWord(true);
        menuText.setForeground(Color.WHITE);
        menuText.setEditable(false);
        menuNav.add(menuText);
        guide.add(menuNav);

        tutorial = new JPanel();
        tutorial.setPreferredSize(new Dimension(width - 20, height/7));
        tutorial.setBackground(new Color(0x3396ff));
        tutorialBorder = new TitledBorder(border, "Tutorial Tips");
        tutorialBorder.setTitleColor(Color.WHITE);
        tutorialBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        tutorial.setBorder(tutorialBorder);
        tutorialText = new JTextArea("After selecting your choice of language and skill, their respective tutorial will" +
                " be loaded. A tutorial consists of a graphical representation of code executing as well as corresponding" +
                " information explaining the code. The next and previous buttons can be used to return to and skip steps. " +
                " At the end of the tutorial, you can take a quiz and an interactive exercise to assess your understanding" +
                " of the content.");
        tutorialText.setColumns(90);
        tutorialText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        tutorialText.setBackground(new Color(0x3396ff));
        tutorialText.setLineWrap(true);
        tutorialText.setWrapStyleWord(true);
        tutorialText.setForeground(Color.WHITE);
        tutorialText.setEditable(false);
        tutorial.add(tutorialText);
        guide.add(tutorial);

        quiz = new JPanel();
        quiz.setPreferredSize(new Dimension(width - 20, height/7));
        quiz.setBackground(new Color(0x3396ff));
        quizBorder = new TitledBorder(border, "Quiz Tips");
        quizBorder.setTitleColor(Color.WHITE);
        quizBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        quiz.setBorder(quizBorder);
        quizText = new JTextArea("At the end of each tutorial, there is a ten question multiple choice quiz to assess your" +
                " understanding of the tutorial content. There is the option to take this quiz at any point during" +
                " the tutorial if you feel comfortable with the content. On submitting, you will receive a score" +
                " which will be updated on your statistics page and in the menu progress bars. You can retake quizzes at any" +
                " point to achieve higher scores, these will be updated accordingly.");
        quizText.setColumns(90);
        quizText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        quizText.setBackground(new Color(0x3396ff));
        quizText.setLineWrap(true);
        quizText.setWrapStyleWord(true);
        quizText.setForeground(Color.WHITE);
        quizText.setEditable(false);
        quiz.add(quizText);
        guide.add(quiz);

        exercise = new JPanel();
        exercise.setPreferredSize(new Dimension(width - 20, height/7));
        exercise.setBackground(new Color(0x3396ff));
        exerciseBorder = new TitledBorder(border, "Practical Exercise Tips");
        exerciseBorder.setTitleColor(Color.WHITE);
        exerciseBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        exercise.setBorder(exerciseBorder);
        exerciseText = new JTextArea("As well as a multiple choice quiz, there is also an interactive exercise at the end" +
                " of each skill. You will be provided with a problem that you will need to write a solution to in the box provided" +
                " based on the content in the tutorial. Your solution will be marked once you click submit and you will be awarded " +
                "a score out of 10.");
        exerciseText.setColumns(90);
        exerciseText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        exerciseText.setBackground(new Color(0x3396ff));
        exerciseText.setLineWrap(true);
        exerciseText.setWrapStyleWord(true);
        exerciseText.setForeground(Color.WHITE);
        exerciseText.setEditable(false);
        exercise.add(exerciseText);
        guide.add(exercise);

        stats = new JPanel();
        stats.setPreferredSize(new Dimension(width - 20, height/7));
        stats.setBackground(new Color(0x3396ff));
        statsBorder = new TitledBorder(border, "Viewing your Stats");
        statsBorder.setTitleColor(Color.WHITE);
        statsBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        stats.setBorder(statsBorder);
        statsText = new JTextArea("You can view a breakdown of your statistics by clicking the view stats option from the menu. " +
                "On this page you will be able to see your current level in each language, your current progress percentage and " +
                "the number of points you have accumulated in each language. Also, you can see the individual points you have received" +
                " from each quiz and exercise.");
        statsText.setColumns(90);
        statsText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        statsText.setBackground(new Color(0x3396ff));
        statsText.setLineWrap(true);
        statsText.setWrapStyleWord(true);
        statsText.setForeground(Color.WHITE);
        statsText.setEditable(false);
        stats.add(statsText);
        guide.add(stats);

        rewards = new JPanel();
        rewards.setPreferredSize(new Dimension(width - 20, height/7));
        rewards.setBackground(new Color(0x3396ff));
        rewardsBorder = new TitledBorder(border, "Rewards");
        rewardsBorder.setTitleColor(Color.WHITE);
        rewardsBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        rewards.setBorder(rewardsBorder);
        rewardsText = new JTextArea("When you have completed assessment tasks at the end of a skill, you will receive points" +
                " based on your performance. The maximum for each task is 10 points, when you receive enough points you will be " +
                "able to level up in a language. There are five possible levels available and forty points between each level.");
        rewardsText.setColumns(90);
        rewardsText.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        rewardsText.setBackground(new Color(0x3396ff));
        rewardsText.setLineWrap(true);
        rewardsText.setWrapStyleWord(true);
        rewardsText.setForeground(Color.WHITE);
        rewardsText.setEditable(false);
        rewards.add(rewardsText);
        guide.add(rewards);

        guideScroll = new JScrollPane(guide);
        guideScroll.setPreferredSize(new Dimension(width, height*3/4));
        guideScroll.setLayout(new ScrollPaneLayout());
        this.add(guideScroll);
    }
}
