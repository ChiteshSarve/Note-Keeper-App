import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class FileMenu {

    public static JFrame frame;
    public static String fileName;
    public static String filePath;
    public static String directory;

    public static void newFile() {
        Frame.textArea.setText("");
        Frame.frame.setTitle("New");
    }

    public static void openFile() {
        FileDialog fileDialog = new FileDialog(frame, "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            directory = fileDialog.getDirectory();
            fileName = fileDialog.getFile();
            filePath = directory + fileName;
            Frame.frame.setTitle(fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                Frame.textArea.setText("");
                while ((line = reader.readLine()) != null) {
                    Frame.textArea.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println("File not opened");
            }
        } else {
            System.out.println("File open operation canceled by the user.");
        }
    }

    public static void saveAs() {
        FileDialog fileDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            directory = fileDialog.getDirectory();
            fileName = fileDialog.getFile();
            filePath = directory + fileName;
            Frame.frame.setTitle(fileName);
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.write(Frame.textArea.getText());
                writer.close();
            } catch (IOException e) {
                System.out.println("File cannot be saved");
            }
        }
    }

    public static void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.write(Frame.textArea.getText());
                writer.close();
            } catch (IOException e) {
                System.out.println("File cannot be saved");
            }
        }
    }
}
