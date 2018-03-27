package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StatsPage extends JPanel {

    private JPanel title, panel, javaStats, javaScriptStats, pythonStats;
    private JLabel name;

    public StatsPage(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height/5));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("Your Statistics");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height*4/5));
        javaStats = new JPanel();
        javaStats.setBackground(new Color(0x3396ff));
        javaStats.setPreferredSize(new Dimension(width/4, height));
        LineBorder border = new LineBorder(Color.WHITE);
        javaStats.setBorder(border);
        panel.add(javaStats);

        javaScriptStats = new JPanel();
        javaScriptStats.setBackground(new Color(0x3396ff));
        javaScriptStats.setPreferredSize(new Dimension(width/4, height));
        javaScriptStats.setBorder(border);
        panel.add(javaScriptStats);

        pythonStats = new JPanel();
        pythonStats.setBackground(new Color(0x3396ff));
        pythonStats.setPreferredSize(new Dimension(width/4, height));
        pythonStats.setBorder(border);
        panel.add(pythonStats);

        this.add(panel);
    }
}
