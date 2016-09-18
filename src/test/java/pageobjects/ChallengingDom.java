package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDom {

    WebDriver driver;
    
    @Test
    
    public void domChallange() {
    	
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	
    	driver.get("https://the-internet.herokuapp.com/challenging_dom");
    	
    	int rowIndex = 0;
        int cellIndex = 0;
        WebElement largeTable = driver.findElement(By.tagName("table"));
        List<WebElement> rows = largeTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells ) {
                if (cell.getText().equalsIgnoreCase("definiebas4")) {
                    System.out.println("row: " + rowIndex + " cell: " + cellIndex + " cell value: " + cell.getText());
                    break;
                }
                 cellIndex++;
            }
            rowIndex++;
        }

    }
    

}
