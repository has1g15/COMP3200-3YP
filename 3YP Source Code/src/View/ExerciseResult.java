package View;

import Controller.ExerciseListener;

import javax.swing.*;
import java.awt.*;

public class ExerciseResult extends JPanel{

    private JPanel title, panel;
    private JLabel name;

    public ExerciseResult(int x, int y, int width, int height, int score, ExerciseListener exerciseListener)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/6));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel(exerciseListener.getLanguage() + ": " + exerciseListener.getSkill() + " Quiz");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height*5/6));
        panel.setBackground(new Color(0x3396ff));
    }
}
