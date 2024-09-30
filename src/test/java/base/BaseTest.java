package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WindowManager;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("browser", "CHROME");
        driver = new ChromeDriver();

        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.get("https://www.demoblaze.com/");
        //homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    }

    @AfterClass
        public void tearDown(){
        //driver.quit();
        }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    }


