import company.FileLoader;
import org.junit.*;
import company.ChangePixels;
import java.awt.*;
import java.io.File;

public class TestsInMaven {
    @Test
    public void ShouldReturnNullWhenFileIsNull(){
        // arrange
        File file = null;

        // act
        Image img  = FileLoader.GetFileAsImage(file);

        // assert
        //TODO: assertNull
        Assert.assertNull(img);
    }

    @Test
    public void ShouldReturnImageWhenFileIsJpg() {
        // arrange
        File file = new File("hackerman.jpg");

        // act
        Image img = FileLoader.GetFileAsImage(file);

        // assert
        //TODO: assertNotNull
        Assert.assertNotNull(img);
    }

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
    public void ShouldBeEqual16776549When666(){
        // arrange
        int oldColor = 666;
        int newColor = 16776549;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        //TODO: assertEquals
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When5555(){
        // arrange
        int oldColor = 5555;
        int newColor = 16771660;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When77777(){
        // arrange
        int oldColor = 77777;
        int newColor = 16699438;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When888888(){
        // arrange
        int oldColor = 888888;
        int newColor = 15888327;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When9999999(){
        // arrange
        int oldColor = 9999999;
        int newColor = 6777216;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When10000000(){
        // arrange
        int oldColor = 10000000;
        int newColor = 6777215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqua16777205When10(){
        // arrange
        int oldColor = 10;
        int newColor = 16777205;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqua16777115When100(){
        // arrange
        int oldColor = 100;
        int newColor = 16777115;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqua16776215When1000(){
        // arrange
        int oldColor = 1000;
        int newColor = 16776215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqua16666104When111111(){
        // arrange
        int oldColor = 111111;
        int newColor = 16666104;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqua16704488When72727(){
        // arrange
        int oldColor = 72727;
        int newColor = 16704488;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16776549When6777215(){
        // arrange
        int oldColor = 10000000;
        int newColor = 6777215;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16656003When121212(){
        // arrange
        int oldColor = 121212;
        int newColor = 16656003;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16544892When232323(){
        // arrange
        int oldColor = 232323;
        int newColor = 16544892;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16433781When343434(){
        // arrange
        int oldColor = 343434;
        int newColor = 16433781;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16322670When454545(){
        // arrange
        int oldColor = 454545;
        int newColor = 16322670;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16211559When565656(){
        // arrange
        int oldColor = 565656;
        int newColor = 16211559;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual16100448When676767(){
        // arrange
        int oldColor = 676767;
        int newColor = 16100448;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual15989337When787878(){
        // arrange
        int oldColor = 787878;
        int newColor = 15989337;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual15878226When898989(){
        // arrange
        int oldColor = 898989;
        int newColor = 15878226;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual15868125When909090(){
        // arrange
        int oldColor = 909090;
        int newColor = 15868125;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual6767205When10010010(){
        // arrange
        int oldColor = 10010010;
        int newColor = 6767205;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual6676205When10101010(){
        // arrange
        int oldColor = 10101010;
        int newColor = 6676205;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }

    @Test
    public void ShouldBeEqual5666104When11111111(){
        // arrange
        int oldColor = 11111111;
        int newColor = 5666104;
        int result;

        // act
        result = ChangePixels.ChangeColor(oldColor);

        // assert
        Assert.assertEquals(newColor, result);
    }
}
