package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
//        1
        driver.findElement(By.id("search2")).click();
//        2
        driver.findElement(By.id("learntocode_searchbtn")).click();
//        3
        driver.findElement(By.id("w3loginbtn")).click();
//        4
        driver.findElement(By.id("signupbtn_topnav")).click();
//        5
        driver.findElement(By.id("navbtn_exercises")).click();

        driver.quit();
    }
}
