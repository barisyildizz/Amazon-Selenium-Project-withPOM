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
       String e =  driver.getTitle();
        Assert.assertEquals(e,"Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi");
        return this;
    }

}
