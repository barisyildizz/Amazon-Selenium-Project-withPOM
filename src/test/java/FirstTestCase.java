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
                enterTextinSearchBox("laptop").
                clickSearchButton().
                isOnHomePage();

        ProductPage productPage = new ProductPage(driver).
                selectProduct(2).
                isOnProductDetailPage().
                clickAddToCartButton().
                clickgoToCartButton();


        CartPage cartPage = new CartPage(driver);
        cartPage.
                isOnCartPage().
                selectQuantity().
                goToHomepage();
    }


}
