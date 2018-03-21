package View;

import javax.swing.*;
import java.awt.*;

public class ToolTipsPage extends JPanel {

    private JPanel title;
    private JLabel name;

    public ToolTipsPage(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
        title = new JPanel();
        title.setPreferredSize(new Dimension(width, height*1/3));
        title.setBackground(new Color(0x0063cc));
        title.setLayout(new GridBagLayout());
        name = new JLabel("Platform Tool Tips");
        name.setFont(new Font("Balsamiq Sans", Font.BOLD, 22));
        name.setForeground(Color.WHITE);
        title.add(name);
        this.add(title);
    }
}
