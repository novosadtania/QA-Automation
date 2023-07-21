package fromSLess9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Test2 {
    static WebDriver driver;
    static Waiters waiters;

    @BeforeClass(groups = {"first", "second"})
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waiters = new Waiters(driver);
    }

    @AfterClass(groups = {"first", "second"})
    public void stopTest() {
        driver.quit();
    }

    @Test(groups = {"second"})
    public void TestAlertMessage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='header-actions__item header-actions__item--user']//button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal__content']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='auth-modal__register-link button button--link ng-star-inserted']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal__holder modal__holder_show_animation modal__holder--medium']")));
        driver.findElement(By.xpath("//input[@id='registerUserPassword']")).sendKeys("12345");
        driver.findElement(By.xpath("//li[@class='errors-list__item ng-star-inserted'][1]"));
        assertEquals(driver.findElements(By.xpath("//form-error//ul//li//p")).get(0).getText(), "Не совпадать с именем и эл. почтой");
        WebElement green = driver.findElements(By.cssSelector("form-error use")).get(0);
        assertEquals(green.getAttribute("href"), "#icon-green-check");
        assertEquals(driver.findElements(By.xpath("//form-error//ul//li//p")).get(2).getText(), "Не менее 6 символов");
        WebElement cross = driver.findElements(By.cssSelector("form-error use")).get(2);
        assertEquals(cross.getAttribute("href"), "#icon-close-modal");
    }

    @Test(groups = {"first"})
    public void checkOfTime() throws InterruptedException {
        driver.get("https://24timezones.com/%D0%9A%D0%B8%D0%B5%D0%B2/%D0%B2%D1%80%D0%B5%D0%BC%D1%8F");
        //div[@id='cityClock']//div//span[3]
        Thread.sleep(2000);
        int timeOfWait = 5;
        int startTime = Integer.parseInt(driver.findElement(By.xpath("//div[@id='cityClock']//div//span[3]")).getText());
        if (startTime >= 56) {
            Thread.sleep(timeOfWait * 1000);
            startTime = Integer.parseInt(driver.findElement(By.xpath("//div[@id='cityClock']//div//span[3]")).getText());
        }
        Thread.sleep(timeOfWait * 1000);
        int finalTime = Integer.parseInt(driver.findElement(By.xpath("//div[@id='cityClock']//div//span[3]")).getText());

        assertEquals(finalTime - startTime, timeOfWait);
    }

    @Test(groups = {"first"})
    public void checkPriceOfGoods() {
        driver.get("https://uhomki.com.ua/stuzzy-dog-beef-shtuzi-govyadina-v-souse-korm-dlya-sobak-pauch-100g-0.1/9356/");
        WebElement priceElement = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class='product-price__item']"));
        int price = Integer.parseInt(priceElement.getText().split("\\.")[0]);
        assertEquals(price, 33);
    }

    @Test(groups = {"second"})
    public void checkPriceOfGoods1() {
        driver.get("https://uhomki.com.ua/stuzzy-dog-beef-shtuzi-govyadina-v-souse-korm-dlya-sobak-pauch-100g-0.1/9356/");
        WebElement priceElement = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class='product-price__item']"));
        int price = Integer.parseInt(priceElement.getText().split("\\.")[0]);
        assertEquals(price, 33);
    }

    @Test(groups = {"second"})
    public void checkPriceOfGoods2() {
        driver.get("https://uhomki.com.ua/stuzzy-dog-beef-shtuzi-govyadina-v-souse-korm-dlya-sobak-pauch-100g-0.1/9356/");
        WebElement priceElement = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class='product-price__item']"));
        int price = Integer.parseInt(priceElement.getText().split("\\.")[0]);
        assertEquals(price, 33);
    }

    @Test(groups = {"first"})
    public void checkPriceOfGoods3() {
        driver.get("https://uhomki.com.ua/stuzzy-dog-beef-shtuzi-govyadina-v-souse-korm-dlya-sobak-pauch-100g-0.1/9356/");
        WebElement priceElement = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class='product-price__item']"));
        int price = Integer.parseInt(priceElement.getText().split("\\.")[0]);
        assertEquals(price, 33);
    }

    @Test(dependsOnGroups = "first")
    public void checkPriceOfGoods4() {
        driver.get("https://uhomki.com.ua/stuzzy-dog-beef-shtuzi-govyadina-v-souse-korm-dlya-sobak-pauch-100g-0.1/9356/");
        WebElement priceElement = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class='product-price__item']"));
        int price = Integer.parseInt(priceElement.getText().split("\\.")[0]);
        assertEquals(price, 33);
    }

}
