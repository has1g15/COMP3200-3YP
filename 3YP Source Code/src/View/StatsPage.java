package View;

import Controller.StatsListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StatsPage extends JPanel {

    private JPanel title, panel, javaStats, javaScriptStats, pythonStats;
    private JLabel name, java, javaScript, python, label;
    private HashMap<String, String> javaData, javaScriptData, pythonData;
    private GridBagConstraints gbc;
    private MatteBorder titlePanelBorder;

    public StatsPage(int x, int y, int width, int height, StatsListener statsListener)
    {
        this.setBounds(x, y, width, height);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
        this.setBackground(new Color(0xebebe0));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height/5));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("Your Statistics");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        titlePanelBorder = new MatteBorder(10, 0, 10, 0, new Color(0x003166));
        title.setBorder(titlePanelBorder);
        title.add(name);
        this.add(title);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 3, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;

        javaData = statsListener.getStatsData("Java");
        javaScriptData = statsListener.getStatsData("JavaScript");
        pythonData = statsListener.getStatsData("Python");

        panel = new JPanel();
        panel.setLayout(flowLayout);
        panel.setPreferredSize(new Dimension(width, height*4/5));

        javaStats = new JPanel();
        javaStats.setBackground(new Color(0xebebe0));
        javaStats.setPreferredSize(new Dimension(width/3, height*4/5));
        javaStats.setLayout(new GridBagLayout());
        LineBorder border = new LineBorder(new Color(0x003166), 2);
        javaStats.setBorder(border);
        java = new JLabel("<HTML><U>Java</U></HTML");
        java.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        java.setForeground(new Color(0x003166));
        javaStats.add(java, gbc);
        gbc.gridy++;
        for (Map.Entry<String, String> entry : javaData.entrySet())
        {
            label = new JLabel(entry.getKey() + ": " + entry.getValue());
            label.setForeground(new Color(0x003166));
            label.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            javaStats.add(label, gbc);
            gbc.gridy++;
        }
        panel.add(javaStats);

        javaScriptStats = new JPanel();
        javaScriptStats.setBackground(new Color(0xebebe0));
        javaScriptStats.setPreferredSize(new Dimension(width/3, height*4/5));
        javaScriptStats.setLayout(new GridBagLayout());
        javaScriptStats.setBorder(border);
        javaScript = new JLabel("<HTML><U>JavaScript</U></HTML");
        javaScript.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        javaScript.setForeground(new Color(0x003166));
        gbc.gridy = 0;
        javaScriptStats.add(javaScript, gbc);
        gbc.gridy++;
        for (Map.Entry<String, String> entry : javaScriptData.entrySet())
        {
            label = new JLabel(entry.getKey() + ": " + entry.getValue());
            label.setForeground(new Color(0x003166));
            label.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            javaScriptStats.add(label, gbc);
            gbc.gridy++;
        }
        panel.add(javaScriptStats);

        pythonStats = new JPanel();
        pythonStats.setBackground(new Color(0xebebe0));
        pythonStats.setPreferredSize(new Dimension(width/3, height*4/5));
        pythonStats.setLayout(new GridBagLayout());
        pythonStats.setBorder(border);
        python = new JLabel("<HTML><U>Python</U></HTML");
        python.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        python.setForeground(new Color(0x003166));
        gbc.gridy = 0;
        pythonStats.add(python, gbc);
        gbc.gridy++;
        for (Map.Entry<String, String> entry : pythonData.entrySet())
        {
            label = new JLabel(entry.getKey() + ": " + entry.getValue());
            label.setForeground(new Color(0x003166));
            label.setFont(new Font("Balsamiq Sans", Font.BOLD, 14));
            pythonStats.add(label, gbc);
            gbc.gridy++;
        }
        panel.add(pythonStats);

        this.add(panel);
    }
}
