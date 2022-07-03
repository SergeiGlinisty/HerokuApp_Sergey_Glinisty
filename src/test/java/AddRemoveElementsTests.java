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



     public class AddRemoveElementsTests extends BaseTest {
        @BeforeMethod
        public void navigate() {
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        }

        @Test
        public void testAddRemoveElements() {
            WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            deleteButtons.isEmpty();//check that the array is empty
            Assert.assertTrue(driver.findElements(By.xpath("//button[text()='Delete']")).size()==0,"The array is not empty!");
            addButton.click();
            addButton.click();
            deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));//added 2 elements
            Assert.assertTrue(driver.findElements(By.xpath("//button[text()='Delete']")).size()==2,"There are not 2 elements");
            deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));//removed 1 elements
            deleteButtons.get(1).click();
            Assert.assertTrue(driver.findElements(By.xpath("//button[text()='Delete']")).size()==1,"There is not 1 element!");

        }
    }

