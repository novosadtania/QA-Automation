package fromSLess9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class DataProviderEx {
    static WebDriver driver;
    static Waiters waiters;
    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waiters = new Waiters(driver);
    }

    @AfterClass
    public void stopTest() {
        driver.quit();
    }


    @Test(dataProvider = "loginWithUsers")
    public void loginTest(String login, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='header-actions__item header-actions__item--user']//button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal__content']")));
        Thread.sleep(2000);
        driver.findElement(By.id("auth_email")).sendKeys(login);
        driver.findElement(By.id("auth_pass")).sendKeys(password);
        assertTrue(driver.findElement(By.cssSelector(".button--green.auth-modal__submit")).isDisplayed());
    }



    @DataProvider(name = "loginWithUsers")
    public Object[][] createData(){
        return new Object[][]{
                {"ivan@ivan.ivan", "passivan"},
                {"anton@anton.anton", "passanton"},
                {"ira@ira.ira", "passira"}
        };
    }

    @DataProvider(name = "loginWithUsers2")
    public Object[] createData2(){
        return new Object[]{
                "ivan@ivan.ivan",
                "anton@anton.anton",
                "ira@ira.ira"
        };
    }
}
