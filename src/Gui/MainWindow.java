package Gui;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CardLayout layout;
    private JPanel mainPanel;

    public MainWindow() {
        setTitle("GroundUp Learn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        HomePanel home = new HomePanel(this);
        StudyPanel study = new StudyPanel(this);
        SubPanel subject = new SubPanel(this);

        home.setBackground(Color.white);
        mainPanel.add(home, "home");
        mainPanel.add(study, "study");
        mainPanel.add(subject, "subject");

        add(mainPanel);
        layout.show(mainPanel, "home");

        setVisible(true);
    }

    public void showScreen(String name) {
        layout.show(mainPanel, name);
    }
}
