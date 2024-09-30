package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SonyVaioi5Page {
    private WebDriver driver;
    private By addToCartButton = By.xpath("//*[text() = 'Add to cart']");
    WebDriverWait wait;

    public SonyVaioi5Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public CartPage clickCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        clickLink("Cart");
        return new CartPage(driver);
    }
    private void clickLink(String linktext){
        driver.findElement(By.linkText(linktext)).click();
    }
}
