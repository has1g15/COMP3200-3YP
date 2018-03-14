package View;

import javax.swing.*;
import java.awt.*;

public class QuizScreen extends JPanel {

    public QuizScreen(int width, int height, String language, String skill)
    {
        this.setSize(width, height);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x0063cc));
    }
}
