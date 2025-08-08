package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudyPanel extends JPanel {
    public StudyPanel(MainWindow window) {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Header with back Button
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.lightGray);
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        JButton transparentButton = new JButton("<");

        //button
        JButton backButton = new JButton("<");
        backButton.setBackground(Color.lightGray);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setPreferredSize(new Dimension(22, 21));
        backButton.addActionListener((ActionEvent e) -> {
            window.showScreen("home");
        });
        headerPanel.add(backButton);
        add(headerPanel, BorderLayout.NORTH);

        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(Color.lightGray);
            }
        });


        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Study Screen", JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        //subject button
        JButton subButton = new JButton("Subjects");
        subButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        subButton.setFocusPainted(false);
        subButton.setBorderPainted(false);
        subButton.setPreferredSize(new Dimension(60, 40));
        subButton.addActionListener((ActionEvent e) -> {
            window.showScreen("subject");
        });

        // Add components to the content panel with spacing
        contentPanel.add(Box.createVerticalGlue()); // Spacer to push content to the middle
        contentPanel.add(label);
        contentPanel.add(Box.createVerticalStrut(20)); // Fixed space between label and button
        contentPanel.add(subButton);
        contentPanel.add(Box.createVerticalGlue()); // Spacer to push content to the middle

        add(contentPanel, BorderLayout.CENTER);
    }
}