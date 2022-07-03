import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkboxes(){
        List<WebElement> chBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertFalse(driver.findElements(By.cssSelector("[type='checkbox']")).get(0).isSelected(),"checkbox 1 is selected");
        chBoxes.get(0).click();
        Assert.assertTrue(driver.findElements(By.cssSelector("[type='checkbox']")).get(0).isSelected(),"checkbox 1 is not selected");
        Assert.assertTrue(driver.findElements(By.cssSelector("[type='checkbox']")).get(1).isSelected(),"checkbox 2 is not selected");
        chBoxes.get(1).click();
        Assert.assertFalse(driver.findElements(By.cssSelector("[type='checkbox']")).get(1).isSelected(),"checkbox 2 is selected");
    }

}
