package TestsForLecture10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class FileUploadTest extends BaseTest {



    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    @Test
    public void uploadFileTest(){
        WebElement selectFileButton = driver.findElement(By.cssSelector("#file-upload"));
        selectFileButton.sendKeys(System.getProperty("D:/study/JAVA/automation_testing_java_course/firstProject/HerokuApp_Sergey_Glinisty/src/main/resources")+"src/main/resources/animals-world-banner.jpg");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

//I can't upload the file
    }
}
