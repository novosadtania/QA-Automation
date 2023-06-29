package less2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Less2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

      /*  1) driver.get("https://demoqa.com/text-box");
        WebElement element = driver.findElement(By.id("userName"));
        element.click();
        element.sendKeys("Hello Tania ");*/
//        2)

        /*driver.get("https://www.guinnessworldrecords.com/search");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(1).sendKeys("Most handstand push ups");
        WebElement element = driver.findElement(By.id("search-button"));
        element.click();*/

        driver.get("https://www.guinnessworldrecords.com/records/");
      driver.findElement(By.xpath( "//i[@class = 'icon icon-search']")).click();
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//input[@id = 'search-term']"));
        element.click();
        Thread.sleep(4000);
        element.sendKeys("Whaaaaat");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id = 'search-button']")).click();



    }
}
