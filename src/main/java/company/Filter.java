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
    public int threads;
    public int tasks;
    private int progress;
    private int labelWidth, labelHeight;
    private File imageFile;
    private JLabel imageContainer;
    private volatile BufferedImage processedImage;
    long startTime, endTime;

    public Filter(File imageFile, JLabel imageContainer, int width, int height, int threads) {
        this.imageFile = imageFile;
        this.imageContainer = imageContainer;
        labelWidth = width;
        labelHeight = height;
        this.threads = threads;
    }

    protected Integer doInBackground() throws Exception {
        BufferedImage image = ImageIO.read(imageFile);
        ExecutorService service =  Executors.newFixedThreadPool(threads);
        List<Callable<Integer>> taskList = new ArrayList<>();
        List<Future<Integer>> resultList;

        //System.out.println("Wymiar obrazka: x:" + image.getWidth() + ", y:" + image.getHeight());
        int difX = image.getWidth()/threads;
        int difY = image.getHeight()/threads;

        for(int i = 0; i< threads; i++) {
            for(int j = 0; j< threads; j++) {
                Coords coord = new Coords(i * difX, i * difX + difX, j * difY, j * difY + difY);
                taskList.add(new PixelChanger(coord, image));
            }
        }

        startTime = System.nanoTime();
        resultList = service.invokeAll(taskList);
        int sum = 0;
        while (tasks != sum) {
            sum = 0;
            for(Future<Integer> result : resultList){
                sum += result.isDone() ? 1 : 0;
            }
            this.progress = sum * (100/ tasks);
            this.setProgress(this.progress);
        }
        endTime = System.nanoTime();

        service.shutdown();
        this.processedImage = image;
        return this.progress;
    }

    protected void done() {
        long time = (endTime - startTime)/1000000;
        System.out.println("Czas dla ilości wątków " + threads + ": " + time);
        Image imageTemp = this.processedImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        this.imageContainer.setIcon(new ImageIcon(imageTemp));
        this.progress = 100;
        this.setProgress(this.progress);
    }
}
