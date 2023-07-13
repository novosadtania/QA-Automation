package less6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        WebElement frame2 = driver.findElement(By.id("sampleHeading"));

        System.out.println(frame2.getText());
        driver.quit();
    }
}
