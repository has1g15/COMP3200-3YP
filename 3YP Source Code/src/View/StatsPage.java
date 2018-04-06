package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StatsPage extends JPanel {

    private JPanel title, panel, javaStats, javaScriptStats, pythonStats;
    private JLabel name, java, javaScript, python;

    public StatsPage(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
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
        panel.setLayout(flowLayout);
        panel.setPreferredSize(new Dimension(width, height*4/5));

        javaStats = new JPanel();
        javaStats.setBackground(new Color(0x3396ff));
        javaStats.setPreferredSize(new Dimension(width/3, height));
        LineBorder border = new LineBorder(Color.WHITE);
        javaStats.setBorder(border);
        java = new JLabel("<HTML><U>Java</U></HTML");
        java.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        java.setForeground(Color.WHITE);
        javaStats.add(java);
        panel.add(javaStats);

        javaScriptStats = new JPanel();
        javaScriptStats.setBackground(new Color(0x3396ff));
        javaScriptStats.setPreferredSize(new Dimension(width/3, height));
        javaScriptStats.setBorder(border);
        javaScript = new JLabel("<HTML><U>JavaScript</U></HTML");
        javaScript.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        javaScript.setForeground(Color.WHITE);
        javaScriptStats.add(javaScript);
        panel.add(javaScriptStats);

        pythonStats = new JPanel();
        pythonStats.setBackground(new Color(0x3396ff));
        pythonStats.setPreferredSize(new Dimension(width/3, height));
        pythonStats.setBorder(border);
        python = new JLabel("<HTML><U>Python</U></HTML");
        python.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        python.setForeground(Color.WHITE);
        pythonStats.add(python);
        panel.add(pythonStats);

        this.add(panel);
    }
}
