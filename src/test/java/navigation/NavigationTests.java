package navigation;
import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigator(){
        homePage.clickCart();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testMultipleCart(){
        var prod = homePage.clickSonyVaioi5();
        prod.clickAddToCart();
        prod.alert_clickToAccept();
        getWindowManager().goBack();
        var prod2 = homePage.clickSamsungGalaxyS6Product();
        prod2.clickAddToCart();
        prod2.alert_clickToAccept();
        getWindowManager().goBack();
        homePage.clickCart();
    }
}
