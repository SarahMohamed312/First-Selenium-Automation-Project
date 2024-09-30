package cart;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import utilities.DataProvider;

import static org.testng.Assert.*;

public class PurchaseTests extends BaseTest {


    /*@Test(dataProvider = "FillFormData", dataProviderClass = DataProvider.class)
    public void testValidData_PlaceOrderModal(String name, String country, String city, String card, String month, String year) {
        var cartPage = homePage.clickCart();
        var purchaseForm = cartPage.clickPlaceOrder();
      purchaseForm.fillPurchaseForm(name, country, city, card, month, year);
        purchaseForm.clickPurchase();
        purchaseForm.clickOK();
        purchaseForm.alert_AcceptAlert();
    }

     */

    @Test
    public void testEmptyFields_PlaceOrderModal( ) {
        var cartPage = homePage.clickCart();
        var purchaseForm = cartPage.clickPlaceOrder();
        purchaseForm.clickPurchase();
       Alert alertPresent = purchaseForm.alert_SwitchToAlert();
        String alert = purchaseForm.alert_GetAlertText();
        purchaseForm.alert_AcceptAlert();
        assertNotNull(alertPresent,"Alert Not Displayed");
        assertEquals(alert,
                "Please fill out Name and Creditcard.",
                "Incorrect Alert Message");
    }

    @Test
    public void testTotalPriceInForm(){
        var product1Page = homePage.clickSamsungGalaxyS6Product();
        product1Page.clickAddToCart();
        product1Page.alert_clickToAccept();
        var homePage = product1Page.clickHome();
        var product2Page = homePage.clickSonyVaioi5();
        product2Page.clickAddToCart();
        product2Page.alert_clickToAccept();
        var cartPage = product2Page.clickCart();
        String TotalPriceInCart = cartPage.getTotalPriceInCart();
        var purchaseModal = cartPage.clickPlaceOrder();
        String TotalPriceInForm = purchaseModal.getTotalPriceInForm();
        System.out.println(TotalPriceInForm);
        System.out.println(TotalPriceInCart);
        assertEquals(TotalPriceInForm, "Total: "+TotalPriceInCart, "Incorrect Total Price In Form");
    }

    @Test(dataProvider = "FillFormData", dataProviderClass = DataProvider.class)
    public void testValidData_PlaceOrderModal(String name, String country, String city, String card, String month, String year) {
        var cartPage = homePage.clickCart();
        var purchaseForm = cartPage.clickPlaceOrder();
        purchaseForm.fillPurchaseForm(name, country, city, card, month, year);
        purchaseForm.clickPurchase();
        String message = purchaseForm.getPurchaseConfirmationMessage();
        purchaseForm.clickOK();
        assertEquals(message, "Thank you for your purchase!","Incorrect Purchase Message");
    }

    //(dataProvider = "FillFormData", dataProviderClass = DataProvider.class)
    //String name, String country, String city, String card, String month, String year
}
