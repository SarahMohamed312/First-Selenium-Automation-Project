package utils;

/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.HomePage;

import java.time.Duration;

public class PagesNavigation {
    private WebDriver driver;
    private By homePage = By.linkText("Home ");
    private By cartPage = By.linkText("Cart");
    private WebDriverWait wait;


    public PagesNavigation(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public HomePage navToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage));
        driver.findElement(homePage).click();
        return new HomePage(driver);
    }

    public CartPage navToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartPage));
        driver.findElement(cartPage).click();
        return new CartPage(driver);
    }

    public CartPage clickCart(){
        clickLink("Cart");
        return new CartPage(driver);
    }
    public SamsungGalaxyS6Page clickSamsungGalaxyS6Product(){
        clickLink("Samsung galaxy s6");
        return new SamsungGalaxyS6Page(driver);
    }
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }



}

 */



