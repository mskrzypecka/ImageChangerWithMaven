package company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

public class ChangePixels implements Callable<Integer> {
    private Coords coords;
    private BufferedImage image;

    public ChangePixels(Coords coords, BufferedImage image){
        this.coords = coords;
        this.image = image;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Poczatek dla X: " + coords.minX + ", Y: " + coords.minY );
        for (int y = coords.minY; y <= coords.maxY; y++) {
            for (int x = coords.minX; x <= coords.maxX; x++) {
                try {
                    image.setRGB(x, y, ChangeColor(image.getRGB(x, y)));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Poza zasiegiem: x:" + x + ", y:" + y);
                }
            }
        }
        System.out.println("Koniec dla X: " + coords.minX + ", Y: " + coords.minY );
        return 1;
    }

    public static int ChangeColor(int color){
        Color col = new Color(color, true);
        col = new Color(255 - col.getRed(),
                255 - col.getGreen(),
                255 - col.getBlue());

        return  col.getRGB();
    }
}