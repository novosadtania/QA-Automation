package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://dan-it.com.ua/");
        driver.findElement(By.xpath( "//a[@class = 'choose-lang__link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath( "//p[@class = 'main-info__text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath( "//li[@class = 'main-expertise__point'][3]")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
