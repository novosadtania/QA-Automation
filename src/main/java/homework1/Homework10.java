package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework10 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1
        driver.get("https://www.jetbrains.com/idea/download/#section=windows");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(@class, '_modeClassic_12yxkch_135')]")).click();
        Thread.sleep(5000);
        driver.quit();
//       2
        driver.get("https://www.jetbrains.com/idea/download/#section=windows");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(@class, '_dark_12yxkch_62')]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
