import Pages.CartPage;
import Pages.MainPage;
import org.junit.Test;


public class FirstTest extends TestBase {

    private int numberOfProductstoAddAndDelete = 3;

    @Test
    public void testCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProductsToCart(numberOfProductstoAddAndDelete);
        mainPage.checkout();

        CartPage cartPage = new CartPage(driver);
        cartPage.deleteProductFromCart(numberOfProductstoAddAndDelete);
        cartPage.waitUntilCartIsEmpty();
    }
}
