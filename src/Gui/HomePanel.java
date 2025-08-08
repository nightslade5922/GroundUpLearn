package Gui;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;


public class HomePanel extends JPanel {

    private MainWindow window;

    public HomePanel(MainWindow window) {
        this.window = window;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // === Main Content (CENTER) ===
        JPanel centerContent = new JPanel();
        centerContent.setLayout(new BoxLayout(centerContent, BoxLayout.Y_AXIS));
        centerContent.setBorder(BorderFactory.createEmptyBorder(60, 40, 40, 40));
        centerContent.setOpaque(false);

        // Title
        JLabel title = new JLabel("Welcome to GroundUp Learn!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        centerContent.add(title);
        centerContent.add(Box.createRigidArea(new Dimension(0, 120)));

        // Recently visited section
        JLabel recentlyVisitedLabel = new JLabel("Recently Visited");
        recentlyVisitedLabel.setFont(new Font("Dialog", Font.ITALIC, 12));
        recentlyVisitedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerContent.add(recentlyVisitedLabel);
        centerContent.add(Box.createRigidArea(new Dimension(0, 7)));

        // Grid panel
        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        gridPanel.setOpaque(false);
        gridPanel.setMaximumSize(new Dimension(600, 250));
        gridPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gridPanel.add(createBox("📘", "Study"));
        gridPanel.add(createBox("📖", "Read"));
        gridPanel.add(createBox("📓", "Journal"));
        gridPanel.add(createBox("🧘", "Meditate"));
        gridPanel.add(createBox("🎯", "Focus"));
        gridPanel.add(createBox("☀", "Reflect"));

        centerContent.add(gridPanel);
        centerContent.add(Box.createVerticalGlue());

        add(centerContent, BorderLayout.CENTER);
        add(new Gui.SidePanel(window), BorderLayout.WEST);
    }

    private JPanel createBox(String emoji, String label) {
        JPanel box = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16); // Rounded corners
            }
        };

        box.setOpaque(false);
        box.setBackground(new Color(245, 245, 245)); // Slight contrast with white
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setPreferredSize(new Dimension(100, 100));
        box.setMaximumSize(new Dimension(150, 100));
        box.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel emojiLabel = new JLabel(emoji, JLabel.CENTER);
        emojiLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
        emojiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel(label, JLabel.CENTER);
        textLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));

        box.add(Box.createVerticalGlue());
        box.add(emojiLabel);
        box.add(Box.createRigidArea(new Dimension(0, 4)));
        box.add(textLabel);
        box.add(Box.createVerticalGlue());

        box.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        box.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                box.setBackground(new Color(230, 230, 230));
                box.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                box.setBackground(new Color(245, 245, 245));
                box.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (label.equalsIgnoreCase("Study")) {
                    window.showScreen("study");
                }
            }
        });

        return box;
    }
}


