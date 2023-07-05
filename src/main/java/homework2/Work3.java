package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*Написать метод который выводит сообщение об айди элемента,
значении тэга элемента , значении класса элемента,
значении атрибута name элемента, текста данного элемента,
а также о координатах центра контейнера данного элемента.*/
public class Work3 {
    static void information(WebElement element) {
        int centreX = element.getLocation().x + (element.getSize().width) / 2;
        int centreY = element.getLocation().y + (element.getSize().height) / 2;

        System.out.println(" ID Елементу : " + element.getAttribute("id") + ".\nTag-name Елементу : " + element.getTagName() + ".\nClass-name Елементу : " + element.getAttribute("class") + ".\nName Елементу : "
                + element.getAttribute("name") + ".\nText Елементу : " + element.getText() + ".\nКоординати середини Елементу : " + "(" + centreX + "," + centreY + ")");

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://pethouse.ua/ua/account/login/");
        WebElement button = driver.findElement(By.id("send-sms"));
        information(button);
        driver.quit();
    }
}
