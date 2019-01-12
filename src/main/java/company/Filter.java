package company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Filter extends SwingWorker<Integer, Integer> {
    public static final int TASK_ROOT = 3;
    public static final int TASKS = TASK_ROOT * TASK_ROOT;
    private int progress;
    private int labelWidth, labelHeight;
    private File imageFile;
    private JLabel imageContainer;
    private BufferedImage processedImage;

    public Filter(File imageFile, JLabel imageContainer, int width, int height) {
        this.imageFile = imageFile;
        this.imageContainer = imageContainer;
        labelWidth = width;
        labelHeight = height;
    }

    protected Integer doInBackground() throws Exception {
        BufferedImage image = ImageIO.read(imageFile);
        ExecutorService service =  Executors.newFixedThreadPool(3);
        List<Callable<Integer>> taskList = new ArrayList<>();
        List<Future<Integer>> resultList;

        System.out.println("Wymiar obrazka: x:" + image.getWidth() + ", y:" + image.getHeight());
        int difX = image.getWidth()/ TASK_ROOT;
        int difY = image.getHeight()/ TASK_ROOT;

        for(int i = 0; i< TASK_ROOT; i++) {
            for(int j = 0; j< TASK_ROOT; j++) {
                Coords coord = new Coords(i * difX, i * difX + difX, j * difY, j * difY + difY);
                taskList.add(new PixelChanger(coord, image));
            }
        }

        resultList = service.invokeAll(taskList);
        int sum = 0;
        while (TASKS != sum) {
            sum = 0;
            for(Future<Integer> result : resultList){
                sum += result.isDone() ? 1 : 0;
            }
            this.progress = sum * (100/ TASKS);
            this.setProgress(this.progress);
        }
        service.shutdown();
        this.processedImage = image;

        return this.progress;
    }

    protected void done() {
        System.out.println("Koniec obliczen");
        Image imageTemp = this.processedImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        this.imageContainer.setIcon(new ImageIcon(imageTemp));
        this.progress = 100;
        this.setProgress(this.progress);
    }
}
