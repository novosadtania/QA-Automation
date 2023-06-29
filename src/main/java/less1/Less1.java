package less1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Less1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://guinnessworldrecords.com/records/");
        System.out.println("====================");
        System.out.println(driver.getCurrentUrl());
        System.out.println("====================");
        driver.quit();
    }
}
