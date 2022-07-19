package TestsForLecture10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {


    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void uploadFileTest() {
        WebElement selectFileButton = driver.findElement(By.cssSelector("#file-upload"));
        selectFileButton.sendKeys(System.getProperty("user.dir") + File.separator + "/src/main/resources/000000843.jpg");

        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.tagName("h3"), "File Uploaded!"));
        String expectedResult = "000000843.jpg";
        String actualResult = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Error, file not uploaded!");

    }
}
