package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/*Написать программу, которая повторит действия на видео "Задание 5.mp4".*/
public class Work4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru");
        WebElement search = driver.findElement(By.cssSelector("[name = 'q']"));
        search.sendKeys("Хорек");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[src = '/content/images/29/162x240l85nn0/75296154028759.webp']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class = 'comparison-button__text")).click();
        WebElement search2 = driver.findElement(By.cssSelector("[name = 'q']"));
        search2.sendKeys("Медведь");
        Thread.sleep(2000);
        search2.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[src = '/content/images/35/240x240l85nn0/88955058723812.webp']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class = 'comparison-button__icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class = 'comparison-view__button-text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class = 'compare-close j-close']")).click();
        Thread.sleep(2000);
        driver.quit();



}}

