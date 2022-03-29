package POM.Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    private By cookieLocator = By.id("sp-cc-accept");
    private By textBoxLocator = By.id("twotabsearchtextbox");
    private By searchButtonLocator = By.id("nav-search-submit-button");
    private By sonuclarLocator = By.cssSelector(".a-size-medium-plus.a-color-base.a-text-normal");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage load(){
        load("/");
        return this;
    }

    public HomePage acceptCookies(){
        wait.until(ExpectedConditions.elementToBeClickable(cookieLocator)).click();
        return this;
    }

    public HomePage enterTextinSearchBox(String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator)).sendKeys(txt);
        return this;
    }

    public HomePage clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator)).click();
        return this;

    }

    public HomePage isOnHomePage(){
       String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(sonuclarLocator)).getText();
        Assert.assertEquals(e,"SONUÇLAR");
        return this;
    }

}
