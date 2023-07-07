package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static javax.swing.UIManager.get;

/*2) http://www.ashortjourney.com/
Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".*/
public class Work2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        driver.navigate().to("http://www.ashortjourney.com/");
        Thread.sleep(5000);
        WebElement circle = driver.findElement(By.tagName("path"));
        WebElement tspan = driver.findElement(By.tagName("tspan"));
        /*actions.dragAndDrop(tspan,circle).perform();*/
        actions.moveToElement(tspan).clickAndHold()
                .moveToElement(circle,702,191).release()
                .build().perform();



}}

