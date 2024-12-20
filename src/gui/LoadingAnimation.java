package gui;

import java.awt.*;
import javax.swing.*;

public class LoadingAnimation {
    public static void showLoading(JPanel panel) {
        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(loadingLabel);
        panel.revalidate();
        panel.repaint();
    }
}
