package company;

import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

public class ChangePixels implements Callable<Integer> {
    private Coords coords;
    private BufferedImage image;

    public ChangePixels(){
    }

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
        int a = (color >> 24) & 0xff;
        int r = (color >> 16) & 0xff;
        int g = (color >> 8) & 0xff;
        int b = color & 0xff;
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
        return  (a << 24) | (r << 16) | (g << 8) | b;
    }
}