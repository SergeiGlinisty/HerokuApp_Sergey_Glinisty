import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Inputs extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void inputsUp(){
        WebElement inputs =driver.findElement(By.tagName("input"));
        inputs.sendKeys("8");
        inputs.sendKeys(Keys.ARROW_UP);
        String actualResultUp = inputs.getAttribute("value");
        String expectedResultUp = "9";
        Assert.assertEquals(actualResultUp, expectedResultUp, "Keys.ARROW_UP doesn't work");

    }

    @Test
    public void inputsDown(){

        WebElement inputsDown =driver.findElement(By.tagName("input"));
        inputsDown.sendKeys("456");
        inputsDown.sendKeys(Keys.ARROW_DOWN);
        String actualResultDown = inputsDown.getAttribute("value");
        String expectedResultDown = "455";
        Assert.assertEquals(actualResultDown, expectedResultDown, "Keys.ARROW_Down doesn't work");
    }
    @Test
    public void inputsLetters(){

        WebElement inputsLetters =driver.findElement(By.tagName("input"));
        inputsLetters.sendKeys("dollars");
        String actualResultDown = inputsLetters.getAttribute("value");
        String expectedResultDown = "";
        Assert.assertEquals(actualResultDown, expectedResultDown, "Letters are entered");
    }

}
