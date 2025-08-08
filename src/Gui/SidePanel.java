package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SidePanel extends JPanel {

    public SidePanel(MainWindow window) {
        setPreferredSize(new Dimension(80, getHeight()));
        setBackground(new Color(240, 240, 240));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Top spacing
        add(Box.createRigidArea(new Dimension(0, 0))); // push logo down

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Gui/logo.png"));

        // Optional: resize the image if needed
        Image img = logoIcon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(img);

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(logoLabel);

        // Flexible space (push settings to bottom)
        add(Box.createVerticalGlue());

        // Settings button
        JButton settingsButton = new JButton("⚙");
        settingsButton.setBackground(new Color(240, 240, 240));
        settingsButton.setFocusPainted(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setPreferredSize(new Dimension(40, 25));
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(settingsButton);

        // Hover effect (currently same color, but structure ready)
        settingsButton.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                settingsButton.setBackground(new Color(240, 240, 240)); // Could lighten here if needed
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingsButton.setBackground(new Color(240, 240, 240));
            }
        });

        // Bottom padding
        add(Box.createRigidArea(new Dimension(0, 15)));
    }
}