
package contact;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import java.time.Duration;


public class ContactTest extends BaseTest {

    @Test
    public void contactAndSendMessage() {
        //WebDriver driver;
        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");*/
        driver.findElement(By.cssSelector("a.nav-link[data-target='#exampleModal']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-header"))); // Replace with your modal's CSS selector

        ContactPage contactPage = new ContactPage(driver);
        contactPage.contactinfo("sara@gmail.com","sara","please help me");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualmessage = alert.getText();
        alert.accept();
        Assert.assertEquals(actualmessage ,"Thanks for the message!!", "Expected alert message was not displayed.");
    }
}