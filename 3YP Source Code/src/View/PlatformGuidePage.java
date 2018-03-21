package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlatformGuidePage extends JPanel {

    private LineBorder border;
    private TitledBorder menuNavBorder, tutorialBorder, quizBorder, exerciseBorder, statsBorder, gameFeaturesBorder;
    private JPanel title, menuNav, tutorial, quiz, exercise, stats, gameFeatures;
    private JLabel name;

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

        menuNav = new JPanel();
        menuNav.setPreferredSize(new Dimension(width, height/5));
        menuNav.setBackground(new Color(0x3396ff));
        menuNavBorder = new TitledBorder(border, "Menu Navigation Tips");
        menuNavBorder.setTitleColor(Color.WHITE);
        menuNavBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        menuNav.setBorder(menuNavBorder);
        this.add(menuNav);

        tutorial = new JPanel();
        tutorial.setPreferredSize(new Dimension(width, height/5));
        tutorial.setBackground(new Color(0x3396ff));
        tutorialBorder = new TitledBorder(border, "Tutorial Tips");
        tutorialBorder.setTitleColor(Color.WHITE);
        tutorialBorder.setTitleFont(new Font("Balsamiq Sans", Font.BOLD, 14));
        tutorial.setBorder(tutorialBorder);
        this.add(tutorial);

    }
}
