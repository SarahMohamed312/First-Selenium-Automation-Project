package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamsungGalaxyS6Page{
    private WebDriver driver;
    WebDriverWait wait;
    private By addToCartButton = By.xpath("//*[text() = 'Add to cart']");
    private By home = By.id("nava");


    public SamsungGalaxyS6Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }
// add this line to alert_clickToAccept
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(home));
    }

    public CartPage clickCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        driver.findElement(By.linkText("Cart")).click();
        return new CartPage(driver);
    }

    public HomePage clickHome(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(home));
        driver.findElement(home).click();
        return new HomePage(driver);
    }
}
