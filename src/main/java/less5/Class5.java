package less5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Class5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://zoo.kyiv.ua/");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(), 'ВАРТІСТЬ КВИТКІВ')]"));
        element.click();

        int centreX = element.getLocation().x + (element.getSize().width) / 2;
        int centreY = element.getLocation().y + (element.getSize().height) / 2;
        System.out.println(centreX + " ," + centreY);
        driver.quit();
    }
}


