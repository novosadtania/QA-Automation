package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/koshki/1074/");
        driver.findElement(By.xpath("//span[@class = 'productsMenu-submenu-t']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}