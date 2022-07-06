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

public class Typos extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @Test
    public void typos(){
        List<WebElement> typos = driver.findElements(By.tagName("p"));
        String actualResultTypos = typos.get(1).getText();
        String expectedResultTypos = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(actualResultTypos, expectedResultTypos, "Error in text");
    }


}
