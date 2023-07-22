package homework9.foxtrot;

import from_S_less8.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Foxtrot {
    @DataProvider(name = "Words")
    public Object[] createData2(){
        return new Object[]{
                "машина",
                "input",
                "смысл"
        };
    }
    @Test(dataProvider = "Words")
    public void findElement(String word) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Waiters waiters = new Waiters(driver);

        driver.get("https://www.foxtrot.com.ua/");
        waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@id = 'user-location-popup']//div//div//i")).click();
        WebElement search = waiters.waitForVisabilityOfWebElementReturn(By.tagName("input"));
        search.sendKeys(word);
        search.sendKeys(Keys.ENTER);

        WebElement resultLine = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class = 'page__title']//h1"));
        String result = resultLine.getText();
        System.out.println(result);
        if(result.contains("Знайдено")) {
            WebElement resultString = waiters.waitForVisabilityOfWebElementReturn(By.xpath("//div[@class = 'page__title']//h1"));
            String wordResult = resultString.getText().split("\\ запиту ")[1];
            System.out.println(word);
            assertTrue(result.contains("«" + word +"»"));
        }else {
            WebElement nothingNotFound = driver.findElement(By.className("search-page__box-title"));
            String nothing = nothingNotFound.getText().split("\\запитом ")[1].split("\\ нічого")[0];
            System.out.println(nothing);
            assertEquals(nothing,"«смысл»" );
        }
        driver.quit();
    }
}
