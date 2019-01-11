package company;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileLoader {
    private File file;
    private MainJFrame frame;
    private JFileChooser fileChooser;

    public FileLoader(MainJFrame frame) {
        this.frame = frame;
        this.fileChooser = new JFileChooser();
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

    public Image GetFileAsImage() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return toolkit.getImage(file.toString());
    }
}
