package POM.Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    protected By miktarLocator = By.cssSelector(".a-dropdown-prompt");
    protected By miktarSecLocator = By.xpath("//a[@id='quantity_2']");
    protected By alisverisSepetiLocator = By.cssSelector("div[class='a-row'] h1");
    protected By anasayfaLocator = By.cssSelector("#nav-logo-sprites");
    protected By cartCountLocator = By.cssSelector("#nav-cart-count");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartCount(){
        String  a = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCountLocator)).getText();
        return Integer.parseInt(a);
    }

    public int getMiktarCount() {
        String count = wait.until(ExpectedConditions.visibilityOfElementLocated(miktarLocator)).getText();
        return Integer.parseInt(count);
    }


    public CartPage isCartandQuantityCountUp() {
        Assert.assertEquals(getCartCount(),getMiktarCount(),"Ürün miktarı artmadı!");
        return this;
    }


    public CartPage selectQuantity() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(miktarLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(miktarSecLocator)).click();
        Thread.sleep(1000);
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
