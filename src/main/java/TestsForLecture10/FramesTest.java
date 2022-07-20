package TestsForLecture10;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }

    @Test
    public void frameTest() {
        driver.findElement(By.cssSelector("a[href='/iframe']")).click();
        driver.switchTo().frame("mce_0_ifr");
        String actualResult = driver.findElement(By.cssSelector(".mce-content-body ")).getText();
        driver.switchTo().defaultContent();
        String expectedResult = "Your content goes here.";
        Assert.assertEquals(actualResult, expectedResult, "Checking the text");

    }

}


