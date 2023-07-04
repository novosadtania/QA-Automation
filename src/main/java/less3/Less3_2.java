package less3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Less3_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.guinnessworldrecords.com/records/");
        Thread.sleep(3333);
        driver.findElement(By.cssSelector(".secondary_menu_wrapper.block.block-12-12.no-margin div a[href='/records/the-application-process']")).click();
    }
}
