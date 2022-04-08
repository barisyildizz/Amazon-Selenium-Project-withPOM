import POM.Base.BaseTest;
import POM.Pages.CartPage;
import POM.Pages.HomePage;
import POM.Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase extends BaseTest {

    @Test
    public void guestCheckOut(){

        HomePage homePage = new HomePage(driver);
        homePage.
                load().
                acceptCookies().
                isOnHomePage().
                enterTextinSearchBox("laptop").
                clickSearchButton();

        ProductPage productPage = new ProductPage(driver).
                selectProduct(2).
                isOnProductDetailPage().
                clickAddToCartButton().
                clickGoToCartButton();


        CartPage cartPage = new CartPage(driver);
        cartPage.
                isOnCartPage();
        Assert.assertTrue(cartPage.isCartCountUp(),"Ürün miktarı artmadı!");
                cartPage.selectQuantity().
                goToHomepage();

    }


}
