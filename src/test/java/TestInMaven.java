import company.ApplyFilter;
import company.FileLoader;
import org.junit.*;
import company.ChangePixels;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;

public class TestInMaven {
    @Test
    public void ShouldBeEqualToBlackWhenGivenWhiteColor(){
        // arrange
        int oldColor = 16777215;
        int newColor = 0;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        //TODO: assertEquals
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqualToWhiteWhenGivenBlackColor(){
        // arrange
        int oldColor = 0;
        int newColor = 16777215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeChangedWhenGivenWhiteColor(){
        // arrange
        int oldColor = 16777215;
        int newColor = 16777215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        //TODO: assertFalse
        Assert.assertFalse(newColor == result);
    }

    @Test
    public void ShouldBeTrueWhenWhiteColorIsBlackThen(){
        // arrange
        int oldColor = 0;
        int newColor = 16777215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        //TODO: assertTrue
        Assert.assertTrue(newColor == result);
    }

    @Test
    public void ShouldReturnNullWhenFileIsNull(){
        //
        File file = null;

        //
        Image img  = FileLoader.GetFileAsImage(file);

        //
        //TODO: assertNull
        Assert.assertNull(img);
    }

    @Test
    public void ShouldReturnImageWhenFileIsJpg() {
        //
        File file = new File("..//filesForTestReasons//hackerman.jpg");

        //
        Image img = FileLoader.GetFileAsImage(file);

        //
        //TODO: assertNotNull
        Assert.assertNotNull(img);
    }
}
