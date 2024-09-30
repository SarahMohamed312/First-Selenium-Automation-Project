
package login;



import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseTest {
    @Test
    protected void LoginWithEmptyUsernameAndEmptyPassword() {
        //driver.get("https://www.demoblaze.com/");

        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToDemoblaze("", "");
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Please fill out Username and Password.", alertMessage);
    }

    @Test
    protected void LoginWithCorrectUsernameAndEmptyPassword() {
        //driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToDemoblaze("sarahmohamed", "");
        String expectedMessage = "Please fill out Username and Password.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");

    }

    @Test
    protected void LoginWithEmptyUsernameAndCorrectPassword() {
        //driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToDemoblaze("", "312");
        String expectedMessage = "Please fill out Username and Password.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");

    }
    @Test
    protected void ShouldBeAbleToLoginWithCorrectUsernameAndPassword() {
        //DriverFactory Class Calling by object from driverfactory class
        // driver= new DriverFactory().intializeDriver(); //instead of inherit BaseTest Class
        //implicit
        //maximize
        //driver.get("https://www.demoblaze.com/");
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

    protected String handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

}
