package POM.Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends BasePage {

   protected By productListLocator = By.className("s-image");
   protected By addToCartButtonLocator = By.id("add-to-cart-button");
   protected By teslimatSecLocator = By.cssSelector("#contextualIngressPtLabel_deliveryShortLine");
   protected By goToCartButtonLocator = By.cssSelector("a[class='a-button-text']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> itemList() {
        List<WebElement> urunler = driver.findElements(productListLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(urunler));
        return urunler;
    }

    public ProductPage selectProduct(int i){
        itemList().get(i).click();
        return this;
    }

    public ProductPage clickAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator)).click();
          return this;
    }

    public ProductPage isOnProductDetailPage(){
        String e = wait.until(ExpectedConditions.visibilityOfElementLocated(teslimatSecLocator)).getText();
        Assert.assertEquals(e,"Teslimat adresini seçin");
        return this;
    }

    public ProductPage clickgoToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButtonLocator)).click();
        return this;
    }



}
