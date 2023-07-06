package less5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DanIT {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        driver.get("https://dan-it.com.ua/uk/");
        actions.moveToElement(driver.findElement((By.xpath("//a[text() = 'Для дітей']")))).pause(Duration.ofSeconds(2)).
                moveToElement(driver.findElement(By.xpath("//a[text() = 'Академічна вища ІТ освіта']"))).pause(Duration.ofSeconds(2)).
                click().pause(Duration.ofSeconds(4)).build().perform();
        driver.quit();
    }
}