package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://dan-it.com.ua/");
        driver.findElement(By.xpath( "//a[@class = 'choose-lang__link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h1[contains(text(), 'IT-освіта')]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
