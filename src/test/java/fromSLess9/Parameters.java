package fromSLess9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class Parameters {

    @Test
    @org.testng.annotations.Parameters({"seachWord"})
    public void search(String searchWord) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        Waiters waiters = new Waiters(driver);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        waiters.waitForVisabilityOfWebElementReturn(By.xpath("//input[@name='search']")).sendKeys(searchWord);
        driver.findElement(By.cssSelector(".button_color_green.search-form__submit")).click();
        String searchH1 = waiters.waitForVisabilityOfWebElementReturn(By.tagName("h1")).getText();
        assertEquals(searchH1,"«" + searchWord +"»");
        driver.quit();
    }
}
