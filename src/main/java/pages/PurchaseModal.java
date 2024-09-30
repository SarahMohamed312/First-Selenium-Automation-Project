package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseModal {
    private WebDriver driver;
    private By nameField = By.id("name");
    private By priceTotalForm = By.id("totalm");
    private By purchaseButton = By.xpath("//*[text()='Purchase']");
    private By closeButton = By.xpath("//*[text()='Close']");
    private By okButton = By.xpath("//*[text()='OK']");
    private By purchaseThanksMessage = By.xpath("//h2[contains(text(),'Thank you')]");
    private WebDriverWait wait;

    public PurchaseModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTotalPriceInForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceTotalForm));
        return driver.findElement(priceTotalForm).getText();
    }


    public void clickField (String id, String text){
        driver.findElement(By.id(id)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void fillPurchaseForm(String name, String country, String city, String card, String month, String year) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        clickField("name",name);
        clickField("country",country);
        clickField("city",city);
        clickField("card",card);
        clickField("month",month);
        clickField("year",year);
    }

    public void clickPurchase()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseButton));
        driver.findElement(purchaseButton).click();
    }

    public void clickOK()  {
        driver.findElement(okButton).click();
    }

    public Alert alert_SwitchToAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public String alert_GetAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void alert_AcceptAlert(){
        driver.switchTo().alert().accept();
        }

    public void closeModal() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public String getPurchaseConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseThanksMessage));
        return driver.findElement(purchaseThanksMessage).getText();
    }
}
