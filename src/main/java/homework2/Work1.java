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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Set<String> window0 = driver.getWindowHandles();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> window1 = driver.getWindowHandles();
        window1.removeAll(window0);
        String newWindow1 = window1.iterator().next();
        driver.switchTo().window(newWindow1);
        driver.get("https://zoo.kiev.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> window2 = driver.getWindowHandles();
        window2.removeAll(window1);
        window2.removeAll(window0);
        String newWindow2 = window2.iterator().next();
        driver.switchTo().window(newWindow2);
        driver.get("https://www.w3schools.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> window3 = driver.getWindowHandles();
        window3.removeAll(window1);
        window3.removeAll(window0);
        window3.removeAll(window2);
        String newWindow3 = window3.iterator().next();
        driver.switchTo().window(newWindow3);
        driver.get("https://taxi838.ua/ru/dnepr/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> window4 = driver.getWindowHandles();
        window4.removeAll(window1);
        window4.removeAll(window0);
        window4.removeAll(window2);
        window4.removeAll(window3);
        String newWindow4 = window4.iterator().next();
        driver.switchTo().window(newWindow4);
        driver.get("https://klopotenko.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

}
