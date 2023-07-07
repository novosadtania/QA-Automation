package homework2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
/*1)Написать программу, которая будет открывать пять различных страниц в новых окнах:
    https://uhomki.com.ua/ru/koshki/1074/
    https://zoo.kiev.ua/
    https://www.w3schools.com/
    https://taxi838.ua/ru/dnepr/
    https://klopotenko.com/
Прописать цикл, который будет переключаться поочередно через все страницы,
для каждой страницы выводить в консоль название и ссылку на эту страницу.
И будет закрывать ту страницу в названии которой есть слово зоопарк.*/
public class Work1 {
    public static void main(String[] args) throws InterruptedException {
        String[] url = {"https://uhomki.com.ua/ru/koshki/1074/",
                "https://zoo.kiev.ua/",
                "https://www.w3schools.com/",
                "https://taxi838.ua/ru/dnepr/",
                "https://klopotenko.com/"};

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url[0]);
        for (int i = 0; i < 5; i++) {
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            Set<String> set1 = driver.getWindowHandles();
            if (i + 1 == 5) {
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.open()");
            Set<String> set2 = driver.getWindowHandles();
            set2.removeAll(set1);
            String descriptor2 = set2.iterator().next();
            if (driver.getTitle().contains("зоопарк")) {
                driver.close();
            }
            driver.switchTo().window(descriptor2);
            driver.get(url[i + 1]);
        }
        driver.quit();
    }
}

