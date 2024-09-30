package signup;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.SignupPage;


 /*
    @Test
    public void ShouldBeAbleToSignUpWithNonExistingUsernameAndPassword() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("signin2")).click();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("newuser9637758", "32205");// New username

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "Sign up successful.", "Expected alert message was not displayed.");
        alert.accept();
    }




*/

public class SignupTest extends BaseTest {

    @Test
    public void signupWithAnExistingUsername() {

        driver.findElement(By.id("signin2")).click();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("sarahmohamed", "312");
        String expectedMessage = "This user already exist.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");
    }

    @Test
    public void signupWithUsernameAndEmptyPassword() {
        driver.findElement(By.id("signin2")).click();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("sarahmohamed", "");
        String expectedMessage = "Please fill out Username and Password.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");
    }

    @Test
    public void signupWithEmptyUsernameAndPassword() {

        driver.findElement(By.id("signin2")).click();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("", "312");

        String expectedMessage = "Please fill out Username and Password.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");
    }

    @Test
    public void shouldBeAbleToSignUpWithNonExistingUsernameAndPassword() {

        driver.findElement(By.id("signin2")).click();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("nilkguser96ffff", "32205");

        String expectedMessage = "Sign up successful.";
        String actualMessage = handleAlert();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected alert message was not displayed.");
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
