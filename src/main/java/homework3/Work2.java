package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

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
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(10000);
        WebElement tspan = driver.findElement(By.tagName("tspan"));
        WebElement path = driver.findElement(By.tagName("path"));
        actions.moveToElement(tspan).clickAndHold()
                .moveToElement(path, 702, 191).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement tspan2 = driver.findElement(By.tagName("tspan"));
        WebElement path2 = driver.findElement(By.tagName("path"));
        actions.moveToElement(tspan2).pause(Duration.ofSeconds(2)).clickAndHold()
                .moveToElement(path2, 485, 267).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement tspan3 = driver.findElement(By.tagName("tspan"));
        WebElement path3 = driver.findElement(By.tagName("path"));
        Thread.sleep(2000);
        actions.moveToElement(tspan3).clickAndHold()
                .moveToElement(path3, 485, 267).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement tspan4 = driver.findElement(By.tagName("tspan"));
        actions.moveToElement(tspan4).clickAndHold().
                moveByOffset(-1222, -359).release()
                .build().perform();

        Thread.sleep(5000);
        WebElement tspan5 = driver.findElement(By.tagName("tspan"));
        actions.moveToElement(tspan5).clickAndHold().
                moveByOffset(-1188, -135).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement tspan6 = driver.findElement(By.tagName("tspan"));
        actions.moveToElement(tspan6).clickAndHold().
                moveByOffset(1152, -485).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement tspan7 = driver.findElement(By.tagName("tspan"));
        actions.moveToElement(tspan7).clickAndHold().
                moveByOffset(401, -485).release()
                .build().perform();

        Thread.sleep(4000);
        WebElement text = driver.findElement(By.tagName("textarea"));
        text.sendKeys("Завдання виконано!!!");
        Thread.sleep(6000);
        driver.quit();
    }
}

