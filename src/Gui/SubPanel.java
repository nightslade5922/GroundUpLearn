package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SubPanel extends JPanel {

    public SubPanel(MainWindow window) {

        JLabel label = new JLabel("Subject Screen", JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));

        setLayout(new BorderLayout());

        // Header with back Button
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.lightGray);
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        //button
        JButton backButton = new JButton("<");
        backButton.setBackground(Color.lightGray);
        backButton.setFocusPainted(false);  // Removes blue focus border
        backButton.setBorderPainted(false); // Optional: removes the button border entirely
        backButton.setPreferredSize(new Dimension(22, 21));
        backButton.addActionListener((ActionEvent e) -> {
            window.showScreen("study");
        });
        headerPanel.add(backButton);
        add(headerPanel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);

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

        add(new Gui.SidePanel(window), BorderLayout.WEST);
    }
}