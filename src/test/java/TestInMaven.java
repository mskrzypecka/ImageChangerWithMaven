import org.junit.*;
import company.ChangePixels;

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
}
