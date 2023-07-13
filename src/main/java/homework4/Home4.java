package homework4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Home4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.google.com/search");
        String window1Handle = driver.getWindowHandle();
        Set<String> window1 = driver.getWindowHandles();
        WebElement google = driver.findElement(By.id("APjFqb"));
        google.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        google.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//h3[contains(text(), 'Create account | Guinness World Records')]"))).keyUp(Keys.CONTROL).build().perform();
        Set<String> window2 = driver.getWindowHandles();
        window2.removeAll(window1);
        String window2Handle = window2.iterator().next();
        Set<String> window3 = driver.getWindowHandles();
        WebElement google2 = driver.findElement(By.id("APjFqb"));
        google2.clear();
        google2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        google2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//h3[contains(text(), 'AlertsDemo - H Y R Tutorials')]"))).keyUp(Keys.CONTROL).build().perform();
        Set<String> window4 = driver.getWindowHandles();
        window4.removeAll(window3);
        String window3Handle = window4.iterator().next();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".w3-panel.w3-pale-yellow.w3-leftbar.w3-border-yellow")));
        System.out.println(driver.findElement(By.cssSelector(".w3-panel.w3-pale-yellow.w3-leftbar.w3-border-yellow")).getText());
        driver.switchTo().window(window2Handle);
        driver.findElement(By.id("LastName")).sendKeys("Novosad");
        driver.findElement(By.id("FirstName")).sendKeys("Tania");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("18");
        driver.findElement(By.id("DateOfBirthMonth")).sendKeys("10");
        driver.findElement(By.id("DateOfBirthYear")).sendKeys("1999");
        Select countrie = new Select(driver.findElement(By.id("Country")));
        countrie.selectByValue("UA");
        WebElement state = driver.findElement(By.id("State"));
        state.sendKeys("Ternopil'");
        driver.findElement(By.id("EmailAddress")).sendKeys("tanya@gmail.com");
        driver.findElement(By.id("ConfirmEmailAddress")).sendKeys("tanya@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Password");
        WebElement pass = driver.findElement(By.id("ConfirmPassword"));
        pass.sendKeys("Password2");
        pass.sendKeys(Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//span[@for= 'ConfirmPassword']")).getText());
        driver.switchTo().window(window3Handle);
        driver.findElement(By.id("alertBox")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("confirmBox")).click();
        driver.switchTo().alert();
        alert.dismiss();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("promptBox")).click();
        driver.switchTo().alert();
        alert.sendKeys("Final step of this task");
        alert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.quit();


    }
}
