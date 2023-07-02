package less3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Less3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(Url.url1);
        driver.findElement(Locators.locSearch).sendKeys(Data.data);
        Thread.sleep(3000);
        driver.findElement(Locators.buttonSearch).click();
        Thread.sleep(3000);
        driver.quit();

    }

    private static class Url {
        private static final String url1 = "https://www.guinnessworldrecords.com/search";
    }

    private static class Locators {
        private static final By locSearch = By.id("search-term");
        private static final By buttonSearch = By.id("search-button");
    }

    private static class Data {
        private static final String data = "I'm searching something";

    }
}
