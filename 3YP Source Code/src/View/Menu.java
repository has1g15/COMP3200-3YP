package View;

import Controller.ExitListener;
import Controller.MenuListener;
import Controller.StatsListener;
import Controller.GuideListener;
import Model.Progress;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private JProgressBar javaProg, jsProg, pythonProg;
    private JLabel java, js, python;
    private JButton stats, helpGuide, menu, exit;
    private GridBagConstraints gbc;
    private Progress progress;

    public Menu(int x, int y, int width, int height)
    {
        //TODO: update progress bars from data upon loading menu
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(0X003166));
        this.setLayout(new GridBagLayout());

        progress = new Progress();

        javaProg = new JProgressBar();
        javaProg.setPreferredSize(new Dimension(150, 20));
        javaProg.setMinimum(0);
        javaProg.setMaximum(100);
        javaProg.setForeground(new Color(0X009900));
        javaProg.setValue(progress.getJavaPercentage());
        java = new JLabel("          Java");
        java.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        java.setForeground(Color.WHITE);

        jsProg = new JProgressBar();
        jsProg.setPreferredSize(new Dimension(150, 20));
        jsProg.setMinimum(0);
        jsProg.setMaximum(100);
        jsProg.setForeground(new Color(0X009900));
        jsProg.setValue(progress.getJavaScriptPercentage());
        js = new JLabel("      JavaScript");
        js.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        js.setForeground(Color.WHITE);

        pythonProg = new JProgressBar();
        pythonProg.setPreferredSize(new Dimension(150, 20));
        pythonProg.setMinimum(0);
        pythonProg.setMaximum(100);
        pythonProg.setForeground(new Color(0X009900));
        pythonProg.setValue(progress.getPythonPercentage());
        python = new JLabel("         Python");
        python.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        python.setForeground(Color.WHITE);

        stats = new JButton("View Stats");
        stats.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        helpGuide = new JButton("Help Guide");
        helpGuide.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        menu = new JButton("Main Menu");
        menu.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        exit = new JButton("Exit");
        exit.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 25, 0);
        gbc.gridx = 0; gbc.gridy = 0;
        this.add(javaProg, gbc); gbc.gridy++;
        this.add(java, gbc); gbc.gridy++;
        this.add(jsProg, gbc); gbc.gridy++;
        this.add(js, gbc); gbc.gridy++;
        this.add(pythonProg, gbc); gbc.gridy++;
        this.add(python, gbc); gbc.gridy++;
        gbc.insets = new Insets(60, 0, 30, 0);
        this.add(stats, gbc); gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(helpGuide, gbc); gbc.gridy++;
        this.add(menu, gbc); gbc.gridy++;
        this.add(exit, gbc);

        stats.addActionListener(new StatsListener());
        helpGuide.addActionListener(new GuideListener());
        menu.addActionListener(new MenuListener());
        exit.addActionListener(new ExitListener());
    }
}
