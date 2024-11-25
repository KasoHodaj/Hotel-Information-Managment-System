package Components;

import javax.swing.*;
import java.awt.*;

public class LogoComponent extends JLabel {

    public LogoComponent() {
        // Load and scale the image
        ImageIcon logoIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/Assets/Borcelle.png")) // Updated resource loading
                        .getImage()
                        .getScaledInstance(200, 200, Image.SCALE_SMOOTH)
        );

        // Set the image icon on the label
        setIcon(logoIcon);

        // Optional: Set preferred size (if needed)
        setPreferredSize(new Dimension(250, 250));
    }
}
