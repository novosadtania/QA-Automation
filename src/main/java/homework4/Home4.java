package homework4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.security.Key;
import java.util.Collections;
import java.util.Set;

public class Home4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.google.com/search");
        System.out.println(driver.getWindowHandle());
        WebElement google =  driver.findElement(By.id("APjFqb"));
        google.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        google.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//h3[contains(text(), 'Create account | Guinness World Records')]"))).keyUp(Keys.CONTROL).build().perform();
        WebElement google2 =  driver.findElement(By.id("APjFqb"));
        google2.clear();
        google2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        google2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//h3[contains(text(), 'AlertsDemo - H Y R Tutorials')]"))).keyUp(Keys.CONTROL).build().perform();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        WebElement frame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame);
        WebElement frame2 = driver.findElement(By.id("fname"));
        frame2.clear();
        frame2.sendKeys("Tetiana");
        WebElement frame3 = driver.findElement(By.id("lname"));
        frame3.clear();
        frame3.sendKeys("Novosad");
        driver.findElement(By.xpath("//input[@value = 'Submit']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector(".w3-panel.w3-pale-yellow.w3-leftbar.w3-border-yellow")).getText());

    }
}
