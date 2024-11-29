package Components;

import javax.swing.*;
import java.awt.*;
/**
 * The `LogoComponent` class is a custom JLabel that displays a scaled logo image.
 */

public class LogoComponent extends JLabel {

    /**
     * Constructor to initialize the `LogoComponent` with the specified logo.
     */
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
