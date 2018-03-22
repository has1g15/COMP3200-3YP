package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlatformGuidePage extends JPanel {

    private LineBorder border;
    private TitledBorder menuNavBorder, tutorialBorder, quizBorder, exerciseBorder, statsBorder, rewardsBorder;
    private JPanel title, guide, menuNav, tutorial, quiz, exercise, stats, rewards;
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
        guide.add(menuNav);

        tutorial = new JPanel();
        tutorial.setPreferredSize(new Dimension(width - 20, height/7));
        tutorial.setBackground(new Color(0x3396ff));
        tutorialBorder = new TitledBorder(border, "Tutorial Tips");
        tutorialBorder.setTitleColor(Color.WHITE);
        tutorialBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        tutorial.setBorder(tutorialBorder);
        guide.add(tutorial);

        quiz = new JPanel();
        quiz.setPreferredSize(new Dimension(width - 20, height/7));
        quiz.setBackground(new Color(0x3396ff));
        quizBorder = new TitledBorder(border, "Quiz Tips");
        quizBorder.setTitleColor(Color.WHITE);
        quizBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        quiz.setBorder(quizBorder);
        guide.add(quiz);

        exercise = new JPanel();
        exercise.setPreferredSize(new Dimension(width - 20, height/7));
        exercise.setBackground(new Color(0x3396ff));
        exerciseBorder = new TitledBorder(border, "Practical Exercise Tips");
        exerciseBorder.setTitleColor(Color.WHITE);
        exerciseBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        exercise.setBorder(exerciseBorder);
        guide.add(exercise);

        stats = new JPanel();
        stats.setPreferredSize(new Dimension(width - 20, height/7));
        stats.setBackground(new Color(0x3396ff));
        statsBorder = new TitledBorder(border, "Viewing your Stats");
        statsBorder.setTitleColor(Color.WHITE);
        statsBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        stats.setBorder(statsBorder);
        guide.add(stats);

        rewards = new JPanel();
        rewards.setPreferredSize(new Dimension(width - 20, height/7));
        rewards.setBackground(new Color(0x3396ff));
        rewardsBorder = new TitledBorder(border, "Rewards");
        rewardsBorder.setTitleColor(Color.WHITE);
        rewardsBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        rewards.setBorder(rewardsBorder);
        guide.add(rewards);

        guideScroll = new JScrollPane(guide);
        guideScroll.setPreferredSize(new Dimension(width, height*3/4));
        guideScroll.setLayout(new ScrollPaneLayout());
        this.add(guideScroll);
    }
}
