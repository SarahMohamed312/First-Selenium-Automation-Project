package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;
     private Categories categories;
     private WebDriverWait wait;


    public HomePage(WebDriver driver){
        this.driver = driver;
        this.categories = new Categories(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CartPage clickCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        clickLink("Cart");
        return new CartPage(driver);
    }
    public SamsungGalaxyS6Page clickSamsungGalaxyS6Product(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6")));
        clickLink("Samsung galaxy s6");
        return new SamsungGalaxyS6Page(driver);
    }

    public SonyVaioi5Page clickSonyVaioi5(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sony vaio i5")));
        clickLink("Sony vaio i5");
        return new SonyVaioi5Page(driver);
    }
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public Categories getCategories(){

        return categories;
    }
}
