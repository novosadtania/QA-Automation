package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1
        /*driver.get("https://uhomki.com.ua/koshki/1074/");
        driver.findElement(By.xpath( "//span[@class = 'userbar__button-text']")).click();
        Thread.sleep(2000);
        driver.quit();*/
//        2
        /*driver.get("https://uhomki.com.ua/koshki/1074/");
        driver.findElement(By.xpath("//span[text() = 'Вход']")).click();
        Thread.sleep(2000);
        driver.quit();*/
//        3
        /*driver.get("https://uhomki.com.ua/koshki/1074/");
        driver.findElement(By.xpath("//span[contains(@class, 'userbar__button')]")).click();
        Thread.sleep(2000);
        driver.quit();*/
//        4
        /*driver.get("https://uhomki.com.ua/koshki/1074/");
        driver.findElement(By.xpath("//span[contains(text(), 'ход')]")).click();
        Thread.sleep(2000);
        driver.quit();*/


    }

}
