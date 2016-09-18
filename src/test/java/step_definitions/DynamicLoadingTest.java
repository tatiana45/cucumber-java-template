package step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTest {


    WebDriver driver;


    @Given("^The user navigates to the site$")
    public void the_user_navigates_to_the_site() throws Throwable {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }


    @Given("^Clicks on the Start button$")
        public void clicks_on_the_Start_button() throws Throwable {

            driver.findElement(By.xpath(".//*[@id='start']/button")).click();
        }


    @When("^the user clicks on the Start button the Progress Bar appears$")
    public void the_user_clicks_on_the_Start_button_the_Progress_Bar_appears() throws Throwable {
        if (driver.findElement(By.xpath(".//*[@id='loading']/img")).isDisplayed()) {

            WebDriverWait wait = new WebDriverWait(driver,10);

            try{

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\".//*[@id='finish']/h4\"")));
            }
            catch (NoSuchElementException exception) {
                System.out.println("The 'Hello World!' text is missing ");
            }
        }

    }

    @Then("^Hello World is displayed$")
    public void hello_World_is_displayed() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String x = (String) js.executeScript("return document.getElementById('finish').getElementsByTagName('h4')[0].innerHTML");
        if (x.equals("Hello World!")) {
            System.out.println("The 'Hello World!' text is correct");
        }else {
            System.out.println("Error: The 'Hello World!' text is incorrect");
        }


    }




}






