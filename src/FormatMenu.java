import javax.swing.*;
import java.awt.*;

public class FormatMenu {
    public static void bold() {
        Font currentFont = Frame.textArea.getFont();
        Font newFont = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
        Frame.textArea.setFont(newFont);
    }

    public static void italic() {
        Font currentFont = Frame.textArea.getFont();
        Font newFont = new Font(currentFont.getFontName(), Font.ITALIC, currentFont.getSize());
        Frame.textArea.setFont(newFont);
    }

    public static void fontColor() {
        Color color = JColorChooser.showDialog(null, "Choose Font Color", Color.BLACK);
        if (color != null) {
            Frame.textArea.setForeground(color);
        }
    }
}
