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
        Thread.sleep(6000);
        WebElement tspan = driver.findElement(By.tagName("tspan"));
        WebElement path = driver.findElement(By.tagName("path"));
        actions.moveToElement(tspan).clickAndHold()
                .moveToElement(path,702,191).release()
                .build().perform();

        Thread.sleep(6000);
        WebElement cirkle = driver.findElements(By.tagName("circle")).get(2);
        Thread.sleep(4000);
        WebElement tspan2 = driver.findElement(By.tagName("tspan"));
        WebElement path2 = driver.findElement(By.tagName("path"));
        actions.moveToElement(tspan2).pause(Duration.ofSeconds(2)).clickAndHold()
                .moveToElement(path2,485,267).release()
                .build().perform();

        Thread.sleep(6000);
        /*WebElement circle3 = driver.findElements(By.tagName("circle")).get(2);
        System.out.println(circle3.getLocation().x);
        System.out.println(circle3.getLocation().y);*/
        WebElement tspan3 = driver.findElement(By.tagName("tspan"));
        WebElement path3 = driver.findElement(By.tagName("path"));
        Thread.sleep(2000);
        actions.moveToElement(tspan3).pause(Duration.ofSeconds(2)).clickAndHold()
                .moveToElement(path3,485,267).release()
                .build().perform();

        Thread.sleep(6000);
        WebElement tspan4 = driver.findElement(By.tagName("tspan"));
        WebElement path4 = driver.findElement(By.tagName("path"));
        WebElement circles = driver.findElements(By.tagName("circle")).get(2);
        actions.moveToElement(tspan4).pause(Duration.ofSeconds(2)).clickAndHold()
                .moveToElement(circles).click().release()
                .build().perform();
        Thread.sleep(4000);
//        driver.quit();

}}

