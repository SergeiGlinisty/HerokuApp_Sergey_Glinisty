import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.pack200.BandSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class DropdownTest extends BaseTest {


        @BeforeMethod
        public void navigate(){
            driver.get("http://the-internet.herokuapp.com/dropdown");
        }

@Test
        public void selectDropdownTest (){
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select select = new Select (dropdownElement);// создаём объект класса select в конструкторе и передаём туда найденный элемент
            List<WebElement> options =select.getOptions();//метод getOptions возвращает коллекцию webelement - ов
            List <String> expectedOptions =new ArrayList<String>();
                expectedOptions.add("Please select an option");
                expectedOptions.add("Option 1");
                expectedOptions.add("Option 2");
            List <String> actualOptions = options.stream().map(option -> option.getText()).toList();
            Assert.assertEquals(expectedOptions, actualOptions);
                options.forEach(option -> System.out.println(option.getText()));// выводим опции
              //  select.selectByValue("1");// выбираем опцию "Option 1"
              //  select.selectByIndex(1);// выбираем опцию "Option 1"
                select.selectByVisibleText("Option 2");// выбираем опцию "Option 2"
                String actualResultOptionSecond = select.getFirstSelectedOption().getText();//метод возвращает webelement который сейчас выбран
                String expectedResultOptionSecond = "Option 2";
                Assert.assertEquals(actualResultOptionSecond, expectedResultOptionSecond, "the second option  is wronged");
           //"Please select an option" is index "0"
                select.selectByIndex(1);// выбираем опцию "Option 1"
                String actualResultOptionFirst = select.getFirstSelectedOption().getText();
                String expectedResultOptionFirst = "Option 1";
                Assert.assertEquals(actualResultOptionFirst, expectedResultOptionFirst, "the first option  is wronged");
        }
    }
