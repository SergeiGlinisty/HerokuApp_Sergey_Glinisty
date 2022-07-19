package TestsForLecture10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static TestsForLecture10.Constants.constantsDZ10.amount;

public class DynamicControlsTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void useDynamicControls() {

        WebElement checkboxElement = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement removeButton = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        removeButton.click();
        WebElement inscriptionCheckbox = (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))));
        int quantityOfCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(quantityOfCheckboxes, amount, "There is checkbox");
        WebElement inputElement = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertFalse(inputElement.isEnabled(), "The input isn't disabled");
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        WebElement inscriptionInput = (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))));
        Assert.assertTrue(inscriptionInput.isEnabled(), "The input isn't enabled");


    }
}





