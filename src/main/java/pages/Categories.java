package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Categories {
    private WebDriver driver;
    private By phonesCategory = By.xpath("//a[text() = 'Phones']");
    private By laptopsCategory = By.xpath("//a[text() = 'Laptops']");
    private By monitorsCategory = By.xpath("//a[text() = 'Monitors']");
    private By categorySection = By.id("tbodyid"); // row of product
    private By sectionProducts = By.cssSelector(".card-block");
    private FluentWait fluentWait;

    public Categories(WebDriver driver) {
        this.driver = driver;
     //this.wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        this.fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public void getListOfPhones() {

        driver.findElement(phonesCategory).click();
        //fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block")));
    }
    public void getListOfLaptops()  {
        driver.findElement(laptopsCategory).click();
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block"))); //class the . class name
    }

    public void getListOfMonitors() {
        driver.findElement(monitorsCategory).click();
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sectionProducts));
        //Thread.sleep(5000);

    }
//To make sure that the item added to the cart is the one in it
    public List<WebElement> listCategorySectionProducts(){
        WebElement section = driver.findElement(categorySection); //select row of product
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sectionProducts));

        return section.findElements(sectionProducts); //By.cssSelector(".card-block");//Can it be found by title?
    }
}

