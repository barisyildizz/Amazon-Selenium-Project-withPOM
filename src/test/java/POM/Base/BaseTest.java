package POM.Base;

import POM.Factory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
      public void initializeDriver(){

        driver = new DriverManager().initializeDriver();

    }

      @AfterMethod
      public void quitDriver(){
        driver.quit();
      }
}
