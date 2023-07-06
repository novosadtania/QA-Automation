package less5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class NewClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://ktokuda.net/");
        WebElement car = driver.findElement(By.id("transport_type"));
        Select carAwt = new Select(car);
        carAwt.selectByValue("2");
        Thread.sleep(2000);
        WebElement people = driver.findElement(By.id("adult"));
        Select parent = new Select(people);
        parent.selectByValue("4");
        Thread.sleep(2000);
        driver.quit();

    }
}
