package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxes {

    WebDriver driver;


    @Test

    public void CheckboxTest() {

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");



        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        System.out.println("Number of checkboxes displayed " + checkboxes.size());

        for (int i=0;i<checkboxes.size();i++)
        {
            WebElement ele = checkboxes.get(i);
            String isChecked = ele.getAttribute("checked");
            System.out.println("Is checked? " + isChecked);

        }




    }


    private void assertTrue(boolean equals) {
        // TODO Auto-generated method stub

    }
}
