package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @FindBy(id = "loginusername")
    private WebElement username;
    @FindBy(id = "loginpassword")
    private WebElement passwad;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement butn;

    public void loginToDemoblaze(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
        passwad.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(butn));
        butn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

    }
}

