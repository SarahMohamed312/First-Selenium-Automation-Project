package e2e;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
public class E2E extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    /*
    @Test
    public void BeAbleToSignUpWithNewUsernameAndPassword() {
       /* driver.findElement(By.id("signin2")).click();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("naakkluser175", "322054"); // New username
        String expectedMessage = "Sign up successful.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
        }*/

    @Test(priority = 1)
    protected void ShouldBeAbleToLoginWithCorrectUsernameAndPassword() {
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToDemoblaze("sarahmohamed", "312");
        /*driver.findElement(By.id("loginusername")).sendKeys("sarahmohamed");
        driver.findElement(By.id("loginpassword")).sendKeys("312");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        Assert.assertTrue(navbarElement.getText().contains("Welcome"));
    }
    @Test(priority = 2)
    public void AddProductstoCart() {
        //add the first product
        var product1Page = homePage.clickSamsungGalaxyS6Product();
        product1Page.clickAddToCart();
        product1Page.alert_clickToAccept();
        product1Page.clickHome();

        //add the second product
        var product2Page = homePage.clickSonyVaioi5();
        product2Page.clickAddToCart();
        product2Page.alert_clickToAccept();

        //check the sum of products prices
        var cartPage = product2Page.clickCart();
        String SumOfProductPrices = cartPage.getSumOfProductPrices();
        String TotalPriceInCart = cartPage.getTotalPriceInCart();
        System.out.println(SumOfProductPrices);
        System.out.println(TotalPriceInCart);
        assertEquals(SumOfProductPrices, TotalPriceInCart, "Incorrect Total Price In Cart");
    }

    @Test(priority = 3)
    public void testValidData_PlaceOrderModal() {
            var cartPage = homePage.clickCart();
            var purchaseForm = cartPage.clickPlaceOrder();
            purchaseForm.fillPurchaseForm("sarahMohamed", "Egypt", "Mansoura", "card", "10", "2024");
            purchaseForm.clickPurchase();
            String message = purchaseForm.getPurchaseConfirmationMessage();
            purchaseForm.clickOK();
            assertEquals(message, "Thank you for your purchase!","Incorrect Purchase Message");
        }
    }
