package POM.Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    protected By miktarLocator = By.cssSelector("#a-autoid-0-announce");
    protected By miktarSecLocator = By.cssSelector("div[id='a-popover-1'] li:nth-child(4)");
    protected By alisverisSepetiLocator = By.cssSelector("div[class='a-row'] h1");
    protected By anasayfaLocator = By.cssSelector("#nav-logo-sprites");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage selectQuantity(){
        wait.until(ExpectedConditions.elementToBeClickable(miktarLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(miktarSecLocator)).click();
        return this;
    }

    public HomePage goToHomepage(){
        wait.until(ExpectedConditions.elementToBeClickable(anasayfaLocator)).click();
        return new HomePage(driver);
    }

    public CartPage isOnCartPage(){
        String e = wait.until(ExpectedConditions.visibilityOfElementLocated(alisverisSepetiLocator)).getText();
        Assert.assertEquals(e,"Alışveriş Sepeti");
        return this;
    }
}
