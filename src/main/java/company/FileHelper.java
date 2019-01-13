package company;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileHelper {
    private File file;
    private MainJFrame frame;
    private JFileChooser fileChooser;

    public FileHelper(MainJFrame frame) {
        this.frame = frame;
        this.fileChooser = new JFileChooser();
        fileChooser.resetChoosableFileFilters();
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("Grafika JPG", "jpg");
        fileChooser.setFileFilter(filter);
    }

    public File OpenDialog() {
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }

    public static Image GetFileAsImage(File file) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        try {
            return toolkit.getImage(file.toString());
        } catch(Exception ex) {
            return null;
        }
    }
}
