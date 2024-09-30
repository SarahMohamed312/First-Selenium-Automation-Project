package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SignupPage {
    private WebDriver driver;
    WebDriverWait wait;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
       PageFactory.initElements(driver, this);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = "#sign-username")
    private WebElement username;
    @FindBy(css = "#sign-password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signupButton;

    public void signup(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
        password.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(signupButton));
        signupButton.click();
    }
}
