package View;

import Controller.GoListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JPanel title, goPanel;
    private JLabel name, selectLanguage, selectSkill;
    private GridBagConstraints gbc;
    private String[] languages, skills;
    private String language, skill;
    private JComboBox<String> languageOptions, skillOptions;
    private JButton go;

    public MainPanel(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/3));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("Graphical Programming E-Learning Platform");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);

        goPanel = new JPanel();
        goPanel.setPreferredSize(new Dimension(width, height*2/3));
        gbc = new GridBagConstraints();
        goPanel.setLayout(new GridBagLayout());
        goPanel.setBackground(new Color(0x3396ff));

        selectLanguage = new JLabel("Please Select a Language...");
        selectLanguage.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        selectLanguage.setForeground(Color.WHITE);
        languages = new String[] {"Select a Language from this Menu", "Java", "Javascript", "Python"};
        languageOptions = new JComboBox<>(languages);
        language = "";
        selectSkill = new JLabel("Please Select a Skill...");
        selectSkill.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
        selectSkill.setForeground(Color.WHITE);
        skills = new String[] {"Select a Skill from this Menu", "Printing, Variable Declaration and Data Types",
                "Formatting and I/O", "Conditional Statements", "Loops", "Operators", "String Handling",
                "Functions, Procedures and Libraries", "Scope", "Data Structures", "File Handling"};
        skillOptions = new JComboBox<>(skills);
        skill = "";

        go = new JButton("GO!");
        languageOptions.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                language = (String)languageOptions.getSelectedItem();


                skillOptions.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        skill = (String)skillOptions.getSelectedItem();
                        if (language!="Select a Language from this Menu" && skill!= "Select a Skill from this Menu") {
                            go.addActionListener(new GoListener(language, skill));
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please Select a Language and a Skill");
                        }
                    }
                });
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        goPanel.add(selectLanguage, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);
        goPanel.add(languageOptions, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(25, 0, 10, 0);
        goPanel.add(selectSkill, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 20, 0);
        goPanel.add(skillOptions, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(30, 0, 40, 0);
        goPanel.add(go, gbc);
        this.add(goPanel);
    }
}
