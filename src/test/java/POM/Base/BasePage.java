package POM.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver=driver;
    }

    public void load(String endPoint){
        driver.get("https://amazon.com.tr"+ endPoint);
    }
}
