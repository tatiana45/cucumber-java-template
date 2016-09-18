package step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormAuthTest {

    WebDriver driver;

    @Given("^The user navigate to the site$")
    public void the_user_navigate_to_the_site() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Given("^Enters invalid username and invalid password$")
    public void enters_invalid_username_and_invalid_password() throws Throwable {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("Pandasareawesome!");

    }

    @When("^the user clicks Login button$")
    public void the_user_clicks_Login_button() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='login']/button")).click();
        Thread.sleep(3000);
    }
    @Then("^Error message appears$")
    public void error_message_appears() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String LogIn = (String) js.executeScript("return document.getElementsByClassName('subheader')[0].innerHTML.substring(0.64)");

        if(LogIn.equals("Welcome to the Secure Area. When you are done click logout below.")) {
            System.out.println("The user is logged in");
        }else{
            System.out.println("Error: The user entered incorrect password");
        }
    }


}
