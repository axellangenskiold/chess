package chess.gui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HoverMouseListener extends MouseAdapter {
        private final ImageIcon originalIcon;
        private final ImageIcon hoverIcon;

        public HoverMouseListener(ImageIcon originalIcon) {
            this.originalIcon = originalIcon;
            this.hoverIcon = createHoverIcon(originalIcon);
        }

        private ImageIcon createHoverIcon(ImageIcon originalIcon) {
            int width = originalIcon.getIconWidth();
            int height = originalIcon.getIconHeight();

            Image originalImage = originalIcon.getImage();
            Image hoverImage = originalImage.getScaledInstance(width + 10, height + 10, Image.SCALE_DEFAULT);

            return new ImageIcon(hoverImage);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                JButton button = (JButton) e.getSource();
                button.setIcon(hoverIcon);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setIcon(originalIcon);
        }
}

