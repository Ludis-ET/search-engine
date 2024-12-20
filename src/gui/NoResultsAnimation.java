package gui;

import java.awt.*;
import javax.swing.*;

public class NoResultsAnimation {
    public static void showAnimation(JPanel panel) {
        JLabel noResultsLabel = new JLabel("No Results Found!");
        noResultsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        noResultsLabel.setForeground(Color.RED);
        noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(noResultsLabel);
        panel.revalidate();
        panel.repaint();
    }
}
