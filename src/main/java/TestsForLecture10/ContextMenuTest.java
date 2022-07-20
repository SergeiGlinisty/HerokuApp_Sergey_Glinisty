package TestsForLecture10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
String expectedText = "You selected a context menu";
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }
@Test
    public void alertTest(){

    Actions action = new Actions(driver);

    WebElement link = driver.findElement(By.cssSelector("#hot-spot"));
    action.contextClick(link).perform();
    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    Assert.assertEquals(alertText, expectedText);
    alert.accept();
    driver.switchTo().defaultContent();

}

}
